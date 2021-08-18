package com.example.coleta_logsup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;

public class ScanActivity extends AppCompatActivity {
    public static TextView resulttextview;
    Button scanbutton, buttontoast, enterbarcodebutton, buttonjustify, buttonphotograph, buttonfinishcollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_activity);

        resulttextview = findViewById(R.id.barcodetextview);
        scanbutton = findViewById(R.id.buttonscanbarcode);
        enterbarcodebutton = findViewById(R.id.buttonenterbarcode);
        buttontoast = findViewById(R.id.buttontoast);
        //buttonjustify.findViewById(R.id.button_justify);
        //buttonjustify.setEnabled(false);
        //buttonphotograph.findViewById(R.id.button_photograph);
        //buttonphotograph.setEnabled(false);
        //buttonfinishcollect.findViewById(R.id.button_finish_collect);
        //buttonfinishcollect.setEnabled(false);

        scanbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
            }
        });

        enterbarcodebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EnterBarCodeActivity.class));
            }
        });

        buttontoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ScanActivity.this, resulttextview.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        getSupportActionBar().hide(); //esconder actionbar
    }

    public void goToJustify(View view) {
        startActivity(new Intent(this, JustifyActivity.class));
    }

    public void goToPhotograph(View view) {
        startActivity(new Intent(this, UploadPhoto.class));
    }

    public void goToFinishCollect(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }
}
