package com.otus.questionnaire.service;

import com.otus.questionnaire.domain.QuestionsAndAnswers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface QuestionnaireService {
    public Map<String, List<String>> printQuestionnaire(QuestionsAndAnswers qa) throws IOException;
}
