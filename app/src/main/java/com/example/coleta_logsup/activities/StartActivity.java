package com.example.coleta_logsup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        getSupportActionBar().hide(); //esconder actionbar
    }

    public void login(View view) {
        Intent intent = new Intent(this, LoginActivity01.class);
//        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}