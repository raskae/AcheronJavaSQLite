package com.raskae.examples.acheronjavasqlite.features.login;

/**
 * Created by Raskae on 23/08/2017.
 */

public interface LoginView {

    void onLoginButtonPressed();

    void onRegisterButtonPressed();

    void showErrorMessage();

    void onLoginFinished();
}
