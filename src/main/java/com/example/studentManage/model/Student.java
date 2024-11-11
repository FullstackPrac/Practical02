package com.example.studentManage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

    @Column(name = "first_name", nullable = false) 
    private String firstName;

    @Column(name = "last_name", nullable = false) 
    private String lastName;

    @Column(name = "email", nullable = false) 
    private String email;

    @Column(name = "department", nullable = false) 
    private String department;

    @Column(name = "year_of_enrolment", nullable = false) 
    private String yearOfEnrolment;
}
