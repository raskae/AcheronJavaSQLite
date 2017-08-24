package com.raskae.examples.acheronjavasqlite.features.registeruser;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.raskae.examples.acheronjavasqlite.R;
import com.raskae.examples.acheronjavasqlite.features.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterUserActivity extends AppCompatActivity implements RegisterUserContract.View {

    @BindView(R.id.inputUsernameReg)
    TextView inputUsernameReg;
    @BindView(R.id.inputPasswordReg)
    TextView inputPasswordReg;
    @BindView(R.id.inputEmailReg)
    TextView inputEmailReg;

    private RegisterUserPresenter registerUserPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        ButterKnife.bind(this);

        //TODO to be injected
        registerUserPresenter = new RegisterUserPresenter(getApplicationContext(), this);
    }

    @OnClick(R.id.cancelRegBtn)
    public void cancel(View view) {
        onCancelPressed();
    }

    @OnClick(R.id.registerBtn)
    public void register(View view) {

        onRegisterPressed();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }

    @Override
    public void onRegisterPressed() {

        registerUserPresenter.registerUser(inputUsernameReg.getText().toString(), inputPasswordReg.getText().toString(), inputEmailReg.getText().toString());
    }

    @Override
    public void onRegisterSuccessfull() {

        Intent intent = new Intent();
        intent.putExtra(LoginActivity.USERNAME_REGISTERED, inputUsernameReg.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void displayError() {
        Toast.makeText(this, "Error Happened!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancelPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
