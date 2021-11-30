package com.DoAn.DoAnTotNghiep.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExam {

    private String name;
    private String time;
    private List<Long> questionIds;

}
