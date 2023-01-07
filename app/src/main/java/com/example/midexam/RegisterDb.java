package com.example.midexam;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.util.ArrayList;


public class RegisterDb extends SQLiteOpenHelper {
    private static final String DB_NAME = "register_db";
    private static final int DB_VERSION = 1;
    private final String REGISTER_TBL = "tbl_register";

    public RegisterDb(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + REGISTER_TBL + "(register_id integer PRIMARY KEY AUTOINCREMENT, user_name TEXT , password TEXT , status TEXT )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public boolean addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("user_name", username);
        cv.put("password", password);

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
    public Boolean checkUserName(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbl_register where user_name = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkLogin(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbl_register where user_name = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)

            return true;
        else
            return false;
    }
    public void checkUpload (String username, String password , String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Cursor cursor = db.rawQuery("Select * from tbl_register where user_name = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0) {
            cv.put("status",status);
            db.update("tbl_register", cv , "user_name = ? and password = ?", new String[]{username,password});
            db.close();
        }else {
            db.close();
        }

    }
    ArrayList<RegisterModel> getDbList(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM " + REGISTER_TBL, null );
        ArrayList<RegisterModel> RegisterArrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            while (cursor.isAfterLast()){
                        @SuppressLint("Range") int register_id =cursor.getInt(cursor.getColumnIndex("register_id"));
                        @SuppressLint("Range") String user_name = cursor.getString(cursor.getColumnIndex("user_name"));
                        @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));
                        @SuppressLint("Range") String status = cursor.getString(cursor.getColumnIndex("status"));
                            RegisterModel registerModel = new RegisterModel(register_id,user_name,password,status);
                            RegisterArrayList.add(registerModel);
                            cursor.moveToNext();


            }
        }
        cursor.close();
            return RegisterArrayList;
    }
}


