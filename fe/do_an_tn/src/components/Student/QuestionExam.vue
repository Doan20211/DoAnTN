<template>
  <div>
    <div class="mb-3 col-10">
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
      <div class="mb-3 col-6">
        <label class="form-label">Đáp án A</label>
        <input
          class="form-control form-control-lg"
          type="text"
          placeholder="Đáp án A"
          v-model="Question.answerA"
        />
      </div>
      <div class="mb-3 col-6">
        <label class="form-label">Đáp án B</label>
        <input
          class="form-control form-control-lg"
          type="text"
          placeholder="Đáp án B"
          v-model="Question.answerB"
        />
      </div>
    </div>
    <div class="row">
      <div class="mb-3 col-6">
        <label class="form-label">Đáp án C</label>
        <input
          class="form-control form-control-lg"
          type="text"
          placeholder="Đáp án C"
          v-model="Question.answerC"
        />
      </div>
      <div class="mb-3 col-6">
        <label class="form-label">Đáp án D</label>
        <input
          class="form-control form-control-lg"
          type="text"
          placeholder="Đáp án D"
          v-model="Question.answerD"
        />
      </div>
    </div>

    <div class="text-center mt-3">
      <button class="btn btn-primary" type="submit">Thêm</button>
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
span {
}
</style>