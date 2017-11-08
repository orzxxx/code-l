var MySidebar = Vue.component('my-sidebar', {
        template: '<el-menu\
            default-active="1"\
            class="el-menu-vertical-demo"\
            background-color="#545c64"\
            text-color="#fff"\
            active-text-color="#ffd04b"\
            :collapse="isCollapse" \
            @select="handleSelect">\
            <template v-for="(menu, i1) in menus">\
                <el-submenu :index="i1.toString()">\
                    <template slot="title">\
                        <i :class="menu.icon"></i>\
                        <span>{{menu.name}}</span>\
                    </template>\
                    <el-menu-item-group>\
                         <template v-for="(subMenu, i2) in menu.subMenus">\
                            <el-menu-item :index="i1.toString() + \'-\' + i2.toString()">\
                                {{subMenu.name}}\
                            </el-menu-item>\
                         </template>\
                    </el-menu-item-group>\
                </el-submenu>\
            </template>\
	</el-menu>',
    computed: {
        isCollapse: function() {
            return store.state.isMenuCollapse;
        }
    },
    methods: {
        handleSelect: function(key, keyPath) {
            var pIndex = key.split("-")[0];
            var cIndex = key.split("-")[1];
            store.commit('setBC', {
                bc2: this.menus[pIndex].name,
                bc3: this.menus[pIndex].subMenus[cIndex].name
            } );
        }
    },
    data: function () {
        return {
            menus: [{
                    name: "导航1",
                    icon: "el-icon-menu",
                    subMenus: [
                        {name: "选项11", route: ""},
                        {name: "选项12", route: ""}
                ]}, {
                    name: "导航2", icon: "el-icon-menu",
                    subMenus: [
                        {name: "选项21", route: ""},
                        {name: "选项22", route: ""}
                ]}
            ]
        }
    }
});
