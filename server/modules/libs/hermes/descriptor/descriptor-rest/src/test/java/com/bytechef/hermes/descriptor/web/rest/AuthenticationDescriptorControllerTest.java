/*
 * Copyright 2021 <your company/name>.
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

package com.bytechef.hermes.descriptor.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bytechef.hermes.descriptor.domain.DSL;
import com.bytechef.hermes.descriptor.handler.AuthenticationDescriptorHandler;
import com.bytechef.hermes.descriptor.repository.ExtAuthenticationDescriptorHandlerRepository;
import com.bytechef.hermes.descriptor.repository.ExtTaskDescriptorHandlerRepository;
import com.bytechef.hermes.descriptor.service.AuthenticationDescriptorHandlerService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Ivica Cardic
 */
@WebMvcTest(AuthenticationDescriptorController.class)
public class AuthenticationDescriptorControllerTest {

    @MockBean
    private ExtAuthenticationDescriptorHandlerRepository extAuthenticationDescriptorHandlerRepository;

    @MockBean
    private ExtTaskDescriptorHandlerRepository extTaskDescriptorHandlerRepository;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @MockBean
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @MockBean
    private AuthenticationDescriptorHandlerService authenticationDescriptorHandlerService;

    private static final List<AuthenticationDescriptorHandler> TASK_AUTH_DESCRIPTOR_HANDLERS = List.of(
            () -> DSL.createAuthenticationDescriptors("task1", List.of(DSL.createAuthenticationDescriptor("auth1"))),
            () -> DSL.createAuthenticationDescriptors("task2", List.of(DSL.createAuthenticationDescriptor("auth2"))));

    @Test
    public void testGetAuthenticationDescriptor() throws Exception {
        Mockito.doReturn(TASK_AUTH_DESCRIPTOR_HANDLERS.get(0))
                .when(authenticationDescriptorHandlerService)
                .getAuthenticationDescriptorHandler(Mockito.anyString());

        mockMvc.perform(get("/authentication-descriptors/task1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(
                        content()
                                .json(
                                        """
                                       {"taskName":"task1","authenticationDescriptors":[{"name":"auth1"}]}
                        """));
    }

    @Test
    public void testGetAuthenticationDescriptors() throws Exception {
        Mockito.doReturn(TASK_AUTH_DESCRIPTOR_HANDLERS)
                .when(authenticationDescriptorHandlerService)
                .getAuthenticationDescriptorHandlers();

        mockMvc.perform(get("/authentication-descriptors").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(
                        content()
                                .json(
                                        """
                        [
                            {"taskName":"task1","authenticationDescriptors":[{"name":"auth1"}]},
                            {"taskName":"task2","authenticationDescriptors":[{"name":"auth2"}]}
                        ]
                        """));
    }
}
