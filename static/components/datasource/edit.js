var DataSourceEdit = Vue.component('datasource-edit', {
    template: '<div>\
        <datasource-form ref="form">\
            <el-button type="primary" @click="onSubmit">提交</el-button>\
            <el-button @click="handleCancel">取消</el-button>\
        </datasource-form>\
    </div>',
    mounted: function () {
        axios.get('/datasources/' + this.$route.params.id)
            .then(function (resp) {
                this.$refs.form.form = resp.data;
            }.bind(this));
    },
    methods: {
        onSubmit: function() {
            var formComp = this.$refs.form;
            formComp.$refs.form.validate(function(v) {
                if (v) {
                    var params = formComp.form;
                    axios.put('/datasources', params)
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


