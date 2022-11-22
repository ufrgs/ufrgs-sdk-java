package br.ufrgs.ufrgsapi.test_app.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.ufrgs.ufrgsapi.test_app.R;
import br.ufrgs.ufrgsapi.token.UfrgsTokenManager;
import br.ufrgs.ufrgsapi.token.UfrgsToken;

/**
 * Presents an UI to the user and send them to network to login a user.
 *
 * @author Alan Wink
 */
public class UfrgsLoginPresenter implements LoginDialog.OnLoginDialogAction {
    private static final String TAG = "UfrgsLoginPresenter";

    public interface OnLoginActionDone{
        void onLoginSuccess(UfrgsToken token);
        void onLoginDismiss();
        void onLoginError(String error);
    }

    private OnLoginActionDone mListener;

    private static final String FORGOT_PASSWORD_URL = "https://www1.ufrgs.br/trocasenhas/esqueciSenha/";

    private AppCompatActivity mActivity;
    private LoginDialog mLoginDialog;
    private ProgressDialog mProgressDialog;
    private UfrgsTokenManager ufrgsTokenManager;

    public UfrgsLoginPresenter(AppCompatActivity activity) {
        mActivity = activity;
        ufrgsTokenManager = new UfrgsTokenManager();
    }

    public void setListener(OnLoginActionDone listener){
        mListener = listener;
    }

    public void login(){
        validateListener();
        setupDialogs();
        showLoginDialog();
    }

    private void showLoginDialog() {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        mLoginDialog.show(fm, "tag");
    }

    private void validateListener() {
        if(mListener == null){
            throw new RuntimeException("No listener found. Have you called setListener()?");
        }
    }

    private void setupDialogs() {
        mLoginDialog = new LoginDialog();

        mLoginDialog.setListener(this);

        // Forgot password opens an URL
        mLoginDialog.setForgorPasswordClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(FORGOT_PASSWORD_URL));
                mActivity.startActivity(browserIntent);
            }
        });


        // Loading dialog
        mProgressDialog = new ProgressDialog(mActivity);
        mProgressDialog.setMessage(mActivity.getString(R.string.loading));
        mProgressDialog.setCancelable(false);

    }

    @Override
    public void onDialogDataReady(Context context, String user, String password) {
        mProgressDialog.show();
        ufrgsTokenManager.requestNewToken(context, user, password, new UfrgsTokenManager.OnTokenListener() {
            @Override
            public void onTokenReady(UfrgsToken token) {
                mProgressDialog.dismiss();
                mListener.onLoginSuccess(token);
            }

            @Override
            public void onError(String error) {
                mProgressDialog.dismiss();
                if(error.contains("Unauthorized")){
                    // Wrong user/password
                    showLoginDialog();
                    mLoginDialog.showErrorMessage(mActivity.getString(R.string.wrong_user_or_password));
                } else {
                    mListener.onLoginError(error);
                }
            }
        });
    }

    @Override
    public void onDialogDismiss() {
        mListener.onLoginDismiss();
    }

}
