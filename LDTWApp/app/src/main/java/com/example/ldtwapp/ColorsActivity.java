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

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ImageView colors = findViewById(R.id.colors);
        ImageButton back3 = findViewById(R.id.back3);
        ImageButton quiz3 = findViewById(R.id.quiz3);
        ImageButton play3 = findViewById(R.id.play3);
        ListView mylist3 = findViewById(R.id.des3);
        ArrayList<String> des3 =new ArrayList<String>();
        des3.add("Describtion");
        des3.add("The world around us is so wonderful\n" +
                "different and amazing\n" +
                "The colors give it that wonderful difference\n" +
                "Colors are what brighten up our world, so let's discover some of them");
        final ArrayAdapter<String> Arrayadapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,des3);
        mylist3.setAdapter(Arrayadapter3);
        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.bounce);
        Animation anim1= AnimationUtils.loadAnimation(this,R.anim.fadein);
        Animation anim3 = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        play3.startAnimation(anim1);
        back3.startAnimation(anim1);
        quiz3.startAnimation(anim1);
        colors.startAnimation(anim2);
        mylist3.startAnimation(anim3);
        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golink("https://www.youtube.com/watch?v=ybt2jhCQ3lA");
            }
        });
        quiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ColorsActivity.this,quizColorsActivity.class);
                startActivity(intent);
            }
        });
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ColorsActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    private void golink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public static class SpaceActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_space);
        }
    }
}