var MyBreadcrumbContainer = Vue.component('my-breadcrumb-container', {
	template : '<el-breadcrumb separator-class="el-icon-arrow-right">\
		<el-breadcrumb-item v-show="false"></el-breadcrumb-item>\
		<el-breadcrumb-item :key="index" v-show="item.name && item.path != \'/\'" \
			v-for="(item, index) in breadcrumbs" :to="item">\
			{{item.name}}\
		</el-breadcrumb-item>\
	</el-breadcrumb>',
	data: function() {
		return {
			breadcrumbs: []
		}
	},
	mounted: function() {
		this.breadcrumbs = (this.$route.matched.filter(function(m) {
				return m.path != '/';
			})) || [];
	},
	watch: {
		$route: function(to) {
			this.breadcrumbs = (to.matched) || [];
		}
	}
});
