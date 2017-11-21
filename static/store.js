var store = new Vuex.Store({
    state: {
        isMenuCollapse: false
    },
    mutations: {
        triggerMenu: function(state, isCollapse) {
            state.isMenuCollapse = isCollapse;
        }
    }
});