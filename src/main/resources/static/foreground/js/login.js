function loginApi(data) {
  return $axios({
    'url': '/customer/login',
    'method': 'post',
    data
  })
}

function registerApi(data) {
  return $axios({
    'url': '/customer/register',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': '/customer/logout',
    'method': 'post',
  })
}
