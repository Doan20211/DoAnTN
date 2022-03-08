<template>
  <div>
    <div class="border mb-2" style="">
      <h1>Đề bài</h1>
      <div style="">
        <textarea
          name=""
          id=""
          cols="150"
          rows="10"
          v-model="thread"
          disabled
        ></textarea>
      </div>
    </div>
    <div class="row">
      <div class="col-6">
        <h2>Đầu vào</h2>
        <textarea
          name="code"
          cols="70"
          rows="10"
          v-model="requestBody.input"
        ></textarea>
      </div>
      <div class="col-6">
        <h2>Kết quả</h2>
        <textarea
          name="result"
          cols="70"
          rows="10"
          v-model="requestBody.result"
        ></textarea>
      </div>
      </div>
    </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      thread: "Viết chương trình HelloWorld. \nInput: \nOutput: HelloWorld\n",
      requestBody: {
        code: "#include<iostream> \n using namespace std; \n int main(){\n    return 0;\n}",
        language: "cpp",
        input: "",
      },
      result: "",
    };
  },
  methods: {
    getQuestion() {
      console.log(this.requestBody.code);
    },
  },
};
</script>

<style>
</style>