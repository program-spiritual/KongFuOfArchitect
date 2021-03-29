import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/layout'

export const constantRoutes = [
  {
    path: '/lodash',
    component: Layout,
    children: [
      {
        path: 'demo1',
        component: () => import('@/views/lodash/demo1'),
        name: 'lodashDemo1',
      },
    ],
  },
  {
    path: '/snabbdom',
    component: Layout,
    children: [
      {
        path: 'demo1',
        component: () => import('@/views/snabbdom/demo1'),
        name: 'snabbdomDemo1',
      },
      {
        path: 'demo2',
        component: () => import('@/views/snabbdom/demo2'),
        name: 'snabbdomDemo2',
      },
    ],
  },
]

const createRouter = () =>
  new Router({
    base: '/',
    mode: 'history',
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes,
  })

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
