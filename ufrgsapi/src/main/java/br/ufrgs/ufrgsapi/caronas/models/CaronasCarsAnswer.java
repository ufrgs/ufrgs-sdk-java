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

import java.util.List;

import br.ufrgs.ufrgsapi.network.pojo.MetaData;

/**
 *
 * @author Theodoro Mota
 * @version 1.0
 */

public class CaronasCarsAnswer {
    @SerializedName("carros")
    @Expose
    public List<CaronasCarsData> carros = null;
    @SerializedName("_meta")
    @Expose
    public MetaData meta;
}
