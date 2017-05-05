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
package br.ufrgs.ufrgsapi;


/**
 *
 * @author Theodoro Mota
 * @version 1.0
 */

public class UfrgsAPI {

    public static String mBaseUrl;
    public static String mClientId;
    public static String mClientSecret;
    public static String mScope;
    public static String mGrantType;

    public static void initialize(boolean setApiToProduction, String clientId, String clientSecret, String scope, String grantType){

        mClientId = clientId;
        mClientSecret = clientSecret;
        mScope = scope;
        mGrantType = grantType;

        if(setApiToProduction)
            mBaseUrl = Tags.BASE_URL_PROD;
        else
            mBaseUrl = Tags.BASE_URL_DEV;

    }

}
