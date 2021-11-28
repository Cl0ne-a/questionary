package com.otus.questionnaire.config;

import com.otus.questionnaire.dao.QuestionDao;
import com.otus.questionnaire.dao.QuestionDaoImpl;
import com.otus.questionnaire.domain.Quiz;
import com.otus.questionnaire.service.QuestionnaireService;
import com.otus.questionnaire.service.QuestionnaireServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigFile {
    @Value("${quiz.csvQuestions}")
    private String csvQuestions;

    @Value("${quiz.csvAnswers}")
    private String csvAnswers;

    @Bean
    public Quiz quiz() {
        return new Quiz(csvQuestions, csvAnswers);
    }

    @Bean
    public QuestionDao questionDao(Quiz quiz) {
        return new QuestionDaoImpl(quiz);
    }

    @Bean
    public QuestionnaireService questionnaireService(QuestionDao questionDao) {
        return new QuestionnaireServiceImpl(questionDao);
    }
}
