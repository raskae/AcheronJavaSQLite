package com.raskae.examples.acheronjavasqlite.features.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.raskae.examples.acheronjavasqlite.R;
import com.raskae.examples.acheronjavasqlite.features.accountlist.AccountListActivity;
import com.raskae.examples.acheronjavasqlite.features.registeruser.RegisterUserActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    public static final String USERNAME_REGISTERED = "USERNAME_REGISTERED";
    private static final int REGISTER_ACCOUNT_CODE = 1;
    @BindView(R.id.inputUsername)
    TextView inputUsername;
    @BindView(R.id.inputPassword)
    TextView inputPassword;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //TODO Inject this
        loginPresenter = new LoginPresenter(getApplicationContext(), this);
    }

    @OnClick(R.id.logMeInBtn)
    public void logMeIn(View view) {
        onLoginButtonPressed();
    }

    @OnClick(R.id.registerMeBtn)
    public void registerMe(View view) {
        onRegisterButtonPressed();
    }

    @Override
    public void onLoginButtonPressed() {
        loginPresenter.logUser(inputUsername.getText().toString(), inputPassword.getText().toString());
    }

    @Override
    public void onRegisterButtonPressed() {
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivityForResult(intent, REGISTER_ACCOUNT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REGISTER_ACCOUNT_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Cuenta: " + data.getStringExtra(USERNAME_REGISTERED), Toast.LENGTH_SHORT).show();
                inputUsername.setText(data.getStringExtra(USERNAME_REGISTERED));
            }
        }
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFinished() {
        startActivity(new Intent(this, AccountListActivity.class));
    }
}
