// 查询列表页接口
const getOrderDetailPage = (params) => {
  return $axios({
    url: '/order/page',
    method: 'get',
    params
  })
}


// 取消，派送，完成接口
function editOrderDetail (id) {
  return $axios({
    url: `/order/${id}`,
    method: 'put'
  })
}
