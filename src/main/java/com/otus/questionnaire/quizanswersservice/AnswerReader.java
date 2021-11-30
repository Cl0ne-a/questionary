package com.otus.questionnaire.quizanswersservice;

import java.util.List;
import java.util.Map;

public interface AnswerReader {
    String getNames();
    List<String> getQuizAnswers(Map<String, List<String>> questionBase, Map<String, String> answerBase);
}
