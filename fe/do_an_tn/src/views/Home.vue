<template>
  <div class="home">
    <div v-if="role=='TEACHER'">
      <Teacher />
    </div>
    <div v-else-if="role=='ADMIN'">
      <Admin />
    </div>
    <div v-else>
      <Student />
    </div>
  </div>
</template>

<script>
import Admin from '../components/Admin.vue'
import Teacher from '../components/Teacher.vue'
import Student from '../components/Student.vue'
export default {
  data(){
    return {
      email:'',
      role:'',
      name:''
    }
  },
  name: 'Home',
  mounted(){
    this.getInfomation();
  },
  methods:{
    getInfomation(){
      this.email = localStorage.getItem('email')
      this.name = localStorage.getItem('name')
      this.role = localStorage.getItem('role')
    },
    logout(){
      localStorage.removeItem('token')
      localStorage.removeItem('email')
      localStorage.removeItem('role')
      localStorage.removeItem('userid')
      this.$router.push("/")
    }

  },
  components: {
    Admin,
    Student,
    Teacher
  }
}
</script>
