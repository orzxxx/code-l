var GeneratorDatabaseStep1 = Vue.component('generator-database-step1', {
    template: '<div>\
        <el-row :gutter="20">\
          <el-col :span="6">\
            <div class="grid-content bg-purple">\
                <el-tree \
                    ref="tableTree"\
                    show-checkbox\
                    :data="treeData"\
                    :props="props"\
                    :load="loadNode"\
                    lazy\
                    accordion\
                    @check-change="handleCheckChange"\
                    @node-click="handleNodeClick">\
                </el-tree>\
            </div>\
          </el-col>\
          <el-col :span="18">\
            <div class="grid-content bg-purple">\
                <el-table\
                    ref="multipleTable"\
                    :data="tableData"\
                    tooltip-effect="dark"\
                    style="width: 100%"\
                    size="small">\
                    <el-table-column\
                      prop="key"\
                      label=""\
                      width="50">\
                      <template slot-scope="scope" v-if="scope.row.key">\
                        <i class="el-icon-fa-key"></i>\
                      </template>\
                    </el-table-column>\
                    <el-table-column\
                      prop="name"\
                      label="列名"\
                      width="200">\
                    </el-table-column>\
                    <el-table-column\
                      prop="type"\
                      label="类型"\
                      width="100">\
                    </el-table-column>\
                    <el-table-column\
                      prop="length"\
                      label="长度"\
                      width="80">\
                    </el-table-column>\
                    <el-table-column\
                      prop="scale"\
                      label="小数点"\
                      width="80">\
                    </el-table-column>\
                    <el-table-column\
                      prop="nullable"\
                      label="非空"\
                      width="80">\
                      <template slot-scope="scope">{{ scope.row.nullable ? "true" : "false" }}</template>\
                    </el-table-column>\
                    <el-table-column\
                      prop="defaultValue"\
                      label="默认值"\
                      width="100">\
                    </el-table-column>\
                    <el-table-column\
                      prop="comment"\
                      label="注释"\
                      width="200">\
                    </el-table-column>\
                </el-table>\
            </div>\
          </el-col>\
        </el-row>\
    </div>',
    mounted: function () {
        axios.get('/datasources')
            .then(function (resp) {
                this.treeData = resp.data;
            }.bind(this));
    },
    data: function () {
        return {
            treeData: [],
            props: {
                label: 'name',
                isLeaf: 'leaf'
            },
            tableData: []
        }
    },
    methods: {
        loadNode: function(node, resolve) {
            if (node.level ===0) {
                return;
            }
            if (node.level === 1) {
                this.loadSchema(node, resolve);
            } else if (node.level === 2) {
                resolve(node.data.tableInfos.map(function(t) {
                    return {
                        id: t.id,
                        name: t.name,
                        leaf: true,
                        columns: t.columns
                    }
                }));
                this.handleCheckChange(); // 在展开前已勾选，计算展开后选中数
            }
        },
        loadSchema: function(node, resolve) {
            axios.get('/databases/schemas/' + node.data.id, {loading: false})
                .then(function (resp) {
                    resolve(resp.data);
                }.bind(this));
        },
        handleCheckChange: function() {
            var checkedKeys = this.getCheckedKeys();
            this.$emit('set-checked-count', checkedKeys.length);
        },
        handleNodeClick: function (data, node) {
            if (node.isLeaf) {
                this.tableData = node.data.columns;
            }
        },
        validate: function() {
            var checkedKeys = this.getCheckedKeys();

            if (!(checkedKeys.length > 0)) {
                this.$notify({
                    title: '提示',
                    message: '请至少选择一张表',
                    position: 'bottom-right'
                });
                return false;
            }
            return true;
        },
        getCheckedKeys: function() {
            var checkedNodes = this.$refs.tableTree.getCheckedNodes();
            return checkedNodes.filter(function(n) {
                return n.leaf;
            }).map(function(n) {
                return n.id;
            });
        },
        getData: function() {
            return this.$refs.tableTree.getCheckedNodes().filter(function(n) {
                return n.leaf;
            }).map(function(n) {
                return {
                    id: n.id,
                    name: n.name,
                    columns: n.columns
                }
            });
        }
    }
});





