package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import com.example.firstapp.data.myTasksTable.MyTask;
import com.example.firstapp.data.myTasksTable.MyTaskQuery;
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
                Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(i);

            }
        });
        //معالج حدث لاختيار موضوع بالسبنر
        spnrMainSubject.setOnClickListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // i استخراج الموضوع حسب رقمه الترتيبي
                String item = subjectAdapter.getItem(i);
                if (item.equals("ALL"))//هذه يعني عرض جميع المهام
                    initAllListView();
                else {
                    //استحراج كائن الموضوع الذي اخترناه حسب رقمه الترتيبي id
                    MySubject subject = subjectQuery.checkSubject(item);
                    //استدعاء العملية التي تجهز القائنة حسب رقم الموضوع  id
                    initListViewBySubjId(subject.getKey_id());
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?>adapterView)
            {}
        });
    }

        /**
         * عملية تجهيز السبنر بالمواضيع
         */
        private void initSubjectSpnr()
        {
            AppDatabase db = AppDatabase.getDB(getApplicationContext());//ثاعدة بناء
            MySubjectQuery subjectQuery = db.getMySubjectQuery();//عملياات جدول المواضيع
            List<MySubject>allSubjects = subjectQuery.getAll();//استحراج جميع المواضيع
            //تجهيز الوسيط
            ArrayAdapter<String> subjectAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
            subjectAdapter.add("ALL");//ستظهر اولا بالسبنر تعني عرض جميع المهمات
            for(MySubject subject : allSubjects)//اضافة المواضيع للوسيط
            {
                subjectAdapter.add(subject.Title);
            }
            spnrMainSubject.setAdapter(subjectAdapter);//ربط السبنر بالوسيط
        }

        /**
         * تجهيز قائمة جميع المهمات وعرضها ب listview
         */
        private void initAllListView()
        {
            AppDatabase db =AppDatabase.getDB(getApplicationContext());
            MyTaskQuery taskQuery = db.getMyTaskQuery();
            List<MyTask>allTasks = taskQuery.getAllTasks();
            ArrayAdapter<MyTask>tsksAdapter=new ArrayAdapter<MyTask>(this, android.R.layout.simple_dropdown_item_1line);
            tsksAdapter.addAll(allTasks);
            lstMainVTask.setAdapter(tsksAdapter);
        }


    /**
     * تجهيز قائمة المهمات حسب رقم الموضوع
     * @param key_id رقم الموضوع
     */
    private void initListViewBySubjId(long key_id)
    {
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        MyTaskQuery taskQuery = db.getMyTaskQuery();
        List<MyTask>allTasks = taskQuery.getTaskBySubjId(key_id);

        ArrayAdapter<MyTask> taskAdapter = new ArrayAdapter<MyTask>(this, android.R.layout.simple_list_item_1);
        taskAdapter.addAll(allTasks);
        lstMainVTask.setAdapter(taskAdapter);

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