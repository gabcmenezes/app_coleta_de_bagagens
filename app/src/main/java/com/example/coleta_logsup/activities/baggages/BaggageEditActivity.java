package com.example.coleta_logsup.activities.baggages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.daos.UserDAO;

public class BaggageEditActivity extends AppCompatActivity {
    private EditText editUser, editQuantity;
    private UserDAO baggageDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baggage_new_activity);
        editUser = findViewById(R.id.editName);
        editQuantity = findViewById(R.id.editQuantity);
        baggageDAO = new UserDAO(this);

        getSupportActionBar().hide(); //esconder actionbar
    }

    public void save(View view) {
        try {
            Toast.makeText(this, "Novo produto inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, BaggagesActivity.class));
    }
}
