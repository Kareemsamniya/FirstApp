package com.example.firstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
}
