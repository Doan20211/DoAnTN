<template>
  <div>
    <div class="border row">
        <span class="col-2 btn btn-secondary">Câu hỏi: </span> 
        <div class="col-10" style="height: 60px">{{ thread }}</div> 
    </div>
    <div class="border row">
        <span class="col-2 btn btn-info">Đáp án A: </span>
        <div class="col-10">{{ answerA }}</div>
    </div>
    <div class="border row">
        <span class="col-2 btn btn-info">Đáp án B: </span> 
        <div class="col-10">{{ answerB }}</div>
    </div>
    <div class="border row">
        <span class="col-2 btn btn-info">Đáp án C: </span> 
        <div class="col-10">{{ answerC }}</div>
    </div>
    <div class="border row">
        <span class="col-2 btn btn-info">Đáp án D: </span> 
        <div class="col-10">{{ answerD }}</div>
    </div>
    <div class="border row">
        <span class="col-2 btn btn-primary">Đáp án Đúng: </span>
        <div class="col-10">{{ corectAnswer }}</div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    thread: "",
    answerA: "",
    answerB: "",
    answerC: "",
    answerD: "",
    corectAnswer: "",
  },
};
</script>

<style scoped>
    span{
    }
</style>