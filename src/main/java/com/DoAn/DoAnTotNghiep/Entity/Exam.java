package com.DoAn.DoAnTotNghiep.Entity;

import com.DoAn.DoAnTotNghiep.DTO.Request.CreateExam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String time;
    private Date date;
    private Integer numberOfQuestion;
    private Integer examTime;

    public Exam(CreateExam createExam){
        this.name = createExam.getName();
        this.time = createExam.getTime();
        this.date = createExam.getDate();
        this.examTime = createExam.getExamTime();
        this.numberOfQuestion = createExam.getNumberOfQuestion();
    }

}
