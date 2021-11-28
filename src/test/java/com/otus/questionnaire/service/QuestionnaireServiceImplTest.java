package com.otus.questionnaire.service;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class QuestionnaireServiceImplTest {

    private final QuestionnaireService mock = mock(QuestionnaireServiceImpl.class);

    @Test
    public void test(){
        mock.questionInit();
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
        when(mock.uploadQuiz()).thenReturn(quizMap);
        when(mock.uploadAnswers()).thenReturn(answerMap);
        verify(mock, times(1)).questionInit();
    }
}