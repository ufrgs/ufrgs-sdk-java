package br.ufrgs.ufrgsapi.test_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.ufrgs.ufrgsapi.caronas.UfrgsCaronasManager;
import br.ufrgs.ufrgsapi.library.UfrgsLibraryManager;
import br.ufrgs.ufrgsapi.library.models.UfrgsLibraryRegister;
import br.ufrgs.ufrgsapi.test_app.login.UfrgsLoginPresenter;
import br.ufrgs.ufrgsapi.token.UfrgsToken;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by theolm on 04/07/16.
 */
public class LoginActivity extends AppCompatActivity implements UfrgsLoginPresenter.OnLoginActionDone {

    @BindView(R.id.login_button) Button mBtnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UfrgsLoginPresenter presenter = new UfrgsLoginPresenter(LoginActivity.this);
                presenter.setListener(LoginActivity.this);
                presenter.login();
            }
        });

    }

    @Override
    public void onLoginSuccess(UfrgsToken token) {
        if(token != null){
            registerUser();
        } else {
            Snackbar.make(mBtnLogin, "Recebendo Token NULL", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onLoginDismiss() {

    }

    @Override
    public void onLoginError(String error) {
        Snackbar.make(mBtnLogin, error, Snackbar.LENGTH_LONG).show();
    }

    private void registerUser(){
        UfrgsCaronasManager ufrgsCaronasManager = new UfrgsCaronasManager(this);
        ufrgsCaronasManager.registerUserOnCaronasAPI(new UfrgsCaronasManager.OnRegisterUserOnCaronasApi() {
            @Override
            public void onRegisterUserOnCaronasApiReady() {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onError(String error) {
                Snackbar.make(mBtnLogin, error, Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
