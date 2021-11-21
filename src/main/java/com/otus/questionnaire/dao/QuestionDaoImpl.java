package com.otus.questionnaire.dao;

import com.otus.questionnaire.domain.QuestionsAndAnswers;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDaoImpl implements  QuestionDao{

    private QuestionsAndAnswers qa;

    public void setQa(QuestionsAndAnswers qa) {
        this.qa = qa;
    }

    @Override
    public Map<String, List<String>> questionnaire(QuestionsAndAnswers qa) throws IOException {

        Reader questions = new FileReader(this.qa.getCsvQuestions());
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("country", "opt1", "opt2").parse(questions);
        Map<String, List<String>> qaMapper = new HashMap<>();
        for (CSVRecord record : records) {
            String country = record.get("country");
            String opt1 = record.get("opt1");
            String opt2 = record.get("opt2");
            qaMapper.put(country, List.of(opt1, opt2));
        }
        return qaMapper;
    }
}
