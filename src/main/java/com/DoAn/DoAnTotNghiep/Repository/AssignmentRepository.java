package com.DoAn.DoAnTotNghiep.Repository;

import com.DoAn.DoAnTotNghiep.Entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {


}
