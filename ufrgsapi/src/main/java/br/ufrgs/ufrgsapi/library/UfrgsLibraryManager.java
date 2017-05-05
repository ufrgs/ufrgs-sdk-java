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
package br.ufrgs.ufrgsapi.library;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.ufrgs.ufrgsapi.dagger.components.DaggerLibraryComponent;
import br.ufrgs.ufrgsapi.dagger.modules.NetModule;
import br.ufrgs.ufrgsapi.dagger.modules.TokenModule;
import br.ufrgs.ufrgsapi.library.models.UfrgsLibraryRegister;
import br.ufrgs.ufrgsapi.library.models.UfrgsLibraryRenew;
import br.ufrgs.ufrgsapi.library.models.UfrgsLibraryUser;
import br.ufrgs.ufrgsapi.network.ApiLibraryInterface;
import br.ufrgs.ufrgsapi.network.pojo.ApiAnswer;
import br.ufrgs.ufrgsapi.library.models.LibraryAgreementAnswer;
import br.ufrgs.ufrgsapi.library.models.LibraryData;
import br.ufrgs.ufrgsapi.library.models.LibraryRenewAnswer;
import br.ufrgs.ufrgsapi.library.models.LibraryRenewAnswerItem;
import br.ufrgs.ufrgsapi.token.UfrgsToken;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * This class handles the calls for the api relative to the UfrgsLibrary scope.
 *
 * @author Alan Wink
 * @author Theodoro Mota
 * @version 1.0
 */

public class UfrgsLibraryManager {
    private static final String TAG = "UfrgsLibraryManager";

    public interface LibraryCallback{
        void onLibraryUserReady(UfrgsLibraryUser user);
        void onError(String error);
    }

    public interface LibraryRenew{
        void onLibraryRenew(List<UfrgsLibraryRenew> renew);
        void onError(String error);
    }

    public interface RegisterUser{
        void onRegisterUser(UfrgsLibraryRegister register);
        void onError(String error);
    }

    public interface GetUserRegister{
        void onGetRegisterUser(UfrgsLibraryRegister register);
        void onError(String error);
    }

    public interface ChangeRenewStatus{
        void onChangeRenewStatus(UfrgsLibraryRegister register);
        void onError(String error);
    }

    @Inject ApiLibraryInterface mService;
    @Inject UfrgsToken mToken;
    private String mTokenHeader;

    public UfrgsLibraryManager(Context context) {

        DaggerLibraryComponent.builder()
                .netModule(new NetModule())
                .tokenModule(new TokenModule(context))
                .build().inject(this);


        mTokenHeader = "Bearer " + mToken.accessToken;
    }

    public void getLibraryUser(final LibraryCallback callback){
        Call<ApiAnswer<LibraryData>> call = mService.getLibraryData(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<LibraryData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<LibraryData>> call, retrofit2.Response<ApiAnswer<LibraryData>> response) {
                if(response.isSuccessful()) {
                    UfrgsLibraryUser libraryUser = new UfrgsLibraryUser(response.body().data);
                    callback.onLibraryUserReady(libraryUser);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<LibraryData>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void renewLibrary(final LibraryRenew callback){
        Call<ResponseBody> call = mService.renewLibrary(mTokenHeader);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    Gson gson = new Gson();
                    try {
                        LibraryRenewAnswer obj = gson.fromJson(response.body().string(), LibraryRenewAnswer.class);

                        List<UfrgsLibraryRenew> renewList = new ArrayList<>();
                        for(LibraryRenewAnswerItem x : obj.data){
                            renewList.add(new UfrgsLibraryRenew(x));
                        }

                        callback.onLibraryRenew(renewList);

                    } catch (IOException e) {
                        e.printStackTrace();
                        callback.onError(e.getMessage());
                    }
                } else {
                    callback.onError(response.message());
                }
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

    }

    public void registerUser(final RegisterUser callback){
        Call<ApiAnswer<LibraryAgreementAnswer>> call = mService.registerUserOnLibrary(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<LibraryAgreementAnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<LibraryAgreementAnswer>> call, retrofit2.Response<ApiAnswer<LibraryAgreementAnswer>> response) {
                if(response.isSuccessful()){
                    UfrgsLibraryRegister register = new UfrgsLibraryRegister(response.body().data);
                    callback.onRegisterUser(register);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<LibraryAgreementAnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    public void getUserRegister(final GetUserRegister callback){
        Call<ApiAnswer<LibraryAgreementAnswer>> call = mService.getUserRegisterOnLibrary(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<LibraryAgreementAnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<LibraryAgreementAnswer>> call, retrofit2.Response<ApiAnswer<LibraryAgreementAnswer>> response) {
                if(response.isSuccessful()){
                    UfrgsLibraryRegister register = new UfrgsLibraryRegister(response.body().data);
                    callback.onGetRegisterUser(register);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<LibraryAgreementAnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void changeRenewStatus(final ChangeRenewStatus callback){
        Call<ApiAnswer<LibraryAgreementAnswer>> call = mService.changeAutoRenewStatus(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<LibraryAgreementAnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<LibraryAgreementAnswer>> call, retrofit2.Response<ApiAnswer<LibraryAgreementAnswer>> response) {
                if(response.isSuccessful()){
                    UfrgsLibraryRegister register = new UfrgsLibraryRegister(response.body().data);
                    callback.onChangeRenewStatus(register);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<LibraryAgreementAnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

}
