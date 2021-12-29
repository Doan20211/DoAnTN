package com.DoAn.DoAnTotNghiep.Service;

import com.DoAn.DoAnTotNghiep.Entity.QuestionIT;

import java.util.List;

public interface QuestionItService {

    boolean createQuestion(QuestionIT questionIT);
    boolean deleteQuestion(Long id);
    QuestionIT getQuestionById(Long id);
    List<QuestionIT> getAllQuestion();

}
