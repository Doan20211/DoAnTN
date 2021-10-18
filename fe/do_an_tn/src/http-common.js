import axios from 'axios'

export const HTTP = axios.create({
    baseURL : `http://localhost:9999/api/`,
    headers:{
        Authorization: 'Bearer ' + localStorage.getItem('token')
    }
})
