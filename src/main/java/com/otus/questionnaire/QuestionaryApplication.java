package com.otus.questionnaire;

import com.otus.questionnaire.service.QuestionnaireService;
import com.otus.questionnaire.service.QuestionnaireServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class QuestionaryApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QuestionaryApplication.class);
        QuestionnaireService service = context.getBean(QuestionnaireServiceImpl.class);

        service.questionInit();
    }
}
