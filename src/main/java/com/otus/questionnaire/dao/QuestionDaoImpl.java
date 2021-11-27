package com.otus.questionnaire.dao;

import com.otus.questionnaire.domain.QuestionsAndAnswers;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionDaoImpl implements QuestionDao {

    private final QuestionsAndAnswers qa;

    public QuestionDaoImpl(QuestionsAndAnswers qa) {
        this.qa = qa;
    }

    @Override
    public Map<String, List<String>> questionnaire() {
        String source = this.qa.getCsvQuestions();
        Reader questions = null;
        try {
            questions = new FileReader(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Iterable<CSVRecord> records = null;
        try {
            assert questions != null;
            records = CSVFormat.RFC4180.withHeader("country", "opt1", "opt2").parse(questions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, List<String>> qaMapper = new HashMap<>();
        assert records != null;
        for (CSVRecord record : records) {
            String country = record.get("country");
            String opt1 = record.get("opt1");
            String opt2 = record.get("opt2");
            qaMapper.put(country, List.of(opt1, opt2));
        }
        return qaMapper;
    }
}
