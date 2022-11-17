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
package br.ufrgs.ufrgsapi.dagger.modules;

import java.io.IOException;

import javax.inject.Singleton;

import br.ufrgs.ufrgsapi.Tags;
import br.ufrgs.ufrgsapi.UfrgsAPI;
import br.ufrgs.ufrgsapi.dagger.SDKScope;
import br.ufrgs.ufrgsapi.network.ApiCaronasInterface;
import br.ufrgs.ufrgsapi.network.ApiInterface;
import br.ufrgs.ufrgsapi.network.ApiLibraryInterface;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is the module that contains the constructor for the Retrofit
 *
 * @author Theodoro Mota
 * @version 1.0
 */

@Module
public class NetModule {

    private String mBaseUrl;

    public NetModule() {
       mBaseUrl = UfrgsAPI.mBaseUrl;
    }

    @Provides
    @SDKScope
    OkHttpClient provideOkHttpClient() {
        //return new OkHttpClient();
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new Interceptor() {

                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        builder.addHeader("Accept-Language", "pt-BR");
                        Request request = builder.build();
                        return chain.proceed(request);
                    }
                }).build();
    }

    @Provides
    @SDKScope
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @SDKScope
    ApiLibraryInterface provideLibraryServices(Retrofit retrofit){
        return retrofit.create(ApiLibraryInterface.class);
    }

    @Provides
    @SDKScope
    ApiInterface provideApiService(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }

    @Provides
    @SDKScope
    ApiCaronasInterface provideCaronasInterface(Retrofit retrofit){
        return retrofit.create(ApiCaronasInterface.class);
    }
}
