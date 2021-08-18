package com.example.coleta_logsup.activities.baggages;

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
import com.example.coleta_logsup.daos.BaggageDAO;
import com.example.coleta_logsup.models.Baggage;
import com.example.coleta_logsup.utils.BaggageListAdapter;

import java.util.List;

public class BaggagesActivity extends AppCompatActivity {
    private RecyclerView recyclerListBaggages;
    private BaggageDAO baggageDAO;
    private List<Baggage> baggages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baggages_activity);
        TextView textHeader = findViewById(R.id.textHeader);
        textHeader.setText(R.string.baggages);


        baggageDAO = new BaggageDAO(this);
        baggages = baggageDAO.list();

        recyclerListBaggages = findViewById(R.id.recyclerListBaggages);
        recyclerListBaggages.setAdapter(new BaggageListAdapter(this, baggages));
        recyclerListBaggages.setLayoutManager(new LinearLayoutManager(this));

        getSupportActionBar().hide(); //esconder actionbar
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void goToNewBaggage(View view) {
        startActivity(new Intent(this, BaggageNewActivity.class));
    }

    public void edit(View view, int baggageID) {
        Intent intent = new Intent(this, BaggageNewActivity.class);
        intent.putExtra("id", baggageID);
        startActivity(intent);
    }

    public void show(View view, int baggageID) {
        Intent intent = new Intent(this, BaggageShowActivity.class);
        intent.putExtra("id", baggageID);
        startActivity(intent);
    }

    public void remove(View view, int baggageID) {
        if (baggageDAO.delete(baggageID)) {
            Toast.makeText(this, "Produto id: " + baggageID + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro na execução desta remoção do produto!", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this, BaggagesActivity.class));
    }
}
