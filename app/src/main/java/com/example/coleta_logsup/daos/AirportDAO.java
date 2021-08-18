package com.example.coleta_logsup.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.coleta_logsup.daos.seeds.AirportsSeeds;
import com.example.coleta_logsup.factories.DatabaseFactory;
import com.example.coleta_logsup.models.Airport;
import com.example.coleta_logsup.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class AirportDAO {
    private SQLiteDatabase database;
    private Context context;

    public AirportDAO(Context context) {
        this.context = context;
        database = Connection.getInstance(context);
        AirportsSeeds.install(this); //deixar comentado
    }

    public void insert(Airport airport) {
        try {
            ContentValues values = new ContentValues();
            values.put("initials", airport.getInitials());
            values.put("uf", airport.getUf());
            database.insert("airport", null, values);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public List<Airport> list() {
        List<Airport> airports = new ArrayList<>();

        try {
            Cursor cursor = database.query("airport", DatabaseFactory.AIRPORT_COLUMNS, null, null, null, null, null);

            while (cursor.moveToNext()) {
                Airport airport = new Airport();
                airport.setId(cursor.getInt(0));
                airport.setInitials(cursor.getString(1));
                airport.setUf(cursor.getString(2));
                airports.add(airport);
            }
        } catch (SQLException e) {
            Toast.makeText(context, "O banco está criado, porém, vazio.", Toast.LENGTH_SHORT).show();
        }

        return airports;
    }

    public Airport find(int id) {
        Airport airport = new Airport();
        final String WHERE = "airport.id=" + id;

        try {
            Cursor cursor = database.query("airport", DatabaseFactory.AIRPORT_COLUMNS, WHERE, null, null, null, null);
            cursor.moveToFirst();
            airport.setId(cursor.getInt(0));
            airport.setInitials(cursor.getString(1));
            airport.setUf(cursor.getString(2));

        } catch (SQLiteException e) {
            database.close();
        }
        return airport;
    }

    public Airport findByInitials(String initials) {
        return null;
    }

    public void update(Airport airport) {
        String sql = "";
    }

    public boolean delete(int id) {
        final String WHERE = "airport.id=" + id;

        try {
            database.delete("airport", WHERE, null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
