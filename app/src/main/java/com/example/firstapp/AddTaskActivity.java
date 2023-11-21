package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapp.data.AppDatabase;
import com.example.firstapp.data.SubjectTable.MySubject;
import com.example.firstapp.data.SubjectTable.MySubjectQuery;
import com.example.firstapp.data.myTasksTable.MyTask;
import com.example.firstapp.data.myTasksTable.MyTaskQuery;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Array;
import java.util.List;

public class AddTaskActivity extends AppCompatActivity {

    private Button btnAddTaskSaveTask;
    private Button btnAddTaskCancelTask;
    private TextView tvAddTaskImportance;
    private SeekBar skbrAddTaskImportance;
    private TextInputEditText etAddTaskShortTitle;
    private TextInputEditText etAddTaskText;
    private AutoCompleteTextView autoEtAddTaskSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        btnAddTaskSaveTask = findViewById(R.id.btnAddTaskSaveTask);
        btnAddTaskCancelTask = findViewById(R.id.btnAddTaskCancelTask);
        tvAddTaskImportance = findViewById(R.id.tvAddTaskImportance);
        skbrAddTaskImportance = findViewById(R.id.skbrAddTaskImportance);
        etAddTaskShortTitle = findViewById(R.id.etAddTaskShortTitle);
        etAddTaskText = findViewById(R.id.etAddTaskText);
        autoEtAddTaskSubject = findViewById(R.id.autoEtAddTaskSubject);
        initAutoEtSubjects();
    }

        /**
         * استخراج اسماء المواضيع من جدول المواضيع وعرضه بالحقل من نوع
         * AutoCompletTextView
         * طريقة التعامل معه شبيه بال "spinner"
         */
        private void initAutoEtSubjects()
        {
            // مؤشر لقاعدة البيانات
            AppDatabase db=AppDatabase.getDB(getApplicationContext());
            // مؤشر لواجهة استعلامات جدول المواضيع
            MySubjectQuery subjectQuery = db.getMySubjectQuery();
            // مصدر المعطيات: استخراج جميع المواضيع من الجدول
            List<MySubject> allSubjects = subjectQuery.getAll();
            // تجهيز الوسيط
            ArrayAdapter<MySubject> adapter=new ArrayAdapter<MySubject>(this, android.R.layout.simple_dropdown_item_1line);
            adapter.addAll(allSubjects); //اضافة جميع المعطيات للوسيط
            autoEtAddTaskSubject.setAdapter(adapter);// ربط الحقل بالوسيط
            // معالجة حدث لعرض المواضيع عند الضغط على الحقل
            autoEtAddTaskSubject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                   autoEtAddTaskSubject.showDropDown();
                }
            });
        }

    public void onClickAddTaskCancel(View V)
    {

        finish();
    }
    public void onClickAddTask(View V)
    {

        checkAddTask();
    }
    private void checkAddTask() {
        boolean isAllOk = true;// يحوي نتيجة فحص الحقول ان كانت سليمة
        //استخراج النص من حقل العنوان القصير
        String ShortTitle = etAddTaskShortTitle.getText().toString();
        //استخراج نص النص
        String Text = etAddTaskText.getText().toString();
        //استخراج نص الموضوع
        String Subject = autoEtAddTaskSubject.getText().toString();
        //استخراج الأهمية
        int Importance = skbrAddTaskImportance.getProgress();
        //فحص النص القصير ان كان فارغ
        if (ShortTitle.length() < 2 || ShortTitle.contains(" ") == true) {
            //تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            isAllOk = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل النص القصير
            etAddTaskShortTitle.setError("Wrong Short Title");
        }
        if (Text.length() < 2 || Text.contains(" ") == true)
        {
            isAllOk = false;
            etAddTaskText.setError("Wrong Text");
        }
        if (Subject.length() < 2 || Subject.contains(" ") == true)
        {
            isAllOk = false;
            autoEtAddTaskSubject.setError("Wrong Subject");
        }
        if(isAllOk)
        {
            Toast.makeText(this, "All Ok", Toast.LENGTH_SHORT).show();
            //بناء قاعدة بيانات وارجاع مؤشر عليها 1
            AppDatabase db= AppDatabase.getDB(getApplicationContext());
            //مؤشر لكائن عمليات المهام 2
            MyTaskQuery taskQuery=db.getMyTaskQuery();

            //بناء كائن
            MyTask myTask = new MyTask();
            //تجديد قيم الصفات بالقيم التي استخرجناها
            myTask.ShortTitle=ShortTitle;
            myTask.text=Text;
            myTask.importance= Importance ;
            myTask.subjeId=Subject;
            //اضافة الكائن للجدول
            taskQuery.insertTask(myTask);
            //اغلاق الشاشة الخالية
            finish();

        }
    }
}