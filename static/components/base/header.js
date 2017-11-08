var MyHeader = Vue.component('my-header', {
	template : '<div>\
		<el-row>\
			<el-col :span="4"\
				<div @click="handleClick">\
					<transition name="my-header__collapse--rotate" mode="out-in">\
						<component v-bind:is="view"></component>\
					</transition>\
				</div>\
			</el-col>\
		</el-row>\
	</div>',
	methods: {
		handleClick: function() {
			this.icon = this.isClicked ? 'el-icon-fa-align-justify' : 'el-icon-fa-align-justify el-icon-fa-rotate-90' ;
			this.view = this.isClicked ? 'aj' : 'ajr90';
			this.isClicked = !this.isClicked;
			store.commit('triggerMenu', this.isClicked );
		}
	},
	data: function() {
		return {
			icon: "el-icon-fa-align-justify",
			view: 'aj',
			isClicked: false
		}
	},
	components: {
		'aj': {
			template: '<el-button type="text" icon="el-icon-fa-align-justify" ></el-button>'
		},
		'ajr90': {
			template: '<el-button type="text" icon="el-icon-fa-align-justify el-icon-fa-rotate-90"></el-button>'
		}
	}
});
