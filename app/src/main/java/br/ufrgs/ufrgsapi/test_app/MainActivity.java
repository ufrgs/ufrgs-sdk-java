package br.ufrgs.ufrgsapi.test_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.ufrgs.ufrgsapi.caronas.UfrgsCaronasManager;
import br.ufrgs.ufrgsapi.caronas.models.CaronasCarsAnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasCarsData;
import br.ufrgs.ufrgsapi.caronas.models.CaronasOferecimentoAwnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasSolicitationAnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasSolicitationData;
import br.ufrgs.ufrgsapi.network.pojo.ErrorData;
import br.ufrgs.ufrgsapi.token.UfrgsTokenManager;
import br.ufrgs.ufrgsapi.user_data.UfrgsUser;
import br.ufrgs.ufrgsapi.user_data.UfrgsUserDataManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by theolm on 04/07/16.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.main_userimage) ImageView mUserImage;
    @BindView(R.id.main_username) TextView mUserName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        UfrgsUserDataManager ufrgsDataManager = new UfrgsUserDataManager(this);

        ufrgsDataManager.getData(new UfrgsUserDataManager.OnDataCallback() {
            @Override
            public void onDataReady(UfrgsUser user) {
                mUserImage.setImageBitmap(UfrgsUserDataManager.convertPicture(user));
                mUserName.setText(user.nomePessoa);
            }

            @Override
            public void onError(String error) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                new UfrgsTokenManager().removeToken(this);
                startActivity(new Intent(this, LoginActivity.class));
                this.finish();
                break;
        }

        return true;
    }
}
