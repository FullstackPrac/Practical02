package com.example.studentManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentManage.model.Student;  // Corrected import
import com.example.studentManage.repository.StudentRepository;
import com.example.studentManage.service.StudentService;

import java.util.List;  
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Save student in database
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students from database
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student using id
    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found with id: " + id);  
        }
    }

    // Update student information
    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));  
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrolment(student.getYearOfEnrolment());
        
        
        return studentRepository.save(existingStudent);  
    }

    // Delete student by id
    @Override
    public void deleteStudent(long id) {
        // Check if student exists
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        // Delete student
        studentRepository.deleteById(id);
    }
}
