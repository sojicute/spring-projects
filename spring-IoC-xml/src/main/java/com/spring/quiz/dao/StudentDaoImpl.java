package com.spring.quiz.dao;

import com.spring.quiz.domain.Student;


public class StudentDaoImpl implements StudentDao {

    @Override
    public Student findByName(String lastName) {
        return new Student("John", lastName);
    }
}
