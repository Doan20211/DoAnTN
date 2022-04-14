package com.DoAn.DoAnTotNghiep.Service.Impl;

import com.DoAn.DoAnTotNghiep.DTO.Response.QuestionDTO;
import com.DoAn.DoAnTotNghiep.Entity.*;
import com.DoAn.DoAnTotNghiep.Repository.AccountRepository;
import com.DoAn.DoAnTotNghiep.Repository.AssignmentRepository;
import com.DoAn.DoAnTotNghiep.Repository.ExamRefQuestionRepository;
import com.DoAn.DoAnTotNghiep.Repository.ExamRepository;
import com.DoAn.DoAnTotNghiep.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ExamRefQuestionRepository examRefQuestionRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public Assignment submitExam(Long id, List<String> listAnswer) {

        int point = 0;
        int i=0;
        Exam exam = this.examRepository.findById(id).get();

        List<ExamRefQuestion> examRefQuestions = this.examRefQuestionRepository.findByExam(exam);
        List<QuestionDTO> questions = new ArrayList<>();
        for(ExamRefQuestion examRefQuestion : examRefQuestions) {
            Question question = examRefQuestion.getQuestion();
            if(question.getCorectAnswer() == listAnswer.get(i)){
                point++;
            }
            i++;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Account account = this.accountRepository.findByEmail(username).get();

        Assignment assignment = new Assignment();

        assignment.setExam(exam);
        assignment.setAccount(account);
        assignment.setTotalQuestion(listAnswer.size());
        assignment.setPoint(point);

        this.assignmentRepository.save(assignment);

        return assignment;
    }

}
