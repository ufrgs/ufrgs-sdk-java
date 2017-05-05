/*
 * Copyright 2016 Universidade Federal do Rio Grande do Sul
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.ufrgs.ufrgsapi.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufrgs.ufrgsapi.dagger.components.DaggerTokenComponent;
import br.ufrgs.ufrgsapi.dagger.modules.NetModule;
import br.ufrgs.ufrgsapi.dagger.modules.SettingsModule;
import br.ufrgs.ufrgsapi.network.ApiInterface;
import br.ufrgs.ufrgsapi.network.pojo.ApiAnswer;
import br.ufrgs.ufrgsapi.network.pojo.TokenData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class handles the Token.
 *
 * @author Alan Wink
 * @author Theodoro Mota
 * @version 1.0
 */

public class UfrgsTokenManager {
    private static final String TAG = "UfrgsTokenManager";
    private static final String TOKEN_TAG = "token";
    private static String sScope;

    public static UfrgsToken sCurrentToken;

    public interface OnTokenListener{
        void onTokenReady(UfrgsToken token);
        void onError(String error);
    }

    public interface OnLogoutComplete{
        void onLogoutReady(boolean isSuccessful);
    }

    @Inject @Named(SettingsModule.CLIENT_ID) String mClientId;
    @Inject @Named(SettingsModule.CLIENT_SECRET) String mClientSecret;
    @Inject @Named(SettingsModule.SCOPE) String mScope;
    @Inject @Named(SettingsModule.GRANT_TYPE) String mGrantType;
    @Inject ApiInterface mService;

    public UfrgsTokenManager() {
        DaggerTokenComponent.builder()
                .netModule(new NetModule())
                .settingsModule(new SettingsModule())
                .build().inject(this);
    }

    public void requestNewToken(final Context context, String username, String password, final OnTokenListener callback){

        Call<ApiAnswer<TokenData>> call = mService.getToken(mClientId, mClientSecret, mGrantType, username, password, mScope);
        call.enqueue(new Callback<ApiAnswer<TokenData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<TokenData>> call, retrofit2.Response<ApiAnswer<TokenData>> response) {
                if(response.isSuccessful()) {
                    TokenData token = response.body().data;
                    if(token == null) {
                        callback.onError(response.body().message);
                    } else {
                        UfrgsToken ufrgsToken = TokenBuilder.build(token);
                        storeToken(context, ufrgsToken);
                        callback.onTokenReady(ufrgsToken);

                    }
                } else{
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<TokenData>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public UfrgsToken getToken(Context context){
        if(sCurrentToken == null){
            this.restoreToken(context);
        }
        return sCurrentToken;
    }

    public void logoutFromAPI(final Context context, String deviceId, final OnLogoutComplete callback){
        UfrgsToken token = restoreToken(context);
        if(token != null) {
            String tokenHeader = "Bearer " + token.accessToken;
            Call<ResponseBody> call = mService.logoutFromAPI(tokenHeader, deviceId);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    removeToken(context);
                    callback.onLogoutReady(true);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    callback.onLogoutReady(false);
                }
            });
        } else {
            throw new RuntimeException("You must have a token to request logout from api");
        }

    }

    public void removeToken(Context context){
        SharedPreferences preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(TOKEN_TAG);
        editor.apply();
    }

    public boolean hasToken(Context context){
        SharedPreferences preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        if(preferences.contains(TOKEN_TAG))
            return true;
        else
            return false;
    }

    private void storeToken(Context context, UfrgsToken token) {
        if(token != null) {
            SharedPreferences preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(TOKEN_TAG, token.serialize());
            editor.apply();
            sCurrentToken = token;
        }
    }

    private UfrgsToken restoreToken(Context context){
        SharedPreferences preferences = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        String serializedToken = preferences.getString(TOKEN_TAG, null);
        if(serializedToken != null){
            UfrgsToken token = UfrgsToken.deserialize(serializedToken);
            sCurrentToken = token;
            return token;
        }

        return null;
    }

    public void registerGcmToken(Context context, String gcmToken, String uuid){
        String tokenHeader = "Bearer " + getToken(context).accessToken;

        Call<ResponseBody> call = mService.registerGcmDevice(tokenHeader, gcmToken, uuid);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                Log.d(TAG, "onResponse: mandou token");
                //TODO: make some verification if the token was successfully saved
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.getMessage());

            }
        });
    }
}
