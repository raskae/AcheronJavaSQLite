package com.raskae.examples.acheronjavasqlite.data.remote;

import com.raskae.examples.acheronjavasqlite.data.local.UserDBHelper;

import static java.security.AccessController.getContext;

/**
 * Created by Raskae on 24/08/2017.
 */

public class UserInteractor {

    UserDBHelper mDbHelper = new UserDBHelper(getContext());
}
