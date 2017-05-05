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
package br.ufrgs.ufrgsapi.token;

import android.util.Log;

import java.io.Serializable;

/**
 * A token used to network requests.
 *
 * @author Alan Wink
 * @version 1.0
 */

public class UfrgsToken implements Serializable {
    private static final String TAG = "UfrgsToken";
    private static String DIVISOR_FIELD = "+";

    public String accessToken;
    public String refreshToken;
    public String scope;

    public String serialize(){
        return accessToken + DIVISOR_FIELD + refreshToken + DIVISOR_FIELD + scope;
    }

    public static UfrgsToken deserialize(String in){
        String[] splitToken = in.split("\\+");
        Log.i(TAG, "deserialize: in = " + in + "split = " + splitToken);
        UfrgsToken token = new UfrgsToken();
        token.accessToken = splitToken[0];
        token.refreshToken = splitToken[1];
        token.scope = splitToken[2];
        return token;
    }

    @Override
    public String toString() {
        return "UfrgsToken{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
