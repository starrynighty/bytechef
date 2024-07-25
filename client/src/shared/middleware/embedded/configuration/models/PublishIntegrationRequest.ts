/* tslint:disable */
/* eslint-disable */
/**
 * The Embedded Configuration Internal API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface PublishIntegrationRequest
 */
export interface PublishIntegrationRequest {
    /**
     * The description of a integration version.
     * @type {string}
     * @memberof PublishIntegrationRequest
     */
    description?: string;
}

/**
 * Check if a given object implements the PublishIntegrationRequest interface.
 */
export function instanceOfPublishIntegrationRequest(value: object): value is PublishIntegrationRequest {
    return true;
}

export function PublishIntegrationRequestFromJSON(json: any): PublishIntegrationRequest {
    return PublishIntegrationRequestFromJSONTyped(json, false);
}

export function PublishIntegrationRequestFromJSONTyped(json: any, ignoreDiscriminator: boolean): PublishIntegrationRequest {
    if (json == null) {
        return json;
    }
    return {
        
        'description': json['description'] == null ? undefined : json['description'],
    };
}

export function PublishIntegrationRequestToJSON(value?: PublishIntegrationRequest | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'description': value['description'],
    };
}
