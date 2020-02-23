import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/dashboard'
    },
    {
      path: '/',
      component: () => import('@/components/common/Home.vue'),
      meta: { title: '自述文件' },
      children: [
        {
          path: '/dashboard',
          component: () => import('@/views/Employee.vue'),
          meta: { title: '系统首页' }
        },
        {
          path: '/department',
          component: () => import('@/views/Department.vue'),
          meta: { title: '部门管理' }
        },
        {
          path: '/employee',
          component: () => import('@/views/Employee.vue'),
          meta: { title: '员工管理' }
        },
        {
          path: '/attend',
          component: () => import('@/views/Attend.vue'),
          meta: { title: '考勤管理' }
        },
        {
          path: '/404',
          component: () => import('@/components/page/404.vue'),
          meta: { title: '404' }
        },
        {
          path: '/403',
          component: () => import('@/components/page/403.vue'),
          meta: { title: '403' }
        },
        {
          path: '/repass',
          component: () => import('@/components/RePass.vue'),
          meta: { title: '密码修改' }
        }

      ]
    },
    {
      path: '/login',
      component: () => import('@/views/Login.vue'),
      meta: { title: '登录' }
    },
    {
      path: '/daka',
      component: () => import('@/components/Daka.vue')
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
})
