import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
//引入 element
// import Element from 'element-ui'
// import'element-ui/lib/theme-chalk/index.css'


//使用 element
// Vue.use(Element);

Vue.config.productionTip = false;


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');


