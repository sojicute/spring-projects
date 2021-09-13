package com.spring.quiz.dao;

import com.spring.quiz.domain.Question;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuestionDaoImpl implements QuestionDao {

    private String fileName;

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile("classpath:"+fileName);
            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");

                List<String> answers = new ArrayList<>();
                for (int i = 1; i < data.length-1; i++) {
                    if (!data[i].isEmpty()) {
                        answers.add(data[i]);
                    }
                }

                Question quest = new Question(data[0], answers, Integer.parseInt(data[data.length-1]));
                questions.add(quest);
            }
            csvReader.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return questions;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
