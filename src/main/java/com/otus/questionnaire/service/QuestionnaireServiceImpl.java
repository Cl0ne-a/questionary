package com.otus.questionnaire.service;

import com.otus.questionnaire.dao.QuestionDao;
import com.otus.questionnaire.dao.QuestionDaoImpl;
import com.otus.questionnaire.domain.QuestionsAndAnswers;
import lombok.Data;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Data
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private QuestionDao csv;

    public QuestionnaireServiceImpl() {
    }

    public void setCsv(QuestionDao csv) {
        this.csv = csv;
    }

    @Override
    public Map<String, List<String>> printQuestionnaire(QuestionsAndAnswers qa) throws IOException {
        return csv.questionnaire(qa);
    }
}
