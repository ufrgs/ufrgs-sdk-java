package br.ufrgs.ufrgsapi.test_app.login;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.ufrgs.ufrgsapi.test_app.R;


/**
 * Dialog asking UFRGS login and password for the user. Should be
 * used by a presenter to setup this view. Please check {@link UfrgsLoginPresenter} to
 * check a setup.
 *
 * @author Alan Wink
 */
public class LoginDialog extends DialogFragment implements TextView.OnEditorActionListener{

    public interface OnLoginDialogAction{
        void onDialogDataReady(Context context, String user, String password);
        void onDialogDismiss();
    }

    private OnLoginDialogAction mListener;

    private EditText mUserEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private TextView mErrorTextView;
    private TextView mForgotPasswordTextView;

    private View.OnClickListener mForgotPasswordClickListener;

    private boolean isDataReady = false;
    private String mErrorMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_dialog, container, false);

        mUserEditText = (EditText) rootView.findViewById(R.id.login_dialog_user_edit_text);
        mPasswordEditText = (EditText) rootView.findViewById(R.id.login_dialog_password_edit_text);
        mLoginButton = (Button) rootView.findViewById(R.id.login_dialog_login_button);
        mErrorTextView = (TextView) rootView.findViewById(R.id.login_dialog_error_message);
        mForgotPasswordTextView = (TextView) rootView.findViewById(R.id.login_dialog_forgot_password_text_view);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishLogin();
            }
        });

        mPasswordEditText.setOnEditorActionListener(this);
        updateForgotPasswordClickListener();
        updateErrorMessage();

        return rootView;
    }

    public void setListener(OnLoginDialogAction listener){
        mListener = listener;
    }

    public void showErrorMessage(String errorMessage){
        mErrorMessage = errorMessage;
        updateErrorMessage();
    }

    public void hideErrorMessage(){
        mErrorMessage = null;
        updateErrorMessage();
    }

    private void updateErrorMessage() {
        if(isAdded()) {
            if (mErrorMessage == null) {
                mErrorTextView.setVisibility(View.GONE);
            } else {
                mErrorTextView.setText(mErrorMessage);
                mErrorTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void setForgorPasswordClickListener(View.OnClickListener listener){
        mForgotPasswordClickListener = listener;
        if(isAdded()) {
            updateForgotPasswordClickListener();
        }
    }

    private void updateForgotPasswordClickListener(){
        mForgotPasswordTextView.setOnClickListener(mForgotPasswordClickListener);
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        // User pressed DONE on keyboard
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            finishLogin();
            return true;
        }
        return false;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        // Check if the dialog will be dismissed with data or not, and call the listener for no data.
        if(isDataReady){
            isDataReady = false;
        } else {
            if(mListener != null)
                mListener.onDialogDismiss();
        }
        super.onDismiss(dialog);
    }

    /**
     * Collects data from fiels and send them back.
     */
    private void finishLogin() {
        String user = mUserEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        mListener.onDialogDataReady(getContext(), user, password);
        isDataReady = true;
        dismiss();
    }
}
