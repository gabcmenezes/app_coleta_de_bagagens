package com.example.coleta_logsup.activities.airports;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.activities.MainMenuActivity;
import com.example.coleta_logsup.activities.ScanActivity;
import com.example.coleta_logsup.daos.AirportDAO;
import com.example.coleta_logsup.models.Airport;
import com.example.coleta_logsup.utils.AirportListAdapter;

import java.util.List;

public class AirportsActivity extends AppCompatActivity {
    private RecyclerView recyclerListPAs;
    private AirportDAO airportDAO;
    private List<Airport> airports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airports_activity);
        TextView textHeader = findViewById(R.id.textHeader);
        textHeader.setText(R.string.airports);
        getSupportActionBar().hide(); //esconder actionbar


        airportDAO = new AirportDAO(this);
        airports = airportDAO.list();

        recyclerListPAs = findViewById(R.id.recyclerListPAs);
        recyclerListPAs.setAdapter(new AirportListAdapter(this, airports));
        recyclerListPAs.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void goToNewAirport(View view) {
        startActivity(new Intent(this, AirportNewActivity.class));
    }

    public void goToDeliveries(View view) {
        startActivity(new Intent(this, ScanActivity.class));
    }

    public void edit(View view, int airportID) {
        Intent intent = new Intent(this, AirportNewActivity.class);
        intent.putExtra("id", airportID);
        startActivity(intent);
    }

    public void show(View view, int airportID) {
        Intent intent = new Intent(this, AirportShowActivity.class);
        intent.putExtra("id", airportID);
        startActivity(intent);
    }

    public void remove(View view, int airportID) {
        if (airportDAO.delete(airportID)) {
            Toast.makeText(this, "Aeroporto id: " + airportID + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro na execução desta remoção do aeroporto!", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this, AirportsActivity.class));
    }
}
