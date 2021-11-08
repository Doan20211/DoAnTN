package com.DoAn.DoAnTotNghiep.Controller;

import com.DoAn.DoAnTotNghiep.DTO.Response.QuestionDTO;
import com.DoAn.DoAnTotNghiep.Entity.Question;
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

    @GetMapping("/question")
    public ResponseEntity<?> getListQuestion(){
        List<Question> list = questionService.getListQuestion();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/question/create")
    public ResponseEntity<?> createQuestion(@RequestBody Question question){
        boolean status = questionService.createQuestion(question);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable ("id") Long id){
        boolean status = questionService.deleteQuestion(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(questionService.getQuestionById(id), HttpStatus.OK);
    }


}
