package com.yuzarsif.studentmanagementsystem.repository;

import com.yuzarsif.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
