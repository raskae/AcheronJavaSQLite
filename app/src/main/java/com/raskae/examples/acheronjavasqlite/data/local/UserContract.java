package com.raskae.examples.acheronjavasqlite.data.local;

import android.provider.BaseColumns;

/**
 * Created by Raskae on 24/08/2017.
 */

public class UserContract {

    public static abstract class UserEntry implements BaseColumns {

        public static final String TABLE_NAME = "USER";
        public static final String COLUMN_USERNAME = "USERNAME";
        public static final String COLUMN_PASSWORD = "PASSWORD";
        public static final String COLUMN_EMAIL = "EMAIL";
        public static final String COLUMN_OVERSEER_ACOUNTS = "OVERSEER_ACCOUNTS";

    }

}
