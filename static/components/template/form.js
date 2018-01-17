var TemplateForm = Vue.component('template-form', {
    template: '<div>\
        <el-form ref="form" :rules="rules" :model="form" size="small" label-width="80px">\
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
                <el-button size="small" type="primary" @click="handleEditContent">编辑</el-button>\
                <el-button size="small" type="primary" @click="handleDetail">查看</el-button>\
            </el-form-item>\
            <el-form-item label="参数">\
                <el-tag\
                    :key="parameter"\
                    v-for="parameter in form.parameters"\
                    closable\
                    :disable-transitions="false"\
                    @close="handleClose(parameter)">\
                    {{parameter}}\
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
                <el-button size="small" v-else class="button--new-tag" @click="showInput">+ New</el-button>\
            </el-form-item>\
            <el-form-item>\
                <slot></slot>\
                 <el-button size="small" type="danger" @click="handleClickTest">测试</el-button>\
            </el-form-item>\
        </el-form>\
        <el-dialog\
            title="查看"\
            :visible.sync="detailDialogVisible"\
            width="50%">\
                <span><pre v-highlightjs="form.content"><code class=""></code></pre></span>\
                <span slot="footer" class="dialog-footer">\
                <el-button @click="detailDialogVisible = false">关闭</el-button>\
            </span>\
        </el-dialog>\
        <el-dialog\
            title="编辑"\
            :visible.sync="editDialogVisible"\
            width="50%">\
                <span>\
                    <el-input ref="textarea" type="textarea" \
                        autosize\
                        @keydown.tab.native="handleTab"\
                        v-model="form.content">\
                        {{editDialogText}}\
                    </el-input>\
                </span>\
                <span slot="footer" class="dialog-footer">\
                <el-button @click="editDialogVisible = false">关闭</el-button>\
            </span>\
        </el-dialog>\
        <el-dialog\
            title="测试"\
            :visible.sync="testDialogVisible"\
            width="50%">\
                <span><pre v-highlightjs="testDialogText"><code class=""></code></pre></span>\
                <span slot="footer" class="dialog-footer">\
                <el-button @click="testDialogVisible = false">关闭</el-button>\
            </span>\
        </el-dialog>\
    </div>',
    data: function () {
        return {
            detailDialogVisible: false,
            testDialogVisible: false,
            testDialogText: "",
            editDialogVisible: false,
            editDialogText: "",
            form: {
                name: '',
                fileName: '',
                filePath: '',
                content: '',
                parameters: []
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
        handleClickTest: function() {
            axios.post('/generator/test', {
                'params': this.buildParams(this.form.parameters),
                'template': this.form
            }).then(function (resp) {
                this.testDialogVisible = true;
                this.testDialogText = resp.data;
            }.bind(this));
        },
        buildParams: function(paramters) {
            var result = {};
            paramters.forEach(function(p) {
                result[p] = p;
            });
            return result;
        },
        handleTab: function(e) {
            // TODO 光标会移到最后，vue的渲染导致的？
            var textareaEle = this.$refs.textarea.$el.lastElementChild;
            var start = textareaEle.selectionStart;
            var end = textareaEle.selectionEnd;
            this.form.content =  textareaEle.value.substring(0, start) + '\t' + textareaEle.value.substring(end, textareaEle.value.length);

            // 阻止默认切换元素的行为
            e.preventDefault();
        },
        handleDetail: function() {
            this.detailDialogText = this.form.content;
            this.detailDialogVisible = true;
        },
        handleEditContent: function() {
            this.editDialogText = this.form.content;
            this.editDialogVisible = true;
        },
        handleClose: function(parameter) {
            this.form.parameters.splice(this.form.parameters.indexOf(parameter), 1);
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
                this.form.parameters.push(inputValue);
            }
            this.inputVisible = false;
            this.inputValue = '';
        }
    }
});


