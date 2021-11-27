package com.otus.questionnaire.service;

import com.otus.questionnaire.dao.QuestionDao;
import com.otus.questionnaire.domain.QuestionsAndAnswers;
import lombok.Data;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Data
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private QuestionDao csv;
    private QuestionsAndAnswers questionsAndAnswers;

    public QuestionnaireServiceImpl(QuestionDao csv) {
        this.csv = csv;
    }

    public Map<String, List<String>> printQuestionnaire()  {
        return csv.questionnaire();
    }
}