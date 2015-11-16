package com.example.utkarsh.mess.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Utkarsh on 02-Aug-15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_BREAKFAST_TABLE = "CREATE TABLE " + Contract.BreakfastTable.TABLE_NAME + " (" + ")";
        final String SQL_CREATE_LUNCH_TABLE = "CREATE TABLE " + Contract.BreakfastTable.TABLE_NAME + " (" + ")";
        final String SQL_CREATE_DINNER_TABLE = "CREATE TABLE " + Contract.BreakfastTable.TABLE_NAME + " (" + ")";
        final String SQL_CREATE_MAINTABLE = "CREATE TABLE " + Contract.MainTable.TABLE_NAME + " (" +
                Contract.MainTable._ID + " INTEGER PRIMARY KEY," +
                Contract.MainTable.COLUMN_NAME_BREAKFAST_key + " INTEGER  NOT NULL, " +
                Contract.MainTable.COLUMN_NAME_LUNCH_key + "  INTEGER NOT NULL, " +
                Contract.MainTable.COLUMN_NAME_Dinner_key + "  INTEGER  NOT NULL, " +
                " FOREIGN KEY (" + Contract.MainTable.COLUMN_NAME_BREAKFAST_key + ") REFERENCES " +
                Contract.BreakfastTable.TABLE_NAME + " (" + Contract.BreakfastTable._ID + "), " +
                " FOREIGN KEY (" + Contract.MainTable.COLUMN_NAME_LUNCH_key + ") REFERENCES " +
                Contract.LunchTable.TABLE_NAME + " (" + Contract.LunchTable._ID + "), " +
                " FOREIGN KEY (" + Contract.MainTable.COLUMN_NAME_Dinner_key + ") REFERENCES " +
                Contract.DinnerTable.TABLE_NAME + " (" + Contract.DinnerTable._ID + "), " +

                " );";
        db.execSQL(SQL_CREATE_MAINTABLE);
        db.execSQL(SQL_CREATE_BREAKFAST_TABLE);
        db.execSQL(SQL_CREATE_LUNCH_TABLE);
        db.execSQL(SQL_CREATE_DINNER_TABLE);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
