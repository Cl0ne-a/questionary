package com.otus.questionnaire.quesrionservice;

import com.otus.questionnaire.dao.QuestionDao;
import com.otus.questionnaire.dao.QuestionDaoImpl;
import com.otus.questionnaire.quizanswersservice.AnswerReader;
import com.otus.questionnaire.quizanswersservice.AnswersReaderImpl;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class QuestionnaireServiceImplTest {

    private final QuestionDao mockQuestionDao = mock(QuestionDaoImpl.class);
    private final AnswerReader mockAnswersReader = mock(AnswersReaderImpl.class);
    private final QuestionnaireService service = new QuestionnaireServiceImpl(mockQuestionDao, mockAnswersReader);

    @Test
    public void test(){
        service.questionInit();
        Map<String, String> answerMap = Map.of(
                "Argentina population in mln","45.38",
                "USA population in mln","335",
                "Capital of Scotland","Edinburgh",
                "Dog breed from China","Pug",
                "Distance to Moon in km","384.400");

        Map<String, List<String>> quizMap = Map.of(
                "Argentina population in mln", List.of( "45.38", " 30.1"),
                "Dog breed from china", List.of("Pug", "Siberian huskie"),
                "Distance to Moon in km", List.of("384.400", "648.600"),
                "USA population in mln", List.of("335", "288.1"),
                "Capital of Scotland", List.of("Edinburgh", "Toronto")
        );

        Answer<Scanner> answer = invocation -> (Scanner) invocation.callRealMethod();

        mockAnswersReader.getNames();
        when(mockAnswersReader.getNames()).then(answer);
        when(mockQuestionDao.quiz()).thenReturn(quizMap);
        when(mockQuestionDao.answerMap()).thenReturn(answerMap);

        verify(mockQuestionDao, times(1)).quiz();
        verify(mockQuestionDao, times(1)).answerMap();
    }
}