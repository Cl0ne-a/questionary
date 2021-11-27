package com.otus.questionnaire.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface QuestionDao {
    Map<String, List<String>> questionnaire();
}
