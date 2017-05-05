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

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * @author Alan Wink
 * @author Theodoro Mota
 * @version 1.0
 */

public class UfrgsLibraryLoan implements Parcelable {

    public String renewUrl;
    public String cancelHoldRequestURL;
    public String nrb;
    public String year;
    public String author;
    public String title;
    public String isbnIssnCode;
    public String isbnIssn;
    public String returnDate;

    public UfrgsLibraryLoan(LibraryLoanData data) {
        this.renewUrl = data.getRenewURL();
        this.cancelHoldRequestURL = data.getCancelHoldRequestURL();
        this.nrb = data.getNRB();
        this.year = data.getAno();
        this.author = data.getAutor();
        this.title = data.getTitulo();
        this.isbnIssnCode = data.getISBNISSNCODE();
        this.isbnIssn = data.getISBNISSN();
        this.returnDate = data.getDataDevolucao();
    }

    @Override
    public String toString() {
        return "UfrgsLibraryLoan{" +
                "renewUrl='" + renewUrl + '\'' +'\n' +
                ", cancelHoldRequestURL='" + cancelHoldRequestURL + '\'' +'\n' +
                ", nrb='" + nrb + '\'' +'\n' +
                ", year='" + year + '\'' +'\n' +
                ", author='" + author + '\'' +'\n' +
                ", title='" + title + '\'' +'\n' +
                ", isbnIssnCode='" + isbnIssnCode + '\'' +'\n' +
                ", isbnIssn='" + isbnIssn + '\'' +'\n' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.renewUrl);
        dest.writeString(this.cancelHoldRequestURL);
        dest.writeString(this.nrb);
        dest.writeString(this.year);
        dest.writeString(this.author);
        dest.writeString(this.title);
        dest.writeString(this.isbnIssnCode);
        dest.writeString(this.isbnIssn);
        dest.writeString(this.returnDate);
    }

    protected UfrgsLibraryLoan(Parcel in) {
        this.renewUrl = in.readString();
        this.cancelHoldRequestURL = in.readString();
        this.nrb = in.readString();
        this.year = in.readString();
        this.author = in.readString();
        this.title = in.readString();
        this.isbnIssnCode = in.readString();
        this.isbnIssn = in.readString();
        this.returnDate = in.readString();
    }

    public static final Parcelable.Creator<UfrgsLibraryLoan> CREATOR = new Parcelable.Creator<UfrgsLibraryLoan>() {
        @Override
        public UfrgsLibraryLoan createFromParcel(Parcel source) {
            return new UfrgsLibraryLoan(source);
        }

        @Override
        public UfrgsLibraryLoan[] newArray(int size) {
            return new UfrgsLibraryLoan[size];
        }
    };
}
