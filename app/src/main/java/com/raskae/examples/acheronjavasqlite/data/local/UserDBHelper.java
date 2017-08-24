package com.raskae.examples.acheronjavasqlite.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Raskae on 23/08/2017.
 */
public class UserDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AcheronJavaSQLite.db";
    public static final String SEPARATOR = ",";

    public static final String USER_CREATE_SQL = "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " (" +
            UserContract.UserEntry._ID + " INTEGER PRIMARY KEY" + SEPARATOR +
            UserContract.UserEntry.COLUMN_USERNAME + " TEXT UNIQUE" + SEPARATOR +
            UserContract.UserEntry.COLUMN_PASSWORD + " TEXT" + SEPARATOR +
            UserContract.UserEntry.COLUMN_EMAIL + " TEXT )";

    private static final String SQL_DELETE_USER =
            "DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME;


    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USER);
        onCreate(db);
    }
}
