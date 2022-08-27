package com.example.ldtwapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AlphabetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        ImageView animals = findViewById(R.id.animals_img);
        ImageButton back = findViewById(R.id.back);
        ImageButton quiz = findViewById(R.id.quiz);
        ImageButton play = findViewById(R.id.play);
        ListView mylist = findViewById(R.id.des);
        ArrayList<String> des =new ArrayList<String>();
        des.add("Describtion");
        des.add("An alphabet is a set of letters usually presented in a fixed order which is used for writing the words of a particular language or group of languages. The modern Russian alphabet has 31 letters. By two and a half he knew the alphabet. Synonyms: letters, script, writing system, syllabary More Synonyms of alphabet.");
        final ArrayAdapter<String> Arrayadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,des);
        mylist.setAdapter(Arrayadapter);
        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.bounce);
        Animation anim1= AnimationUtils.loadAnimation(this,R.anim.fadein);
        Animation anim3 = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        play.startAnimation(anim1);
        back.startAnimation(anim1);
        quiz.startAnimation(anim1);
        animals.startAnimation(anim2);
        mylist.startAnimation(anim3);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golink("https://youtu.be/hq3yfQnllfQ");
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AlphabetActivity.this,quizAlphabetActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AlphabetActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void golink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}