package com.example.firstapp;

import static com.example.firstapp.R.id.etWelcome;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SplashScreen extends AppCompatActivity {

    private TextView etWelcome;
    private Button btnGo;
    private ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        btnGo= (Button) findViewById(R.id.btnGo);
        imageView1= (ImageView) findViewById(R.id.imageView1);
        etWelcome= (TextView) findViewById(R.id.etWelcome);


    }
}
