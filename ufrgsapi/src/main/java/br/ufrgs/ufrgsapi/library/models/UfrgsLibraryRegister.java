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

/**
 *
 * @author Theodoro Mota
 * @version 1.0
 */

public class UfrgsLibraryRegister {
    public String card;
    public String regsterDate;
    public String registerTime;
    public boolean isRenewActive;

    public UfrgsLibraryRegister(){
    }

    public UfrgsLibraryRegister(LibraryAgreementAnswer data){
        String date = data.getDataAceitacaoTermoBib();

        this.card = data.getCodPessoa();
        this.regsterDate = date.split(" ")[0];
        this.regsterDate = date.split(" ")[1];

        if(data.getIndicadorRenovaAutomaticoBib().contentEquals("S")){
            this.isRenewActive = true;
        } else {
            this.isRenewActive = false;
        }


    }
}
