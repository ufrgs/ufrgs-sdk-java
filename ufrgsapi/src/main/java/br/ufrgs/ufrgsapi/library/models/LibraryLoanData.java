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

public class LibraryLoanData {

    @SerializedName("RenewURL")
    @Expose
    private String RenewURL;
    @SerializedName("CancelHoldRequestURL")
    @Expose
    private String CancelHoldRequestURL;
    @SerializedName("NRB")
    @Expose
    private String NRB;
    @SerializedName("Ano")
    @Expose
    private String Ano;
    @SerializedName("Autor")
    @Expose
    private String Autor;
    @SerializedName("Titulo")
    @Expose
    private String Titulo;
    @SerializedName("ISBN_ISSN_CODE")
    @Expose
    private String ISBNISSNCODE;
    @SerializedName("ISBN_ISSN")
    @Expose
    private String ISBNISSN;
    @SerializedName("DataPrevisaoDevolucao")
    @Expose
    private String DataDevolucao;

    public String getRenewURL() {
        return RenewURL;
    }

    public void setRenewURL(String RenewURL) {
        this.RenewURL = RenewURL;
    }

    public String getCancelHoldRequestURL() {
        return CancelHoldRequestURL;
    }

    public void setCancelHoldRequestURL(String CancelHoldRequestURL) {
        this.CancelHoldRequestURL = CancelHoldRequestURL;
    }

    public String getNRB() {
        return NRB;
    }

    public void setNRB(String NRB) {
        this.NRB = NRB;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getISBNISSNCODE() {
        return ISBNISSNCODE;
    }

    public void setISBNISSNCODE(String ISBNISSNCODE) {
        this.ISBNISSNCODE = ISBNISSNCODE;
    }

    public String getISBNISSN() {
        return ISBNISSN;
    }

    public void setISBNISSN(String ISBNISSN) {
        this.ISBNISSN = ISBNISSN;
    }

    public String getDataDevolucao() {
        return DataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        DataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "LoanAnswer{" +
                "RenewURL='" + RenewURL + '\n' +
                ", CancelHoldRequestURL='" + CancelHoldRequestURL + '\n' +
                ", NRB='" + NRB + '\n' +
                ", Ano='" + Ano + '\n' +
                ", Autor='" + Autor + '\n' +
                ", Titulo='" + Titulo + '\n' +
                ", ISBNISSNCODE='" + ISBNISSNCODE + '\n' +
                ", ISBNISSN='" + ISBNISSN + '\n' +
                '}';
    }
}