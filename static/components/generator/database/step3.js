var GeneratorDatabaseStep3 = Vue.component('generator-database-step3', {
    template: '<el-form label-width="80px">\
        <template v-for="t in tags">\
             <el-form-item label="t">\
                <el-input v-model="params[t]"></el-input>\
            </el-form-item>\
        </template>\
    </el-form>',
    props: ['templates'],
    data: function () {
        return {
            params: {}
        }
    },
    computed: {
        tags: function() {
            return this.templates.reduce(function(p, c, i, arr) {
                if (c.parameters) {
                    return p.concat(c.parameters);
                }
                return p;
            }, []);
        }
    },
    methods: {
        validate: function() {
            return true;
        },
        getData: function() {
            return this.params;
        }
    }
});





