package com.example.studentManage.service;
import com.example.studentManage.model.Student; 
import java.util.List;

import org.springframework.http.ResponseEntity;  

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();  
    Student getStudentById(long id);
    Student updateStudent(Student student, long id);  
    void deleteStudent(long id);
    List<Student> getByYearOfEnrolment(String year);
    String getDepartmentByStudentId(Long id);
    
    ResponseEntity<String> deleteStudentsByYear(String year);
}
