package com.example.ldtwapp;

public class QuestionModel {
    private String questions,option1,option2,option3,option4;
    private int correctAnsNo;

    public QuestionModel(String questions, String option1, String option2, String option3, String option4, int correctAnsNo) {
        this.questions = questions;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnsNo = correctAnsNo;
    }



    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getCorrectAnsNo() {
        return correctAnsNo;
    }

    public void setCorrectAnsNo(int correctAnsNo) {
        this.correctAnsNo = correctAnsNo;
    }


}

