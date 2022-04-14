<template>
  <div class="col-12 col-lg-12 col-xxl-12 d-flex">
    <div class="card flex-fill">
      <div class="card-header">
        <div class="row">
          <h4 class="col-6">Danh sách câu hỏi trắc nghiệm</h4>
          <div class="col-6 text-end">
            <button class="btn btn-outline-primary" @click="toInsert">
              Tạo đề thi
            </button>
          </div>
        </div>
      </div>
      <div class="scroll">
        <table class="table table-hover my-0">
          <thead>
            <tr>
              <th class="col-1">ID</th>
              <th class="col-9">Đề thi</th>
              <th class="col-1">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="exam in ListExam" :key="exam.id">
              <td >{{ exam.id }}</td>
              <td> {{exam.name}}</td>
              <td>
                <button
                  class="btn btn-outline-info"
                  @click="toEdit(ques.id)"
                >
                  <i class="align-middle" data-feather="edit"></i>
                  Sửa
                </button>
                <button
                  class="btn btn-outline-danger"
                  @click="deleteAccount(ques.id)"
                >
                  <i class="align-middle" data-feather="trash"></i>
                  Xóa
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import { HTTP } from "../../http-common";
import feather from 'feather-icons'
import Question from '../Question/Question.vue'
export default {
  data() {
    return {
      ListExam: [],
    };
  },
  components:{
    Question,
  },
  methods: {
    getListQuestion() {
      HTTP.get("teacher/exam")
        .then((res) => {
          this.ListExam = res.data;
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    reload() {
      HTTP.get("teacher/exam")
        .then((res) => {
          this.ListQuestion = res.data;
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    toEdit(id) {
      localStorage.setItem("idQuestion", id);
      console.log(id);
      this.$router.push("/home/teacher/question/edit");
    },
    deleteExam(id) {
    },
  },
  mouted() {
    feather.replace();
    this.getListQuestion();
    
  },
  created() {
    this.getListQuestion();
  },
};
</script>

<style scoped>
thead{
  position: sticky;
  top:0;
  background: white;
}
.scroll {
  height: 450px;
  overflow: scroll;
}
</style>