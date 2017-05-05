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
package br.ufrgs.ufrgsapi.library.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Theodoro Mota
 * @version 1.0
 */

public class LibraryAgreementAnswer {
    @SerializedName("CodPessoa")
    @Expose
    public String codPessoa;
    @SerializedName("DataAceitacaoTermoBib")
    @Expose
    public String dataAceitacaoTermoBib;
    @SerializedName("IndicadorRenovaAutomaticoBib")
    @Expose
    public String indicadorRenovaAutomaticoBib;

    public String getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(String codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getDataAceitacaoTermoBib() {
        return dataAceitacaoTermoBib;
    }

    public void setDataAceitacaoTermoBib(String dataAceitacaoTermoBib) {
        this.dataAceitacaoTermoBib = dataAceitacaoTermoBib;
    }

    public String getIndicadorRenovaAutomaticoBib() {
        return indicadorRenovaAutomaticoBib;
    }

    public void setIndicadorRenovaAutomaticoBib(String indicadorRenovaAutomaticoBib) {
        this.indicadorRenovaAutomaticoBib = indicadorRenovaAutomaticoBib;
    }
}
