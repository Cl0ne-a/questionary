package com.otus.questionnaire;

import com.otus.questionnaire.service.QuestionnaireService;
import com.otus.questionnaire.service.QuestionnaireServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class QuestionaryApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QuestionaryApplication.class);
        QuestionnaireService service = (QuestionnaireService) context.getBean("questionnaireServiceImpl");

        service.questionInit();
    }
}
