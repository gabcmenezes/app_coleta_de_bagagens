package com.example.coleta_logsup.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.coleta_logsup.factories.DatabaseFactory;

public class Connection {

    public static SQLiteDatabase getInstance(Context context) {
        DatabaseFactory database = new DatabaseFactory(context);
        return database.getWritableDatabase();
    }
}
