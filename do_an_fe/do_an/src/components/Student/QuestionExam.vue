<template>
  <div class="question-exam">
    <div class="mb-5 col-10">
      <strong>Câu hỏi: Ngôn ngữ lập trình là gì?</strong>
    </div>
    <div class="row">
      <div class="mb-3 col-6">
        <div class="input-group mb-3">
          <div class="input-group-text">
            <input class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
          </div>
          <input type="text" class="form-control" value="Đáp án A" disabled>
        </div>
      </div>
      <div class="mb-3 col-6">
        <div class="input-group mb-3">
          <div class="input-group-text">
            <input class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
          </div>
          <input type="text" class="form-control" value="Đáp án B" disabled>
        </div>
      </div>
      <div class="mb-3 col-6">
        <div class="input-group mb-3">
          <div class="input-group-text">
            <input class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
          </div>
          <input type="text" class="form-control" value="Đáp án C" disabled>
        </div>
      </div>
      <div class="mb-3 col-6">
        <div class="input-group mb-3">
          <div class="input-group-text">
            <input class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
          </div>
          <input type="text" class="form-control" value="Đáp án D" disabled>
        </div>
      </div>
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
.question-exam {
  border: 1px solid rgb(0, 0, 0);
  border-radius: 12px;
  padding: 12px;
  margin: 12px;
}
</style>