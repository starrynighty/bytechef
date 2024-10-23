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

package com.bytechef.component.google.contacts.action;

import static com.bytechef.component.definition.ComponentDsl.action;
import static com.bytechef.component.definition.ComponentDsl.array;
import static com.bytechef.component.definition.ComponentDsl.object;
import static com.bytechef.component.definition.ComponentDsl.outputSchema;
import static com.bytechef.component.definition.ComponentDsl.string;
import static com.bytechef.component.google.contacts.constant.GoogleContactsConstants.COMPANY;
import static com.bytechef.component.google.contacts.constant.GoogleContactsConstants.EMAIL;
import static com.bytechef.component.google.contacts.constant.GoogleContactsConstants.FIRST_NAME;
import static com.bytechef.component.google.contacts.constant.GoogleContactsConstants.JOB_TITLE;
import static com.bytechef.component.google.contacts.constant.GoogleContactsConstants.LAST_NAME;
import static com.bytechef.component.google.contacts.constant.GoogleContactsConstants.MIDDLE_NAME;
import static com.bytechef.component.google.contacts.constant.GoogleContactsConstants.PHONE_NUMBER;
import static com.bytechef.component.google.contacts.constant.GoogleContactsConstants.RESOURCE_NAME;
import static com.bytechef.component.google.contacts.constant.GoogleContactsConstants.UPDATE_CONTACT;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.ComponentDsl.ModifiableActionDefinition;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.definition.Property;
import com.bytechef.google.commons.GoogleServices;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.model.EmailAddress;
import com.google.api.services.people.v1.model.Name;
import com.google.api.services.people.v1.model.Organization;
import com.google.api.services.people.v1.model.Person;
import com.google.api.services.people.v1.model.PhoneNumber;
import java.io.IOException;
import java.util.List;

/**
 * @author Martin Tarasovič
 */
public class GoogleContactsUpdateContactAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(UPDATE_CONTACT)
        .title("Update Contact")
        .description("Modifies an existing contact")
        .properties(
            string(RESOURCE_NAME)
                .label("Resource Name")
                .description("Resource name of the contact to be updated")
                .required(true),
            string(FIRST_NAME)
                .label("First name")
                .description("New first name of the contact")
                .required(true),
            string(MIDDLE_NAME)
                .label("Middle name")
                .description("New middle name of the contact")
                .required(false),
            string(LAST_NAME)
                .label("Last name")
                .description("Updated last name of the contact")
                .required(true),
            string(JOB_TITLE)
                .label("Job title")
                .description("Updated job title of the contact")
                .required(false),
            string(COMPANY)
                .label("Company")
                .description("Updated name of the company where the contact is employed")
                .required(false),
            string(EMAIL)
                .label("Email address")
                .description("Updated email address of the contact")
                .controlType(Property.ControlType.EMAIL)
                .required(false),
            string(PHONE_NUMBER)
                .label("Phone number")
                .description("Updated phone number of the contact")
                .controlType(Property.ControlType.PHONE)
                .required(false))
        .output(
            outputSchema(
                object()
                    .properties(
                        array("names")
                            .items(
                                object()
                                    .properties(
                                        string(FIRST_NAME),
                                        string(MIDDLE_NAME),
                                        string(LAST_NAME))),
                        array("organizations")
                            .items(
                                object()
                                    .properties(
                                        string(COMPANY),
                                        string(JOB_TITLE))),
                        array("emailAddresses")
                            .items(
                                object()
                                    .properties(
                                        string("value"))),
                        array("phoneNumbers")
                            .items(
                                object()
                                    .properties(
                                        string("value"))))))
        .perform(GoogleContactsUpdateContactAction::perform);

    public static Person perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext) throws IOException {

        PeopleService peopleService = GoogleServices.getPeopleService(connectionParameters);

        Person existingPerson = peopleService
            .people()
            .get(inputParameters.getRequiredString("resourceName"))
            .setPersonFields("names,emailAddresses,phoneNumbers,organizations")
            .execute();

        existingPerson
            .setNames(List.of(new Name()
                .setGivenName(inputParameters.getRequiredString(FIRST_NAME))
                .setMiddleName(inputParameters.getString(MIDDLE_NAME))
                .setFamilyName(inputParameters.getRequiredString(LAST_NAME))))
            .setEmailAddresses(List.of(new EmailAddress().setValue(inputParameters.getString(EMAIL))))
            .setPhoneNumbers(List.of(new PhoneNumber().setValue(inputParameters.getString(PHONE_NUMBER))))
            .setOrganizations(List.of(new Organization()
                .setTitle(inputParameters.getString(JOB_TITLE))
                .setName(inputParameters.getString(COMPANY))));

        return peopleService
            .people()
            .updateContact(inputParameters.getRequiredString("resourceName"), existingPerson)
            .setUpdatePersonFields("names,emailAddresses,phoneNumbers,organizations")
            .execute();
    }
}
