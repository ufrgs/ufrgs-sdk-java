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
package br.ufrgs.ufrgsapi.caronas;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import br.ufrgs.ufrgsapi.caronas.models.CaronasAgreementAnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasCarsAnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasCarsData;
import br.ufrgs.ufrgsapi.caronas.models.CaronasOferecimentoAwnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasOferecimentoData;
import br.ufrgs.ufrgsapi.caronas.models.CaronasSolicitationAnswer;
import br.ufrgs.ufrgsapi.caronas.models.CaronasSolicitationData;
import br.ufrgs.ufrgsapi.dagger.components.DaggerCaronasComponent;
import br.ufrgs.ufrgsapi.dagger.modules.NetModule;
import br.ufrgs.ufrgsapi.dagger.modules.TokenModule;
import br.ufrgs.ufrgsapi.network.ApiCaronasInterface;
import br.ufrgs.ufrgsapi.network.pojo.ApiAnswer;
import br.ufrgs.ufrgsapi.network.pojo.ErrorData;
import br.ufrgs.ufrgsapi.token.UfrgsToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class handles the calls for the api relative to the UfrgsCaronas scope.
 *
 * @author Alan Wink
 * @author Theodoro Mota
 * @version 1.0
 */

public class UfrgsCaronasManager {

    @Inject ApiCaronasInterface mService;
    @Inject UfrgsToken mToken;
    private static final String TAG = "UfrgsCaronasManager";
    private Context mContext;
    private String mTokenHeader;

    public interface OnRegisterUserOnCaronasApi{
        void onRegisterUserOnCaronasApiReady();
        void onError(String error);
    }
    
    public interface OnOffersReturn {
        void onOffersReady(CaronasOferecimentoAwnswer offersAwnswer);
        void onError(String error);
    }

    public interface OnOfferReturn {
        void onOfferReady(CaronasOferecimentoData caronasOferecimentoData);
        void onError(ErrorData error);
    }

    public interface OnCarsReturn {
        void onCarsReady(CaronasCarsAnswer caronasCarsAnswer);
        void onError(String error);
    }

    public interface OnCarReturn {
        void onCarReady(CaronasCarsData caronasCarsData);
        void onError(ErrorData error);
    }

    public interface OnSolicitationsReturn {
        void onSolicitationsReady(CaronasSolicitationAnswer solicitationsAnswer);
        void onError(String error);
    }

    public interface OnSolicitationReturn {
        void onSolicitationReady(CaronasSolicitationData solicitationData);
        void onError(ErrorData error);
    }


    public UfrgsCaronasManager(Context context) {
        DaggerCaronasComponent.builder()
                .netModule(new NetModule())
                .tokenModule(new TokenModule(context))
                .build().inject(this);

        mContext = context;
        mTokenHeader = "Bearer " + mToken.accessToken;

        Log.i("Token Header",mTokenHeader);
    }

    public void registerUserOnCaronasAPI(final OnRegisterUserOnCaronasApi callback){
        Call<ApiAnswer<CaronasAgreementAnswer>> call = mService.registerUserOnCaronas(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<CaronasAgreementAnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasAgreementAnswer>> call, Response<ApiAnswer<CaronasAgreementAnswer>> response) {
                if(response.isSuccessful()){
                    callback.onRegisterUserOnCaronasApiReady();
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasAgreementAnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    public void listAllAvaiableOffers(int page, boolean includeDriver, boolean includeCar, final OnOffersReturn callback){

        String expand;

        if(includeCar && includeDriver)
            expand = "motorista,carro";
        else if (includeCar)
            expand = "carro";
        else if(includeDriver)
            expand = "motorista";
        else
            expand = null;

        Call<ApiAnswer<CaronasOferecimentoAwnswer>> call = mService.getAllAvaiableOffers(mTokenHeader, String.valueOf(page), expand);
        call.enqueue(new Callback<ApiAnswer<CaronasOferecimentoAwnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Response<ApiAnswer<CaronasOferecimentoAwnswer>> response) {
                if(response.isSuccessful()){
                    callback.onOffersReady(response.body().data);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void listUsersOffers(int page, final OnOffersReturn callback){
        Call<ApiAnswer<CaronasOferecimentoAwnswer>> call = mService.getUserOffers(mTokenHeader, String.valueOf(page));
        call.enqueue(new Callback<ApiAnswer<CaronasOferecimentoAwnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Response<ApiAnswer<CaronasOferecimentoAwnswer>> response) {
                if(response.isSuccessful()){
                    callback.onOffersReady(response.body().data);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void registerOffer(String codCarro, int codCampusOrigem, int codCampusDestino, String dataHoraSaida, int nrVagas, String pontoDeEncontro, double lat, double lon, String observacoes, boolean apenasMulheres, final OnOfferReturn callback){

        String am = apenasMulheres ? "S" : "N";

        Call<ApiAnswer<CaronasOferecimentoData>> call = mService.registerOffer(mTokenHeader, codCarro, String.valueOf(codCampusOrigem), String.valueOf(codCampusDestino), dataHoraSaida, String.valueOf(nrVagas), pontoDeEncontro, String.valueOf(lat), String.valueOf(lon), observacoes, am);
        call.enqueue(new Callback<ApiAnswer<CaronasOferecimentoData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasOferecimentoData>> call, Response<ApiAnswer<CaronasOferecimentoData>> response) {
                if(response.isSuccessful()){
                    callback.onOfferReady(response.body().data);
                } else {
                    ErrorData err = new ErrorData(response.message());
                    try {
                        err.setData(response.errorBody().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    callback.onError(err);
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasOferecimentoData>> call, Throwable t) {
                callback.onError(new ErrorData(t.getMessage()));
            }
        });

    }

    public void listUsersOffersHistory(int page, final OnOffersReturn callback){
        Call<ApiAnswer<CaronasOferecimentoAwnswer>> call = mService.getUserOffersHistory(mTokenHeader, String.valueOf(page));
        call.enqueue(new Callback<ApiAnswer<CaronasOferecimentoAwnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Response<ApiAnswer<CaronasOferecimentoAwnswer>> response) {
                if(response.isSuccessful()){
                    callback.onOffersReady(response.body().data);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void listUsersOffersCancel(int page, final OnOffersReturn callback){
        Call<ApiAnswer<CaronasOferecimentoAwnswer>> call = mService.getUserOffersCancel(mTokenHeader, String.valueOf(page));
        call.enqueue(new Callback<ApiAnswer<CaronasOferecimentoAwnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Response<ApiAnswer<CaronasOferecimentoAwnswer>> response) {
                if(response.isSuccessful()){
                    callback.onOffersReady(response.body().data);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void listCarsOnOffers(int page, final OnCarsReturn callback){
        Call<ApiAnswer<CaronasCarsAnswer>> call = mService.getAllCarsOffers(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<CaronasCarsAnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasCarsAnswer>> call, Response<ApiAnswer<CaronasCarsAnswer>> response) {
                if(response.isSuccessful()){
                    callback.onCarsReady(response.body().data);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasCarsAnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void listUsersCars(int page, final OnCarsReturn callback){
        Call<ApiAnswer<CaronasCarsAnswer>> call = mService.getUsersCars(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<CaronasCarsAnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasCarsAnswer>> call, Response<ApiAnswer<CaronasCarsAnswer>> response) {
                if(response.isSuccessful()){
                    callback.onCarsReady(response.body().data);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasCarsAnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public void registerUsersCar(String identification, int nrVagas, String model, String codCor, String plate, final OnCarReturn callback){
        Call<ApiAnswer<CaronasCarsData>> call = mService.registerUsersCar(mTokenHeader, identification, String.valueOf(nrVagas), model, codCor, plate);
        call.enqueue(new Callback<ApiAnswer<CaronasCarsData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasCarsData>> call, Response<ApiAnswer<CaronasCarsData>> response) {
                Log.i("REGISTER-CAR", "Code: " + response.code() + ", " + response.message());

                if(response.isSuccessful()){
                    callback.onCarReady(response.body().data);
                } else {
                    ErrorData err = new ErrorData(response.message());
                    try {
                        err.setData(response.errorBody().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    callback.onError(err);
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasCarsData>> call, Throwable t) {
                callback.onError(new ErrorData(t.getMessage()));
            }
        });
    }

    public void listAllSolicitations(final OnSolicitationsReturn callback){
        Call<ApiAnswer<CaronasSolicitationAnswer>> call = mService.getAllSolicitations(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<CaronasSolicitationAnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasSolicitationAnswer>> call, Response<ApiAnswer<CaronasSolicitationAnswer>> response) {
                if(response.isSuccessful()){
                    callback.onSolicitationsReady(response.body().data);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasSolicitationAnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    public void listUsersSolicitations(final OnSolicitationsReturn callback){
        Call<ApiAnswer<CaronasSolicitationAnswer>> call = mService.getUsersSolicitations(mTokenHeader);
        call.enqueue(new Callback<ApiAnswer<CaronasSolicitationAnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasSolicitationAnswer>> call, Response<ApiAnswer<CaronasSolicitationAnswer>> response) {
                if(response.isSuccessful()){
                    callback.onSolicitationsReady(response.body().data);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasSolicitationAnswer>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

    public void registerSolicitation(String nrseqCarona, String msgSolicitacao,final OnSolicitationReturn callback){
        Call<CaronasSolicitationData> call = mService.registerSolicitation(mTokenHeader, nrseqCarona, msgSolicitacao);
        call.enqueue(new Callback<CaronasSolicitationData>() {
            @Override
            public void onResponse(Call<CaronasSolicitationData> call, Response<CaronasSolicitationData> response) {
                if(response.isSuccessful()){
                    callback.onSolicitationReady(response.body());
                } else {
                    ErrorData err = new ErrorData(response.message());
                    try {
                        err.setData(response.errorBody().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    callback.onError(err);
                }
            }

            @Override
            public void onFailure(Call<CaronasSolicitationData> call, Throwable t) {
                callback.onError(new ErrorData(t.getMessage()));
            }
        });
    }

    public void getCarById(int carId, final OnCarReturn callback){
        Call<ApiAnswer<CaronasCarsData>> call = mService.getCarById(mTokenHeader, carId);
        call.enqueue(new Callback<ApiAnswer<CaronasCarsData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasCarsData>> call, Response<ApiAnswer<CaronasCarsData>> response) {
                if(response.isSuccessful()){
                    callback.onCarReady(response.body().data);
                } else {
                    callback.onError(new ErrorData(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasCarsData>> call, Throwable t) {
                callback.onError(new ErrorData(t.getMessage()));
            }
        });
    }

    public void getOfferByID(int offerId, final OnOfferReturn callback, String expand){
        Call<ApiAnswer<CaronasOferecimentoData>> call = mService.getOfferById(mTokenHeader, offerId);
        call.enqueue(new Callback<ApiAnswer<CaronasOferecimentoData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasOferecimentoData>> call, Response<ApiAnswer<CaronasOferecimentoData>> response) {
                if(response.isSuccessful()){
                    callback.onOfferReady(response.body().data);
                } else {
                    callback.onError(new ErrorData(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasOferecimentoData>> call, Throwable t) {
                callback.onError(new ErrorData(t.getMessage()));
            }
        });
    }

    public void patchOfferByID(int offerId, String obs, final OnOfferReturn callback){
        Call<ApiAnswer<CaronasOferecimentoData>> call = mService.patchOferecimentos(mTokenHeader, offerId, obs);
        call.enqueue(new Callback<ApiAnswer<CaronasOferecimentoData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasOferecimentoData>> call, Response<ApiAnswer<CaronasOferecimentoData>> response) {
                if(response.isSuccessful()){
                    callback.onOfferReady(response.body().data);
                    Log.i("UPDATE-OFER", "A request foi um sucesso");
                } else {
                    callback.onError(new ErrorData(response.message()));
                    Log.i("UPDATE-OFER", "Ocorreu um erro: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasOferecimentoData>> call, Throwable t) {
                callback.onError(new ErrorData(t.getMessage()));
                Log.i("UPDATE-OFER", "Ocorreu uma falha: " + t.getMessage());
            }
        });
    }

    public void getSolicitationById(int solicitationId, final OnSolicitationReturn callback){
        Call<ApiAnswer<CaronasSolicitationData>> call = mService.getSolicitationById(mTokenHeader, solicitationId);
        call.enqueue(new Callback<ApiAnswer<CaronasSolicitationData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasSolicitationData>> call, Response<ApiAnswer<CaronasSolicitationData>> response) {
                if(response.isSuccessful()){
                    callback.onSolicitationReady(response.body().data);
                } else {
                    callback.onError(new ErrorData(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasSolicitationData>> call, Throwable t) {
                callback.onError(new ErrorData(t.getMessage()));
            }
        });
    }

    public void patchSolicitationById(int solicitationId, String message, final OnSolicitationReturn callback){
        Call<ApiAnswer<CaronasSolicitationData>> call = mService.patchSolicitationById(mTokenHeader, solicitationId, message);
        call.enqueue(new Callback<ApiAnswer<CaronasSolicitationData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasSolicitationData>> call, Response<ApiAnswer<CaronasSolicitationData>> response) {
                if(response.isSuccessful()){
                    callback.onSolicitationReady(response.body().data);
                } else {
                    callback.onError(new ErrorData(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasSolicitationData>> call, Throwable t) {
                callback.onError(new ErrorData(t.getMessage()));
            }
        });
    }

    public void deleteCar(int id, final OnCarReturn callback){
        Call<ApiAnswer<CaronasCarsData>> call = mService.deleteCar(mTokenHeader,id);
        call.enqueue(new Callback<ApiAnswer<CaronasCarsData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasCarsData>> call, Response<ApiAnswer<CaronasCarsData>> response) {
                Log.i("DELETE-CAR", "Code: " + response.code() + ", " + response.message());

                if (response.isSuccessful()) {
                    Log.i("DELETE-CAR", "Carro deletado com sucesso");
                    callback.onCarReady(response.body().data);
                } else {
                    Log.i("DELETE-CAR", "Carro não foi deletado - " + response.message());
                    callback.onError(new ErrorData(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasCarsData>> call, Throwable t) {
                Log.e("DELETE-CAR", "Throwable: " + t.getMessage());
                callback.onError(new ErrorData(t.getMessage()));
            }
        });

    }

    public void deleteOfer(int id, final OnOffersReturn callback){
        Call<ApiAnswer<CaronasOferecimentoAwnswer>> call = mService.deleteOffers(mTokenHeader,id);
        call.enqueue(new Callback<ApiAnswer<CaronasOferecimentoAwnswer>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Response<ApiAnswer<CaronasOferecimentoAwnswer>> response) {

                Log.i("DELETE-OFER", "Code: " + response.code() + ", " + response.message());

                if(response.isSuccessful()){
                    Log.i("DELETE-OFER", "Oferta deletada com sucesso");
                    callback.onOffersReady(response.body().data);
                }else{
                    Log.i("DELETE-OFER", "Oferta não foi deletada - " + response.message());
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasOferecimentoAwnswer>> call, Throwable t) {
                Log.e("DELETE-OFER", "Throwable: " + t.getMessage());
                callback.onError(t.getMessage());
            }
        });
    }

    public void deleteSolicitation(int id, final OnCarReturn callback){
        Call<ApiAnswer<CaronasCarsData>> call = mService.deleteSolicitation(mTokenHeader,id);
        call.enqueue(new Callback<ApiAnswer<CaronasCarsData>>() {
            @Override
            public void onResponse(Call<ApiAnswer<CaronasCarsData>> call, Response<ApiAnswer<CaronasCarsData>> response) {

                Log.i("DELETE-SOLICITATION", "Code: " + response.code() + ", " + response.message());

                if(response.isSuccessful()){
                    Log.i("DELETE-SOLICITATION", "Solicitação deletada com sucesso");
                    callback.onCarReady(response.body().data);
                }else{
                    Log.i("DELETE-SOLICITATION", "Solicitação não foi deletada - " + response.message());
                    callback.onError(new ErrorData(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasCarsData>> call, Throwable t) {
                Log.e("DELETE-SOLICITATION", "Throwable: " + t.getMessage());
                callback.onError(new ErrorData(t.getMessage()));
            }
        });
    }

    public void updateCar(int id, String identificador, int vagaspadrao, String modelo,
                          String codigocor, String placa, final OnCarReturn callback){
        Call<ApiAnswer<CaronasCarsData>> call = mService.updateCar(mTokenHeader, id,
                identificador,vagaspadrao,modelo,codigocor,placa);
        call.enqueue(new Callback<ApiAnswer<CaronasCarsData>>() {

            @Override
            public void onResponse(Call<ApiAnswer<CaronasCarsData>> call, Response<ApiAnswer<CaronasCarsData>> response) {
                Log.i("UPDATE-CAR", "Code: " + response.code() + ", " + response.message());

                if(response.isSuccessful()) {
                    Log.i("UPDATE-CAR", "Carro atualizado com sucesso");
                    callback.onCarReady(response.body().data);
                }else {
                    Log.i("UPDATE-CAR", "Carro não atualizado");
                    callback.onError(new ErrorData(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ApiAnswer<CaronasCarsData>> call, Throwable t) {
                Log.e("UPDATE-CAR", "Throwable: " + t.getMessage());
                callback.onError(new ErrorData(t.getMessage()));
            }
        });

    }

}
