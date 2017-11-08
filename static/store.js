var store = new Vuex.Store({
    state: {
        isMenuCollapse: false,
        bc1: '首页',
        bc2: '',
        bc3: '',
        bc4: ''
    },
    mutations: {
        setBC: function(state, payload) {
            state.bc1 = payload.bc1 || state.bc1;
            state.bc2 = payload.bc2 || state.bc2;
            state.bc3 = payload.bc3 || state.bc3;
            state.bc4 = payload.bc4 || state.bc4;
        },
        triggerMenu: function(state, isCollapse) {
            state.isMenuCollapse = isCollapse;
        }
    }
});