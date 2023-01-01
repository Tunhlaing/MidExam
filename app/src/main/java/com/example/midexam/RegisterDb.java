package com.example.midexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class RegisterDb extends SQLiteOpenHelper {
    private static final String DB_NAME = "register_db";
    private static final int DB_VERSION = 1;
    private final String REGISTER_TBL = "tbl_register";
    private static final String REGISTER_ID = "register_id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";


    public RegisterDb(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + REGISTER_TBL + " ("
                + REGISTER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME + " TEXT,"
                + PASSWORD + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    boolean addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME, username);
        cv.put(PASSWORD, password);

        try {
            db.insert(REGISTER_TBL, null, cv);
            db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            db.close();
            return false;
        }
    }
}
