/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.platform.configuration.web.rest;

import com.bytechef.platform.configuration.web.rest.model.ScriptTestExecutionModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-06T14:06:10.952484+01:00[Europe/Zagreb]")
@Validated
@Tag(name = "workflow-node-script", description = "The Platform Workflow Node Script API")
public interface WorkflowNodeScriptApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /workflows/{id}/scripts/{workflowNodeName} : Execute a script for testing purposes
     * Execute a script for testing purposes.
     *
     * @param id The id of a workflow. (required)
     * @param workflowNodeName The name of a workflow node which uses the script component. (required)
     * @return The script test execution object. (status code 200)
     */
    @Operation(
        operationId = "testWorkflowNodeScript",
        summary = "Execute a script for testing purposes",
        description = "Execute a script for testing purposes.",
        tags = { "workflow-node-script" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The script test execution object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ScriptTestExecutionModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/workflows/{id}/scripts/{workflowNodeName}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ScriptTestExecutionModel> testWorkflowNodeScript(
        @Parameter(name = "id", description = "The id of a workflow.", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "workflowNodeName", description = "The name of a workflow node which uses the script component.", required = true, in = ParameterIn.PATH) @PathVariable("workflowNodeName") String workflowNodeName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"output\" : \"{}\", \"error\" : { \"stackTrace\" : [ \"stackTrace\", \"stackTrace\" ], \"message\" : \"message\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}