/* tslint:disable */
/* eslint-disable */
/**
 * The Automation Execution API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { JobBasicModel } from './JobBasicModel';
import {
    JobBasicModelFromJSON,
    JobBasicModelFromJSONTyped,
    JobBasicModelToJSON,
} from './JobBasicModel';
import type { ProjectBasicModel } from './ProjectBasicModel';
import {
    ProjectBasicModelFromJSON,
    ProjectBasicModelFromJSONTyped,
    ProjectBasicModelToJSON,
} from './ProjectBasicModel';
import type { ProjectInstanceBasicModel } from './ProjectInstanceBasicModel';
import {
    ProjectInstanceBasicModelFromJSON,
    ProjectInstanceBasicModelFromJSONTyped,
    ProjectInstanceBasicModelToJSON,
} from './ProjectInstanceBasicModel';
import type { WorkflowBasicModel } from './WorkflowBasicModel';
import {
    WorkflowBasicModelFromJSON,
    WorkflowBasicModelFromJSONTyped,
    WorkflowBasicModelToJSON,
} from './WorkflowBasicModel';

/**
 * Contains basic information about execution of a project workflow.
 * @export
 * @interface WorkflowExecutionBasicModel
 */
export interface WorkflowExecutionBasicModel {
    /**
     * The id of a workflow execution.
     * @type {number}
     * @memberof WorkflowExecutionBasicModel
     */
    readonly id?: number;
    /**
     * 
     * @type {ProjectInstanceBasicModel}
     * @memberof WorkflowExecutionBasicModel
     */
    projectInstance?: ProjectInstanceBasicModel;
    /**
     * 
     * @type {JobBasicModel}
     * @memberof WorkflowExecutionBasicModel
     */
    job?: JobBasicModel;
    /**
     * 
     * @type {ProjectBasicModel}
     * @memberof WorkflowExecutionBasicModel
     */
    project?: ProjectBasicModel;
    /**
     * 
     * @type {WorkflowBasicModel}
     * @memberof WorkflowExecutionBasicModel
     */
    workflow?: WorkflowBasicModel;
}

/**
 * Check if a given object implements the WorkflowExecutionBasicModel interface.
 */
export function instanceOfWorkflowExecutionBasicModel(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function WorkflowExecutionBasicModelFromJSON(json: any): WorkflowExecutionBasicModel {
    return WorkflowExecutionBasicModelFromJSONTyped(json, false);
}

export function WorkflowExecutionBasicModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): WorkflowExecutionBasicModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': !exists(json, 'id') ? undefined : json['id'],
        'projectInstance': !exists(json, 'projectInstance') ? undefined : ProjectInstanceBasicModelFromJSON(json['projectInstance']),
        'job': !exists(json, 'job') ? undefined : JobBasicModelFromJSON(json['job']),
        'project': !exists(json, 'project') ? undefined : ProjectBasicModelFromJSON(json['project']),
        'workflow': !exists(json, 'workflow') ? undefined : WorkflowBasicModelFromJSON(json['workflow']),
    };
}

export function WorkflowExecutionBasicModelToJSON(value?: WorkflowExecutionBasicModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'projectInstance': ProjectInstanceBasicModelToJSON(value.projectInstance),
        'job': JobBasicModelToJSON(value.job),
        'project': ProjectBasicModelToJSON(value.project),
        'workflow': WorkflowBasicModelToJSON(value.workflow),
    };
}

