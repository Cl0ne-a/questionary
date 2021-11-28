package com.otus.questionnaire.service;

import com.otus.questionnaire.dao.QuestionDao;
import com.otus.questionnaire.domain.Quiz;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
@Data
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionDao questionDao;
    private final Quiz quiz;

    public QuestionnaireServiceImpl(QuestionDao questionDao, Quiz quiz) {
        this.questionDao = questionDao;
        this.quiz = quiz;
    }

    public Map<String, List<String>> uploadQuiz() {
        return questionDao.quiz();
    }

    public Map<String, String> uploadAnswers() {
        return questionDao.answerMap();
    }

    public void questionInit() {
        Map<String, List<String>> questionBase = uploadQuiz();
        Map<String, String> answerBase = uploadAnswers();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name and surname: \n");
        String name;

        while ((name = sc.nextLine()).isEmpty()) {
            System.out.println("Please, enter your name");
        }
        System.out.printf("Ok, %s, now please print the correct answers or \"-\":\n", name);

        List<String> answers = new ArrayList<>();
        questionBase.forEach((key, value) -> {
            System.out.printf("\n%s?", key);
            System.out.printf("\nChooze: %s or %s\n", value.get(0), value.get(1));
            String response = sc.next();
            if (response.equalsIgnoreCase(answerBase.get(key))) {
                answers.add(key + ": " + response);
            }
        });

        if (!answers.isEmpty() && answers.size() > questionBase.size() / 2) {
            System.out.printf("\n%s, test is passed with score %d of %d\n", name, answers.size(), questionBase.size());
            answers.forEach(System.out::println);
        } else {
            System.out.printf("%s, time to search some google :)", name);
        }
    }
}