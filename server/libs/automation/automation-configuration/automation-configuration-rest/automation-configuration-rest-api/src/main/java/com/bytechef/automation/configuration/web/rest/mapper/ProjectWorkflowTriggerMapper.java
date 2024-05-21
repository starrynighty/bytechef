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

package com.bytechef.automation.configuration.web.rest.mapper;

import com.bytechef.automation.configuration.web.rest.mapper.config.AutomationConfigurationMapperSpringConfig;
import com.bytechef.automation.configuration.web.rest.model.WorkflowTriggerModel;
import com.bytechef.platform.configuration.domain.WorkflowTrigger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Ivica Cardic
 */
@Mapper(config = AutomationConfigurationMapperSpringConfig.class)
public interface ProjectWorkflowTriggerMapper extends Converter<WorkflowTrigger, WorkflowTriggerModel> {

    @Mapping(target = "connections", ignore = true)
    WorkflowTriggerModel convert(WorkflowTrigger workflowTrigger);
}