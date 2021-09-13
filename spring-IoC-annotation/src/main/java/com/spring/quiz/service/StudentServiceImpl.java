package com.spring.quiz.service;

import com.spring.quiz.dao.StudentDao;
import com.spring.quiz.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student getByName(String lastName) {
        return studentDao.findByName(lastName);
    }
}