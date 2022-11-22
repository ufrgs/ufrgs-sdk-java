package br.ufrgs.ufrgsapi.test_app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import br.ufrgs.ufrgsapi.token.UfrgsTokenManager;
import br.ufrgs.ufrgsapi.user_data.UfrgsUser;
import br.ufrgs.ufrgsapi.user_data.UfrgsUserDataManager;
import butterknife.BindView;
import butterknife.ButterKnife;

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
