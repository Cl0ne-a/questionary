package com.otus.questionnaire.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Quiz {

    private String csvQuestions;

    private String csvAnswers;

    private Map<String, List<String>> test;

    public Quiz() {
    }

    public Quiz(String csvQuestions, String csvAnswers) {
        this.csvQuestions = csvQuestions;
        this.csvAnswers = csvAnswers;
    }
}
