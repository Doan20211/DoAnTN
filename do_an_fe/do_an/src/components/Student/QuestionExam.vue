<template>
  <div class="question-exam">
    <div class="mb-5 col-10">
      <strong>{{question.thread}}</strong>
    </div>
    <div class="row">
      <div class="mb-3 col-6">
        <div class="input-group mb-3">
          <div class="input-group-text">
            <input class="form-check-input mt-0" type="checkbox" v-model="ansA" 
            aria-label="Checkbox for following text input" @change="createAnswer()">
          </div>
          <input type="text" class="form-control" v-model="question.answerA" disabled>
        </div>
      </div>
      <div class="mb-3 col-6">
        <div class="input-group mb-3">
          <div class="input-group-text">
            <input class="form-check-input mt-0" type="checkbox" v-model="ansB" 
            aria-label="Checkbox for following text input"  @change="createAnswer()">
          </div>
          <input type="text" class="form-control" v-model="question.answerB" disabled>
        </div>
      </div>
      <div class="mb-3 col-6">
        <div class="input-group mb-3">
          <div class="input-group-text">
            <input class="form-check-input mt-0" type="checkbox" v-model="ansC" 
            aria-label="Checkbox for following text input"  @change="createAnswer()">
          </div>
          <input type="text" class="form-control" v-model="question.answerC" disabled>
        </div>
      </div>
      <div class="mb-3 col-6">
        <div class="input-group mb-3">
          <div class="input-group-text">
            <input class="form-check-input mt-0" type="checkbox" v-model="ansD" 
            aria-label="Checkbox for following text input"  @change="createAnswer()">
          </div>
          <input type="text" class="form-control" v-model="question.answerD" disabled>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ansA: false,
      ansB: false,
      ansC: false,
      ansD: false,
      answer: ''
    };
  },
  props: {
    question: {},
    create:'',
    index: ''
  },
  methods: {
    createAnswer() {
      this.answer = '';
      if(this.ansA){
        this.answer += 'A';
      }
      if(this.ansB){
        this.answer += 'B';
      }
      if(this.ansC){
        this.answer += 'C';
      }
      if(this.ansD){
        this.answer += 'D';
      }
      this.create(this.index, this.answer);
    }
  }
};
</script>

<style scoped>
.question-exam {
  border: 1px solid rgb(0, 0, 0);
  border-radius: 12px;
  padding: 12px;
  margin: 12px;
}
</style>