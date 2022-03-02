<template>
  <div class="about">
    <h1>This is an about page</h1>
    <button @click="getInfo" class="btn btn-primary">get Info</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {

    }
  },
  methods: {
    getInfo() {
      axios
        .create({
            headers: {
              "Access-Control-Allow-Origin": "*",
              "Access-Control-Allow-Methods":
                "GET, POST, PUT, DELETE, PATCH, OPTIONS",
              "Access-Control-Allow-Headers":
                "X-Requested-With, content-type, Authorization",
                "Content-Type": "application/json"
            },
          })
        .post('https://codexweb.netlify.app/.netlify/functions/enforceCode')
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        })

    }
  }
}
</script>