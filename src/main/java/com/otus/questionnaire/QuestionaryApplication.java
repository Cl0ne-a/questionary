package com.otus.questionnaire;

import com.otus.questionnaire.domain.QuestionsAndAnswers;
import com.otus.questionnaire.service.QuestionnaireService;
import com.otus.questionnaire.service.QuestionnaireServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class QuestionaryApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/spring-context.xml");
        QuestionnaireService service = context.getBean(QuestionnaireServiceImpl.class);
        QuestionsAndAnswers info = new QuestionsAndAnswers();
        var questionnaire = service.printQuestionnaire(info);
        questionnaire.forEach((q, a) -> System.out.printf("%s: \n\t%s/ %s \n\n", q, a.get(0), a.get(1))
        );
    }
}
