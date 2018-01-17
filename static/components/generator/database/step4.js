var GeneratorDatabaseStep4 = Vue.component('generator-database-step4', {
    template: '<div>\
        <el-tabs tab-position="left" style="height: 400px;">\
            <el-tab-pane v-for="(t, i) in tables" :label="t.name">\
                <template v-for="(tmpl, j) in templates">\
                     <el-row>\
                        <el-col :span="4"><div style="padding: 8.5px 20px;">{{tmpl.name}}</div></el-col>\
                        <el-col :span="2">\
                            <div style="padding: 8.5px 1px;">\
                                <i v-if="result[i] && result[i][j].status === GENERATE_STATUS_EXECUTING" class="el-icon-loading"></i>\
                                <i v-if="result[i] && result[i][j].status === GENERATE_STATUS_SUCCESS" style="color:#67c23a;" class="el-icon-success"></i>\
                                <i v-if="result[i] && result[i][j].status === GENERATE_STATUS_FAILED" style="color:#f56c6c;" class="el-icon-error"></i>\
                            </div>\
                        </el-col>\
                        <el-col v-if="result[i] && result[i][j].fileContent" :span="2">\
                            <div><el-button type="text" @click="detail(result[i][j].fileContent)">查看</el-button></div>\
                        </el-col>\
                        <el-col v-else :span="2"><div><el-button type="text" @click="review(t.id, tmpl.id)">预览</el-button></div></el-col>\
                    </el-row>\
                </template>\
            </el-tab-pane>\
        </el-tabs>\
        <el-dialog\
            :title="dialogTitle"\
            :visible.sync="dialogVisible"\
            width="50%">\
                <span><pre v-highlightjs><code class="">{{dialogText}}</code></pre></span>\
                <span slot="footer" class="dialog-footer">\
                    <el-button @click="dialogVisible = false">关闭</el-button>\
                </span>\
        </el-dialog>\
    </div>',
    props: ['templates', 'tables', 'params', 'generateResult'],
    data: function () {
        return {
            dialogTitle: "",
            dialogVisible: false,
            dialogText: "",
            result: [].concat(this.generateResult)
        }
    },
    methods: {
        review: function(tableId, templateId) {
            axios.post('/generator/review', {
                'params': this.params,
                'template': this.templates.filter(function (t) {
                    return t.id === templateId;
                }.bind(this))[0],
                'table': this.tables.filter(function (t) {
                    return t.id === tableId;
                }.bind(this))[0]
            }).then(function (resp) {
                this.dialogTitle = "预览";
                this.dialogText = resp.data;
                this.dialogVisible = true;
            }.bind(this));
        },
        detail: function(fileContent) {
            this.dialogTitle = "查看";
            this.dialogText = fileContent;
            this.dialogVisible = true;
        }
    }
});





