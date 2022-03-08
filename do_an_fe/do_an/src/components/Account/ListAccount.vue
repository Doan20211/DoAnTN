<template>
  <div class="col-12 col-lg-12 col-xxl-12 d-flex">
    <div class="card flex-fill">
      <div class="card-header">
        <div class="row">
          <h4 class="col-6">Danh sách tài khoản</h4>
          <div class="col-6 text-end">
            <button class="btn btn-outline-primary" @click="toInsert">
              Thêm tài khoản
            </button>
          </div>
        </div>
      </div>
      <div class="scroll">
        <table class="table table-hover my-0">
          <thead>
            <tr>
              <th class="d-none d-xl-table-cell d-md-table-cell">ID</th>
              <th class="d-none d-xl-table-cell d-md-table-cell">Họ và Tên</th>
              <th class="d-none d-xl-table-cell d-md-table-cell">Email</th>
              <th class="d-none d-xl-table-cell d-md-table-cell">Địa chỉ</th>
              <th class="d-none d-xl-table-cell d-md-table-cell">SĐT</th>
              <th class="d-none d-xl-table-cell d-md-table-cell">Mã</th>
              <th class="d-none d-xl-table-cell d-md-table-cell">Chức vụ</th>
              <th class="d-none d-xl-table-cell d-md-table-cell">Quyền</th>
              <th class="d-none d-xl-table-cell d-md-table-cell">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="account in ListAccount" :key="account.id">
              <td class="d-none d-xl-table-cell">{{ account.id }}</td>
              <td class="d-none d-xl-table-cell">{{ account.fullName }}</td>
              <td class="d-none d-xl-table-cell">{{ account.email }}</td>
              <td class="d-none d-xl-table-cell">{{ account.address }}</td>
              <td class="d-none d-xl-table-cell">{{ account.phone }}</td>
              <td class="d-none d-xl-table-cell">{{ account.code }}</td>
              <td class="d-none d-xl-table-cell">{{ account.position }}</td>
              <td>
                <span v-show="account.role === 'ADMIN'" class="badge bg-primary">{{ account.role }}</span>
                <span v-show="account.role === 'TEACHER'" class="badge bg-success">{{ account.role }}</span>
                <span v-show="account.role === 'STUDENT'" class="badge bg-warning">{{ account.role }}</span>
              </td>
              <td>
                <button
                  class="btn btn-outline-info"
                  @click="toEdit(account.id)"
                >
                  <i class="align-middle" data-feather="edit"></i>
                  Sửa
                </button>
                <button
                  class="btn btn-outline-danger"
                  @click="deleteAccount(account.id)"
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
export default {
  data() {
    return {
      ListAccount: [],
    };
  },
  methods: {
    getListAccount() {
      HTTP.get("/admin/account")
        .then((res) => {
          this.ListAccount = res.data;
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    reload() {
      HTTP.get("/admin/account")
        .then((res) => {
          this.ListAccount = res.data;
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    toInsert() {
      this.$router.push("/home/admin/account/create");
    },
    toEdit(id) {
      localStorage.setItem("idAccount", id);
      console.log(id);
      this.$router.push("/home/admin/account/edit");
    },
    deleteAccount(id) {
      HTTP.delete("admin/account/" + id)
        .then((res) => {
          this.ListAccount = res.data;
          console.log(res);
          alert('Xóa tài khoản thành công!');
        })
        .catch((error) => {
          console.log(error);
        });
      this.$router.go();
    },
  },
  mouted() {
    feather.replace();
    this.getListAccount();
    
  },
  created() {
    this.getListAccount();
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