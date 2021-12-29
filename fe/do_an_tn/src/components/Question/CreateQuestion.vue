<template>
  <div class="container d-flex flex-column">
    <div class="row vh-90">
      <div class="col-sm-12 col-md-10 col-lg-8 mx-auto d-table h-100">
        <div class="d-table-cell align-middle">
          <div class="card">
            <h2 class="card-title mt-3 strong">Thêm câu hỏi</h2>
            <hr class="solid" />
            <div class="card-body">
              <div class="m-sm-8">
                <form @submit.prevent="createQuestion">
                  <div class="mb-3 col-12">
                    <label class="form-label">Câu hỏi</label>
                    <textarea
                      class="form-control form-control-lg"
                      type="text"
                      style="height: 100px"
                      placeholder="Câu hỏi"
                      v-model="Question.thread"
                    />
                  </div>
                  <div class="row">
                    <div class="mb-3 col-6 row">
                      <label class="form-label ">Đáp án A</label>
                      <div class="col-1"><input type="checkbox" id="answerA" value="A"></div>
                      <div class="col-11">
                        <input
                        class="form-control form-control-lg"
                        type="text"
                        placeholder="Đáp án A"
                        v-model="Question.answerA"
                      />
                      </div>
                      
                    </div>
                    <div class="mb-3 col-6 row">
                      <label class="form-label">Đáp án B</label>
                      <div class="col-1"><input type="checkbox" id="answerB" value="B"></div>
                      <div class="col-11">
                        <input
                        class="form-control form-control-lg"
                        type="text"
                        placeholder="Đáp án B"
                        v-model="Question.answerB"
                      />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="mb-3 col-6 row">
                      <label class="form-label">Đáp án C</label>
                      <div class="col-1"><input type="checkbox" id="answerC" value="C"></div>
                      <div class="col-11">
                        <input
                        class="form-control form-control-lg"
                        type="text"
                        placeholder="Đáp án C"
                        v-model="Question.answerC"
                      />
                      </div>
                    </div>
                    <div class="mb-3 col-6 row">
                      <label class="form-label">Đáp án D</label>
                      <div class="col-1"><input type="checkbox" id="answerD" value="D"></div>
                      <div class="col-11">
                        <input
                        class="form-control form-control-lg"
                        type="text"
                        placeholder="Đáp án D"
                        v-model="Question.answerD"
                      />
                      </div>
                    </div>
                  </div>
                  <div class="text-center mt-3">
                    <button class="btn btn-primary" type="submit">Thêm</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { HTTP } from "../../http-common";
export default {
  data() {
    return {
      Question: {
        thread: "",
        answerA: "",
        answerB: "",
        answerC: "",
        answerD: "",
        corectAnswer: "",
      },
      msgError: {
        thread: "",
        answerA: "",
        answerB: "",
        answerC: "",
        answerD: "",
        corectAnswer: "",
      },
    };
  },
  methods: {
    createQuestion() {
      HTTP.post("/teacher/question/create", this.Question)
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
};
</script>

<style>
</style>