import Vue from 'vue'
import VueRouter from 'vue-router'
//
import Home from '../views/Home.vue'
import login from '../views/login'
import sysUser from '../views/sysUser'




Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  }, {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue'),
  },
  {
    path: '/login',
    name: 'Login',
    component: login,
  }, {
    path: '/menu',
    component: Home,
    children: [
      {
        path: '/sysUser',
        component: sysUser,
      }, {
        path: '/role',
        component: Home,
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
