package com.spring.quiz.domain;

import java.util.List;

public class Quiz {
    private Student student;
    private List<Question> questions;
    private boolean result;

    public Quiz(Student student, List<Question> questionsList) {
        this.student = student;
        this.questions = questionsList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questions = questionsList;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
