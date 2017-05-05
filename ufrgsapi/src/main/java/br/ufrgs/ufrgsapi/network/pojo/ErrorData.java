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
package br.ufrgs.ufrgsapi.network.pojo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Theodoro Mota
 * @version 1.0
 */

public class ErrorData {
    private String message;
    private JSONObject data;

    public ErrorData() {
    }

    public ErrorData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(String rawData) {
        try {
            JSONObject jsonObject = new JSONObject(rawData);
            this.data = jsonObject.getJSONObject("data").getJSONObject("erros");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
