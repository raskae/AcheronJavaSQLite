package com.raskae.examples.acheronjavasqlite.features.login;

/**
 * Created by Raskae on 23/08/2017.
 */

public interface LoginContract {

    interface View {

        void onLoginButtonPressed();

        void onRegisterButtonPressed();

        void showErrorMessage();

        void onLoginFinished();
    }

    interface Presenter{

        void logUser(String username, String password);
    }

}
