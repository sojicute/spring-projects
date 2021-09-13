package com.spring.quiz.dao;

import com.spring.quiz.domain.Student;

public interface StudentDao {
    Student findByName(String firstName);
}
