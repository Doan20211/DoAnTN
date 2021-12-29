package com.DoAn.DoAnTotNghiep.Service.Impl;

import com.DoAn.DoAnTotNghiep.Entity.QuestionIT;
import com.DoAn.DoAnTotNghiep.Repository.QuestionItRepository;
import com.DoAn.DoAnTotNghiep.Service.QuestionItService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QestionItServiceImpl implements QuestionItService {

    @Autowired
    QuestionItRepository questionItRepository;

    @Override
    public boolean createQuestion(QuestionIT questionIT) {
        this.questionItRepository.save(questionIT);
        return true;
    }

    @Override
    public boolean deleteQuestion(Long id) {
        this.questionItRepository.deleteById(id);
        return true;
    }

    @Override
    public QuestionIT getQuestionById(Long id) {
        return this.questionItRepository.getById(id);
    }

    @Override
    public List<QuestionIT> getAllQuestion() {
        return this.questionItRepository.findAll();
    }
}
