<template>
  <div>
       <div class=" row justify-content-center">
        <div class="title text-center mt-5">
            <h2>Thêm tài khoản</h2>
        </div>
        <form  class="col-md-8" @submit.prevent="createAccount" enctype="multipart/form-data" >
            <div class="input-group mb-3">
                <span class="input-group-text col-md-3" >Tên tài khoản</span>
                <input type="text" placeholder="Tên tài khoản" v-model="Account.fullName"  class="col-md-9">
                <p>{{msgError.fullName}}</p>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text col-md-3" >Mã số</span>
                <input type="text" placeholder="Mã số" v-model="Account.code"  class="col-md-9">
                <p>{{msgError.fullName}}</p>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text col-md-3" >Email</span>
                <input type="text" placeholder="Email" v-model="Account.email"  class="col-md-9">
                <p>{{msgError.fullName}}</p>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text col-md-3" >SĐT</span>
                <input type="text" placeholder="SĐT" v-model="Account.phone"  class="col-md-9">
                <p>{{msgError.fullName}}</p>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text col-md-3" >Địa chỉ</span>
                <input type="text" placeholder="Địa chỉ" v-model="Account.address"  class="col-md-9">
                <p>{{msgError.fullName}}</p>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text col-md-3" >Chức vụ</span>
                <input type="text" placeholder="Chức vụ" v-model="Account.position"  class="col-md-9">
                <p>{{msgError.fullName}}</p>
            </div>
            
            <div class="input-group mb-3  row justify-content-around">
                <span class="input-group-text col-md-3" >Quyền</span><br>
                <div class="col-3">
                    <input  type="radio" id="role1" v-model="Account.role" name="role" value="ROLE_ADMIN">
                    <label  for="role1">ADMIN</label>
                </div>
                <div class="col-3">
                    <input type="radio" id="role2" v-model="Account.role" name="role" value="ROLE_TEACHER">
                    <label for="role2">TEACHER</label>
                </div>
                <div class="col-3">
                    <input type="radio" id="role3" v-model="Account.role" name="role" value="ROLE_STUDENT">
                    <label for="role3">STUDENT</label>
                </div>
                <p>{{msgError.role}}</p>
			</div>
            
            <div class="row text-center">
                <button class="btn btn-primary" type="submit">Thêm tài khoản</button>
            </div>
        </form>
    </div>
  </div>
</template>

<script>
import { HTTP } from '../../http-common'
export default {
    data(){
        return{
            Account:{
                fullName:'',
                email:'',
                fullName:'',
                address:'',
                phone:'',
                position:'',
                code:'',
                role:''
            },
            msgError:{
                fullName:'',
                email:'',
                fullName:'',
                address:'',
                phone:'',
                position:'',
                code:'',
                role:''
            }
        }
    },
    methods:{
        createAccount(){
            HTTP
                .post('/admin/account', this.Account)
                .then((res) => {
                    this.$router.push('/home/admin/account')
                })
                .catch((error) => {
                    console.log(error);
                    alert("Thêm tài khoản không thành công!")
                })
        }
    }
}
</script>

<style>

</style>