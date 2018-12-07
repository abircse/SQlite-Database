package com.studioabir.sqlitepractice.sqlitepractice.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class mydatabasehelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="student.db";
    private static final String TABLE_NAME="student";
    private static final String ID="id";
    private static final String NAME="name";
    private static final String AGE="age";
    private static final int DATABASE_VERSION = 1;
    private static final String insertquery = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" TEXT, "+AGE+" TEXT)";
    private static final String droptable = "DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;

    public mydatabasehelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        try
        {
            db.execSQL(insertquery);
            Toast.makeText(context, "On Create Method called", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(context, "OnCreate throw Exception is"+e, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try
        {
            db.execSQL(droptable);
            onCreate(db);
        }
        catch (Exception e)
        {
            Toast.makeText(context, "OnUpgrade throw Exception is"+e, Toast.LENGTH_LONG).show();

        }
    }


    public long insertdata(String name, String age)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);

        long rowid = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;
    }
}
