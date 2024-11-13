package com.example.studentManage.repository;
import com.example.studentManage.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByYearOfEnrolment(String year);
    
    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    String findDepartmentById(@Param("id") long id);
}
