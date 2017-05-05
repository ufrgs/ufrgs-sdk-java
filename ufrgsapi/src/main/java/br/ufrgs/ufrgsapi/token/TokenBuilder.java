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

import br.ufrgs.ufrgsapi.network.pojo.TokenData;

/**
 *
 * @author Alan Wink
 * @version 1.0
 */

public class TokenBuilder {
    public static UfrgsToken build(TokenData data){
        UfrgsToken token = new UfrgsToken();

        token.accessToken = data.getAccessToken();
        token.refreshToken = data.getRefreshToken();
        token.scope = data.getScope();

        return token;
    }
}
