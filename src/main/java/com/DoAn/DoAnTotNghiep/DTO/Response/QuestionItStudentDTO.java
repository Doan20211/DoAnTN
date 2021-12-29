package com.DoAn.DoAnTotNghiep.DTO.Response;

import com.DoAn.DoAnTotNghiep.Entity.QuestionIT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionItStudentDTO {

    private String thread;
    private String input;
    private int testCase;

    public QuestionItStudentDTO(QuestionIT questionIT){
        this.thread = questionIT.getThread();
        this.testCase = questionIT.getTestCase();
        this.input = questionIT.getInput();
    }

}
