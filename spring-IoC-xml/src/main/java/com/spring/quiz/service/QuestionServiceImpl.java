package com.spring.quiz.service;

import com.spring.quiz.dao.QuestionDao;
import com.spring.quiz.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestions() {
        return questionDao.getQuestions();
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }
}
