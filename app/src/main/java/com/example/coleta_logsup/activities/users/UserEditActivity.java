package com.example.coleta_logsup.activities.users;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.activities.MainMenuActivity;
import com.example.coleta_logsup.daos.UserDAO;
import com.example.coleta_logsup.models.User;

public class UserEditActivity extends AppCompatActivity {
    private EditText editName, editSurname, editCPF, editPassword, editPhone;
    private CheckBox checkAdmin;
    private UserDAO userDAO;
    private Spinner spinnerRoles;

    // TODO use DAO to instantiate the currect User, then load the fields and then as sumbitted do update

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_new_activity);
        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        editCPF = findViewById(R.id.editCPF);
        editPassword = findViewById(R.id.editPassword);
        editPhone = findViewById(R.id.editPhone);
        spinnerRoles = findViewById(R.id.spinnerRoles);
        checkAdmin = findViewById(R.id.checkAdmin);
        userDAO = new UserDAO(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.role_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoles.setAdapter(adapter);

        spinnerRoles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textSelected = ((TextView) view);
                spinnerRoles.setSelection(position);
                textSelected.setGravity(Gravity.CENTER);
                textSelected.setTextColor(Color.parseColor("#10375E"));
                textSelected.setWidth(spinnerRoles.getWidth());
                textSelected.setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        getSupportActionBar().hide(); //esconder actionbar
    }

    public void save(View view) {
        try {
            userDAO.update(new User(
                    editName.getText().toString(),
                    editSurname.getText().toString(),
                    Long.parseLong(editCPF.getText().toString()),
                    editPassword.getText().toString(),
                    Long.parseLong(editPhone.getText().toString()),
                    spinnerRoles.getSelectedItemPosition(),
                    checkAdmin.isChecked())
            );
            Toast.makeText(this, "Novo funcionário inserido com sucesso!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainMenuActivity.class));

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, UserEditActivity.class));
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }
}
