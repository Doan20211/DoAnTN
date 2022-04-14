package com.DoAn.DoAnTotNghiep.Service;

import com.DoAn.DoAnTotNghiep.Entity.Assignment;

import java.util.List;

public interface AssignmentService {

    Assignment submitExam(Long id, List<String> listAnswer);

}
