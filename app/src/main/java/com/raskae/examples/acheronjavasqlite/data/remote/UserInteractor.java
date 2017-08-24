package com.raskae.examples.acheronjavasqlite.data.remote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.raskae.examples.acheronjavasqlite.data.local.UserContract;
import com.raskae.examples.acheronjavasqlite.data.local.UserDBHelper;
import com.raskae.examples.acheronjavasqlite.data.model.User;

/**
 * Created by Raskae on 24/08/2017.
 */

public class UserInteractor {

    //    private UserDBHelper dbHelper = new UserDBHelper(getContext());
    private UserDBHelper dbHelper;

    //    public UserInteractor(UserDBHelper dbHelper) {
    //TODO this should be injected
    public UserInteractor(Context ctx) {
        this.dbHelper = new UserDBHelper(ctx);
    }

    public Boolean logUserIn(User user) {

        User userFound = getUser(user);
        boolean result = false;

        if (userFound != null && userFound.getPassword().equals(user.getPassword())) {
            result = true;
        }

        return result;
    }

    public User getUser(User user) {
        User userFound = null;

        String[] projection = {
                UserContract.UserEntry._ID,
                UserContract.UserEntry.COLUMN_USERNAME,
                UserContract.UserEntry.COLUMN_PASSWORD,
                UserContract.UserEntry.COLUMN_EMAIL
        };

        String selection = UserContract.UserEntry.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {user.getUsername()};
        String sortOrder = UserContract.UserEntry.COLUMN_USERNAME + " DESC";

        Cursor cursor = dbHelper.getReadableDatabase().query(
                UserContract.UserEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        if (cursor.getCount() == 1) {

            while (cursor.moveToNext()) {

                userFound = new User();

                userFound.setId(cursor.getLong(
                        cursor.getColumnIndexOrThrow(UserContract.UserEntry._ID)));
                userFound.setUsername(cursor.getString(
                        cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_USERNAME)));
                userFound.setPassword(cursor.getString(
                        cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_PASSWORD)));
                userFound.setEmail(cursor.getString(
                        cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_EMAIL)));
            }
        }

        cursor.close();

        return userFound;
    }

    public boolean registerUser(User user) {

        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.COLUMN_USERNAME, user.getUsername());
        values.put(UserContract.UserEntry.COLUMN_PASSWORD, user.getPassword());
        values.put(UserContract.UserEntry.COLUMN_EMAIL, user.getEmail());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = dbHelper.getWritableDatabase().insert(UserContract.UserEntry.TABLE_NAME, null, values);

        return newRowId != 0;
    }
}
