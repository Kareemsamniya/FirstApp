package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firstapp.data.AppDatabase;
import com.example.firstapp.data.useresTable.MyUser;
import com.example.firstapp.data.useresTable.MyUserQuery;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

        checkAndSignUP_FB();
    }
    private void checkSignUp()
    {
        boolean isAllOk = true;// يحوي نتيجة فحص الحقول ان كانت سليمة
        //استخراج النص من حقل الايميل
        String Email = etSignUpEmail.getText().toString();
        //استخراج نص كلمة المرور
        String Password = etSignUpPassword.getText().toString();
        //استخراج نص تأكيد كلمة المرور
        String RePassword = etSignUpRepassword.getText().toString();
        //استخراج نص الاسم
        String Name = etSignUpName.getText().toString();
        //استخراج نص رقم الهاتف
        String Phone = etSignUpPhone.getText().toString();
        //فحص الايميل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (Email.length() < 6 || Email.contains("@") == false)
        {
            //تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            isAllOk = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etSignUpEmail.setError("Wrong Email");
        }
        if(Password.length() < 8 || Password.contains(" ") == true)
        {
            isAllOk = false;
            etSignUpPassword.setError("Wrong Password");
        }
        if(RePassword.contains(" ") == true || RePassword.equals(Password) == false )
        {
            isAllOk = false;
            etSignUpRepassword.setError("Wrong Re-Password");
        }
        if(Name.length() < 2 || Name.contains(" ") == true)
        {
            isAllOk = false;
            etSignUpName.setError("Wrong Name");
        }
        if(Phone.length() != 10 || Phone.contains(" ") == true )
        {
            isAllOk = false;
            etSignUpPhone.setError("Wrong Phone");
        }
        if(isAllOk)
        {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
            //بناء قاعدة بيانات وارجاع مؤشر عليها 1
            AppDatabase db= AppDatabase.getDB(getApplicationContext());
            //مؤشر لكائن عمليات الجدول 2
            MyUserQuery userQuery=db.getMyUserQuery();
            //فحص هل البريد الالكتروني موجود من قبل اي تم التسجيل من قبل
            if(userQuery.checkEmail(Email)!=null)
            {
                etSignUpEmail.setError("found email");
            }
            else// ان لم يكن البريد موجودا نقوم ببناء كائن للمستعمل وادخاله في الجدول MyUser المستعملين
            {
                //بناء كائن
                MyUser myUser = new MyUser();
                //تجديد قيم الصفات بالقيم التي استخرجناها
                myUser.email=Email;
                myUser.fullName=Name;
                myUser.phone=Phone;
                myUser.passw=Password;
                //اضافة الكائن للجدول
                userQuery.insert(myUser);
                //اغلاق الشاشة الخالية
                finish();
            }
        }


    }
    private void checkAndSignUP_FB()
    {
        boolean isAllOk = true;// يحوي نتيجة فحص الحقول ان كانت سليمة
        //استخراج النص من حقل الايميل
        String Email = etSignUpEmail.getText().toString();
        //استخراج نص كلمة المرور
        String Password = etSignUpPassword.getText().toString();
        //استخراج نص تأكيد كلمة المرور
        String RePassword = etSignUpRepassword.getText().toString();
        //استخراج نص الاسم
        String Name = etSignUpName.getText().toString();
        //استخراج نص رقم الهاتف
        String Phone = etSignUpPhone.getText().toString();
        //فحص الايميل ان كان طوله اقل من 6 او لا يحوي @ فهو خطأ
        if (Email.length() < 6 || Email.contains("@") == false)
        {
            //تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            isAllOk = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل البريد
            etSignUpEmail.setError("Wrong Email");
        }
        if(Password.length() < 8 || Password.contains(" ") == true)
        {
            isAllOk = false;
            etSignUpPassword.setError("Wrong Password");
        }
        if(RePassword.contains(" ") == true || RePassword.equals(Password) == false )
        {
            isAllOk = false;
            etSignUpRepassword.setError("Wrong Re-Password");
        }
        if(Name.length() < 2 || Name.contains(" ") == true)
        {
            isAllOk = false;
            etSignUpName.setError("Wrong Name");
        }
        if(Phone.length() != 10 || Phone.contains(" ") == true )
        {
            isAllOk = false;
            etSignUpPhone.setError("Wrong Phone");
        }
        if(isAllOk)
        {
            //עצם לביצוע רישום كائن لعملية التسجيل
            FirebaseAuth auth= FirebaseAuth.getInstance();
            //יצירת חשבון בעזרת מיל וסיסמא
            auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override//התגובה שמתקבל הניסיון הרישום בענן
                public void onComplete(@NonNull Task<AuthResult> task) {//הפרמטר מכיל מידע מהשרת על תוצאת הבקשה לרישום
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SignUpActivity.this, "Signing up succeeded", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this, "Signing up failed", Toast.LENGTH_SHORT).show();
                        etSignUpEmail.setError(task.getException().getMessage());//הצגת הודעת השגיאה שהתקבלה מהענן
                    }
                }
            });
        }
    }


}