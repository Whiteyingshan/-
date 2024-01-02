import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/employee/list',
    method: 'get',
    params: query
  })
}

export function fetchArticle(id) {
  return request({
    url: '/vue-element-admin/article/detail',
    method: 'get',
    params: { id }
  })
}

export function fetchPv(pv) {
  return request({
    url: '/vue-element-admin/article/pv',
    method: 'get',
    params: { pv }
  })
}

export function createArticle(data) {
  return request({
    url: '/employee/add',
    method: 'post',
    data
  })
}

export function updateArticle(data) {
  return request({
    url: '/employee/edit',
    method: 'put',
    data
  })
}

export function deleteArticle(id) {
  return request({
    url: '/employee/delete',
    method: 'delete',
    params: { id }
  })
}
export function sexCount() {
  return request({
    url: '/employee/sex_count',
    method: 'get'
  })
}
export function deptCount() {
  return request({
    url: '/employee/dept_count',
    method: 'get'
  })
}
export function degreeCount() {
  return request({
    url: '/employee/degree_count',
    method: 'get'
  })
}

