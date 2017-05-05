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

import javax.inject.Named;

import br.ufrgs.ufrgsapi.UfrgsAPI;
import br.ufrgs.ufrgsapi.dagger.SDKScope;
import dagger.Module;
import dagger.Provides;

/**
 * This is the module that contains the static information about the api. Its used in all the SDK.
 * @author Theodoro Mota
 * @version 1.0
 */

@Module
@SDKScope
public class SettingsModule {

    public static final String CLIENT_ID = "clientId";
    public static final String CLIENT_SECRET = "clientSecret";
    public static final String SCOPE = "scope";
    public static final String GRANT_TYPE = "grantType";

    @Provides @Named(CLIENT_ID)
    @SDKScope
    String providesClientId(){
        return UfrgsAPI.mClientId;
    }

    @Provides @Named(CLIENT_SECRET)
    @SDKScope
    String providesClientSecret(){
        return UfrgsAPI.mClientSecret;
    }

    @Provides @Named(SCOPE)
    @SDKScope
    String providesScope(){
        return UfrgsAPI.mScope;
    }

    @Provides @Named(GRANT_TYPE)
    @SDKScope
    String providesGrantType(){
        return UfrgsAPI.mGrantType;
    }
}
