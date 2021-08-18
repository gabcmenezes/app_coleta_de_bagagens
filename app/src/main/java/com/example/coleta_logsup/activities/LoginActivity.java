package com.example.coleta_logsup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.daos.UserDAO;
import com.example.coleta_logsup.models.User;

public class LoginActivity extends AppCompatActivity {
    private EditText editLogin, editPassword;
    private User user;
    private UserDAO userDAO = new UserDAO(this);
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        getSupportActionBar().hide(); //esconder actionbar

        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
    }

    public void Check() {
        user = userDAO.findByCPF(Long.parseLong(editLogin.getText().toString()));

        if (editLogin.getText().toString().equals("admin") && editPassword.getText().toString().equals("1234")) {
            Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Failed Login", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
