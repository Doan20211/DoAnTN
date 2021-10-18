<template>
    <div class="main-bg">
        <div class="container " >
            <div style="height:5rem;" ></div>
            <div class="row justify-content-center">
                <div class="col-lg-4 col-md-8 col-sm-8">
                    <div class="card shadow-lg ">
                        <img src="../assets/logo-BK.jpg" alt="" height="200" width="250">
                        <div class="card-title text-center border-bottom">
                            <h2 class="p-3">Login</h2>
                        </div>
                        <div class="card-body">
                            <form @submit.prevent="login">
                                <div class="mb-4">
                                    <label for="username" class="form-label ">Email</label>
                                    <input type="text" class="form-control" v-model="username" id="username" placeholder="Email" required>
                                    <p>{{msgUsername}}</p>
                                </div>
                                
                                <div class="mb-4">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" v-model="password" id="password" placeholder="Password" required >
                                    <p>{{msgPassword}}</p>
                                </div>
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                                </div>
                            </form>
                            <a href="forgot">Quên mật khẩu!</a>
                            <div class="mt-2">
                                <p style="color:red">{{msg}}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div style="height:7rem"></div>
        </div>
    </div>
</template>

<script>
import { HTTP } from '../http-common'
export default {
    name: "Login",
    data(){
        return{
            username:'',
            password:'',
            msgUsername:'',
            msgPassword:''
        }
    },
    methods:{
        login(){
            if(this.checkForm()){
                    this.msgUsername = '';
                    this.msgPassword = '';
                HTTP
                    .post('login',{
                        username : this.username,
                        password: this.password
                    })
                    .then((response) => {
                        localStorage.setItem('token',response.data.token)
                        localStorage.setItem('role',response.data.roles)
                        localStorage.setItem('email',response.data.email)
                        localStorage.setItem('name',response.data.name)
                        this.$router.push("/home")
                    })
                    .catch((error) => {
                        alert('Tên đăng nhập hoặc mật khẩu không đúng!')
                    })
            }
        },
        checkForm(){
            if(this.validEmail(this.username) && this.password.length>5){
                return true;
            }else{
                if(!this.validEmail(this.username)){
                    this.msgUsername = 'Email không hợp lệ!';
                }else{
                    this.msgUsername = '';
                }
                if(this.password.length < 6){
                    this.msgPassword = 'Mật khẩu phải có ít nhất 6 ký tự!'
                }else{
                    this.msgPassword = ''
                }
                return false;
            }
        },
        validEmail(email) {
            var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(email);
        }
    }
}
</script>

<style scoped>
    input:focus,
    button:focus{
        border: 2px solid lightgray;
    }
    .main-bg{
        height: 100%;
        width: 100%;
        background-image: url('../assets/Background-BK.jpg');
    }
    p{
        color: red;
    }
    .card{
        background-color: white;
    }

    img{
        margin: 0 auto;
    }

    
</style>