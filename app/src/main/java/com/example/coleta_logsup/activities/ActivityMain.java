package com.example.coleta_logsup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    Button buttonAddItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddItem = (Button)findViewById(R.id.btn_add_item);
        buttonAddItem.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v==buttonAddItem){

            Intent intent = new Intent(getApplicationContext(),AddItem.class);
            startActivity(intent);
        }

    }
}