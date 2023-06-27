package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity2 extends AppCompatActivity {

    //........................................ تعريف المتغيرات
    TextInputLayout user,pass,confpass,email;
    Button sign,canc;
    static String username,password,confarmpassword,email1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //,.=,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.........................

        user = (TextInputLayout) findViewById(R.id.username);
        pass = (TextInputLayout) findViewById(R.id.password);
        confpass = (TextInputLayout) findViewById(R.id.confarmpassword);
        email = (TextInputLayout) findViewById(R.id.Email);
        sign = (Button) findViewById(R.id.SignUp);
        canc = (Button) findViewById(R.id.cancel);

        //...................................................... تعريف الأزرار
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!userNameValidation() || !passwordValidaion() || !confermPassVaidation() || !emailValidaion()){
                    return;
                }else {
                    Intent i1 = new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(i1);
                    Toast.makeText(getApplicationContext(), "Wellcom User", Toast.LENGTH_SHORT).show();
                }

            }
        });

        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }//end

    //........................................تعريف الميثود اللازمة

    public boolean userNameValidation(){
        username = user.getEditText().getText().toString().trim();
        if (username.isEmpty()){
            user.setError("The name cannot be left blank");
            return false;
        }else if (username.length()>10){
            user.setError("It cannot exceed 10 characters");
            return false;
        }else {
            user.setErrorEnabled(false);
            return true;
        }
    }

    public boolean passwordValidaion(){
        password = pass.getEditText().getText().toString().trim();
        if (password.isEmpty()){
            pass.setError("The Password cannot be left blank");
            return false;
        }else if (password.length()>8){
            pass.setError("It cannot exceed 8 characters");
            return false;
        }else {
            pass.setErrorEnabled(false);
            return true;
        }
    }

    public boolean confermPassVaidation(){
        confarmpassword = confpass.getEditText().getText().toString().trim();
        if (confarmpassword.isEmpty()){
            confpass.setError("The Phone cannot be left blank");
            return false;
        }else if (!confarmpassword.equals(password)){
            confpass.setError("Password error");
            return false;
        }else if (confarmpassword.length()>8){
            confpass.setError("It cannot exceed 8 characters");
            return false;
        }else {
            confpass.setErrorEnabled(false);
            return true;
        }
    }

    public boolean emailValidaion(){
        email1 = email.getEditText().getText().toString().trim();
        if (email1.isEmpty()){
            email.setError("The Email cannot be left blank");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
            email.setError("Error in the email");
            return false;
        }else {
            email.setErrorEnabled(false);
            return true;
        }
    }


}