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

import br.ufrgs.ufrgsapi.caronas.models.CaronasOferecimentoAwnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasOferecimentoData;
import br.ufrgs.ufrgsapi.caronas.models.CaronasCarsAnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasCarsData;
import br.ufrgs.ufrgsapi.caronas.models.CaronasSolicitationAnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasSolicitationData;
import br.ufrgs.ufrgsapi.network.pojo.ApiAnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasAgreementAnswer;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Webservices calls handled by Retrofit.
 * @author Theodoro Mota
 * @version 1.0
 */
public interface ApiCaronasInterface {

    @POST("v1/caronas/usuario")
    Call<ApiAnswer<CaronasAgreementAnswer>> registerUserOnCaronas(@Header("Authorization") String authorizationHeader);

    @GET("/v1/caronas/oferecimentos")
    Call<ApiAnswer<CaronasOferecimentoAwnswer>> getAllAvaiableOffers(@Header("Authorization") String authorizationHeader, @Query("page") String page, @Query("expand") String expand);

    @GET("/v1/caronas/oferecimentos/{id}")
    Call<ApiAnswer<CaronasOferecimentoData>> getOfferById(@Header("Authorization") String authorizationHeader, @Path("id") int offerId);

    @FormUrlEncoded
    @PATCH("/v1/caronas/oferecimentos/{id}")
    Call<ApiAnswer<CaronasOferecimentoData>> patchOferecimentos(@Header("Authorization") String authorizationHeader,
                                                                @Path("id") int offerId,
                                                                @Field("observacoes") String obs);

    @FormUrlEncoded
    @POST("/v1/caronas/oferecimentos")
    Call<ApiAnswer<CaronasOferecimentoData>> registerOffer(@Header("Authorization") String authorizationHeader,
                                                           @Field("codigocarro") String codCarro,
                                                           @Field("codigocampusorigem") String codCampusOrigem,
                                                           @Field("codigocampusdestino") String codCampusDestino,
                                                           @Field("horasaida") String dataHoraSaida,
                                                           @Field("vagas") String nrVagas,
                                                           @Field("pontoencontro") String pontoDeEncontro,
                                                           @Field("latitude") String latitude,
                                                           @Field("longitude") String longitude,
                                                           @Field("observacoes") String observacoes,
                                                           @Field("apenasmulheres") String apenasMulheres);

    @GET("/v1/caronas/oferecimentos/usuario")
    Call<ApiAnswer<CaronasOferecimentoAwnswer>> getUserOffers(@Header("Authorization") String authorizationHeader, @Query("page") String page);

    @GET("/v1/caronas/oferecimentos/usuario/historico")
    Call<ApiAnswer<CaronasOferecimentoAwnswer>> getUserOffersHistory(@Header("Authorization") String authorizationHeader, @Query("page") String page);

    @GET("/v1/caronas/oferecimentos/usuario/cancelados")
    Call<ApiAnswer<CaronasOferecimentoAwnswer>> getUserOffersCancel(@Header("Authorization") String authorizationHeader, @Query("page") String page);

    @GET("v1/caronas/carros")
    Call<ApiAnswer<CaronasCarsAnswer>> getAllCarsOffers(@Header("Authorization") String authorizationHeader);

    @GET("v1/caronas/carros/{id}")
    Call<ApiAnswer<CaronasCarsData>> getCarById(@Header("Authorization") String authorizationHeader, @Path("id") int carId);

    @GET("v1/caronas/carros/usuario")
    Call<ApiAnswer<CaronasCarsAnswer>> getUsersCars(@Header("Authorization") String authorizationHeader);


    @FormUrlEncoded
    @POST("v1/caronas/carros")
    Call<ApiAnswer<CaronasCarsData>> registerUsersCar(@Header("Authorization") String authorizationHeader,
                                                      @Field("identificador") String identificador,
                                                      @Field("vagaspadrao") String nrVagas,
                                                      @Field("modelo") String modelo,
                                                      @Field("codigocor") String codCor,
                                                      @Field("placa") String placa);

    @GET("v1/caronas/solicitacoes")
    Call<ApiAnswer<CaronasSolicitationAnswer>> getAllSolicitations(@Header("Authorization") String authorizationHeader);

    @GET("v1/caronas/solicitacoes/usuario")
    Call<ApiAnswer<CaronasSolicitationAnswer>> getUsersSolicitations(@Header("Authorization") String authorizationHeader);

    @GET("v1/caronas/solicitacoes/{id}")
    Call<ApiAnswer<CaronasSolicitationData>> getSolicitationById(@Header("Authorization") String authorizationHeader, @Path("id") int solicitationId);

    @FormUrlEncoded
    @PATCH("v1/caronas/solicitacoes/{id}")
    Call<ApiAnswer<CaronasSolicitationData>> patchSolicitationById(@Header("Authorization") String authorizationHeader,
                                                                   @Path("id") int solicitationId,
                                                                   @Field("mensagemsolicitacao") String message);

    @FormUrlEncoded
    @POST("v1/caronas/solicitacoes")
    Call<CaronasSolicitationData> registerSolicitation(@Header("Authorization") String authorizationHeader,
                                                       @Field("codigooferecimento") String codigoOferecimento,
                                                       @Field("mensagemsolicitacao") String msgSolicitacao);

    @DELETE("v1/caronas/carros/{id}")
    Call<ApiAnswer<CaronasCarsData>> deleteCar(@Header("Authorization") String authorizationHeader, @Path("id") int id);

    @DELETE("v1/caronas/oferecimentos/{id}")
    Call<ApiAnswer<CaronasOferecimentoAwnswer>> deleteOffers(@Header("Authorization") String authorizationHeader, @Path("id") int id);

    @DELETE("v1/caronas/solicitacoes/{id}")
    Call<ApiAnswer<CaronasCarsData>> deleteSolicitation(@Header("Authorization") String authorizationHeader, @Path("id") int id);

    @FormUrlEncoded
    @PATCH("v1/caronas/carros/{id}")
    Call<ApiAnswer<CaronasCarsData>> updateCar(@Header("Authorization")String authorizationHeader, @Path("id") int id,
                                               @Field("identificador") String identificador,
                                               @Field("vagaspadrao") int vagaspadrao,
                                               @Field("modelo") String modelo,
                                               @Field("codigocor") String codigocor,
                                               @Field("placa") String placa);

}