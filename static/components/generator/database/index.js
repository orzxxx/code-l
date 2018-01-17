var GeneratorDatabaseIndex = Vue.component('generator-database-index', {
    template: '<div>\
        <el-steps :active="step" align-center>\
            <el-step title="选择表" :description="\'已选\' + tableCount"></el-step>\
            <el-step title="选择模板" :description="\'已选\' + templateCount"></el-step>\
            <el-step title="填写参数"></el-step>\
            <el-step title="生成"></el-step>\
        </el-steps>\
        </br>\
        <div class="my__generator">\
            <generator-database-step1 ref="step1" v-if="step === 0" @set-checked-count="handleCheckedTableCount"></generator-database-step1>\
            <generator-database-step2 ref="step2" v-if="step === 1" @set-template-count="handleCheckedTemplateCount"></generator-database-step2>\
            <generator-database-step3 ref="step3" v-if="step === 2" :templates="selectedTemplates"></generator-database-step3>\
            <generator-database-step4 ref="step4" v-if="step === 3" \
                :tables="selectedTables"\
                :params="params"\
                :templates="selectedTemplates"\
                :generateResult="generateResult">\
            </generator-database-step4>\
        </div>\
        </br>\
        <div>\
            <el-button :disabled="step === 0" @click="handlePrevious" size="small">上一步</el-button>\
            <el-button type="primary" v-if="step !== 3" @click="handleNext" size="small">\
                {{"下一步"}}\
            </el-button>\
            <el-button type="primary" v-if="step === 3" @click="generate(false)" size="small">\
                {{"测试"}}\
            </el-button>\
            <el-button type="primary" v-if="step === 3" @click="generate(true)" size="small">\
                {{"生成"}}\
            </el-button>\
        </div>\
    </div>',
    data: function () {
        return {
            step: 0,
            tableCount: 0,
            templateCount: 0,
            selectedTemplates: [],
            selectedTables: [],
            params: {}
        }
    },
    computed: {
        generateResult: function () {
            var result = [];
            for (var i = 0; i < this.selectedTables.length; i++) {
                var status = [];
                for (var j = 0; j < this.selectedTemplates.length; j++) {
                    status.push({
                        status: null,
                        fileContent: ""
                    });
                }
                result.push(status);
            }
            return result;
        }
    },
    methods: {
        handleCheckedTableCount: function(count) {
            this.tableCount = count;
        },
        handleCheckedTemplateCount: function(count) {
            this.templateCount = count;
        },
        handlePrevious: function() {
            this.step -= 1;
        },
        handleNext: function() {
            var validMark = true;
            if (this.step === 0) {
                validMark = this.$refs.step1.validate();
                if (validMark) {
                    this.selectedTables = this.$refs.step1.getData();
                }
            } else if (this.step === 1) {
                validMark = this.$refs.step2.validate();
                if (validMark) {
                    this.selectedTemplates = this.$refs.step2.getData();
                }
            } else if (this.step === 2) {
                validMark = this.$refs.step3.validate();
                if (validMark) {
                    this.params = this.$refs.step3.getData();
                }
            }

            if (validMark) {
                this.step += 1;
            }
        },
        generate: function(generated) {
            for (var i = 0; i < this.selectedTables.length; i++) {
                for (var j = 0; j < this.selectedTemplates.length; j++) {
                    this.doGenerate(i, j, generated);
                }
            }
        },
        doGenerate: function(i, j, generated) {
            Vue.set(this.generateResult[i], j, Object.assign({}, this.generateResult[i][j], {
                status: this.GENERATE_STATUS_EXECUTING
            }));
            axios.post('/generator/review', {
                'params': this.params,
                'template': this.selectedTemplates[j],
                'table': this.selectedTables[i],
                'generated': generated
            }).then(function (resp) {
                    Vue.set(this.generateResult[i], j, Object.assign({}, this.generateResult[i][j], {
                        status: this.GENERATE_STATUS_SUCCESS,
                        fileContent: resp.data
                    }));
                }.bind(this))
                .catch(function (error) {
                    Vue.set(this.generateResult[i], j, Object.assign({}, this.generateResult[i][j], {
                        status: this.GENERATE_STATUS_FAILED
                    }));
                }.bind(this));
        }
    }
});


