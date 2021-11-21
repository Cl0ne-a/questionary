package com.otus.questionnaire.service;

import com.otus.questionnaire.dao.QuestionDao;
import com.otus.questionnaire.domain.QuestionsAndAnswers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

class QuestionnaireServiceImplTest {

    private final QuestionnaireService mock = mock(QuestionnaireServiceImpl.class);
    private final Map<String, List<String>> expectetd = Map.of("Argentina population", List.of( "45.38 mln", " 30.1 mln"),
            "Dog breed from china", List.of(" Pugs", " Siberian huskie"),
            "Distance to Moon", List.of(" 384.400 km", " 648.600 km"),
            "USA population", List.of(" 239.5 mln", " 288.1 mln"),
            "Capital of Scotland", List.of(" Edinburgh", " Toronto")
    );

    @Test
    public void test() throws IOException {
        QuestionsAndAnswers qa = mock(QuestionsAndAnswers.class);
        QuestionDao csv = mock(QuestionDao.class);

        mock.printQuestionnaire(qa);

        when(mock.printQuestionnaire(qa)).thenReturn(expectetd);
        verify(mock).printQuestionnaire(qa);
    }
}