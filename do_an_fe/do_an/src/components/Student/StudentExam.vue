<template>
  <div>
    <div class="header-exam">
      <div>
        <strong style="font-size: 24px">{{exam.name}}</strong>
      </div>
      <div class="row mt-4 justify-content-center" style="height: 100px">
        <div class="col-5">
          <p>Môn thi: Ngôn ngữ lập trình </p>
          <p>Thời gian thi: {{exam.time}} phút</p>
        </div>
        <div class="col-5">
          <strong style="font-size: 20px">Thời gian còn lại: {{min}}:{{sec}}</strong>
        </div>
      </div>
      <div class="text-end mb-2">
        <Button class="btn btn-primary" @click="submitExam">Nộp bài</Button>
        <Button class="btn btn-danger " style="margin-left: 5px">Hủy bài thi</Button>
      </div>
    </div>
    <div class="body-exam">
      <ul>
        <li v-for="(ques, index) in listQuestion" :key="ques.id">
          <!-- <QuestionExam v-bind="question"> -->
            <span>Câu hỏi: {{index + 1}}</span>
            <QuestionExam :question="ques" :create="createAns" :index="index"/>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { HTTP } from '../../http-common';
import QuestionExam from './QuestionExam.vue'
  export default {
    data() {
      return {
        exam: {
          name: 'Thi cuối kỳ',
        },
        listQuestion:[],
        min: '',
        sec: 59,
        answer: []
      }
    },
    components: {
      QuestionExam,
    },
    methods: {
      getExam(){
        HTTP.get('/student/exam')
        .then((res) => {
          this.exam = res.data;
          this.min = res.data.time - 1;
          this.listQuestion = res.data.questions;
        })
        .catch((error) => {
          console.log(error);
        })
      },
      createAns(index, ans) {
        this.answer[index] = ans;
      },
      submitExam() {
        HTTP
          .post("/student/exam/" + this.exam.id, this.answer)
          .then((res) => {
            console.log(res.data);
            alert("Kết quả: Đúng " + res.data.point + "/" + res.data.totalQuestion + "câu.");
            this.$router.push("/home/teacher/class");
          })
          .catch((error) => {
            console.log(error);
          })
        
      }
    },
    mounted() {
      this.getExam();
    },
    created() {
      setInterval(() => {
        this.sec--;
        if(this.sec < 0) {
          if(this.min > 0){
            this.sec = 59;
          } else {

          }
        }
      }, 1000);
      setInterval(() => {
        this.min--;
      }, 60000)
    }
  };
</script>

<style scoped>
.header-exam {
  height: 220px;
  background-color: #fff;
  border-radius: 12px;
  padding: 16px;
  margin-bottom: 4px;
}

.body-exam {
  background-color: rgb(255, 255, 255);
  border-radius: 12px;
  padding: 16px;
}
</style>