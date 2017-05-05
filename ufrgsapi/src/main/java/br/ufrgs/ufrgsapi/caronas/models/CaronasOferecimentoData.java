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

package br.ufrgs.ufrgsapi.caronas.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Theodoro Mota
 * @version 1.0
 */

public class CaronasOferecimentoData {

    @SerializedName("codigo")
    @Expose
    public String nrSeqCarona;
    @SerializedName("codigomotorista")
    @Expose
    public String codPessoa;
    @SerializedName("codigocarro")
    @Expose
    public String codCarro;
    @SerializedName("codigocampusorigem")
    @Expose
    public String codCampusOrigem;
    @SerializedName("codigocampusdestino")
    @Expose
    public String codCampusDestino;
    @SerializedName("horasaida")
    @Expose
    private String dataHoraSaida;
    @SerializedName("vagas")
    @Expose
    public String nrVagas;
    @SerializedName("pontoencontro")
    @Expose
    public String pontoEncontro;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("observacoes")
    @Expose
    public String observacoes;
    @SerializedName("apenasmulheres")
    @Expose
    public String apenasMulheres;
    @SerializedName("motorista")
    @Expose
    public SimpleDriverData motorista;
    @SerializedName("carro")
    @Expose
    public SimpleCarData carro;



    public Date getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(dataHoraSaida);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double getLatitude(){
        return Double.parseDouble(latitude);
    }

    public double getLongitude(){
        return Double.parseDouble(longitude);
    }

    public boolean getApenasMulheres(){
        if(apenasMulheres.contentEquals("S"))
            return true;
        else
            return false;
    }
}
