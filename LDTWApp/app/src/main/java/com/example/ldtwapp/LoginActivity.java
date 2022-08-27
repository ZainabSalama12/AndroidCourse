package com.example.ldtwapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginn=findViewById(R.id.signInGoo);
        EditText userNamee=findViewById(R.id.userNamee);
        EditText passWordd=findViewById(R.id.passwordd);
        Button registerr=findViewById(R.id.signUpScreenn);
        DBHelper DB=new DBHelper(this);


        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=userNamee.getText().toString();
                String pass=passWordd.getText().toString();
                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Please enter username or password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUserPass = DB.checkUsernamePassword(user,pass);
                    if (checkUserPass==true){
                        Toast.makeText(LoginActivity.this, "Login done Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();

                    }
                }            }
        });
        registerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivity.this,SignUp.class);
                startActivity(intent);
            }
        });

    }
}