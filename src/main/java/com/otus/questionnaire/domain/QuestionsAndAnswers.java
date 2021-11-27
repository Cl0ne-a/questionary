package com.otus.questionnaire.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class QuestionsAndAnswers {

    private String csvQuestions;

    private Map<String, List<String>> test;

    public QuestionsAndAnswers() {
    }

    public QuestionsAndAnswers(String csvQuestions) {
        this.csvQuestions = csvQuestions;
    }
}
