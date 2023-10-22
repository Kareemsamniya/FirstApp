package com.example.firstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class AddTaskActivity extends AppCompatActivity {

    private Button btnSaveTask;
    private Button btnCancelTask;
    private TextView tvImportance;
    private SeekBar skbrImportance;
    private TextInputLayout etShortTitle;
    private TextInputLayout etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        btnSaveTask =(Button) findViewById(R.id.btnSaveTask);
        btnCancelTask =(Button) findViewById(R.id.btnCancelTask);
        tvImportance =(TextView) findViewById(R.id.tvImportance);
        skbrImportance =(SeekBar) findViewById(R.id.skbrImportance);
        etShortTitle=(TextInputLayout) findViewById(R.id.etShortTitle);
        etText=(TextInputLayout) findViewById(R.id.etText);
    }
}
