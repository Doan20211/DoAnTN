<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
import feather from "feather-icons";
import Login from "./views/Login.vue";
export default {
  name: "app",
  data() {
    return {
      msg: "",
    };
  },
  method: {},
  mounted() {
    feather.replace();
  },
  components:{
    Login
  }
};
</script>

<style>
@import url(./css/app.css);
</style>
