package com.otus.questionnaire;

import com.otus.questionnaire.config.ConfigFile;
import com.otus.questionnaire.service.QuestionnaireService;
import com.otus.questionnaire.service.QuestionnaireServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.otus.questionnaire")
@Configuration
public class QuestionaryApplication {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigFile.class);
        QuestionnaireService service = context.getBean(QuestionnaireServiceImpl.class);

        var questionnaire = service.printQuestionnaire();

        questionnaire.forEach((q, a) -> System.out.printf("%s: \n\t%s/ %s \n\n", q, a.get(0), a.get(1)));
    }
}
