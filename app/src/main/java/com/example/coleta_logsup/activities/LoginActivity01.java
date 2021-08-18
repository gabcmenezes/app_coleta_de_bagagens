package com.example.coleta_logsup.activities;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.activities.airports.AirportsActivity;

public class LoginActivity01 extends AppCompatActivity {

    //private UserDAO userDAO = new UserDAO(this);
    EditText user, password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity01);

        String correctuser="Gabriel";
        String correctpassword = "123456";

        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submit_btn);

        submit.setEnabled(false);

        user.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        getSupportActionBar().hide(); //esconder actionbar

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(user.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(LoginActivity01.this, "empty data", Toast.LENGTH_SHORT).show();
                }else if(user.getText().toString().equals(correctuser)){
                    //check user
                }if(password.getText().toString().equals(correctpassword)){
                    Toast.makeText(LoginActivity01.this, "Bem-vindo, " + user.getText().toString() + "!", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(LoginActivity01.this, MainMenuActivity.class);
                    Intent intent = new Intent(LoginActivity01.this, AirportsActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity01.this, "Usuário ou senha incorretos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Check() {
        Toast.makeText(this, "entrou", Toast.LENGTH_SHORT).show();
        //user = userDAO.findByID(user.getText().toString());

        if (user.getText().toString().equals("admin") && password.getText().toString().equals("1234")) {
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

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String n = user.getText().toString();
            String a = password.getText().toString();

            if(!n.isEmpty() && !a.isEmpty()){
                //ambos não estão vazios
                submit.setEnabled(true);
            }else{
                submit.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}