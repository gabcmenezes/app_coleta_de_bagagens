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
import com.example.coleta_logsup.activities.baggages.BaggagesActivity;
import com.example.coleta_logsup.models.Baggage;

import java.util.List;

public class BaggageListAdapter extends RecyclerView.Adapter<BaggageListAdapter.ViewHolder> {
    private Context context;
    private List<Baggage> baggages;

    public BaggageListAdapter(Context context, List<Baggage> baggages) {
        this.context = context;
        this.baggages = baggages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.baggages_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textName.setText(baggages.get(position).getUser());
        holder.baggageID = baggages.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return baggages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private int baggageID;
        private TextView textName;
        private TextView textCategory;
        private TextView textPrice;

        @SuppressLint("CutPasteId")
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);

            TextView textDetails = itemView.findViewById(R.id.textDetails);
            TextView textEdit = itemView.findViewById(R.id.textEdit);
            TextView textRemove = itemView.findViewById(R.id.textRemove);

            textDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((BaggagesActivity) context).show(view, baggageID);
                }
            });

            textEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((BaggagesActivity) context).edit(view, baggageID);
                }
            });

            textRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((BaggagesActivity) context).remove(view, baggageID);
                }
            });
        }
    }
}
