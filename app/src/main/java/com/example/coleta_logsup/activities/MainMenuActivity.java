package com.example.coleta_logsup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.activities.airports.AirportsActivity;
import com.example.coleta_logsup.activities.baggages.BaggagesActivity;
import com.example.coleta_logsup.activities.users.UsersActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
        getSupportActionBar().hide(); //esconder actionbar
    }

    public void goToUsers(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }

    public void goToBaggages(View view) {
        startActivity(new Intent(this, BaggagesActivity.class));
    }

    public void goToAirports(View view) {
        startActivity(new Intent(this, AirportsActivity.class));
    }

    public void goToScan(View view) {
        startActivity(new Intent(this, ScanActivity.class));
    }

    public void goToStartActivity(View view) {
        startActivity(new Intent(this, LoginActivity01.class));
    }
}
