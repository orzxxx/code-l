var GeneratorDatabaseStep2 = Vue.component('generator-database-step2', {
    template: '<div class="my__step__content">\
        <div>\
            <el-select v-model="value" placeholder="选择模板组" @change="handleChange" size="small">\
                <el-option\
                    v-for="item in templateGroups"\
                    :key="item.id"\
                    :label="item.name"\
                    :value="item.id">\
                </el-option>\
            </el-select>\
        </div>\
        </br>\
        <div>\
            <el-checkbox v-for="t in templates" size="small"\
                :label="t.name" @change="v => handleChangeChecked(t.id, v)" \
                border\
                v-model="t.checked">\
             </el-checkbox>\
        </div>\
    </div>',
    mounted: function () {
        axios.get('/templateGroups')
            .then(function (resp) {
                this.templateGroups = resp.data;
            }.bind(this));

        axios.get('/templates')
            .then(function (resp) {
                this.templates = resp.data;
                this.templates.forEach(function(t, i) {
                    Vue.set(this.templates, i, Object.assign({}, this.templates[i], {
                        checked: false
                    }));
                }.bind(this));
            }.bind(this));
    },
    data: function () {
        return {
            templateGroups: [],
            value: '',
            templates: [],
            checkedTemplateIds: []
        }
    },
    methods: {
        handleChangeChecked: function(id, checked) {
            var index = this.checkedTemplateIds.indexOf(id);
            if (checked && index === -1) {
                this.checkedTemplateIds.push(id);
            } else  if (index !== -1) {
                this.checkedTemplateIds.splice(index, 1);
            }

            this.$emit('set-template-count', this.checkedTemplateIds.length);
        },
        handleChange: function(value) {
            this.checkedTemplateIds = [];

            var tIds = this.templateGroups.filter(function(tg) {
                return tg.id === value;
            })[0].tIds;

            this.templates.forEach(function(t, i) {
               if (tIds.indexOf(t.id) !== -1) {
                   Vue.set(this.templates, i, Object.assign({}, this.templates[i], {
                       checked: true
                   }));
                   this.checkedTemplateIds.push(t.id);
               } else {
                   Vue.set(this.templates, i, Object.assign({}, this.templates[i], {
                       checked: false
                   }));
               }
            }.bind(this));

            this.$emit('set-template-count', this.checkedTemplateIds.length);
        },
        validate: function() {
            if (!(this.checkedTemplateIds.length > 0)) {
                this.$notify({
                    title: '提示',
                    message: '请至少选择一张表',
                    position: 'bottom-right'
                });
                return false;
            }
            return true;
        },
        getData: function() {
            return this.templates.filter(function(t) {
                return this.checkedTemplateIds.indexOf(t.id) !== -1;
            }.bind(this));
        }
    }
});





