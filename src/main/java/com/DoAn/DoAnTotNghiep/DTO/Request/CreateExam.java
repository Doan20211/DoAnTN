package com.DoAn.DoAnTotNghiep.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExam {

    private String name;
    private Integer examTime;
    private Date date;
    private String time;
    private Integer numberOfQuestion;

}
