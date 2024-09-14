package com.example.implementasisqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated cunstructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated cunstructor stub
        String sql = "create table biodata(no integer primary key autoincrement, nama text null, tgl next null, jk text null, alamat text null, password text);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (nama, tgl, jk, alamat, password) VALUES ('Tony', '09-05-2001', 'Laki-laki', 'Jakarta', '123');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop TABLE if exists biodata");
    }

    public Boolean insertData(String username, String password, String tgl, String jk, String alamat){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama", username);
        contentValues.put("tgl", tgl);
        contentValues.put("jk", jk);
        contentValues.put("alamat", alamat);
        contentValues.put("password", password);
        long result = MyDB.insert("biodata", null, contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from biodata where nama =?", new String[] {username});
        if(cursor.getCount()>0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from biodata where nama = ? and password = ?", new String[] {username, password});
        if (cursor.getCount()>0){
            return true;
        } else {
            return false;
        }
    }
}
