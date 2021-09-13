package com.spring.quiz.service;

import com.spring.quiz.dao.StudentDao;
import com.spring.quiz.domain.Student;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student getByName(String lastName) {
        return studentDao.findByName(lastName);
    }
}