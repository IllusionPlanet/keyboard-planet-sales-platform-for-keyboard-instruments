// 查询列表接口
const getDisplayPage = (params) => {
  return $axios({
    url: '/product/display',
    method: 'get',
    params
  })
}

// 修改接口
const editDish = (params) => {
  return $axios({
    url: '/product',
    method: 'put',
    data: { ...params }
  })
}

// 查询详情
const queryProductById = (id) => {
  return $axios({
    url: `/product/${id}`,
    method: 'get'
  })
}

// 获取菜品分类列表
const getCategoryList = (params) => {
  return $axios({
    url: '/category/list',
    method: 'get',
    params
  })
}

// 查菜品列表的接口
const queryDishList = (params) => {
  return $axios({
    url: '/product/list',
    method: 'get',
    params
  })
}

// 文件down预览
const commonDownload = (params) => {
  return $axios({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
    },
    url: '/common/download',
    method: 'get',
    params
  })
}
