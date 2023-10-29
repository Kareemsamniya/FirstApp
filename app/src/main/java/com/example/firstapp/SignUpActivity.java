package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout etSignUpEmail;
    private TextInputLayout etSignUpPassword;
    private TextInputLayout etSignUpRepassword;
    private TextInputLayout etSignUpName;
    private TextInputLayout etSignUpPhone;
    private Button btnSignUpSave;
    private Button btnSignUpCancel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etSignUpEmail=  findViewById(R.id.etSignUpEmail);
        etSignUpPassword=  findViewById(R.id.etSignUpPassword);
        etSignUpRepassword=  findViewById(R.id.etSignUpRepassword);
        etSignUpName= findViewById(R.id.etSignUpName);
        etSignUpPhone=  findViewById(R.id.etSignUpPhone);
        btnSignUpSave= findViewById(R.id.btnSignUpSave);
        btnSignUpCancel= findViewById(R.id.btnSignUpCancel);



    }
}