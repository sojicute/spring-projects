package com.spring.quiz;

import com.spring.quiz.service.QuizServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

        QuizServiceImpl quizService = ctx.getBean(QuizServiceImpl.class);

        quizService.start();
    }
}
