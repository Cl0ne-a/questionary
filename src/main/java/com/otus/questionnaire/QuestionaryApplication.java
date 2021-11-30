package com.otus.questionnaire;

import com.otus.questionnaire.quesrionservice.QuestionnaireService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@ComponentScan
public class QuestionaryApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QuestionaryApplication.class);
        QuestionnaireService service = (QuestionnaireService) context.getBean("questionnaireServiceImpl");

        service.questionInit();
    }
}
