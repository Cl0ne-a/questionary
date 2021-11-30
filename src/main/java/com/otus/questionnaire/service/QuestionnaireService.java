package com.otus.questionnaire.service;

import java.util.List;
import java.util.Map;

public interface QuestionnaireService {
    Map<String, List<String>> uploadQuiz();

    Map<String, String> uploadAnswers();

    void questionInit();
}
