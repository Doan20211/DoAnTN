<template>
  <div class="container d-flex flex-column">
    <div class="row vh-90">
      <div class="col-sm-12 col-md-10 col-lg-8 mx-auto d-table h-100">
        <div class="d-table-cell align-middle">
          <div class="card">
            <h2 class="card-title mt-3 strong">Thêm tài khoản</h2>
            <hr class="solid">
            <div class="card-body">
              <div class="m-sm-8">
                <form @submit.prevent="createAccount">
                  <div class="row">
                    <div class="mb-3 col-8">
                      <label class="form-label">Tên tài khoản</label>
                      <input
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
                      class="form-control form-control-lg"
                      type="text"
                      name="text"
                      placeholder="Địa chỉ"
                      v-model="Account.address"
                    />
                  </div>
                  <div class="row">
                    <div class="mb-3 col-4">
                      <label class="form-label">Chức vụ</label>
                      <input
                        class="form-control form-control-lg"
                        type="text"
                        name="text"
                        placeholder="Chức vụ"
                        v-model="Account.position"
                      />
                    </div>
                    <div class="col-8">
                      <label class="form-label">Quyền tài khoản</label>
                      <div class="input-group mb-3 pb-2 row justify-content-around radio-form">
                        <div class="col-3 mt-2">
                          <input
                            type="radio"
                            id="role1"
                            v-model="Account.role"
                            name="role"
                            value="ROLE_ADMIN"
                          />
                          <label for="role1">ADMIN</label>
                        </div>
                        <div class="col-3 mt-2">
                          <input
                            type="radio"
                            id="role2"
                            v-model="Account.role"
                            name="role"
                            value="ROLE_TEACHER"
                          />
                          <label for="role2">TEACHER</label>
                        </div>
                        <div class="col-3 mt-2">
                          <input
                            type="radio"
                            id="role3"
                            v-model="Account.role"
                            name="role"
                            value="ROLE_STUDENT"
                          />
                          <label for="role3">STUDENT</label>
                        </div>
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
      Account: {
        fullName: "",
        email: "",
        fullName: "",
        address: "",
        phone: "",
        position: "",
        code: "",
        role: "",
      },
      msgError: {
        fullName: "",
        email: "",
        fullName: "",
        address: "",
        phone: "",
        position: "",
        code: "",
        role: "",
      },
    };
  },
  methods: {
    createAccount() {
      HTTP.post("/admin/account", this.Account)
        .then((res) => {
          alert('Thêm tài khoản thành công!')
          this.$router.push("/home/admin/account");
        })
        .catch((error) => {
          console.log(error);
          alert("Thêm tài khoản không thành công!");
        });
    },
  },
};
</script>

<style>
</style>