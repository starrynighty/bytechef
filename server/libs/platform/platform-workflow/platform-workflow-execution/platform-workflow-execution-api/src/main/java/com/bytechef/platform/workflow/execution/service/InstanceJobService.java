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

package com.bytechef.platform.workflow.execution.service;

import com.bytechef.atlas.execution.domain.Job.Status;
import com.bytechef.platform.constant.ModeType;
import com.bytechef.platform.workflow.execution.domain.InstanceJob;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

/**
 * @author Ivica Cardic
 */
public interface InstanceJobService {

    InstanceJob create(long jobId, long instanceId, ModeType type);

    void deleteInstanceJobs(long jobId, ModeType type);

    Optional<Long> fetchLastJobId(long instanceId, ModeType type);

    Optional<Long> fetchJobInstanceId(long jobId, ModeType type);

    long getJobInstanceId(long jobId, ModeType type);

    List<Long> getJobIds(long instanceId, ModeType type);

    Page<Long> getJobIds(
        Status status, LocalDateTime startDate, LocalDateTime endDate, List<Long> instanceIds,
        ModeType type, List<String> workflowIds, int pageNumber);
}
