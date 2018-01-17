var MyContent = Vue.component('my-content', {
    template: '<div class="my__content" v-loading="loading">\
        <component v-bind:is="currentView"></component>\
    </div>',
    data: function () {
        return {
            currentView: Home,
            allViews: new Map(),
            loading: false
        }
    },
    mounted: function() {
        // 全局ajax
        axios.interceptors.request.use(function (config) {
            //TODO 可能会在返回时把其他loading取消掉？
            if (config.loading != null && !config.loading) {
                return config;
            }
            this.loading = true; // loading
            return config;
        }.bind(this), function (error) {
            return Promise.reject(error);
        });

        axios.interceptors.response.use(function (response) {
            this.loading = false; // 取消loading
            return response;
        }.bind(this), function (error) {
            this.loading = false; // 取消loading
            // 错误弹窗
            this.$notify({
                title: '提示',
                message: error.response.data,
                position: 'bottom-right'
            });
            return Promise.reject(error);
        }.bind(this));

        // 获取所有vue-router组件
        this.$router.options.routes[0].children.map(function(cr) {
            this.getChildRoutes(this.allViews, "", cr);
        }.bind(this));
        this.allViews.set("/", Home); // 放后面避免被覆盖
        this.allViews.set("", Home);

        this.currentView = this.getActive();
    },
    methods: {
        getChildRoutes: function(allViews, path, r) {
            this.allViews.set(this.getFullPath(path, r.path), r.component);
            if (r.children) {
                r.children.forEach(function(cr) {
                    this.getChildRoutes(this.allViews, this.getFullPath(path, r.path), cr);
                }.bind(this));
            }
        },
        getFullPath: function(pPath, cPath) {
            if (pPath == "/" && cPath.substr(0, 1) != "/") {
                return pPath + cPath;
            } else if (pPath == "/" && cPath.substr(0, 1) == "/") {
                return cPath;
            } else if (pPath != "/" && cPath.substr(0, 1) != "/") {
                return pPath + "/" + cPath;
            } else {
                return pPath + cPath;
            }
        },
        getActive: function() {
            if (!this.$route.matched) {
                return null; // TODO 404
            }
            var path = this.$route.matched[this.$route.matched.length - 1].path;
            var result = this.allViews.get(path);
            // 面包屑会时path变成解析后的？
            if (result == null) {
                this.allViews.forEach(function(v, k) {
                    var re = pathToRegexp(k);
                    if (re.test(path)) {
                        result = this.allViews.get(k);
                        return false;
                    }
                }.bind(this));
            }
            return result;
        }
    },
    watch: {
        $route: function(to) {
            this.currentView = this.getActive();
        }
    }
});


