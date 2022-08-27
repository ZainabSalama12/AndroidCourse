package com.example.ldtwapp;

import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class SpaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);
        ImageView solar_sys = findViewById(R.id.solar_system);
        ImageButton back2 = findViewById(R.id.back2);
        ImageButton quiz2 = findViewById(R.id.quiz2);
        ImageButton play2 = findViewById(R.id.play2);

        ListView mylist2 = findViewById(R.id.des2);

        ArrayList<String> des2 =new ArrayList<String>();

        des2.add("Describtion");
        des2.add("We live in a huge world\n" +
                "Bigger than we think We live in a house and the house is inside a street and the street is inside a city and the city is inside countries and the country is inside a continent and the continent is inside the planet and the planet is part of our solar system\n" +
                "Our solar system consists of a planet, stars and moons. Let's explore them");
        final ArrayAdapter<String> Arrayadapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,des2);
        mylist2.setAdapter(Arrayadapter2);

        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.bounce);
        Animation anim1= AnimationUtils.loadAnimation(this,R.anim.fadein);
        Animation anim3 = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        play2.startAnimation(anim1);
        back2.startAnimation(anim1);
        quiz2.startAnimation(anim1);
        solar_sys.startAnimation(anim2);
        mylist2.startAnimation(anim3);

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                golink("https://www.youtube.com/watch?v=sD1-rS_TM2o");
            }
        });
        quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SpaceActivity.this,quizSpaceActivity.class);
                startActivity(intent);
            }
        });
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SpaceActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void golink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}
