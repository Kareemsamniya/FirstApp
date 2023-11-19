package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapp.data.AppDatabase;
import com.example.firstapp.data.myTasksTable.MyTask;
import com.example.firstapp.data.myTasksTable.MyTaskQuery;
import com.example.firstapp.data.useresTable.MyUser;
import com.example.firstapp.data.useresTable.MyUserQuery;
import com.google.android.material.textfield.TextInputEditText;
public class AddTaskActivity extends AppCompatActivity {

    private Button btnAddTaskSaveTask;
    private Button btnAddTaskCancelTask;
    private TextView tvAddTaskImportance;
    private SeekBar skbrAddTaskImportance;
    private TextInputEditText etAddTaskShortTitle;
    private TextInputEditText etAddTaskText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        btnAddTaskSaveTask = findViewById(R.id.btnAddTaskSaveTask);
        btnAddTaskCancelTask = findViewById(R.id.btnAddTaskCancelTask);
        tvAddTaskImportance = findViewById(R.id.tvAddTaskImportance);
        skbrAddTaskImportance = findViewById(R.id.skbrAddTaskImportance);
        etAddTaskShortTitle= findViewById(R.id.etAddTaskShortTitle);
        etAddTaskText= findViewById(R.id.etAddTaskText);
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
        //استخراج الأهمية
        int Importance = skbrAddTaskImportance.getProgress();
        //فحص النص القصير ان كان فارغ
        if (ShortTitle.contains(" ") == true) {
            //تعديل المتغير ليدل على ان الفحص يعطي نتيجة خاطئة
            isAllOk = false;
            //عرض ملاحظة خطأ على الشاشة داخل حقل النص القصير
            etAddTaskShortTitle.setError("Wrong Short Title");
        }
        if (Text.contains(" ") == true)
        {
            isAllOk = false;
            etAddTaskText.setError("Wrong Text");
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
            //اضافة الكائن للجدول
            taskQuery.insertTask(myTask);
            //اغلاق الشاشة الخالية
            finish();

        }
    }
}
