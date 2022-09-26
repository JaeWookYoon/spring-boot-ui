import {createRouter, createWebHistory} from "vue-router";
import coinView from '../components/coinView/coinView.vue'
import jusikView from '../components/jusikView/jusikView.vue'
import tokenTest from '../components/tokenTest/tokenTest.vue'
const routes = [{
                       path:"/coin",
                       name:"coin",
                       component:coinView
                   },{
                       path:"/jusik",
                       name:"jusik",
                       component:jusikView
                   },{
                       path:"/token",
                       name:"token",
                       component:tokenTest
                   }]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router;