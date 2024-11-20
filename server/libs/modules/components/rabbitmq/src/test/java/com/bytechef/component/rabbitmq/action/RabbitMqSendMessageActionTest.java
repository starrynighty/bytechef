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

package com.bytechef.component.rabbitmq.action;

import static com.bytechef.component.rabbitmq.constant.RabbitMqConstants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class RabbitMqSendMessageActionTest {

    private final Parameters mockedConnectionProperties = mock(Parameters.class);
    private final Parameters mockedInputParameters = mock(Parameters.class);

    @Test
    public void testPerformThrowsIOException() {
        when(mockedConnectionProperties.getString(HOSTNAME)).thenReturn("wrongHostname");
        when(mockedConnectionProperties.getString(USERNAME)).thenReturn("wrongUsername");
        when(mockedConnectionProperties.getString(PASSWORD)).thenReturn("wrongPassword");
        when(mockedConnectionProperties.getInteger(PORT)).thenReturn(5672);

        assertThrows(IOException.class, () -> RabbitMqSendMessageAction.perform(mockedInputParameters,
            mockedConnectionProperties, mock(ActionContext.class)));
    }
}
