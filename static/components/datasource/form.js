var DataSourceForm = Vue.component('datasource-form', {
    template: '<el-form ref="form" :rules="rules" :model="form" label-width="80px" size="small">\
        <el-form-item label="名称"  prop="name">\
            <el-input v-model="form.name"></el-input>\
        </el-form-item>\
        <el-form-item label="Url" prop="url">\
            <el-input v-model="form.url"></el-input>\
        </el-form-item>\
        <el-form-item label="用户名" prop="username">\
            <el-input v-model="form.username"></el-input>\
        </el-form-item>\
        <el-form-item label="密码" prop="password">\
            <el-input v-model="form.password"></el-input>\
        </el-form-item>\
        <el-form-item>\
            <slot></slot>\
        </el-form-item>\
    </el-form>',
    data: function () {
        return {
            form: {
                name: '',
                url: '',
                username: '',
                password: ''
            },
            rules: {
                name: [
                    { required: true, message: '请输入名称', trigger: 'blur' }
                ],
                url: [
                    { required: true, message: '请输入Url', trigger: 'blur' }
                ],
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' }
                ]
            }
        }
    }
});


