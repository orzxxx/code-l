var TemplateGroupEdit = Vue.component('template-group-edit', {
    template: '<div>\
        <template-group-form ref="form">\
            <el-button type="primary" @click="onSubmit">提交</el-button>\
            <el-button @click="handleCancel">取消</el-button>\
        </template-group-form>\
    </div>',
    mounted: function () {
        axios.get('/templateGroups/' + this.$route.params.id)
            .then(function (resp) {
                resp.data.templates = resp.data.templates || [];
                this.$refs.form.form = resp.data;
            }.bind(this));
    },
    methods: {
        onSubmit: function() {
            var formComp = this.$refs.form;
            formComp.$refs.form.validate(function(v) {
                if (v) {
                    var params = formComp.form;
                    axios.put('/templateGroups', params)
                        .then(function (resp) {
                            this.$notify({
                                title: '提示',
                                message: '修改成功',
                                position: 'bottom-right'
                            });
                            this.$router.go(-1);
                        }.bind(this));
                } else {
                    return false;
                }}.bind(this));
        },
        handleCancel: function() {
            this.$router.go(-1);
        }
    }
});

