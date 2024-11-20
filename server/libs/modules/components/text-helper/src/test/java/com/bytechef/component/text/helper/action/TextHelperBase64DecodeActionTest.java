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

package com.bytechef.component.text.helper.action;

import static com.bytechef.component.text.helper.constant.TextHelperConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.test.definition.MockParametersFactory;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TextHelperBase64DecodeActionTest {

    @Test
    public void testDecodeString() {
        String expectedResult = "this is a testing string for testing purposes of decoding base64";
        String base64String =
            "dGhpcyBpcyBhIHRlc3Rpbmcgc3RyaW5nIGZvciB0ZXN0aW5nIHB1cnBvc2VzIG9mIGRlY29kaW5nIGJhc2U2NA==";

        Parameters parameters =
            MockParametersFactory.create(Map.of(CONTENT, base64String, ENCODING_SCHEMA, ENCODING_SCHEMA_BASE64));
        var result = TextHelperBase64DecodeAction.perform(parameters, parameters, mock(ActionContext.class));
        assertTrue(result instanceof String);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDecodeEmptyString() {
        String expectedResult = "";
        String base64String = "";

        Parameters parameters =
            MockParametersFactory.create(Map.of(CONTENT, base64String, ENCODING_SCHEMA, ENCODING_SCHEMA_BASE64));
        var result = TextHelperBase64DecodeAction.perform(parameters, parameters, mock(ActionContext.class));
        assertTrue(result instanceof String);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDecodeStringUrlSafe() {
        String expectedResult = "this is a testing string for testing purposes of decoding base64";
        String base64String = "dGhpcyBpcyBhIHRlc3Rpbmcgc3RyaW5nIGZvciB0ZXN0aW5nIHB1cnBvc2VzIG9mIGRlY29kaW5nIGJhc2U2NA";

        Parameters parameters =
            MockParametersFactory.create(Map.of(CONTENT, base64String, ENCODING_SCHEMA, ENCODING_SCHEMA_BASE64URL));
        var result = TextHelperBase64DecodeAction.perform(parameters, parameters, mock(ActionContext.class));
        assertTrue(result instanceof String);
        assertEquals(expectedResult, result);
    }
}
