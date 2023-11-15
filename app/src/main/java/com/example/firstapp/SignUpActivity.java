package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    private TextInputEditText etSignUpEmail;
    private TextInputEditText etSignUpPassword;
    private TextInputEditText etSignUpRepassword;
    private TextInputEditText etSignUpName;
    private TextInputEditText etSignUpPhone;
    private Button btnSignUpSave;
    private Button btnSignUpCancel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etSignUpEmail=  findViewById(R.id.etSignUpEmail);
        etSignUpPassword=  findViewById(R.id.etSignUpPassword);
        etSignUpRepassword=  findViewById(R.id.etSignUpRepassword);
        etSignUpName= findViewById(R.id.etSignUpName);
        etSignUpPhone=  findViewById(R.id.etSignUpPhone);
        btnSignUpSave= findViewById(R.id.btnSignUpSave);
        btnSignUpCancel= findViewById(R.id.btnSignUpCancel);



    }
    public void onClickSignUpCancel(View V)
    {

        finish();
    }

    public void onClickSignUp(View V)
    {

        checkSignUp();
    }
    private void checkSignUp()
    {
        boolean isAllOk = true;// يحوي نتيجة فحص الحقول ان كانت سليمة
        //استخراج النص من حقل الايميل
        String email = etSignUpEmail.getText().toString();
        //استخراج نص كلمة المرور
        String password = etSignUpPassword.getText().toString();
        //فحص الايميل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (etSignUpEmail.length() < 6 || email.contains("@") == false)
        {
            //تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            isAllOk = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etSignUpPassword.setError("Wrong Password");
        }
        if(etSignUpPassword.length() < 8 || password.contains(" ") == true)
        {
            isAllOk = false;
            etSignUpPassword.setError("Wrong Password");
        }
        if(isAllOk)
        {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
        }


    }

}