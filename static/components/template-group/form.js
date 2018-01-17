var TemplateGroupForm = Vue.component('template-group-form', {
    template: '<el-form ref="form" :rules="rules" :model="form" label-width="80px">\
        <el-form-item label="名称" prop="name">\
            <el-input v-model="form.name"></el-input>\
        </el-form-item>\
        <el-form-item label="模板">\
            <el-checkbox v-for="t in templates" \
                :label="t.name" @change="v => handleChange(t.id, v)" \
                :checked="form.tIds.indexOf(t.id) != -1"\
                border>\
            </el-checkbox>\
        </el-form-item>\
        <el-form-item>\
            <slot></slot>\
        </el-form-item>\
    </el-form>',
    mounted: function() {
        axios.get('/templates')
            .then(function (resp) {
                this.templates = resp.data;
            }.bind(this));
    },
    data: function () {
        return {
            templates: [],
            form: {
                name: '',
                tIds: []
            },
            inputVisible: false,
            inputValue: '',
            rules: {
                name: [
                    { required: true, message: '请输入名称', trigger: 'blur' }
                ]
            }
        }
    },
    methods: {
        handleChange: function(id, checked) {
            var index = this.form.tIds.indexOf(id);
            if (checked && index == -1) {
                this.form.tIds.push(id);
            } else  if (index != -1) {
                this.form.tIds.splice(index, 1);
            }
        }
    }
});


