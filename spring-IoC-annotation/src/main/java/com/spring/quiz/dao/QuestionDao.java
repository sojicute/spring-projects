package com.spring.quiz.dao;

import com.spring.quiz.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions();
}
