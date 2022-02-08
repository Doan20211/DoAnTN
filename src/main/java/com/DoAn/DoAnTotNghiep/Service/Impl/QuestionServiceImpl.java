package com.DoAn.DoAnTotNghiep.Service.Impl;

import com.DoAn.DoAnTotNghiep.DTO.Response.QuestionDTO;
import com.DoAn.DoAnTotNghiep.Entity.Question;
import com.DoAn.DoAnTotNghiep.Repository.QuestionRepository;
import com.DoAn.DoAnTotNghiep.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public QuestionDTO getQuestionById(Long id) {
        Question question = this.questionRepository.getById(id);
        return new QuestionDTO(question);
    }

    @Override
    public List<QuestionDTO> getAllQuestion() {
        List<Question> questions = this.questionRepository.findAll();
        return questions.stream()
                .map(question -> new QuestionDTO(question))
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> getListQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getRandomQuestionByQuantity(Integer number) {
        List<Question> result = new ArrayList<>();
        List<Question> questionList = this.questionRepository.findAll();
        Map<Long, Question> questionMap = questionList.stream()
                .collect(Collectors.toMap(Question::getId, question -> question));
        List<Long> listKey = new ArrayList<>(questionMap.keySet());
        if(number > listKey.size()){
            return null;
        }else{
            Random rand = new Random();
            for(int i=0; i<number; i++){
                Long randomKey = listKey.get(rand.nextInt(listKey.size()));
                result.add(questionMap.get(randomKey));
                listKey.remove(randomKey);
            }
        }
        return result;
    }

    @Override
    public boolean createQuestion(Question question) {
        this.questionRepository.save(question);
        return true;
    }

    @Override
    public boolean deleteQuestion(Long id) {
        this.questionRepository.deleteById(id);
        return true;
    }
}
