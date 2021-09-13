package com.spring.quiz;

import com.spring.quiz.service.QuizServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        QuizServiceImpl quizService = context.getBean(QuizServiceImpl.class);

        quizService.start();
    }
}
