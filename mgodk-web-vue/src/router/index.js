import Vue from 'vue'
import VueRouter from 'vue-router'
// 引入自定义组件页面
import login from '../views/login'
import home from '../views/home'
import sysUser from '../views/sys_user/sysUser'


// const originalPush = VueRouter.prototype.push;
// VueRouter.prototype.push = function push(location) {
//   return originalPush.call(this, location).catch(err => err)
// };

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: '/login',
  }, {
    path: '/login',
    name: 'login',
    component: login,
  }, {
    path: '/home',
    component: home,
    children: [
      {
        path: '/sysUser',
        component: sysUser,
      }, {
        path: '/role',
        component: sysUser,
      },
    ],
  },
];


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
