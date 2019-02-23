package com.example.SA.domain.Servey;

import com.example.SA.Algorithms.ExcelExtract.ExcelReader;
import com.example.SA.Algorithms.ExcelExtract.Question;
import com.example.SA.Algorithms.ExcelExtract.Responder;
import com.example.SA.Algorithms.ExcelExtract.Transfer;
import com.example.SA.domain.User.User;

import java.io.IOException;
import java.util.ArrayList;

public class TableExcel {
    private ArrayList<Question> questions;
    private ArrayList<Responder> responders;

    public TableExcel(String path, User user) throws IOException {
        ExcelReader reader = new ExcelReader(path);
        responders = reader.read();
        questions = new Transfer().transfer(responders, reader.questions());
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Responder> getResponders() {
        return responders;
    }

    public void setResponders(ArrayList<Responder> responders) {
        this.responders = responders;
    }
}