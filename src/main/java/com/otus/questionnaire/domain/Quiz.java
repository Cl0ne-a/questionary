package com.otus.questionnaire.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Data
@Component
public class Quiz {
    @Value("${Quiz.csvQuestions}")
    private String csvQuestions;

    @Value("${Quiz.csvAnswers}")
    private String csvAnswers;
}
