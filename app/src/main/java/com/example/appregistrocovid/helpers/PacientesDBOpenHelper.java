package com.example.appregistrocovid.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PacientesDBOpenHelper extends SQLiteOpenHelper {

    private final String sqlCreate = "CREATE TABLE pacientes(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "nombre TEXT," +
            "apellido TEXT," +
            "rut TEXT," +
            "estado TEXT," +
            "fecha TEXT," +
            "sintomas INTEGER," +
            "tos INTEGER," +
            "presion INTEGER," +
            "area TEXT)";

    public PacientesDBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(this.sqlCreate);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
