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
package br.ufrgs.ufrgsapi.dagger.components;

import br.ufrgs.ufrgsapi.dagger.SDKScope;
import br.ufrgs.ufrgsapi.dagger.modules.NetModule;
import br.ufrgs.ufrgsapi.dagger.modules.TokenModule;
import br.ufrgs.ufrgsapi.library.UfrgsLibraryManager;
import dagger.Component;

/**
 *
 * @author Theodoro Mota
 * @version 1.0
 */

@SDKScope
@Component(modules={NetModule.class, TokenModule.class})
public interface LibraryComponent {
    void inject(UfrgsLibraryManager ufrgsLibraryManager);
}
