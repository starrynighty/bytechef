/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.quickbooks.action;

import static org.mockito.Mockito.mock;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Context.Http;
import com.bytechef.component.definition.Parameters;
import org.mockito.ArgumentCaptor;

/**
 * @author Monika Kušter
 */
abstract class AbstractQuickbooksActionTest {

    protected ArgumentCaptor<Http.Body> bodyArgumentCaptor = ArgumentCaptor.forClass(Http.Body.class);
    protected ActionContext mockedContext = mock(ActionContext.class);
    protected Http.Executor mockedExecutor = mock(Http.Executor.class);
    protected Object mockedObject = mock(Object.class);
    protected Parameters mockedParameters;
    protected Http.Response mockedResponse = mock(Http.Response.class);
}