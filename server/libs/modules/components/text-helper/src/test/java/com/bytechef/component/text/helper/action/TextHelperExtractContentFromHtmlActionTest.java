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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.test.definition.MockParametersFactory;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TextHelperExtractContentFromHtmlActionTest {

    @Test
    public void testExtractText() {
        String htmlElement = "<a href=\"https://some.link/testing\" title=\"Question score (upvotes - downvotes)\">" +
            "<div class=\"answer-votes answered-accepted large\">619</div>" +
            "</a>";
        Parameters parameters = MockParametersFactory.create(
            Map.of(CONTENT, htmlElement,
                QUERY_SELECTOR, "a",
                RETURN_VALUE, "text",
                ATTRIBUTE, "",
                RETURN_ARRAY, false));

        Object result =
            TextHelperExtractContentFromHtmlAction.perform(parameters, parameters, mock(ActionContext.class));
        assertTrue(result instanceof String);
        assertEquals("619", result);
    }

    @Test
    public void testExtractInnerHtml() {
        String htmlElement = "<a href=\"https://some.link/testing\" title=\"Question score (upvotes - downvotes)\">" +
            "<div class=\"answer-votes answered-accepted large\">619</div>" +
            "</a>";
        Parameters parameters = MockParametersFactory.create(
            Map.of(CONTENT, htmlElement,
                QUERY_SELECTOR, "a",
                RETURN_VALUE, "html",
                ATTRIBUTE, "",
                RETURN_ARRAY, false));

        Object result =
            TextHelperExtractContentFromHtmlAction.perform(parameters, parameters, mock(ActionContext.class));
        assertTrue(result instanceof String);
        assertEquals("<div class=\"answer-votes answered-accepted large\">\n 619\n</div>", result);
    }

    @Test
    public void testExtractAttribute() {
        String htmlElement = "<a href=\"https://some.link/testing\" title=\"Question score (upvotes - downvotes)\">" +
            "<div class=\"answer-votes answered-accepted large\">619</div>" +
            "</a>";
        Parameters parameters = MockParametersFactory.create(
            Map.of(CONTENT, htmlElement,
                QUERY_SELECTOR, "div",
                RETURN_VALUE, "attribute",
                ATTRIBUTE, "class",
                RETURN_ARRAY, false));

        Object result =
            TextHelperExtractContentFromHtmlAction.perform(parameters, parameters, mock(ActionContext.class));
        assertTrue(result instanceof String);
        assertEquals("answer-votes answered-accepted large", result);
    }

    @Test
    public void testExtractAttributeArray() {
        String htmlElement = "<a href=\"https://some.link/testing\" title=\"Question score (upvotes - downvotes)\">" +
            "<div class=\"answer-votes answered-accepted large\">619</div>" +
            "<div class=\"answer-votes answered-accepted large\">619</div>" +
            "</a>";
        Parameters parameters = MockParametersFactory.create(
            Map.of(CONTENT, htmlElement,
                QUERY_SELECTOR, "div",
                RETURN_VALUE, "text",
                ATTRIBUTE, "none",
                RETURN_ARRAY, true));

        Object result =
            TextHelperExtractContentFromHtmlAction.perform(parameters, parameters, mock(ActionContext.class));
        assertTrue(result instanceof List);
        assertEquals(List.of("619", "619"), result);
    }

    @Test
    public void testExtractWrongAttribute() {
        String htmlElement = "<a href=\"https://some.link/testing\" title=\"Question score (upvotes - downvotes)\">" +
            "<div class=\"answer-votes answered-accepted large\">619</div>" +
            "</a>";
        Parameters parameters = MockParametersFactory.create(
            Map.of(CONTENT, htmlElement,
                QUERY_SELECTOR, "div",
                RETURN_VALUE, "nonexistentType",
                ATTRIBUTE, "noSuchAttribute",
                RETURN_ARRAY, false));

        assertThrows(IllegalArgumentException.class,
            () -> TextHelperExtractContentFromHtmlAction.perform(parameters, parameters, mock(ActionContext.class)));
    }
}
