package com.spring.quiz.service;

import com.spring.quiz.dao.QuestionDao;
import com.spring.quiz.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    @Autowired
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
