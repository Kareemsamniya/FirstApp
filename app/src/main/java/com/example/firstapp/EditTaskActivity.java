package com.example.firstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EditTaskActivity extends AppCompatActivity {

    private Button btnEditTaskUpdateTask;
    private Button btnEditTaskCancelTask;
    private TextView tvImportance;
    private SeekBar skbrEditTaskImportance;
    private TextInputLayout etEditTaskShortTitle;
    private TextInputLayout etEditTaskText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        btnEditTaskUpdateTask = findViewById(R.id.btnEditTaskUpdateTask);
        btnEditTaskCancelTask = findViewById(R.id.btnEditTaskCancelTask);
        etEditTaskShortTitle = findViewById(R.id.etEditTaskShortTitle);
        skbrEditTaskImportance = findViewById(R.id.skbrEditTaskImportance);
        etEditTaskShortTitle= findViewById(R.id.etEditTaskShortTitle);
        etEditTaskText= findViewById(R.id.etEditTaskText);



    }
}
