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
package br.ufrgs.ufrgsapi.dagger.modules;

import android.content.Context;

import br.ufrgs.ufrgsapi.dagger.SDKScope;
import br.ufrgs.ufrgsapi.token.UfrgsTokenManager;
import br.ufrgs.ufrgsapi.token.UfrgsToken;
import br.ufrgs.ufrgsapi.utils.ApiUtils;
import dagger.Module;
import dagger.Provides;

/**
 * This is the module that contains the constructor for the UfrgsTokenManager
 *
 * @author Theodoro Mota
 * @version 1.0
 */

@Module
@SDKScope
public class TokenModule {

    private Context context;

    public TokenModule(Context context) {
        this.context = context;
    }

    @Provides
    @SDKScope
    UfrgsToken providesUfrgsToken(){
        ApiUtils.validateClientInfo();
        UfrgsToken token = new UfrgsTokenManager().getToken(context);
        if(token == null) {
            throw new RuntimeException("The client must request a token (login) before start an API Call");
        } else {
            return  token;
        }
    }
}
