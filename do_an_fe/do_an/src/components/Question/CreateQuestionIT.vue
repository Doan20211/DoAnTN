<template>
  <div>
    <div class="mb-2" style="">
      <h1>Đề bài</h1>
      <div style="">
        <textarea
          name=""
          id=""
          cols="150"
          rows="10"
          v-model="thread"
        ></textarea>
      </div>
    </div>

    <div class="row">
      <div class="col-8 vue-brace row" id="vue-brace">  
        <div class="col-8"><h2>CODE</h2></div>
        <div class="col-4">
          <select class="form-select" aria-label="Default select example" v-model="requestBody.language">
            <!-- <option selected>Language</option> -->
            <option value="cpp">C++</option>
            <option value="c">C</option>
            <option value="cs">C#</option>
            <option value="java">Java</option>
            <option value="py">Python</option>
          </select>
        </div>
        <brace
          :value="requestBody.code"
          style="height: 300px"
          :fontsize="'12px'"
          :theme="'github'"
          :mode="'json'"
          :codefolding="'markbegin'"
          :selectionstyle="'text'"
          :highlightline="true"
          scroll
          class="border"
        >
        </brace>
      </div>
      <div class="col-4">
        <h2>ĐẦU VÀO</h2>
        <textarea
          style="height: 300px"
          name="result"
          cols="45"
          rows="10"
          v-model="requestBody.input"
        ></textarea>
      </div>
      <div>
        <Button @click="submit" class="btn btn-info btn-large">
          <span
            v-show="loading"
            class="spinner-border spinner-border-sm"
            role="status"
          ></span>
          <span>Chạy thử</span>
        </Button>
        <Button @click="createQuestion" class="btn btn-primary"
          >Thêm câu hỏi</Button
        >
      </div>
      <div class="text-center"></div>
      <div class="text-center mt-3">
        <h2>KẾT QUẢ</h2>
        <textarea
          name="result"
          cols="150"
          rows="10"
          v-model="result"
        ></textarea>
      </div>
    </div>
  </div>
</template>

<script>
import Brace from "vue-bulma-brace";
import axios from "axios";
import { HTTP } from "../../http-common";
export default {
  data() {
    return {
      thread:
        "Viết chương trình HelloWorld. \nInput: Không có đầu vào \nOutput: HelloWorld\n",
      requestBody: {
        code: "#include<iostream> \n using namespace std; \n int main(){\n\treturn 0;\n}",
        language: "cpp",
        input: "",
      },
      result: "",
      loading: false,
    };
  },
  methods: {
    setCodeRequest() {
      this.requestBody.code =
        document.getElementsByClassName("ace_content")[0].innerText;
      console.log(this.requestBody.code);
    },
    getCode() {
      console.log(this.requestBody.code);
    },
    submit() {
      this.setCodeRequest();
      this.loading = true;
      axios
        .create({
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods":
              "GET, POST, PUT, DELETE, PATCH, OPTIONS",
            "Access-Control-Allow-Headers":
              "X-Requested-With, content-type, Authorization",
          },
        })
        .post(
          "https://codexweb.netlify.app/.netlify/functions/enforceCode",
          this.requestBody
        )
        .then((res) => {
          this.loading = false;
          console.log(res.data);
          this.result = res.data.output;
        })
        .catch((err) => {
          this.loading = false;
          console.log("error: " + err);
        });
    },
    createQuestion() {
      HTTP.post("/teacher/question-it/create", {
        thread: this.thread,
        input: this.requestBody.input,
        output: this.result,
      })
        .then((res) => {
          alert("Thêm câu hỏi thành công!");
          this.$router.push("/home/teacher/question");
        })
        .catch((error) => {
          console.log(error);
          alert("Thêm câu hỏi không thành công!");
        });
    },
  },
  mounted() {
    this.setCodeRequest();
  },
  components: {
    Brace,
  },
};
</script>

<style>
</style>