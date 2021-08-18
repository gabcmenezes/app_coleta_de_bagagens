package com.example.coleta_logsup.activities.baggages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.activities.StartActivity;
import com.example.coleta_logsup.daos.BaggageDAO;

public class BaggageNewActivity extends AppCompatActivity {
    private EditText editUser, editQuantity;
    private Spinner spinnerCategory;
    private BaggageDAO baggageDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baggage_new_activity);
        editUser = findViewById(R.id.editName);
        editQuantity = findViewById(R.id.editQuantity);
        baggageDAO = new BaggageDAO(this);
        getSupportActionBar().hide(); //esconder actionbar
    }

    public void save(View view) {
        try {
            //baggageDAO.insert(new Baggage(
            //        editUser.getText().toString(),
            //        Integer.parseInt(editQuantity.getText().toString())
            //));

            Toast.makeText(this, "Novo produto inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, BaggageNewActivity.class));
        }
        startActivity(new Intent(this, StartActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
