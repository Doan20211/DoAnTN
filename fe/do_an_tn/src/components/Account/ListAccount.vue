<template>
  <div>
        <div class="card mt-3">
            <div class="card-header mt-3 text-end">
                <button @click="toInsert" class="btn-primary" style="border-radius:24px; margin-right:2rem">Thêm tài khoản</button>
            </div>
            <div class="card-body"> 
                <table class="table border">
                    <thead class="">
                        <th>STT</th>
                        <th>ID</th>
                        <th>Tên tài khoản</th>
                        <th>Mã số</th>
                        <th>Email</th>
                        <th>Địa chỉ</th>
                        <th>SĐT</th>
                        <th>Chức vụ</th>
                        <th>Quyền</th>
                        <th>Action</th>
                    </thead>
                    <tbody>
                        <tr v-for="(account,index) in ListAccount" :key="account.id">
                            <td>{{index+1}}</td>
                                <td>{{account.id}}</td>
                            <td>{{account.fullName}}</td>
                            <td>{{account.code}}</td>
                            <td>{{account.email}}</td>
                            <td>{{account.address}}</td>
                            <td>{{account.phone}}</td>
                            <td>{{account.position}}</td>
                            <td>{{account.role}}</td>
                            <td>
                                <button @click="deleteAccount(account.id)" class="btn ">Delete</button>
                                <button @click="toEdit(account.id)" class="btn">Edit</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
  </div>
</template>

<script>
import {HTTP} from '../../http-common'
export default {
    data(){
        return{
            ListAccount:[]
        }
    },
    methods:{
        getListAccount(){
            HTTP
                .get('admin/account')
                .then((res) => {
                    this.ListAccount = res.data;
                    console.log(res);
                })
                .catch((error) => {
                    console.log(error);
                })
        },
        reload(){
            HTTP
                .get('admin/account')
                .then((res) => {
                    this.ListAccount = res.data;
                    console.log(res);
                })
                .catch((error) => {
                    console.log(error);
                })
        },
        toInsert(){
            this.$router.push('/home/admin/account/create')
        },
        toEdit(id){
            localStorage.setItem('idStaff',id)
            console.log(id)
            this.$router.push('/home/admin/account/edit')
        },
        deleteAccount(id){
            HTTP
                .delete('admin/account/' + id)
                .then((res) => {
                    this.ListAccount = res.data;
                    console.log(res);
                })
                .catch((error) => {
                    console.log(error);
                })
        }
    },
    mouted(){
        this.getListAccount();
    },
    created(){
        this.getListAccount();
    }

}
</script>

<style scoped>
    .card{
        border-radius: 24px;
        min-height: 400px;
    }
    table{
        border-radius: 12px;
    }
</style>