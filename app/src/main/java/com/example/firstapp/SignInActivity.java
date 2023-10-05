package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class SignInActivity extends AppCompatActivity {

    private TextInputLayout etEmail;
    private TextInputLayout etpassword;
    private TextInputLayout btnsignin;
    private TextInputLayout btnsignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etEmail= (TextInputLayout) findViewById(R.id.etEmail);
        etpassword= (TextInputLayout) findViewById(R.id.etpassword);
        Button btnsignin= (Button) findViewById(R.id.btnsignin);
        Button btnSignUp = (Button) findViewById(R.id.btnSignUp);


    }
}