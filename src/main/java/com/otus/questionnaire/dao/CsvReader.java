package com.otus.questionnaire.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;


public interface CsvReader {

    static Reader getReader(String source) {
        Reader questions = null;
        try {
            questions = new FileReader(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
