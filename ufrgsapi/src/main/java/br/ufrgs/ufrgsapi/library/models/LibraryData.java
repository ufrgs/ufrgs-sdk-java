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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Theodoro Mota
 * @version 1.0
 */

public class LibraryData {

    @SerializedName("CodPessoa")
    @Expose
    private String CodPessoa;
    @SerializedName("NomePessoa")
    @Expose
    private String NomePessoa;
    @SerializedName("DebitoTotal")
    @Expose
    private String DebitoTotal;
    @SerializedName("TotalEmprestimos")
    @Expose
    private String TotalEmprestimos;
    @SerializedName("TotalReservas")
    @Expose
    private String TotalReservas;
    @SerializedName("Emprestimos")
    @Expose
    private List<LibraryLoanData> Emprestimos = new ArrayList<>();
    @SerializedName("Reservas")
    @Expose
    private List<Object> Reservas = new ArrayList<Object>();

    public String getCodPessoa() {
        return CodPessoa;
    }

    public void setCodPessoa(String CodPessoa) {
        this.CodPessoa = CodPessoa;
    }

    public String getNomePessoa() {
        return NomePessoa;
    }

    public void setNomePessoa(String NomePessoa) {
        this.NomePessoa = NomePessoa;
    }

    public String getDebitoTotal() {
        return DebitoTotal;
    }

    public void setDebitoTotal(String DebitoTotal) {
        this.DebitoTotal = DebitoTotal;
    }

    public String getTotalEmprestimos() {
        return TotalEmprestimos;
    }

    public void setTotalEmprestimos(String TotalEmprestimos) {
        this.TotalEmprestimos = TotalEmprestimos;
    }

    public String getTotalReservas() {
        return TotalReservas;
    }

    public void setTotalReservas(String TotalReservas) {
        this.TotalReservas = TotalReservas;
    }

    public List<LibraryLoanData> getEmprestimos() {
        return Emprestimos;
    }

    public void setEmprestimos(List<LibraryLoanData> Emprestimos) {
        this.Emprestimos = Emprestimos;
    }
    public List<Object> getReservas() {
        return Reservas;
    }

    public void setReservas(List<Object> Reservas) {
        this.Reservas = Reservas;
    }

    @Override
    public String toString() {
        return "LibraryAnswer{" +
                "CodPessoa='" + CodPessoa + '\'' + '\n' +
                ", NomePessoa='" + NomePessoa + '\'' + '\n' +
                ", DebitoTotal='" + DebitoTotal + '\'' + '\n' +
                ", TotalEmprestimos='" + TotalEmprestimos + '\'' + '\n' +
                ", TotalReservas='" + TotalReservas + '\'' + '\n' +
                ", Emprestimos=" + Emprestimos + '\n' +
                ", Reservas=" + Reservas +
                '}';
    }
}