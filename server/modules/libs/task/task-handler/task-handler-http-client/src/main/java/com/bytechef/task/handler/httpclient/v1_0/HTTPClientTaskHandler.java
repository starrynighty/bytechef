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

package com.bytechef.task.handler.httpclient.v1_0;

import com.bytechef.atlas.task.execution.domain.TaskExecution;
import com.bytechef.atlas.worker.task.handler.TaskHandler;
import com.bytechef.task.handler.httpclient.HTTPClientTaskConstants;
import com.bytechef.task.handler.httpclient.v1_0.http.HTTPClientHelper;
import org.springframework.stereotype.Component;

/**
 * @author Ivica Cardic
 */
public class HTTPClientTaskHandler {

    public abstract static class AbstractHTTPClientTaskHandler implements TaskHandler<Object> {

        private final HTTPClientHelper httpClientHelper;

        public AbstractHTTPClientTaskHandler(HTTPClientHelper httpClientHelper) {
            this.httpClientHelper = httpClientHelper;
        }

        @Override
        public Object handle(TaskExecution taskExecution) throws Exception {
            return httpClientHelper.send(taskExecution, getRequestMethod());
        }

        protected abstract HTTPClientTaskConstants.RequestMethod getRequestMethod();
    }

    @Component(HTTPClientTaskConstants.HTTP_CLIENT + "/" + HTTPClientTaskConstants.VERSION_1_0 + "/"
            + HTTPClientTaskConstants.DELETE)
    public static class HTTPClientDeleteTaskHandler extends AbstractHTTPClientTaskHandler {

        public HTTPClientDeleteTaskHandler(HTTPClientHelper httpClientHelper) {
            super(httpClientHelper);
        }

        @Override
        protected HTTPClientTaskConstants.RequestMethod getRequestMethod() {
            return HTTPClientTaskConstants.RequestMethod.DELETE;
        }
    }

    @Component(HTTPClientTaskConstants.HTTP_CLIENT + "/" + HTTPClientTaskConstants.VERSION_1_0 + "/"
            + HTTPClientTaskConstants.GET)
    public static class HTTPClientGetTaskHandler extends AbstractHTTPClientTaskHandler {

        public HTTPClientGetTaskHandler(HTTPClientHelper httpClientHelper) {
            super(httpClientHelper);
        }

        @Override
        protected HTTPClientTaskConstants.RequestMethod getRequestMethod() {
            return HTTPClientTaskConstants.RequestMethod.GET;
        }
    }

    @Component(HTTPClientTaskConstants.HTTP_CLIENT + "/" + HTTPClientTaskConstants.VERSION_1_0 + "/"
            + HTTPClientTaskConstants.HEAD)
    public static class HTTPClientHeadTaskHandler extends AbstractHTTPClientTaskHandler {

        public HTTPClientHeadTaskHandler(HTTPClientHelper httpClientHelper) {
            super(httpClientHelper);
        }

        @Override
        protected HTTPClientTaskConstants.RequestMethod getRequestMethod() {
            return HTTPClientTaskConstants.RequestMethod.HEAD;
        }
    }

    @Component(HTTPClientTaskConstants.HTTP_CLIENT + "/" + HTTPClientTaskConstants.VERSION_1_0 + "/"
            + HTTPClientTaskConstants.PATCH)
    public static class HTTPClientPatchTaskHandler extends AbstractHTTPClientTaskHandler {

        public HTTPClientPatchTaskHandler(HTTPClientHelper httpClientHelper) {
            super(httpClientHelper);
        }

        @Override
        protected HTTPClientTaskConstants.RequestMethod getRequestMethod() {
            return HTTPClientTaskConstants.RequestMethod.PATCH;
        }
    }

    @Component(HTTPClientTaskConstants.HTTP_CLIENT + "/" + HTTPClientTaskConstants.VERSION_1_0 + "/"
            + HTTPClientTaskConstants.POST)
    public static class HTTPClientPostTaskHandler extends AbstractHTTPClientTaskHandler {

        public HTTPClientPostTaskHandler(HTTPClientHelper httpClientHelper) {
            super(httpClientHelper);
        }

        @Override
        protected HTTPClientTaskConstants.RequestMethod getRequestMethod() {
            return HTTPClientTaskConstants.RequestMethod.POST;
        }
    }

    @Component(HTTPClientTaskConstants.HTTP_CLIENT + "/" + HTTPClientTaskConstants.VERSION_1_0 + "/"
            + HTTPClientTaskConstants.PUT)
    public static class HTTPClientPutTaskHandler extends AbstractHTTPClientTaskHandler {

        public HTTPClientPutTaskHandler(HTTPClientHelper httpClientHelper) {
            super(httpClientHelper);
        }

        @Override
        protected HTTPClientTaskConstants.RequestMethod getRequestMethod() {
            return HTTPClientTaskConstants.RequestMethod.PUT;
        }
    }
}
