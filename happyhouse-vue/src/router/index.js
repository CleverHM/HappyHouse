import Vue from "vue";
import VueRouter from "vue-router";

import List from '@/components/page/List.vue';
import Create from '@/components/page/Create.vue';
import Read from '@/components/page/Read.vue';
import Update from '@/components/page/Update.vue';
import Delete from '@/components/page/Delete.vue';
import Reply from '@/components/page/Reply.vue';


Vue.use(VueRouter);

export default new VueRouter({
  base : '/happyhouse',
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/list' 
    },
    {
      path: '/list',
      name: 'list',
      component: List
    },
    {
      path: '/create',
      name: 'create',
      component: Create
    },
    {
      path: '/read',
      name: 'read',
      component: Read
    },
    {
      path: '/update',
      name: 'update',
      component: Update
    },
    
    {
      path: '/delete/:no',
      name: 'delete',
      component: Delete
    },

    {
      path: '/reply/:no',
      name: 'reply',
      component: Reply
    }
    
  ]
});