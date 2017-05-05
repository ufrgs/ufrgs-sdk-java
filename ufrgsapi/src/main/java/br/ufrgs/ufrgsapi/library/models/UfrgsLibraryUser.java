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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan Wink
 * @author Theodoro Mota
 * @version 1.0
 */

public class UfrgsLibraryUser {

    public String personCode;
    public String personName;
    public float debtTotal;
    public int loansTotal;
    public int reservationsTotal;
    public List<UfrgsLibraryLoan> loans = new ArrayList<>();
    //public List<Object> reservation; // Not implemented

    public UfrgsLibraryUser(LibraryData data){
        this.personCode = data.getCodPessoa();
        this.personName = data.getNomePessoa();
        this.debtTotal =  Float.valueOf(data.getDebitoTotal());
        this.loansTotal = Integer.getInteger(data.getTotalEmprestimos(), -1);
        this.reservationsTotal = Integer.getInteger(data.getTotalReservas(), -1);
        for (int i = 0; i < data.getEmprestimos().size(); i++) {
            loans.add(new UfrgsLibraryLoan(data.getEmprestimos().get(i)));
        }
    }

    @Override
    public String toString() {
        return "UfrgsLibraryUser{" +
                "personCode='" + personCode + '\n' +
                ", personName='" + personName + '\n' +
                ", debtTotal=" + debtTotal +'\n' +
                ", loansTotal=" + loansTotal +'\n' +
                ", reservationsTotal=" + reservationsTotal +'\n' +
                ", loans=" + loans +'\n' +
                '}';
    }
}
