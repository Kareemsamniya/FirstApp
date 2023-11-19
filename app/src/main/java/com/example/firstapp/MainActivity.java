package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapp.data.AppDatabase;
import com.example.firstapp.data.SubjectTable.MySubject;
import com.example.firstapp.data.SubjectTable.MySubjectQuery;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabMainAdd;
    private SearchView srshMainV;
    private ListView lstMainVTask;

    //spnr1
    private Spinner spnrMainSubject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabMainAdd = findViewById(R.id.fabMainAdd);
        srshMainV = findViewById(R.id.srshMainV);
        lstMainVTask = findViewById(R.id.lstMainVTask);
        fabMainAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,AddTaskActivity.class);
                startActivity(i);

            }
        });

        //spnr2
        spnrMainSubject=findViewById(R.id.spnrMainSubject);
        //spnr3 prepare adapter
        ArrayAdapter<String>adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spnr 4 data source
        String[] ar={"Math","CS","Phs","Arb","Eng"};
        //spnr 5
        adapter.addAll(ar);
        //spnr 6
        spnrMainSubject.setAdapter(adapter);


        Log.d("","");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        //بناء قاعدة بيانات وأرجاع مؤشر عليها(1
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        //مؤشر لجدول(2
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
        // 3) بناء كائن من نوع الجدول وتحديد قيم الصفات
        MySubject s1=new MySubject();
        s1.Title="math";
        MySubject s2= new MySubject();
        s2.Title="computers";
        //4) اضافة كائن للجدول
        subjectQuery.insert(s1);
        subjectQuery.insert(s2);

        //5) فحص هل تم حفظ ما سبق
        //استخراج وطباعة جميع معطيات جدول المواضيع
        final List<MySubject> allSubjects = subjectQuery.getAll();
        for(MySubject s : allSubjects)
        {
            Log.d("kareem",s.Title);
            Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ka","onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ka","OnRestart");
        Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ka","onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ka","onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ka","onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ka","onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}