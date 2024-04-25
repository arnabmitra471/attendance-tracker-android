package com.example.attendancetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TeacherDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "AttendanceDb";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "TeacherData";
    public static final String T_ID = "teacher_id";

    public static final String T_NAME = "teacher_name";
    public static final String T_EMAIL = "teacher_email";
    public static final String T_PASSWORD = "teacher_password";
    public static final String CONF_PASS = "confirm_password";
    public TeacherDbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+ T_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+T_NAME +" VARCHAR(50) NOT NULL, " +T_EMAIL+ " VARCHAR(100) NOT NULL UNIQUE, "+T_PASSWORD+" VARCHAR(50) NOT NULL, "+CONF_PASS + " VARCHAR(50) NOT NULL" + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(drop_query);
        onCreate(db);
    }
    public long addTeacher(TeacherRegData tr)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues teacherData = new ContentValues();
        if(!tr.gettName().isEmpty())
        {
            teacherData.put(T_NAME,tr.gettName());
        }
        if(!tr.gettEmail().isEmpty())
        {
            teacherData.put(T_EMAIL,tr.gettEmail());
        }
        if(!tr.gettPass().isEmpty())
        {
            teacherData.put(T_PASSWORD,tr.gettPass());
        }
        if(!tr.gettConfPass().isEmpty())
        {
            teacherData.put(CONF_PASS,tr.gettConfPass());
        }
        long insertedId = db.insert(TABLE_NAME,null,teacherData);

        return insertedId;
    }
    public TeacherRegData fetchTeacherData(String t_email){
        // Getting an instance of a readable database
        SQLiteDatabase db = this.getReadableDatabase();
        TeacherRegData teacherRegData = null;

        // We have to fetch the teacher data by email of T_EMAIL + " = ?" is provided in selection condition
        String selectionCondition = T_EMAIL + " = ?";

        // Passing the selectionArgument as t_email
        String [] selectionArgs = {t_email};
        Cursor cursor = db.query(TABLE_NAME,null,selectionCondition,selectionArgs,null,null,null);
        // Checking if the cursor is not null and moving it to the first row
        if(cursor != null && cursor.moveToFirst())
        {
            // Retrieving the String type data from the cursor for name,email,password and confirm password
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            String password = cursor.getString(3);
            String conf_pass = cursor.getString(4);
            // Storing all the retrived data in the object and returning it after closing the cursor
            teacherRegData = new TeacherRegData(name,email,password,conf_pass);

            cursor.close();
        }
        return teacherRegData;
    }
}
