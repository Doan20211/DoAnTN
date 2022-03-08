<template>
  <div>
    <div class="header-exam">
      <div>
        <strong style="font-size: 24px">Đề thi trắc nghiệm cuối kỳ</strong>
      </div>
      <div class="row mt-4 justify-content-center" style="height: 100px">
        <div class="col-5">
          <p>Môn thi: Ngôn ngữ lập trình </p>
          <p>Thời gian thi: 60 phút</p>
        </div>
        <div class="col-5">
          <strong style="font-size: 20px">Thời gian còn lại: 00:30:26</strong>
        </div>
      </div>
      <div class="text-end mb-2">
        <Button class="btn btn-primary">Nộp bài</Button>
        <Button class="btn btn-danger">Hủy bài thi</Button>
      </div>
    </div>
    <div class="body-exam">
      <question-exam />
      <question-exam />
      <question-exam />
    </div>
    <!-- Button trigger modal -->
    <button
      type="button"
      class="btn btn-primary"
      data-bs-toggle="modal"
      data-bs-target="#exampleModal"
    >
      Launch demo modal
    </button>

    <!-- Modal -->
    <div
      class="modal fade"
      id="exampleModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">...</div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-bs-dismiss="modal"
            >
              Close
            </button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import QuestionExam from './QuestionExam.vue'
  export default {
    data() {
      return {
        abc: ''
      }
    },
    components: {
      QuestionExam,
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
  height: 500px;
  background-color: rgb(255, 255, 255);
  border-radius: 12px;
  padding: 16px;
}
</style>