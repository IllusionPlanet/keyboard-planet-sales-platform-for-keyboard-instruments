function addOrder(data) {
    return $axios({
        'url': '/order',
        'method': 'post',
        data
    })
}

// 查询列表页接口
const getOrder = (params) => {
    return $axios({
        url: '/order/page2',
        method: 'get',
        params
    })
}