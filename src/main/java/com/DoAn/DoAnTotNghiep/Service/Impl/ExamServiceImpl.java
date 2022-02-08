package com.DoAn.DoAnTotNghiep.Service.Impl;

import com.DoAn.DoAnTotNghiep.DTO.Request.CreateExam;
import com.DoAn.DoAnTotNghiep.Entity.Exam;
import com.DoAn.DoAnTotNghiep.Entity.ExamRefQuestion;
import com.DoAn.DoAnTotNghiep.Entity.Question;
import com.DoAn.DoAnTotNghiep.Repository.ExamRefQuestionITRepository;
import com.DoAn.DoAnTotNghiep.Repository.ExamRefQuestionRepository;
import com.DoAn.DoAnTotNghiep.Repository.ExamRepository;
import com.DoAn.DoAnTotNghiep.Service.ExamService;
import com.DoAn.DoAnTotNghiep.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final ExamRefQuestionRepository examRefQuestionRepository;
    private final ExamRefQuestionITRepository examRefQuestionITRepository;
    private final QuestionService questionService;

    @Override
    public boolean createExam(CreateExam createExam) {
        Exam exam = this.examRepository.save(new Exam(createExam));

        List<Question> listQuestion = this.questionService.getRandomQuestionByQuantity(exam.getNumberOfQuestion());

        for (Question question : listQuestion){
            ExamRefQuestion examRefQuestion = new ExamRefQuestion();
            examRefQuestion.setExam(exam);
            examRefQuestion.setQuestion(question);
            this.examRefQuestionRepository.save(examRefQuestion);
        }

        return true;

    }

    @Override
    public boolean createExamIt(CreateExam createExam) {
        return false;
    }

    @Override
    public List<Exam> getListExam() {
        return null;
    }

    @Override
    public List<Exam> getListExamIT() {
        return null;
    }
}
