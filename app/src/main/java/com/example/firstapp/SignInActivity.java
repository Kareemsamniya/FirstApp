package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {

    private TextInputEditText etSignInEmail;
    private TextInputEditText etSignInPassword;
    private Button btnSignInSignIn;
    private Button btnSignInSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etSignInEmail=  findViewById(R.id.etSignInEmail);
        etSignInPassword=  findViewById(R.id.etSignInPassword);
        btnSignInSignIn=  findViewById(R.id.btnSignInSignIn);
        btnSignInSignUp= findViewById(R.id.btnSignInSignUp);



    }
    public void onClickSignInSignUp(View V)
    {

        Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(i);

    }
    private void checkEmailPassw()
    {
        boolean isAllOk = true;// يحوي نتيجة فحص الحقول ان كانت سليمة
        //استخراج النص من حقل الايميل
        String email = etSignInEmail.getText().toString();
        //استخراج نص كلمة المرور
        String password = etSignInPassword.getText().toString();
        //فحص الايميل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (etSignInEmail.length() < 6)
        {

        }
    }
}