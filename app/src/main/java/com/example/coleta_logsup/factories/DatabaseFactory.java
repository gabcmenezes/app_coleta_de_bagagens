package com.example.coleta_logsup.factories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseFactory extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "coleta_logsup_app.db";
    public static final int VERSION = 1;
    public static final String[] USER_COLUMNS = {"id", "name", "surname", "CPF", "password", "phone", "role", "admin"};
    public static final String[] AIRPORT_COLUMNS = {"id", "initials", "uf"};
    public static final String[] BAGGAGE_COLUMNS = {"id", "user", "quantity"};
    private Context context;

    public DatabaseFactory(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        createTableUser(database);
        createTableAirport(database);
        createTableBaggage(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        dropTableDropUser(database);
        dropTableDropAirport(database);
        dropTableDropBaggage(database);
    }

    /*(((USERS)))*/

    public void createTableUser(SQLiteDatabase database) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS user (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "airport CHAR(3) NOT NULL," +
                    "name VARCHAR(25) NOT NULL," +
                    "surname VARCHAR(25) NOT NULL," +
                    "CPF BIGINT NOT NULL UNIQUE, " +
                    "password VARCHAR(8) NOT NULL, " +
                    "phone BIGINT UNIQUE," +
                    "role TINYINT," +
                    "admin INTEGER NOT NULL DEFAULT 0)";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void dropTableDropUser(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS user";
        database.execSQL(sql);
    }



    /*(((AIRPORTS)))*/

    public void createTableAirport(SQLiteDatabase database) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS airport (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "initials VARCHAR(25) NOT NULL," +
                    "uf char(2) NOT NULL)";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void dropTableDropAirport(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS airport";
        database.execSQL(sql);
    }



    /*(((BAGGAGES)))*/

    public void createTableBaggage(SQLiteDatabase database) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS baggage (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "user VARCHAR(25) NOT NULL," +
                    "quantity TINYINT NOT NULL)";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void dropTableDropBaggage(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS baggage";
        database.execSQL(sql);
    }


}
