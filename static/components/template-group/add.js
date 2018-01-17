var TemplateGroupAdd = Vue.component('template-group-add', {
    template: '<div>\
        <template-group-form ref="form">\
            <el-button size="small" type="primary" @click="onSubmit">提交</el-button>\
            <el-button size="small" @click="handleCancel">取消</el-button>\
        </template-group-form>\
    </div>',
    methods: {
        onSubmit: function() {
            var formComp = this.$refs.form;
            formComp.$refs.form.validate(function(v) {
                if (v) {
                    var params = formComp.form;
                    axios.post('/templateGroups', params)
                        .then(function(resp) {
                            this.$notify({
                                title: '提示',
                                message: '添加成功',
                                position: 'bottom-right'
                            });
                            this.$router.go(-1);
                        }.bind(this))
                        .catch(function(error) {
                            console.log(error);
                        });
                } else {
                    return false;
            }}.bind(this));
        },
        handleCancel: function() {
            this.$router.go(-1);
        }
    }
});


