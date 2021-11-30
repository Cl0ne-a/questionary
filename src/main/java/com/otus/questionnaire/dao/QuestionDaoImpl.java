package com.otus.questionnaire.dao;

import com.otus.questionnaire.domain.Quiz;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.otus.questionnaire.dao.CsvReader.getReader;

@Service
public class QuestionDaoImpl implements QuestionDao {

    private final Quiz quiz;

    public QuestionDaoImpl(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public Map<String, List<String>> quiz() {
        String source = this.quiz.getCsvQuestions();
        Reader questions = getReader(source);
        Iterable<CSVRecord> records = null;
        try {
            assert questions != null;
            records = CSVFormat.RFC4180.withHeader(
                    "question",
                    "opt1", "opt2")
                    .parse(questions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert records != null;
        return getQuizMap(records);
    }


    @Override
    public Map<String, String> answerMap() {
        String source = this.quiz.getCsvAnswers();
        Reader questions = getReader(source);
        Iterable<CSVRecord> records = null;
        try {
            assert questions != null;
            records = CSVFormat.RFC4180.withHeader(
                    "question",
                    "answer")
                    .parse(questions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert records != null;
        return getAnswerMap(records);
    }

    private Map<String, List<String>> getQuizMap(Iterable<CSVRecord> records) {
        Map<String, List<String>> qaMapper = new HashMap<>();
        assert records != null;
        for (CSVRecord record : records) {
            String country = record.get("question");
            String opt1 = record.get("opt1");
            String opt2 = record.get("opt2");
            qaMapper.put(country, List.of(opt1, opt2));
        }
        return qaMapper;
    }

    private Map<String, String> getAnswerMap(Iterable<CSVRecord> records) {
        Map<String, String> answerBase = new HashMap<>();
        assert records != null;
        for (CSVRecord record : records) {
            String question = record.get("question");
            String answer = record.get("answer");
            answerBase.put(question, answer);
        }
        return answerBase;
    }
}
