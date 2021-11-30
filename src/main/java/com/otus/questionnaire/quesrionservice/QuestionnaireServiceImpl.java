package com.otus.questionnaire.quesrionservice;

import com.otus.questionnaire.dao.QuestionDao;
import com.otus.questionnaire.quizanswersservice.AnswerReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private final QuestionDao questionDao;
    private final AnswerReader answerReader;

    public QuestionnaireServiceImpl(QuestionDao questionDao, AnswerReader answerReader) {
        this.questionDao = questionDao;
        this.answerReader = answerReader;
    }

    @Override
    public void questionInit() {
        Map<String, List<String>> questionBase = uploadQuiz();
        Map<String, String> answerBase = uploadAnswers();

        System.out.println("Enter your name and surname: \n");

        String name = answerReader.getNames();
        System.out.printf("Ok, %s, now please print the correct answers or \"-\":\n", name);

        List<String> answers = answerReader.getQuizAnswers(questionBase, answerBase);

        if (!answers.isEmpty() && answers.size() > questionBase.size() / 2) {
            System.out.printf("\n%s, test is passed with score %d of %d\n", name, answers.size(), questionBase.size());
            answers.forEach(System.out::println);
        } else {
            System.out.printf("%s, time to search some google :)", name);
        }
    }

    private Map<String, List<String>> uploadQuiz() {
        return questionDao.quiz();
    }

    private Map<String, String> uploadAnswers() {
        return questionDao.answerMap();
    }
}