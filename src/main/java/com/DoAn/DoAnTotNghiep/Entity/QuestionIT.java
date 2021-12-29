package com.DoAn.DoAnTotNghiep.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question_it")
public class QuestionIT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "thread", columnDefinition = "LONGTEXT")
    private String thread;

    @Column(name = "input")
    private String input;

    @Column(name = "output")
    private String output;

    @Column(name = "testCase")
    private int testCase;

}
