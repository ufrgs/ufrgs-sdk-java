package br.ufrgs.ufrgsapi.test_app;

import android.app.Application;

import br.ufrgs.ufrgsapi.UfrgsAPI;


/**
 * Created by theolm on 25/01/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UfrgsAPI.initialize(false, Tags.CLIENT_ID, Tags.CLIENT_SECRET, Tags.SCOPE, Tags.GRANT_TYPE);
    }
}
