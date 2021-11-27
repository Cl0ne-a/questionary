package com.otus.questionnaire.config;

import com.otus.questionnaire.dao.QuestionDao;
import com.otus.questionnaire.dao.QuestionDaoImpl;
import com.otus.questionnaire.domain.QuestionsAndAnswers;
import com.otus.questionnaire.service.QuestionnaireService;
import com.otus.questionnaire.service.QuestionnaireServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigFile {
    @Value("${questionsAndAnswer.csvQuestions}")
    private String csvQuestions;

    @Bean
    public QuestionsAndAnswers questionsAndAnswers(){
        return new QuestionsAndAnswers(csvQuestions);
    }

    @Bean
    public QuestionDao questionDao(QuestionsAndAnswers questionsAndAnswers) {
        return new QuestionDaoImpl(questionsAndAnswers);
    }

    @Bean
    public QuestionnaireService questionnaireService(QuestionDao questionDao) {
        return new QuestionnaireServiceImpl(questionDao);
    }
}
