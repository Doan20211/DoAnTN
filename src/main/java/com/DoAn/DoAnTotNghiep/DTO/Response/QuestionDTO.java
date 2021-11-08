package com.DoAn.DoAnTotNghiep.DTO.Response;

import com.DoAn.DoAnTotNghiep.Entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private String thread;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    public QuestionDTO(Question question){
        this.thread = question.getThread();
        this.answerA = question.getAnswerA();
        this.answerB = question.getAnswerB();
        this.answerC = question.getAnswerC();
        this.answerD = question.getAnswerD();
    }

}
