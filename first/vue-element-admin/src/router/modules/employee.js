/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const employeeRouter = {
  path: '/employee',
  component: Layout,
  redirect: '/employee/list',
  name: 'Employee',
  meta: {
    title: 'employee',
    icon: 'example'
  },
  children: [
    {
      path: 'count',
      component: () => import('@/views/employee/count'),
      name: 'EmployeeCount',
      meta: { title: 'employeeCount', icon: 'edit' }
    },
    {
      path: 'list',
      component: () => import('@/views/employee/list'),
      name: 'EmployeeList',
      meta: { title: 'employeeList', icon: 'list' }
    }
  ]
}
export default employeeRouter
