<template>
  <div class="col-12 col-lg-12 col-xxl-12 d-flex">
    <div class="container d-flex flex-column">
      <div class="row vh-90">
        <div class="col-sm-12 col-md-10 col-lg-8 mx-auto d-table h-100">
          <div class="d-table-cell align-middle">
            <div class="card">
              <h2 class="card-title mt-3 ms-3 strong">Tạo đề thi trắc nghiệm</h2>
              <hr class="solid" />
              <div class="card-body">
                <div class="m-sm-8">
                  <form @submit.prevent="createExam">
                    <div class="mb-3 col-12">
                      <label class="form-label">Tên đề thi</label>
                      <textarea
                        class="form-control form-control-lg"
                        type="text"
                        style=""
                        placeholder="Tên đề thi"
                        v-model="Exam.name"
                      />
                    </div>
                    <div class="row">
                      <div class="mb-3 col-6">
                        <label class="form-label">Thời gian thi</label>
                        <input
                          class="form-control form-control-lg"
                          type="number"
                          style=""
                          placeholder="Phút"
                          v-model="Exam.examTime"
                        />
                      </div>
                      <div class="mb-3 col-6">
                        <label class="form-label">Ngày thi</label>
                        <input
                          class="form-control form-control-lg"
                          type="date"
                          style=""
                          placeholder="Tên đề thi"
                          v-model="Exam.date"
                        />
                      </div>
                      <div class="mb-3 col-6">
                        <label class="form-label">Giờ thi</label>
                        <input
                          class="form-control form-control-lg"
                          type="time"
                          style=""
                          placeholder="Tên đề thi"
                          v-model="Exam.time"
                        />
                      </div>
                      <div class="mb-3 col-6">
                        <label class="form-label">Số câu hỏi</label>
                        <input
                          class="form-control form-control-lg"
                          type="number"
                          style=""
                          placeholder="Số lượng câu hỏi trong đề thi"
                          v-model="Exam.numberOfQuestion"
                        />
                      </div>
                    </div>
                    <div class="text-center mt-3">
                      <button class="btn btn-primary" type="submit">
                        Thêm
                      </button>
                    </div>
                  </form>
                </div>
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
import feather from "feather-icons";
export default {
  data() {
    return {
      Exam: {
        name: "",
        examTime:"",
        time: "",
        date: "",
        numberOfQuestion: "",
      },
    };
  },
  components: {},
  methods: {
    createExam(){
      HTTP.post('/teacher/create/exam', this.Exam)
      .then((res) => {
        alert("Tạo đề thi thành công!");
        
      })
      .catch((err) => {
        alert("Tạo đề thi lỗi!");
      })
    }
  },
  mouted() {
    feather.replace();
  },
  created() {
  },
};
</script>

<style scoped>
thead {
  position: sticky;
  top: 0;
  background: white;
}
.scroll {
  height: 450px;
  overflow: scroll;
}
</style>