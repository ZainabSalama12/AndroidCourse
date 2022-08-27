package com.example.ldtwapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Declaring variables
    LinearLayout animalsActivity,colorsActivity,spaceActivity,alphabetActivity;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TextView textView;
    Toolbar toolbar;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Defining hooks
        animalsActivity = findViewById(R.id.greenLayout);
        colorsActivity = findViewById(R.id.yellowLayout);
        spaceActivity = findViewById(R.id.orangeLayout);
        alphabetActivity= findViewById(R.id.redLayout);
        drawerLayout = findViewById(R.id.MainLayout);
        navigationView = findViewById(R.id.navgView);
        toolbar = findViewById(R.id.homeToolbar);


       // Toolbar as action bar
        setSupportActionBar(toolbar);
     //   Navigation Drawer Menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //To click on navigation menu icons
        navigationView.setNavigationItemSelectedListener(this);
        //To set home page as default page
        navigationView.setCheckedItem(R.id.navgView);


        //go to animals activity
        animalsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,AnimalsActivity.class);
                startActivity(intent);
            }
        });
        //go to colors activity
        colorsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ColorsActivity.class);
                startActivity(intent);
            }
        });
        //go to space activity
        spaceActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SpaceActivity.class);
                startActivity(intent);
            }
        });
        //go to Alphabet activity
        alphabetActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,AlphabetActivity.class);
                startActivity(intent);
            }
        });
    }
    //To close navigation bar when pressing back button
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navHome:
                break;

            case R.id.navAnimals:
                Intent animalsIntent = new Intent(HomeActivity.this,AnimalsActivity.class);
                startActivity(animalsIntent);
                break;

            case R.id.navColors:
                Intent colorsIntent = new Intent(HomeActivity.this,ColorsActivity.class);
                startActivity(colorsIntent);
                break;

            case R.id.navSpace:
                Intent spaceIntent = new Intent(HomeActivity.this,SpaceActivity.class);
                startActivity(spaceIntent);
                break;

            case R.id.navAlphabet:
                Intent alphabetIntent = new Intent(HomeActivity.this,AlphabetActivity.class);
                startActivity(alphabetIntent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}