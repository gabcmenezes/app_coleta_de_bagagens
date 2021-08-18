package com.example.coleta_logsup.activities.users;

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
import com.example.coleta_logsup.daos.UserDAO;
import com.example.coleta_logsup.models.User;
import com.example.coleta_logsup.utils.UserListAdapter;

import java.util.List;

public class UsersActivity extends AppCompatActivity {
    private RecyclerView recyclerListUsers;
    private UserDAO userDAO;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_activity);
        TextView textHeader = findViewById(R.id.textHeader);
        textHeader.setText(R.string.users);
        getSupportActionBar().hide(); //esconder actionbar


        userDAO = new UserDAO(this);
        users = userDAO.list();

        recyclerListUsers = findViewById(R.id.recyclerListUsers);
        recyclerListUsers.setAdapter(new UserListAdapter(this, users));
        recyclerListUsers.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void goToNewUser(View view) {
        startActivity(new Intent(this, UserNewActivity.class));
    }

    public void edit(View view, int userID) {
        Intent intent = new Intent(this, UserNewActivity.class);
        intent.putExtra("id", userID);
        startActivity(intent);
    }

    public void show(View view, int userID) {
        Intent intent = new Intent(this, UserShowActivity.class);
        intent.putExtra("id", userID);
        startActivity(intent);
    }

    public void remove(View view, int userID) {
        if (userDAO.delete(userID)) {
            Toast.makeText(this, "Usuário id: " + userID + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro na execução desta remoção do usuário!", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this, UsersActivity.class));
    }
}
