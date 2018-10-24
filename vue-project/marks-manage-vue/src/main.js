import Vue from 'vue';
import App from './App';
import router from './router';
import axios from 'axios';
import ElementUI from 'element-ui';
import VueResource from 'vue-resource';
import 'element-ui/lib/theme-chalk/index.css';    // 默认主题

// import '../static/css/theme-green/index.css';       // 浅绿色主题
import '../static/css/icon.css';
import "babel-polyfill";

Vue.use(VueResource);
Vue.use(ElementUI, {size: 'small'});
Vue.prototype.$axios = axios;
Vue.http.interceptors.push((request, next) => {
    const token = sessionStorage.getItem('token');
    // modify request
    request.headers.set('token', token);
    // continue to next interceptor
    const selt = this;
    next((response) => {//在响应之后传给then之前对response进行修改和逻辑判断。对于token时候已过期的判断，就添加在此处，页面中任何一次http请求都会先调用此处方法
        //如果session失效，跳转登录页面
        if (response.data.code == 10006) {
            //跳转回login路由，并把目标路由的url路径保存在login的query中
            console.log(router.currentRoute.fullPath);
            router.push({
                path: "/login",
                query: {redirect: router.currentRoute.fullPath}
            })
        } else {
            return response;
        }
    });

});

//使用钩子函数对路由进行权限跳转
router.beforeEach((to, from, next) => {
    const role = sessionStorage.getItem('token');
    if (!role && to.path !== '/login') {
        next('/login');
    } else if (to.meta.permission) {
        // 如果是管理员权限则可进入，这里只是简单的模拟管理员权限而已
        role === 'admin' ? next() : next('/403');
    } else {
        // 简单的判断IE10及以下不进入富文本编辑器，该组件不兼容
        if (navigator.userAgent.indexOf('MSIE') > -1 && to.path === '/editor') {
            Vue.prototype.$alert('vue-quill-editor组件不兼容IE10及以下浏览器，请使用更高版本的浏览器查看', '浏览器不兼容通知', {
                confirmButtonText: '确定'
            });
        } else {
            next();
        }
    }
})

new Vue({
    router,
    render: h => h(App)
}).$mount('#app');
