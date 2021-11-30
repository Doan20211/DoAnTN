<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
import feather from 'feather-icons';
export default {
  name: 'app',
  data () {
    return {
      msg: ''
    }
  },
  method:{
    
  },
  mounted() {
      feather.replace();
    }
}
</script>

<style>
  @import url(./css/app.css);
</style>
