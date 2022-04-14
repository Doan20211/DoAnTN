<template>
  <div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar" v-show="isActive">
      <div class="sidebar-content js-simplebar">
        <a class="sidebar-brand" href="/home">
          <span class="align-middle">TEACHER</span>
        </a>
        <ul class="sidebar-nav">
          <li class="sidebar-header">Chức năng</li>

          <!-- <li
            class="sidebar-item"
            @click="active = '1'"
            :class="{ active: active === '1' }"
          >
            <a class="sidebar-link" href="/home/teacher/class">
              <i class="align-middle" data-feather="user"></i>
              <span class="align-middle">Quản lý lớp sinh viên</span>
            </a>
          </li> -->

          <li class="sidebar-header">
						Quản lý câu hỏi
					</li>

          <li
            class="sidebar-item"
            @click="active = '1'"
            :class="{ active: active === '1' }"
          >
            <a class="sidebar-link" href="/home/teacher/question">
              <i class="align-middle" data-feather="help-circle"></i>
              <span class="align-middle">Câu hỏi trắc nghiệm</span>
            </a>
          </li>

          <li
            class="sidebar-item"
            @click="active = '2'"
            :class="{ active: active === '2' }"
          >
            <a class="sidebar-link" href="/home/teacher/question">
              <i class="align-middle" data-feather="help-circle"></i>
              <span class="align-middle">Tạo đề thi trắc nghiệm</span>
            </a>
          </li>

          <li
            class="sidebar-item"
            @click="active = '3'"
            :class="{ active: active === '3' }"
          >
            <a class="sidebar-link" href="/home/teacher/questionIT/create">
              <i class="align-middle" data-feather="help-circle"></i>
              <span class="align-middle">Câu hỏi Code</span>
            </a>
          </li>

          <li
            class="sidebar-item"
            @click="active = '4'"
            :class="{ active: active === '4' }"
          >
            <a class="sidebar-link" href="/home/teacher/exam">
              <i class="align-middle" data-feather="file-text"></i>
              <span class="align-middle">Quản lý đề thi</span>
            </a>
          </li>
          
          <li
            class="sidebar-item"
            @click="active = '5'"
            :class="{ active: active === '5' }"
          >
            <a class="sidebar-link" href="/home/teacher/examIT">
              <i class="align-middle" data-feather="file-text"></i>
              <span class="align-middle">Thi code</span>
            </a>
          </li>
          
        </ul>
      </div>
    </nav>

    <div class="main">
      <nav class="navbar navbar-expand navbar-light navbar-bg sticky-top">
        <a
          class="sidebar-toggle js-sidebar-toggle"
          @click="isActive = !isActive"
        >
          <i class="hamburger align-self-center"></i>
        </a>
        <div class="navbar-collapse collapse">
          <ul class="navbar-nav navbar-align">
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle d-none d-sm-inline-block"
                type="button"
                data-bs-toggle="dropdown"
              >
                <span class="text-dark">Tài khoản </span>
              </a>
              <div class="dropdown-menu dropdown-menu-end">
                <a class="dropdown-item" href="/home/information"  >
                  <i class="align-middle me-1" data-feather="user"></i> 
                  Thông tin tài khoản
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" type="button" @click="logout">Đăng xuất</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>
      <div class="content">
        <div class="container-fluid p-0">
          <h1 class="h3 mb-3"><strong></strong></h1>
          <div class="row">
            <router-view />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ListAccount from "./Account/ListAccount.vue";
import feather from "feather-icons";
export default {
  components: { ListAccount },
  data() {
    return {
      isActive: true,
      active: "",
    };
  },
  props: {
    role: "",
    name: "",
  },
  methods: {
    logout() {
      localStorage.removeItem("token");
      localStorage.removeItem("email");
      localStorage.removeItem("role");
      localStorage.removeItem("userid");
      this.$router.push("/");
    },
  },
  mounted() {
    feather.replace();
  },
};
</script>

<style>
hr.solid {
  border-top: 3px solid #bbb;
}
.active{
  background-color: aqua;
  color: white;
}
</style>