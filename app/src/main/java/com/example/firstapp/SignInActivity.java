package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firstapp.data.AppDatabase;
import com.example.firstapp.data.useresTable.MyUser;
import com.example.firstapp.data.useresTable.MyUserQuery;
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
    public void onClickSignIn(View V)
    {

        checkSignIn();
    }
    private void checkSignIn()
    {
        boolean isAllOk = true;// يحوي نتيجة فحص الحقول ان كانت سليمة
        //استخراج النص من حقل الايميل
        String Email = etSignInEmail.getText().toString();
        //استخراج نص كلمة المرور
        String Password = etSignInPassword.getText().toString();
        //فحص الايميل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (Email.length() < 6 || Email.contains("@") == false)
        {
            //تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            isAllOk = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etSignInEmail.setError("Wrong Email");
        }
        if(Password.length() < 8 || Password.contains(" ") == true)
        {
            isAllOk = false;
            etSignInPassword.setError("Wrong Password");
        }
        if(isAllOk)
        {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
            //بناء قاعدة بيانات وارجاع مؤشر عليها 1
            AppDatabase db= AppDatabase.getDB(getApplicationContext());
            //مؤشر لكائن عمليات الجدول 2
            MyUserQuery userQuery=db.getMyUserQuery();
            //ان لم يكن موجود null استدعاء العملية التي تنفذ الاستعلام الذي يفحص البريد وكلمة المرور ويعيد كائنا ان كان موجودا او لا 3
            MyUser myUser = userQuery.checkEmailPassw(Email,Password);
            if(myUser==null)// هل لا يوجد حساب الايميل والباسورد
                Toast.makeText(this, "Wrong Email Or Password", Toast.LENGTH_SHORT).show();
            else
            {// ان كان هنالك حساب الايميل والباسورد ننتقل الى الشاشة الرئسيسة
                Intent i=new Intent(SignInActivity.this,MainActivity.class);
                startActivity(i);
//                finish();

            }


        }


    }

}