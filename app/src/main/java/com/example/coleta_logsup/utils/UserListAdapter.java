package com.example.coleta_logsup.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.activities.users.UsersActivity;
import com.example.coleta_logsup.enums.Roles;
import com.example.coleta_logsup.models.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    private Context context;
    private List<User> users;

    public UserListAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textName.setText(users.get(position).getFullName());
        holder.textRole.setText(Roles.stringfy(users.get(position).getRole()));
        holder.textPhone.setText(String.valueOf(users.get(position).getPhone()));
        holder.userID = users.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int userID;
        private TextView textName;
        private TextView textRole;
        private TextView textPhone;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textRole = itemView.findViewById(R.id.textRole);
            textPhone = itemView.findViewById(R.id.textPhone);

            TextView textDetails = itemView.findViewById(R.id.textDetails);
            TextView textEdit = itemView.findViewById(R.id.textEdit);
            TextView textRemove = itemView.findViewById(R.id.textRemove);

            textDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((UsersActivity) context).show(view, userID);
                }
            });

            textEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((UsersActivity) context).edit(view, userID);
                }
            });

            textRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((UsersActivity) context).remove(view, userID);
                }
            });
        }
    }
}
