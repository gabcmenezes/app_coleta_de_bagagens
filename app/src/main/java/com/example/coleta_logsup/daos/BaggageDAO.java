package com.example.coleta_logsup.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.coleta_logsup.factories.DatabaseFactory;
import com.example.coleta_logsup.models.Baggage;
import com.example.coleta_logsup.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class BaggageDAO {
    private SQLiteDatabase database;
    private Context context;

    public BaggageDAO(Context context) {
        this.context = context;
        database = Connection.getInstance(context);
//        BaggagesSeeds.install(this);
    }

    public void insert(Baggage baggage) {
        try {
            ContentValues values = new ContentValues();
            values.put("user", baggage.getUser());
            values.put("quantity", baggage.getQuantity());
            database.insert("baggage", null, values);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public List<Baggage> list() {
        List<Baggage> baggages = new ArrayList<>();

        try {
            Cursor cursor = database.query("baggage", DatabaseFactory.BAGGAGE_COLUMNS, null, null, null, null, null);

            while (cursor.moveToNext()) {
                Baggage baggage = new Baggage();
                baggage.setId(cursor.getInt(0));
                baggage.setUser(cursor.getString(1));
                baggage.setQuantity(cursor.getInt(2));
                baggages.add(baggage);
            }
        } catch (SQLException e) {
            Toast.makeText(context, "O banco está criado, porém, vazio.", Toast.LENGTH_SHORT).show();
        }

        return baggages;
    }

    public Baggage find(int id) {
        Baggage baggage = new Baggage();
        final String WHERE = "baggage.id=" + id;

        try {
            Cursor cursor = database.query("baggage", DatabaseFactory.BAGGAGE_COLUMNS, WHERE, null, null, null, null);
            cursor.moveToFirst();
            baggage.setId(cursor.getInt(0));
            baggage.setUser(cursor.getString(1));
            baggage.setQuantity(cursor.getInt(2));

        } catch (SQLiteException e) {
            database.close();
        }
        return baggage;
    }

    public Baggage findByName(String name) {
        return null;
    }

    public void update(Baggage baggage) {
        String sql = "";
    }

    public boolean delete(int id) {
        final String WHERE = "baggage.id=" + id;

        try {
            database.delete("baggage", WHERE, null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
