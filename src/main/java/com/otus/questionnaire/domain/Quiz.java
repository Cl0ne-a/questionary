package com.otus.questionnaire.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

@Data
public class Quiz {
    @Value("${quiz.csvQuestions}")
    private String csvQuestions;
    @Value("${quiz.csvAnswers}")
    private String csvAnswers;

    private Map<String, List<String>> test;

    public Quiz() {
    }

    public Quiz(String csvQuestions, String csvAnswers) {
        this.csvQuestions = csvQuestions;
        this.csvAnswers = csvAnswers;
    }
}
