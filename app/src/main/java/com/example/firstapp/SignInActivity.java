package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignInActivity extends AppCompatActivity {

    private TextInputEditText etEmail;
    private TextInputEditText etpassword;
    private TextInputEditText btnsignin;
    private TextInputEditText btnsignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etEmail= (TextInputEditText) findViewById(R.id.etEmail);
        etpassword= (TextInputEditText) findViewById(R.id.etpassword);
        Button btnsignin= (Button) findViewById(R.id.btnsignin);
        Button btnSignUp = (Button) findViewById(R.id.btnSignUp);


    }
}