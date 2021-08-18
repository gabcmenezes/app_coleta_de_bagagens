package com.example.coleta_logsup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;

public class EnterBarCodeActivity extends AppCompatActivity {
    public static TextView textJustify;
    Button button_send_enter_barcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_barcode_activity);

        textJustify = findViewById(R.id.textJustify);
        button_send_enter_barcode = findViewById(R.id.button_send_barcode);

        button_send_enter_barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), JustifyActivity.class));
            }
        });

        getSupportActionBar().hide(); //esconder actionbar
    }

    public void goToVerifyBarCode(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, ScanActivity.class));
    }
}
