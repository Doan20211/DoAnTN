package com.DoAn.DoAnTotNghiep.Controller;

import com.DoAn.DoAnTotNghiep.DTO.Request.CreateExam;
import com.DoAn.DoAnTotNghiep.DTO.Response.Complie;
import com.DoAn.DoAnTotNghiep.Entity.Exam;
import com.DoAn.DoAnTotNghiep.Entity.Question;
import com.DoAn.DoAnTotNghiep.Entity.QuestionIT;
import com.DoAn.DoAnTotNghiep.Service.ComplieService;
import com.DoAn.DoAnTotNghiep.Service.ExamService;
import com.DoAn.DoAnTotNghiep.Service.QuestionItService;
import com.DoAn.DoAnTotNghiep.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionItService questionItService;

    @Autowired
    ExamService examService;

    @Autowired
    ComplieService complieService;

    @GetMapping("/question")
    public ResponseEntity<?> getListQuestion(){
        List<Question> list = questionService.getListQuestion();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/question-it")
    public ResponseEntity<?> getListQuestionIT(){
        List<QuestionIT> list = this.questionItService.getAllQuestion();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/question/create")
    public ResponseEntity<?> createQuestion(@RequestBody Question question){
        boolean status = questionService.createQuestion(question);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @PostMapping("/question-it/create")
    public ResponseEntity<?> createQuestionIt(@RequestBody QuestionIT question){
        boolean status = questionItService.createQuestion(question);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable ("id") Long id){
        boolean status = questionService.deleteQuestion(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @DeleteMapping("/question-it/{id}")
    public ResponseEntity<?> deleteQuestionIt(@PathVariable ("id") Long id){
        boolean status = questionItService.deleteQuestion(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(questionService.getQuestionById(id), HttpStatus.OK);
    }

    @GetMapping("/question-it/{id}")
    public ResponseEntity<?> getQuestionItById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(questionItService.getQuestionById(id), HttpStatus.OK);
    }

    @PostMapping("/create/exam")
    public ResponseEntity<?> createExam(@RequestBody CreateExam createExam){
        boolean status = this.examService.createExam(createExam);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @PostMapping("/create/exam-it")
    public ResponseEntity<?> createExamIt(@RequestBody CreateExam createExam){
        boolean status = true;
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<?> Test(){
        Complie result = this.complieService.complie();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/exam")
    public ResponseEntity<?> listExam(){
        List<Exam> exams = this.examService.getListExam();
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

}
