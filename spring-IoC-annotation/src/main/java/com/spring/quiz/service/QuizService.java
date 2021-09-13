package com.spring.quiz.service;


import com.spring.quiz.domain.Question;
import com.spring.quiz.domain.Quiz;
import com.spring.quiz.domain.Student;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(Student student, List<Question> questionList);
}
