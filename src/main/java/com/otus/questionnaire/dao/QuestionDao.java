package com.otus.questionnaire.dao;

import java.util.List;
import java.util.Map;

public interface QuestionDao {
    Map<String, List<String>> quiz();

    Map<String, String> answerMap();
}
