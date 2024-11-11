package com.example.studentManage.repository;
import com.example.studentManage.model.Student;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    
}
