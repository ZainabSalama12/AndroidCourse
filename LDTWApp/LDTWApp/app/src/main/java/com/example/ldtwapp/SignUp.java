package com.example.ldtwapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText userName=findViewById(R.id.userName);
        EditText passWord=findViewById(R.id.password);
        Button login=findViewById(R.id.signInScreen);
        Button register=findViewById(R.id.signUpGo);
        EditText confirm=findViewById(R.id.Confirmpassword);
        DBHelper DB=new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=userName.getText().toString();
                String pass=passWord.getText().toString();
                String rePass=confirm.getText().toString();

                if(user.equals("")||pass.equals("")||rePass.equals("")){
                    Toast.makeText(SignUp.this, "please enter username or password", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals(rePass)){
                        Boolean checkUser =DB.checkUsername(user);
                        if(checkUser==false){
                            Boolean insert =DB.insertData(user,pass);
                            if ((insert==true)){
                                Toast.makeText(SignUp.this, "Registration done Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(SignUp.this, HomeActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(SignUp.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(SignUp.this, "User Already Exits,please Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SignUp.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}