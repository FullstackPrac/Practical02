package com.example.studentManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentManage.model.Student;
import com.example.studentManage.service.StudentService;

import java.util.List; 

@RestController
@RequestMapping("api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;  

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    // GetAll Rest Api
    @GetMapping
    public List<Student> getAllStudents() { 
        return studentService.getAllStudents();
    }

    // Get by Id Rest Api
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId) {  
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    // Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);  
    }

    // Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);  // Delete student
        return new ResponseEntity<>("Student deleted successfully.", HttpStatus.OK);
    }

    // Get by year of enrolment
    @GetMapping("/enrolment-year/{year}")
    public ResponseEntity<List<Student>> getByYearOfEnrolment(@PathVariable("year") String year) {
        List<Student> students = studentService.getByYearOfEnrolment(year);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

    //Get Depatment by student id

    @GetMapping("/department/{id}")

    public ResponseEntity<String> getDepartmentByStudentId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getDepartmentByStudentId(id), HttpStatus.OK);
    }

    // Delete students by year of enrolment
    @DeleteMapping("/enrolment-year/{year}")
    public ResponseEntity<String> deleteStudentsByYear(@PathVariable("year") String year) {
        return studentService.deleteStudentsByYear(year);
    }
}
