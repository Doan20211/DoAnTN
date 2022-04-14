package com.DoAn.DoAnTotNghiep.Controller;

import com.DoAn.DoAnTotNghiep.DTO.Response.ExamDTO;
import com.DoAn.DoAnTotNghiep.Entity.Assignment;
import com.DoAn.DoAnTotNghiep.Entity.Exam;
import com.DoAn.DoAnTotNghiep.Service.AssignmentService;
import com.DoAn.DoAnTotNghiep.Service.ComplieService;
import com.DoAn.DoAnTotNghiep.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private ExamService examService;

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/exam")
    private ResponseEntity<?> getExamStudent(){
        ExamDTO exam = this.examService.getExamStudent();
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @PostMapping("/exam/{id}")
    private ResponseEntity<?> subitExam(@PathVariable("id") Long id,
                                        @RequestBody List<String> listAnswer){
        Assignment assignment = this.assignmentService.submitExam(id, listAnswer);
        return new ResponseEntity<>(assignment, HttpStatus.OK);
    }

}
