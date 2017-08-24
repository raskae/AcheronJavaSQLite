package com.raskae.examples.acheronjavasqlite.features.login;

import android.content.Context;

import com.raskae.examples.acheronjavasqlite.data.model.User;
import com.raskae.examples.acheronjavasqlite.data.remote.UserInteractor;

/**
 * Created by Raskae on 23/08/2017.
 */
public class LoginPresenter implements LoginContract.Presenter {

    //also known as repository
    private UserInteractor userInteractor;

    private LoginContract.View mView;

    //    public LoginPresenter(UserInteractor userInteractor) {
    public LoginPresenter(Context context, LoginContract.View view) {
        //TODO Inject this Interactor/repository/datasource
        userInteractor = new UserInteractor(context);
        mView = view;
    }

    @Override
    public void logUser(String username, String password) {
        User user = new User(username, password);

        if (userInteractor.logUserIn(user)) {
            mView.onLoginFinished();
        } else {
            mView.showErrorMessage();
        }
    }
}
