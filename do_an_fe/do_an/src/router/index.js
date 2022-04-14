import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import ListAccount from '../components/Account/ListAccount.vue'
import CreateAccount from '../components/Account/CreateAccount.vue'
import EditAccount from '../components/Account/EditAccount.vue'
import ListQuestion from '../components/Question/ListQuestion.vue'
import CreateQuestion from '../components/Question/CreateQuestion.vue'
import EditQuestion from '../components/Question/EditQuestion.vue'
import Information from '../components/Information/Information.vue'
import Class from '../components/Teacher/Class.vue'
import ListExam from '../components/Teacher/ListExam.vue'
import CreateExam from '../components/Teacher/CreateExam.vue'
import ComplieCode from '../components/ExamIT/ComplieCode.vue'
import CreateQuestionIT from '../components/Question/CreateQuestionIT.vue'
import StudentExam from '../components/Student/StudentExam.vue'

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: 'Home',
    component: Home,
    children: [{
      path: 'admin/account',
      name: 'ListAccount',
      component: ListAccount
    },
    {
      path: 'admin/account/create',
      name: 'CreateAccount',
      component: CreateAccount
    },
    {
      path: 'admin/account/edit',
      name: 'EditAccount',
      component: EditAccount
    },
    {
      path: 'teacher/question',
      name: 'ListQuestion',
      component: ListQuestion
    },
    {
      path: 'teacher/question/create',
      name: 'CreateQuestion',
      component: CreateQuestion
    },
    {
      path: 'teacher/questionIT/create',
      name: 'CreateQuestionIT',
      component: CreateQuestionIT
    },
    {
      path: 'teacher/question/edit',
      name: 'EditQuestion',
      component: EditQuestion
    },
    {
      path: 'teacher/class',
      name: 'Class',
      component: Class
    },
    {
      path: 'teacher/exam',
      name: 'ListExam',
      component: ListExam
    },
    {
      path: 'teacher/exam/create',
      name: 'CreateExam',
      component: CreateExam
    },
    {
      path: 'teacher/examIT',
      name: 'ComplieCode',
      component: ComplieCode
    },
    {
      path: 'information',
      name: 'Information',
      component: Information
    },
    {
      path: 'student/exam',
      name: 'StudentExam',
      component: StudentExam,
    }
    ]
  },
  // {
  //   path: '/login',
  //   name: 'Login',
  //   component: () => import('../views/Login.vue')
  // },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
