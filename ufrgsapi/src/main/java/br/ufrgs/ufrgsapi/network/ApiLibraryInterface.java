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
import br.ufrgs.ufrgsapi.library.models.LibraryAgreementAnswer;
import br.ufrgs.ufrgsapi.library.models.LibraryData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Webservices calls handled by Retrofit.
 * @author Theodoro Mota
 * @version 1.0
 */
public interface ApiLibraryInterface {

    @GET("v1/biblioteca/emprestimos")
    Call<ApiAnswer<LibraryData>> getLibraryData(@Header("Authorization") String authorizationHeader);

    @POST("v1/biblioteca/emprestimos")
    Call<ResponseBody> renewLibrary(@Header("Authorization") String authorizationHeader);

    @POST("v1/biblioteca/usuarios")
    Call<ApiAnswer<LibraryAgreementAnswer>> registerUserOnLibrary(@Header("Authorization") String authorizationHeader);

    @GET("v1/biblioteca/usuario/status")
    Call<ApiAnswer<LibraryAgreementAnswer>> getUserRegisterOnLibrary(@Header("Authorization") String authorizationHeader);

    @PUT("v1/biblioteca/configura/renovacao")
    Call<ApiAnswer<LibraryAgreementAnswer>> changeAutoRenewStatus(@Header("Authorization") String authorizationHeader);

}