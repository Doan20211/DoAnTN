package com.DoAn.DoAnTotNghiep.Service;

import com.DoAn.DoAnTotNghiep.DTO.Request.CreateExam;
import com.DoAn.DoAnTotNghiep.DTO.Response.ExamDTO;
import com.DoAn.DoAnTotNghiep.Entity.Exam;

import java.util.List;

public interface ExamService {

    boolean createExam(CreateExam createExam);
    ExamDTO getExamStudent();
    Exam getExamById(Long id);
    boolean createExamIt(CreateExam createExam);
    List<Exam> getListExam();
    List<Exam> getListExamIT();

}
