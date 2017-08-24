package com.raskae.examples.acheronjavasqlite.features.registeruser;

import com.raskae.examples.acheronjavasqlite.data.model.User;

/**
 * Created by ptenni on 24/8/2017.
 */

public interface RegisterUserContract {

    interface View {

        void onRegisterPressed();

        void onRegisterSuccessfull();

        void displayError();

        void onCancelPressed();
    }

    interface Presenter {

        void registerUser(String username, String password, String email);
    }
}
