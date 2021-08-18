package com.example.coleta_logsup.activities.baggages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.daos.BaggageDAO;
import com.example.coleta_logsup.models.Baggage;

public class BaggageShowActivity extends AppCompatActivity {
    private Baggage baggage;
    private BaggageDAO baggageDAO;
    TextView textHeader, textShowName, textShowCategory, textShowAvailablility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baggage_show_activity);
        baggageDAO = new BaggageDAO(this);
        baggage = baggageDAO.find(getIntent().getExtras().getInt("id"));

        textHeader = findViewById(R.id.textHeader);

        textHeader.setText(baggage.getUser());
        textShowName.setText(String.valueOf(baggage.getUser()));
        textShowAvailablility.setText(String.valueOf(baggage.getQuantity()));

        getSupportActionBar().hide(); //esconder actionbar
    }

    public void back(View view) {
        startActivity(new Intent(this, BaggagesActivity.class));
    }
}
