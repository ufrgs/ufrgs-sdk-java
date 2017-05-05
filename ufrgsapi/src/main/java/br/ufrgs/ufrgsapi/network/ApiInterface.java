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
package br.ufrgs.ufrgsapi.network;

import br.ufrgs.ufrgsapi.network.pojo.ApiAnswer;
import br.ufrgs.ufrgsapi.network.pojo.TokenData;
import br.ufrgs.ufrgsapi.network.pojo.UserData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;


/**
 * Webservices calls handled by Retrofit.
 * @author Alan Wink
 * @version 1.0
 */
public interface ApiInterface {

    @FormUrlEncoded
    @POST("v1/token")
    Call<ApiAnswer<TokenData>> getToken(@Field("client_id") String client_id,
                                        @Field("client_secret") String client_secret,
                                        @Field("grant_type") String grant_type,
                                        @Field("username") String username,
                                        @Field("password") String password,
                                        @Field("scope") String scope);

    @GET("v1/pessoa")
    Call<ApiAnswer<UserData>> getUserData(@Header("Authorization") String authorizationHeader);

    @FormUrlEncoded
    @POST("v1/logout")
    Call<ResponseBody> logoutFromAPI(@Header("Authorization") String authorizationHeader,
                                                    @Field("deviceID") String deviceId);
    @FormUrlEncoded
    @PUT("v1/dispositivo")
    Call<ResponseBody> registerGcmDevice(@Header("Authorization") String authorizationHeader, @Field("iid") String gcmToken, @Field("deviceID") String deviceUID);

}