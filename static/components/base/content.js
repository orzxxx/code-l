var MyContent = Vue.component('my-content', {
    template: '<div id="app">\
	<el-row :gutter="20">\
	  <el-col :span="8">\
	  	<div class="grid-content bg-purple">\
	  		<el-tree \
				:data="data" \
				:props="defaultProps" \
				accordion \
				@node-click="handleNodeClick"> \
			</el-tree>\
	  	</div>\
	  </el-col>\
	  <el-col :span="16">\
	  	<div class="grid-content bg-purple">\
	  		<el-table\
			    ref="multipleTable"\
			    :data="tableData"\
			    tooltip-effect="dark"\
			    style="width: 100%">\
			    <el-table-column\
			      type="selection"\
			      width="55">\
			    </el-table-column>\
			    <el-table-column\
			      prop="name"\
			      label="列名"\
			      width="120">\
			    </el-table-column>\
			    <el-table-column\
			      prop="type"\
			      label="类型"\
			      width="120">\
			    </el-table-column>\
			    <el-table-column\
			      prop="length"\
			      label="长度"\
			      width="120">\
			    </el-table-column>\
			    <el-table-column\
			      prop="scale"\
			      label="小数点"\
			      width="120">\
			    </el-table-column>\
			    <el-table-column\
			      prop="nullable"\
			      label="非空"\
			      width="120">\
			      <template slot-scope="scope">{{ scope.row.nullable ? "true" : "false" }}</template>\
			    </el-table-column>\
			    <el-table-column\
			      prop="defaultValue"\
			      label="默认值"\
			      width="120">\
			    </el-table-column>\
			    <el-table-column\
			      prop="comment"\
			      label="注释"\
			      width="120">\
			    </el-table-column>\
			    <el-table-column\
			      prop="key"\
			      label=""\
			      width="120">\
			      <template slot-scope="scope" v-if="scope.row.key">\
			      	<i class="el-icon-fa-key"></i>\
			      </template>\
			    </el-table-column>\
			</el-table>\
	  	</div>\
	  </el-col>\
	</el-row>\
</div>',
    created: function () {
        var self = this;
        axios.get('/matedate')
            .then(function (resp) {
                self.data = resp.data;
            })
            .catch(function (error) {
                console.log(error);
            });
    },
    data: function () {
        return {
            data: [{
                name: ''
            }],
            defaultProps: {
                children: 'tableInfos',
                label: 'name'
            },
            tableData: []
        }
    },
    methods: {
        handleNodeClick: function (data, node) {
            if (node.isLeaf) {
                var self = this;
                axios.get('/tables/' + data.name)
                    .then(function (resp) {
                        self.tableData = resp.data.columns;
                    }).catch(function (error) {
                    console.log(error);
                });
            }
        }
    }
});


