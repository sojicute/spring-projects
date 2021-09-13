package com.spring.quiz.service;

import com.spring.quiz.domain.Question;
import com.spring.quiz.domain.Quiz;
import com.spring.quiz.domain.Student;

import java.util.List;
import java.util.Scanner;

public class QuizServiceImpl implements QuizService{

    private StudentService studentService;
    private QuestionService questionService;

    public QuizServiceImpl(StudentService studentService, QuestionService questionService) {
        this.studentService = studentService;
        this.questionService = questionService;
    }

    @Override
    public Quiz createQuiz(Student student, List<Question> questionList) {
        return new Quiz(student, questionList);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your last name");
        String lastName = sc.nextLine();

        Student student = studentService.getByName(lastName);
        System.out.println("Hello "+ student.getFirstName() + " " + student.getLastName());
        System.out.println("Test start...");

        List<Question> questions = questionService.getQuestions();
        Quiz quiz = this.createQuiz(student, questions);

        int currentQuestion = 0;
        int correctAnswer = 0;
        int InputAnswer;

        for (Question question : quiz.getQuestions()) {
            currentQuestion++;
            System.out.println(currentQuestion+".Question: ");
            System.out.println(question.getQuestion());
            for (int i = 1; i <= question.getAnswers().size(); i++) {
                System.out.println(i+question.getAnswers().get(i - 1));
            }

            InputAnswer = sc.nextInt();

            if (question.getCorrectAnswer() == InputAnswer) {
                correctAnswer++;
            }
        }

        if (quiz.getQuestions().size()/2 < correctAnswer) {
            quiz.setResult(true);
            System.out.println("You passed the test! The number of correct answers: "+ correctAnswer + "/"+ quiz.getQuestions().size());
        } else {
            quiz.setResult(false);
            System.out.println("You failed the test! The number of correct answers: "+ correctAnswer + "/"+ quiz.getQuestions().size());
        }




    }

}
