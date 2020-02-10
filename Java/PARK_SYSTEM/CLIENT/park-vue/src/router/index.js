import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Admin from '@/views/Admin'
import Operator from '@/views/Operator'
import Charge from '@/views/Charge'
import Station from '@/views/Station'
import FreeStation from '@/views/FreeStation'
import Card from '@/views/Card'
import Info from '@/views/Info'
import Login from '@/views/Login'
import CardMoney from '@/views/CardMoney'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      children: [{
        path: '/Admin',
        name: 'Admin',
        component: Admin
      },
      {
        path: '/Operator',
        name: 'Operator',
        component: Operator
      },
      {
        path: '/Charge',
        name: 'Charge',
        component: Charge
      },
      {
        path: '/Station',
        name: 'Station',
        component: Station
      },
      {
        path: '/FreeStation',
        name: 'FreeStation',
        component: FreeStation
      },
      {
        path: '/Card',
        name: 'Card',
        component: Card
      },
      {
        path: '/info',
        name: 'Info',
        component: Info
      }, {
        path: '/CardMoney',
        name: 'CardMoney',
        component: CardMoney
      }
      ]
    },
    {
      path: '/',
      name: 'Login',
      component: Login
    }
  ]
})
