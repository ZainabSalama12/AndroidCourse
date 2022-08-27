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

public class AnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        ImageView animals = findViewById(R.id.animals_img);
        ImageButton back = findViewById(R.id.back);
        ImageButton quiz = findViewById(R.id.quiz);
        ImageButton play = findViewById(R.id.play);
        ListView mylist = findViewById(R.id.des);
        ArrayList<String> des =new ArrayList<String>();
        des.add("Describtion");
        des.add("Animals are our partner creatures on the planet. They have a good heart and are harmless. They live in zoos and forests, and some of them live with us in our homes and they are good friends.");
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
                golink("https://www.youtube.com/watch?v=KQt3jVyME-k");
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AnimalsActivity.this,quizAnimalActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AnimalsActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void golink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}