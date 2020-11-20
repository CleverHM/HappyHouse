
<template>
  <div id="app" class="container">
    <router-view></router-view>
  </div>
</template>

<script>
import NavHeader from '@/components/layout/Header.vue';

export default {
  name: 'App',

  data:{
    name: '',
  },

  components: {
    NavHeader
  },

  created() {
    this.$router.push('/list');
  },
}
</script>

<style>
</style>
