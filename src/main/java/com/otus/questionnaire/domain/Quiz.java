package com.otus.questionnaire.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Data
public class Quiz {
    @Value("${quiz.csvQuestions}")
    private final String csvQuestions;

    @Value("${quiz.csvAnswers}")
    private final String csvAnswers;

    private Map<String, List<String>> test;
}
