function loginApi(data) {
  return $axios({
    'url': '/staff/login',
    'method': 'post',
    data,
    withCredentials: true
  })
}

function logoutApi() {
  return $axios({
    'url': '/staff/logout',
    'method': 'post',
    withCredentials: true
  })
}
