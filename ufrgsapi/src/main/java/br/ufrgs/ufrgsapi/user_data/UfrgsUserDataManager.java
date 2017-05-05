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
package br.ufrgs.ufrgsapi.user_data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import javax.inject.Inject;

import br.ufrgs.ufrgsapi.dagger.components.DaggerUserDataComponent;
import br.ufrgs.ufrgsapi.dagger.modules.NetModule;
import br.ufrgs.ufrgsapi.dagger.modules.TokenModule;
import br.ufrgs.ufrgsapi.network.ApiInterface;
import br.ufrgs.ufrgsapi.network.pojo.ApiAnswer;
import br.ufrgs.ufrgsapi.network.pojo.UserData;
import br.ufrgs.ufrgsapi.token.UfrgsToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class handles the calls for the api relative to the UfrgsUserData scope.
 *
 * @author Alan Wink
 * @author Theodoro Mota
 * @version 1.0
 */

public class UfrgsUserDataManager  {

    public static Bitmap convertPicture(UfrgsUser user) {
        return convertPicture(user.foto);
    }

    public interface OnDataCallback{
        void onDataReady(UfrgsUser user);
        void onError(String error);
    }

     @Inject UfrgsToken mToken;
     @Inject ApiInterface mService;

    private Context context;
    private String mTokenHeader;

    public UfrgsUserDataManager(Context context) {
        DaggerUserDataComponent.builder()
                .netModule(new NetModule())
                .tokenModule(new TokenModule(context))
                .build().inject(this);


        this.context = context;
        mTokenHeader = "Bearer " + mToken.accessToken;
    }

    public void getData(final OnDataCallback callback){

        Call<ApiAnswer<UserData>> call = mService.getUserData(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<UserData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<UserData>> call, Response<ApiAnswer<UserData>> response) {
                if(response.isSuccessful()){
                    UfrgsUser user = new UfrgsUser(response.body().data);
                    callback.onDataReady(user);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<UserData>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    /**
     * Given a string with Base64 values, convert it to a byte array.
     * @param in String containing the data.
     * @return The byte array that represents the input.
     */
    private static Bitmap convertPicture(String in) {
        byte[] data = Base64.decode(in, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

        return bitmap;
    }

}
