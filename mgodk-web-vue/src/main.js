import Vue from 'vue'
import App from './App.vue'
//引入依赖及插件
import router from './router'
import store from './store'
import './plugins/registerServiceWorker'
import'./plugins/element'
import 'babel-polyfill'
import axios from 'axios'
import moment from 'moment'
import qs from 'qs'

// 引入全局样式
import './assets/font/iconfont.css'
// import './assets/css/style.css'
// import './assets/css/global.css'
import util from './assets/js/util'

Vue.config.productionTip = false;

axios.defaults.baseURL = '/api';  // 请求根路径，将自动加到 url 前面，便于传递使用相对 url
// axios.defaults.withCredentials = true;  // 请求 发送 cookie
// 添加请求拦截器
// 添加响应拦截器





Vue.prototype.$http = axios;
Vue.prototype.$qs = qs;
Vue.prototype.$moment = moment;
Vue.prototype.$util = util;
Vue.prototype.openLoading = function () {
  //自定义 Loading 对象属性
  let loading = this.$loading({
    target: '.sub-main',  // 覆盖的Dom节点，默认为 document.body；若传入字符串，使用 document.querySelector获取节点
    body: false,  // 默认 false
    fullscreen: true, // 默认 true
    lock: true,  // 是否锁屏，默认 false
    text: '请稍后...', // 加载图标下方文字
    spinner: 'el-icon-loading',  // 加载图标类名
    background: 'rgba(0, 0, 0, 0.7)', // 遮罩背景色
    customClass: 'mask',  //自定义类名，及遮罩层类名
  });
  //设置定时器，加载超时5s后关闭遮罩层，防止失败时一直加载
  setTimeout(function () {
    loading.close();
  },5000);
  return loading;
};





new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');


