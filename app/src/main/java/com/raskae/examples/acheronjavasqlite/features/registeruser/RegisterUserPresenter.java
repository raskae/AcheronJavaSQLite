package com.raskae.examples.acheronjavasqlite.features.registeruser;

import android.content.Context;

import com.raskae.examples.acheronjavasqlite.data.model.User;
import com.raskae.examples.acheronjavasqlite.data.remote.UserInteractor;

/**
 * Created by ptenni on 24/8/2017.
 */

public class RegisterUserPresenter implements RegisterUserContract.Presenter {

    //also known as repository
    private UserInteractor userInteractor;

    private RegisterUserContract.View mView;

    //    public RegisterUserPresenter(UserInteractor userInteractor) {
    public RegisterUserPresenter(Context context, RegisterUserContract.View view) {
        //TODO Inject this Interactor/repository/datasource
        userInteractor = new UserInteractor(context);
        mView = view;
    }

    @Override
    public void registerUser(String username, String password, String email) {

        User user = new User(username, password, email);
        if (userInteractor.registerUser(user)) {
            mView.onRegisterSuccessfull();
        } else {
            mView.displayError();
        }

    }

}
