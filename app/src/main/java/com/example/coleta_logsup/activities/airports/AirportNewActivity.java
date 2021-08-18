package com.example.coleta_logsup.activities.airports;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.daos.AirportDAO;
import com.example.coleta_logsup.models.Airport;

public class AirportNewActivity extends AppCompatActivity {
    private EditText editInitials, editUf;
    private AirportDAO airportDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airport_new_activity);
        editInitials = findViewById(R.id.editInitials);
        editUf = findViewById(R.id.editUf);
        airportDAO = new AirportDAO(this);
        getSupportActionBar().hide(); //esconder actionbar
    }

    // TODO método para escurecer o fundo do input quando este estiver com focus

    public void save(View view) {
        try {
            airportDAO.insert(new Airport(
                    editInitials.getText().toString(),
                    editUf.getText().toString())
            );
            Toast.makeText(this, "Novo aeroporto inserido com sucesso!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AirportsActivity.class));

        } catch (SQLException e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AirportNewActivity.class));
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, AirportsActivity.class));
    }
}