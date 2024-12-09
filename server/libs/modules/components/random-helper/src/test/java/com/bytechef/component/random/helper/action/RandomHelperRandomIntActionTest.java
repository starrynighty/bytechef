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

package com.bytechef.component.random.helper.action;

import static com.bytechef.component.random.helper.constant.RandomHelperConstants.END_INCLUSIVE;
import static com.bytechef.component.random.helper.constant.RandomHelperConstants.START_INCLUSIVE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.test.definition.MockParametersFactory;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class RandomHelperRandomIntActionTest {

    @Test
    public void testPerformWithinLimits() {
        int start = 100;
        int end = 6200;
        Parameters parameters = MockParametersFactory.create(Map.of(START_INCLUSIVE, start, END_INCLUSIVE, end));

        int result = RandomHelperRandomIntAction.perform(parameters, parameters, mock(ActionContext.class));
        assertTrue(result >= start && result <= end);
    }

    @Test
    public void testIllegalArguments() {
        Parameters parametersBiggerStart =
            MockParametersFactory.create(Map.of(START_INCLUSIVE, 9000, END_INCLUSIVE, 123));
        assertThrows(IllegalArgumentException.class, () -> RandomHelperRandomIntAction.perform(parametersBiggerStart,
            parametersBiggerStart, mock(ActionContext.class)));

        Parameters parametersNegative = MockParametersFactory.create(Map.of(START_INCLUSIVE, -10, END_INCLUSIVE, 420));
        assertThrows(IllegalArgumentException.class, () -> RandomHelperRandomIntAction.perform(parametersNegative,
            parametersNegative, mock(ActionContext.class)));
    }

    @Test
    public void testPerformSameLimits() {
        int start = 59;
        int end = 59;
        Parameters parameters = MockParametersFactory.create(Map.of(START_INCLUSIVE, start, END_INCLUSIVE, end));

        float result = RandomHelperRandomIntAction.perform(parameters, parameters, mock(ActionContext.class));
        assertEquals(start, result);
    }
}
