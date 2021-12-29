package com.DoAn.DoAnTotNghiep.Service;

import com.DoAn.DoAnTotNghiep.DTO.Response.QuestionDTO;
import com.DoAn.DoAnTotNghiep.Entity.Question;

import java.util.List;

public interface QuestionService {

    QuestionDTO getQuestionById(Long id);
    List<QuestionDTO> getAllQuestion();
    List<Question> getListQuestion();
    List<QuestionDTO> getRandomQuestionByQuantity(Integer number);
    boolean createQuestion(Question question);
    boolean deleteQuestion(Long id);

}
