var DataSourceIndex = Vue.component('datasource-index', {
    template: '<div>\
        <div class="my__filter-container">\
            <el-button class="my__filter-container__item" type="primary" icon="el-icon-fa-plus" @click="handleAdd">新增</el-button>\
        </div>\
        <el-table\
            :data="tableData"\
            tooltip-effect="dark"\
            style="width: 99%;">\
            <el-table-column\
                 prop="name"\
                 label="名称"\
                 min-width="15%">\
            </el-table-column>\
            <el-table-column\
                 prop="url"\
                 label="Url"\
                 min-width="50%">\
            </el-table-column>\
            <el-table-column\
                 prop="username"\
                 label="用户名"\
                 min-width="10%">\
            </el-table-column>\
            <el-table-column\
                 prop="password"\
                 label="密码"\
                 min-width="10%">\
            </el-table-column>\
            <el-table-column \
                label="操作"\
                min-width="15%">\
                <template slot-scope="scope">\
                    <el-button\
                        size="mini"\
                        @click="handleEdit(scope.$index, scope.row)">编辑</el-button>\
                    <el-button\
                        size="mini"\
                        type="danger"\
                        @click="handleDelete(scope.$index, scope.row)">删除</el-button>\
                </template>\
            </el-table-column>\
        </el-table>\
    </div>',
    mounted: function () {
        axios.get('/datasources')
            .then(function (resp) {
                this.tableData = resp.data;
            }.bind(this))
            .catch(function (error) {
                console.log(error);
            });
    },
    data: function () {
        return {
            tableData: []
        }
    },
    watch: {
        $route: function() {
            axios.get('/datasources')
                .then(function (resp) {
                    this.tableData = resp.data;
                }.bind(this))
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    methods: {
        handleAdd: function() {
            router.push("datasources/new");
        },
        handleEdit: function(index, row) {
            router.push("datasources/" + row.id);
        },
        handleDelete: function(index, row) {
            this.$confirm('确定删除？', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(function() {
                axios.delete('/datasources/' + row.id)
                    .then(function (resp) {
                        this.$notify({
                            title: '提示',
                            message: '删除成功',
                            position: 'bottom-right'
                        });
                        this.tableData = this.tableData.filter(function(d) {
                            return d.id != row.id;
                        });
                    }.bind(this))
                    .catch(function (error) {
                        console.log(error);
                    });
            }.bind(this));
        }
    }
});


