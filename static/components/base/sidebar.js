var MySidebar = Vue.component('my-sidebar', {
    template: '<el-menu\
            ref="menu"\
            @open="handleOpen"\
            class="el-menu-vertical-demo"\
            background-color="#545c64"\
            text-color="#fff"\
            active-text-color="#ffd04b"\
            :collapse="isCollapse" \
            :router="true" \
            :default-active="active">\
            <template v-for="(route, index) in $router.options.routes[0].children">\
                <template v-if="hasChildrenMenu(route.children)">\
                    <el-submenu :index="route.name">\
                        <template slot="title">\
                            <i :class="route.icon"></i>\
                            <span>{{route.name}}</span>\
                        </template>\
                        <el-menu-item :key="cIndex" :index="getIndex(cRoute.path)"\
                            v-if="isMenu(cRoute.meta.menu)"\
                            v-for="(cRoute, cIndex) in route.children" :route="cRoute">\
                            {{cRoute.name}}\
                        </el-menu-item>\
                    </el-submenu>\
                </template>\
                <template v-if="!hasChildrenMenu(route.children)">\
                    <el-menu-item :key="index" :index="getIndex(route.path)" :route="route"><i :class="route.icon"></i><span slot="title">{{route.name}}</span></el-menu-item>\
                </template>\
            </template>\
	</el-menu>',
    data: function() {
        return {
            active: "/",
            openIndex: ""
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
        },
        isCollapse: function() {
            if (this.openIndex !== '') {
                this.$refs.menu.open(this.openIndex);
            }
        }
    },
    mounted: function() {
        this.active = this.getActive();
    },
    methods: {
        handleOpen: function(index, indexPath) {
            this.openIndex = index;
        },
        getActive: function() {
            // 设置当前打开菜单，用于折叠后展开
            this.openIndex = this.$route.matched[1] ? this.$route.matched[1].name : this.$route.matched[0].name;

            var curIndex = this.$route.matched.length - 1;
            var path = "";
            for (var i = curIndex; i >= 0; i--) {
                if (this.isMenu(this.$route.matched[i].meta.menu)) {
                    path = this.$route.matched[i].path;
                    break;
                }
            }

            if (path.substr(0, 1) == "/") {
                path = path.substr(1);
            }
            return path;
        },
        getIndex: function(path) {
            if (path.substr(0, 1) == "/") {
                return path.substr(1);
            }
            return path;
        },
        hasChildrenMenu: function(children) {
            if (!children) {
                return false;
            }

            var childrenMenu = children.filter(function(c) {
                return this.isMenu(c.meta.menu);
            }.bind(this));
            return childrenMenu.length > 0;
        },
        isMenu: function(menu) {
            return menu == null || (menu != null && menu);
        }
    }
});
