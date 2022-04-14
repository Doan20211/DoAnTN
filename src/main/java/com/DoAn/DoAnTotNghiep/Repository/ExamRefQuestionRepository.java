package com.DoAn.DoAnTotNghiep.Repository;

import com.DoAn.DoAnTotNghiep.Entity.Exam;
import com.DoAn.DoAnTotNghiep.Entity.ExamRefQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRefQuestionRepository extends JpaRepository<ExamRefQuestion, Long> {

    List<ExamRefQuestion> findByExam(Exam exam);

}
