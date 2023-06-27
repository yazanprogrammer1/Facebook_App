package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button enter,signup;
    TextInputLayout email2,pass1;
    String us,pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //....................................

        email2 = (TextInputLayout) findViewById(R.id.username1);
        pass1 = (TextInputLayout) findViewById(R.id.password1);
        enter = (Button) findViewById(R.id.enter);
        signup = (Button) findViewById(R.id.sign1);

        //....................................

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emailvad() || !passvad()){
                    return;
                }else {
                    Intent i1 = new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(i1);
                    Toast.makeText(getApplicationContext(), "Wellcom User", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });

    }//end
    public boolean emailvad(){
        us = email2.getEditText().getText().toString().trim();
        if(!us.equals(MainActivity2.email1)){
            email2.setError("Error in The Email");
            return false;
        }else {
            email2.setErrorEnabled(false);
                return true;
        }

    }
    public boolean passvad(){
        pas = pass1.getEditText().getText().toString().trim();
        if(!pas.equals(MainActivity2.password)){
            pass1.setError("Error in The Email");
            return false;
        }else {
            pass1.setErrorEnabled(false);
            return true;
        }

    }

}