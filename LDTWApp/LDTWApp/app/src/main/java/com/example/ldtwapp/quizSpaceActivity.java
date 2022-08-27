package com.example.ldtwapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class quizSpaceActivity extends AppCompatActivity {
    private TextView question,score,questionNo,timer;
    private Button next;
    private RadioGroup radioGroup;
    private RadioButton opt1,opt2,opt3,opt4;
    private List<QuestionModel> questionList;
    private int qCounter=0;
    private int totalQuestion;
    private QuestionModel currentQuestion;
    boolean answered;
    ColorStateList colorStateList;
    int Score;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_space);
        questionList = new ArrayList<>();
        question=findViewById(R.id.question);
        questionNo=findViewById(R.id.questionsNumber);
        score=findViewById(R.id.score);
        timer=findViewById(R.id.timer);
        radioGroup=findViewById(R.id.answers);
        next=findViewById(R.id.btnNext);
        opt1=findViewById(R.id.option1);
        opt2=findViewById(R.id.option2);
        opt3=findViewById(R.id.option3);
        opt4=findViewById(R.id.option4);
        colorStateList=opt1.getTextColors();
        addQuestion();
        totalQuestion=questionList.size();
        showNextQuestion();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answered==false){
                    if(opt1.isChecked()||opt2.isChecked()||opt3.isChecked()||opt4.isChecked()){
                        checkAnswer();
                        countDownTimer.cancel();
                    }
                    else{
                        Toast.makeText(quizSpaceActivity.this, "Please select any option", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    showNextQuestion();
                }
            }
        });

    }
    private void checkAnswer(){
        answered=true;
        RadioButton radioButton=findViewById(radioGroup.getCheckedRadioButtonId());
        int answerno=radioGroup.indexOfChild(radioButton)+1;
        if(answerno==currentQuestion.getCorrectAnsNo()){
            Score++;
            score.setText("Score: "+Score);
        }
        opt1.setTextColor(Color.RED);
        opt2.setTextColor(Color.RED);
        opt3.setTextColor(Color.RED);
        opt4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()){
            case 1:opt1.setTextColor(Color.GREEN);
                break;
            case 2:opt2.setTextColor(Color.GREEN);
                break;
            case 3:opt3.setTextColor(Color.GREEN);
                break;
            case 4:opt4.setTextColor(Color.GREEN);
                break;
        }
        if(qCounter<totalQuestion){
            next.setText("Next");
        }
        else{
            next.setText("Finish");
        }

    }

    private void showNextQuestion() {
        radioGroup.clearCheck();
        opt1.setTextColor(colorStateList);
        opt2.setTextColor(colorStateList);
        opt3.setTextColor(colorStateList);
        opt4.setTextColor(colorStateList);

        if(qCounter<totalQuestion){
            timer();
            currentQuestion=questionList.get(qCounter);
            question.setText((currentQuestion.getQuestions()));
            questionNo.setText(currentQuestion.getQuestions());
            opt1.setText(currentQuestion.getOption1());
            opt2.setText(currentQuestion.getOption2());
            opt3.setText(currentQuestion.getOption3());
            opt4.setText(currentQuestion.getOption4());
            qCounter++;
            questionNo.setText("Question"+qCounter+"/"+totalQuestion);
            answered=false;
        }
        else{
            finish();
            Toast.makeText(this, "Your Score is "+Score, Toast.LENGTH_SHORT).show();
        }
    }

    private void timer() {
        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l)
            {
                timer.setText("00:" + l/1000);
            }

            @Override
            public void onFinish() {
                showNextQuestion();
            }
        }.start();

    }

    private void addQuestion() {
        questionList.add(new QuestionModel("What is the biggest planet?","Earth","Saturn","Jupiter","Mercury",3));
        questionList.add(new QuestionModel("What is the planet that we live in?","Saturn","Earth","Neptune","Jupiter",2));
        questionList.add(new QuestionModel("______ is called the “Red Planet” in our solar system.","Mars","Venus","Mercury","Earth",1));
        questionList.add(new QuestionModel("What is the smallest planet?","Jupiter","Saturn","Earth","Mercury",4));
        questionList.add(new QuestionModel("______ is the third planet from the sun.","Mars","Jupiter","Earth","Saturn",3));
    }
}