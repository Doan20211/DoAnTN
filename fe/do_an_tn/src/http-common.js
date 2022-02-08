import axios from 'axios'

export const HTTP = axios.create({
    baseURL : `http://localhost:9909/api/`,
    headers:{
        Authorization: 'Bearer ' + localStorage.getItem('token')
    }
});
