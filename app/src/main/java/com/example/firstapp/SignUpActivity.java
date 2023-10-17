package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout etEmail;
    private TextInputLayout etpassword;
    private TextInputLayout etRepassword;
    private TextInputLayout etname;
    private TextInputLayout etphone;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etEmail= (TextInputLayout) findViewById(R.id.etEmail);
        etpassword= (TextInputLayout) findViewById(R.id.etpassword);
        etRepassword= (TextInputLayout) findViewById(R.id.etRepassword);
        etname= (TextInputLayout) findViewById(R.id.etname);
        etphone= (TextInputLayout) findViewById(R.id.etphone);
        btnSave=(Button) findViewById(R.id.btnSave);


    }
}