<template>
  <div class="container d-flex flex-column">
    <div class="row vh-90">
      <div class="col-sm-12 col-md-10 col-lg-8 mx-auto d-table h-100">
        <div class="d-table-cell align-middle">
          <div class="text-center mt-2">
            <h1 class="h2">Thông tin tài khoản</h1>
          </div>
          <div class="card">
            <div class="card-body">
              <button class="btn btn-info" v-show="isUpdate == false" @click="isUpdate = !isUpdate">Cập nhật thông tin tài khoản</button>
              <div class="m-sm-4">
                <form @submit.prevent="updateAccount">
                  <div class="row">
                    <div class="mb-3 col-8">
                      <label class="form-label">Tên tài khoản</label>
                      <input
                        :disabled="isUpdate == false"
                        class="form-control form-control-lg"
                        type="text"
                        name="name"
                        placeholder="Tên tài khoản"
                        v-model="Account.fullName"
                      />
                    </div>
                    <div class="mb-3 col-4">
                      <label class="form-label">Mã số</label>
                      <input
                        disabled
                        class="form-control form-control-lg"
                        type="text"
                        name="company"
                        placeholder="Mã số"
                        v-model="Account.code"
                      />
                    </div>
                  </div>
                  <div class="row">
                    <div class="mb-3 col-6">
                      <label class="form-label">Email</label>
                      <input
                        disabled
                        class="form-control form-control-lg"
                        type="email"
                        name="email"
                        placeholder="Email"
                        v-model="Account.email"
                      />
                    </div>
                    <div class="mb-3 col-6">
                      <label class="form-label">SĐT</label>
                      <input
                        :disabled="isUpdate == false"
                        class="form-control form-control-lg"
                        type="text"
                        name="text"
                        placeholder="SĐT"
                        v-model="Account.phone"
                      />
                    </div>
                  </div>
                  <div class="mb-3">
                    <label class="form-label">Địa chỉ</label>
                    <input
                      :disabled="isUpdate == false"
                      class="form-control form-control-lg"
                      type="text"
                      name="text"
                      placeholder="Địa chỉ"
                      v-model="Account.address"
                    />
                  </div>
                  <div class="text-center mt-3">
                    <button v-show="isUpdate" class="btn btn-primary" type="submit">Cập nhật</button>
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
      isUpdate:false,
      Account: {
        id: "",
        fullName: "",
        email: "",
        address: "",
        phone: "",
      },
      msgError: {
        fullName: "",
        email: "",
        fullName: "",
        address: "",
        phone: "",
      },
    };
  },
  methods: {
    getAccount() {
      const email = localStorage.getItem("email");
      HTTP.get("/information")
        .then((res) => {
          this.Account = res.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    updateAccount() {
      HTTP.post("/information", this.Account)
        .then((res) => {
          alert("Cập nhật tài khoản không thành công!");
          this.$router.go();
        })
        .catch((error) => {
          console.log(error);
          alert("Cập nhật tài khoản không thành công!");
        });
    },
  },
  mouted() {
    this.getAccount();
  },
  created() {
    this.getAccount();
  },
};
</script>

<style scoped>

  .radio-form{
    border: 1px solid lightgray ;
    border-radius: 12px;
  }

</style>