var TemplateForm = Vue.component('template-form', {
    template: '<el-form ref="form" :rules="rules" :model="form" label-width="80px">\
        <el-form-item label="名称" prop="name">\
            <el-input v-model="form.name"></el-input>\
        </el-form-item>\
        <el-form-item label="文件名" prop="fileName">\
            <el-input v-model="form.fileName"></el-input>\
        </el-form-item>\
        <el-form-item label="文件路径">\
            <el-input v-model="form.filePath"></el-input>\
        </el-form-item>\
        <el-form-item label="内容" prop="content">\
            <el-input type="textarea" v-model="form.content"></el-input>\
        </el-form-item>\
        <el-form-item label="变量">\
            <el-tag\
                :key="tag"\
                v-for="tag in form.tags"\
                closable\
                :disable-transitions="false"\
                @close="handleClose(tag)">\
                {{tag}}\
            </el-tag>\
            <el-input\
                class="input--new-tag"\
                v-if="inputVisible"\
                v-model="inputValue"\
                ref="saveTagInput"\
                size="small"\
                @keyup.enter.native="handleInputConfirm"\
                @blur="handleInputConfirm">\
            </el-input>\
            <el-button v-else class="button--new-tag" size="small" @click="showInput">+ New</el-button>\
        </el-form-item>\
        <el-form-item>\
            <slot></slot>\
        </el-form-item>\
    </el-form>',
    data: function () {
        return {
            form: {
                name: '',
                fileName: '',
                filePath: '',
                content: '',
                tags: []
            },
            inputVisible: false,
            inputValue: '',
            rules: {
                name: [
                    { required: true, message: '请输入名称', trigger: 'blur' }
                ],
                fileName: [
                    { required: true, message: '请输入文件名', trigger: 'blur' }
                ],
                content: [
                    { required: true, message: '请输入内容', trigger: 'blur' }
                ]
            }
        }
    },
    methods: {
        handleClose: function(tag) {
            this.form.tags.splice(this.form.tags.indexOf(tag), 1);
        },
        showInput: function() {
            this.inputVisible = true;
            this.$nextTick(function() {
                this.$refs.saveTagInput.$refs.input.focus();
            }.bind(this));
        },
        handleInputConfirm: function() {
            var inputValue = this.inputValue;
            if (inputValue) {
                this.form.tags.push(inputValue);
            }
            this.inputVisible = false;
            this.inputValue = '';
        }
    }
});


