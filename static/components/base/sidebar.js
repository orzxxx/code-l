var MySidebar = Vue.component('my-sidebar', {
        template: '<el-menu\
            class="el-menu-vertical-demo"\
            background-color="#545c64"\
            text-color="#fff"\
            active-text-color="#ffd04b"\
            :collapse="isCollapse" \
            :router="true" \
            :default-active="active">\
            <template v-for="(route, index) in $router.options.routes[0].children">\
                <template v-if=" route.children">\
                    <el-submenu :index="route.name">\
                        <template slot="title">\
                            <i :class="route.icon"></i>\
                            <span>{{route.name}}</span>\
                        </template>\
                        <el-menu-item :key="cIndex" :index="cRoute.path"\
                            v-for="(cRoute, cIndex) in route.children" :route="cRoute">\
                            {{cRoute.name}}\
                        </el-menu-item>\
                    </el-submenu>\
                </template>\
                <template v-if="!route.children">\
                    <el-menu-item :key="index" :index="route.path" :route="route">{{route.name}}</el-menu-item>\
                </template>\
            </template>\
	</el-menu>',
    data: function() {
        return {
            active: "/"
        }
    },
    computed: {
        isCollapse: function() {
            // el-table width为100%时有问题
            return store.state.isMenuCollapse;
        }
    },
    watch: {
        $route: function(to) {
            this.active = this.getActive();
        }
    },
    mounted: function() {
        this.active = this.getActive();
    },
    methods: {
        getActive: function() {
            var level = this.$route.meta.level;
            var path = "";
            if (level == 3) {
                path = this.$route.matched[2].path;
            } else {
                path = this.$route.matched[level].path;
            }
            if (path.substr(0, 1) == "/") {
                path = path.substr(1);
            }
            return path;
        }
    }
});
