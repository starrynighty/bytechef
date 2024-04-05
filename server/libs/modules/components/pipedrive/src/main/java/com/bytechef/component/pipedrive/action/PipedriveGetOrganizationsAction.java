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

package com.bytechef.component.pipedrive.action;

import static com.bytechef.component.OpenApiComponentHandler.PropertyType;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.array;
import static com.bytechef.component.definition.ComponentDSL.bool;
import static com.bytechef.component.definition.ComponentDSL.integer;
import static com.bytechef.component.definition.ComponentDSL.object;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.definition.Context.Http.ResponseType;

import com.bytechef.component.definition.ComponentDSL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Provides a list of the component actions.
 *
 * @generated
 */
public class PipedriveGetOrganizationsAction {
    public static final ComponentDSL.ModifiableActionDefinition ACTION_DEFINITION = action("getOrganizations")
        .title("Get all organizations")
        .description("Returns all organizations.")
        .metadata(
            Map.of(
                "method", "GET",
                "path", "/organizations"

            ))
        .properties(integer("user_id").label("User Id")
            .description(
                "If supplied, only organizations owned by the given user will be returned. However, `filter_id` takes precedence over `user_id` when both are supplied.")
            .required(false)
            .metadata(
                Map.of(
                    "type", PropertyType.QUERY)),
            integer("filter_id").label("Filter Id")
                .description("The ID of the filter to use")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            string("first_char").label("First Char")
                .description(
                    "If supplied, only organizations whose name starts with the specified letter will be returned (case insensitive)")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            integer("start").label("Start")
                .description("Pagination start")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            integer("limit").label("Limit")
                .description("Items shown per page")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            string("sort").label("Sort")
                .description(
                    "The field names and sorting mode separated by a comma (`field_name_1 ASC`, `field_name_2 DESC`). Only first-level field keys are supported (no nested keys).")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)))
        .outputSchema(
            object()
                .properties(
                    object("additional_data")
                        .properties(object("pagination").properties(integer("start").description("Pagination start")
                            .required(false),
                            integer("limit").description("Items shown per page")
                                .required(false),
                            bool("more_items_in_collection").description(
                                "Whether there are more list items in the collection than displayed")
                                .required(false),
                            integer("next_start").description("Next pagination start")
                                .required(false))
                            .description("Pagination details of the list")
                            .required(false))
                        .required(false),
                    array("data")
                        .items(
                            object()
                                .properties(
                                    string("address_route").description("The route of the organization location")
                                        .required(false),
                                    integer("related_closed_deals_count").description(
                                        "The count of related closed deals related with the item")
                                        .required(false),
                                    integer("email_messages_count")
                                        .description("The count of email messages related to the organization")
                                        .required(false),
                                    string("name").description("The name of the user")
                                        .required(false),
                                    integer("has_pic")
                                        .description(
                                            "Whether the user has picture or not. 0 = No picture, 1 = Has picture.")
                                        .required(false),
                                    bool("active_flag").description("Whether the user is active or not")
                                        .required(false),
                                    integer("id").description("The ID of the user")
                                        .required(false),
                                    integer("value").description("The ID of the owner")
                                        .required(false),
                                    string("email").description("The email of the user")
                                        .required(false),
                                    string("pic_hash").description("The user picture hash")
                                        .required(false),
                                    string("cc_email").description("The BCC email of the organization")
                                        .required(false),
                                    integer("open_deals_count")
                                        .description("The count of open deals related with the item")
                                        .required(false),
                                    bool("active_flag").description("Whether the organization is active or not")
                                        .required(false),
                                    string("update_time").description("The update time of the picture")
                                        .required(false),
                                    integer("added_by_user_id").description("The ID of the user who added the picture")
                                        .required(false),
                                    integer("item_id").description("The ID of related item")
                                        .required(false),
                                    string("item_type").description("The type of item the picture is related to")
                                        .required(false),
                                    bool("active_flag").description("Whether the associated picture is active or not")
                                        .required(false),
                                    integer("value").description("The ID of the picture associated with the item")
                                        .required(false),
                                    string("add_time").description("The add time of the picture")
                                        .required(false),
                                    object("pictures")
                                        .properties(string("128").description("The URL of the 128*128 picture")
                                            .required(false),
                                            string("512").description("The URL of the 512*512 picture")
                                                .required(false))
                                        .required(false),
                                    integer("people_count")
                                        .description("The count of persons related to the organization")
                                        .required(false),
                                    integer("last_activity_id")
                                        .description("The ID of the last activity associated with the deal")
                                        .required(false),
                                    string("next_activity_date")
                                        .description("The date of the next activity associated with the deal")
                                        .required(false),
                                    string("update_time")
                                        .description("The last updated date and time of the organization")
                                        .required(false),
                                    integer("activities_count")
                                        .description("The count of activities related to the organization")
                                        .required(false),
                                    integer("id").description("The ID of the organization")
                                        .required(false),
                                    string("address_admin_area_level_2")
                                        .description("The level 2 admin area of the organization location")
                                        .required(false),
                                    integer("won_deals_count")
                                        .description("The count of won deals related with the item")
                                        .required(false),
                                    string("address_admin_area_level_1")
                                        .description("The level 1 admin area of the organization location")
                                        .required(false),
                                    string("address_street_number")
                                        .description("The street number of the organization location")
                                        .required(false),
                                    string("owner_name").description("The name of the organization owner")
                                        .required(false),
                                    integer("files_count").description("The count of files related to the organization")
                                        .required(false),
                                    string("address").description("The full address of the organization")
                                        .required(false),
                                    integer("company_id")
                                        .description("The ID of the company related to the organization")
                                        .required(false),
                                    string("address_formatted_address")
                                        .description("The formatted organization location")
                                        .required(false),
                                    string("address_postal_code")
                                        .description("The postal code of the organization location")
                                        .required(false),
                                    integer("related_won_deals_count")
                                        .description("The count of related won deals related with the item")
                                        .required(false),
                                    string("address_country").description("The country of the organization location")
                                        .required(false),
                                    string("first_char").description("The first character of the organization name")
                                        .required(false),
                                    integer("undone_activities_count")
                                        .description("The count of undone activities related to the organization")
                                        .required(false),
                                    integer("closed_deals_count")
                                        .description("The count of closed deals related with the item")
                                        .required(false),
                                    string("address_subpremise")
                                        .description("The sub-premise of the organization location")
                                        .required(false),
                                    string("last_activity_date")
                                        .description("The date of the last activity associated with the deal")
                                        .required(false),
                                    integer("label").description("The ID of the label")
                                        .required(false),
                                    integer("related_open_deals_count")
                                        .description("The count of related open deals related with the item")
                                        .required(false),
                                    integer("related_lost_deals_count")
                                        .description("The count of related lost deals related with the item")
                                        .required(false),
                                    integer("next_activity_id")
                                        .description("The ID of the next activity associated with the deal")
                                        .required(false),
                                    string("country_code").description("The country code of the organization")
                                        .required(false),
                                    string("visible_to")
                                        .description("The visibility group ID of who can see the organization")
                                        .required(false),
                                    integer("notes_count").description("The count of notes related to the organization")
                                        .required(false),
                                    integer("followers_count")
                                        .description("The count of followers related to the organization")
                                        .required(false),
                                    string("name").description("The name of the organization")
                                        .required(false),
                                    string("address_sublocality")
                                        .description("The sub-locality of the organization location")
                                        .required(false),
                                    string("address_locality").description("The locality of the organization location")
                                        .required(false),
                                    integer("lost_deals_count")
                                        .description("The count of lost deals related with the item")
                                        .required(false),
                                    string("next_activity_time")
                                        .description("The time of the next activity associated with the deal")
                                        .required(false),
                                    string("add_time").description("The creation date and time of the organization")
                                        .required(false),
                                    integer("done_activities_count").description(
                                        "The count of done activities related to the organization")
                                        .required(false))
                                .description("The array of organizations"))
                        .description("The array of organizations")
                        .required(false),
                    object("related_objects")
                        .properties(object("organization").additionalProperties(object().properties(integer("id")
                            .description("The ID of the organization associated with the item")
                            .required(false),
                            string("name").description("The name of the organization associated with the item")
                                .required(false),
                            integer("people_count").description(
                                "The number of people connected with the organization that is associated with the item")
                                .required(false),
                            integer("owner_id").description(
                                "The ID of the owner of the organization that is associated with the item")
                                .required(false),
                            string("address").description("The address of the organization")
                                .required(false),
                            string("cc_email").description("The BCC email of the organization associated with the item")
                                .required(false)))
                            .required(false),
                            object("user")
                                .additionalProperties(object().properties(
                                    integer("id").description("The ID of the user")
                                        .required(false),
                                    string("name").description("The name of the user")
                                        .required(false),
                                    string("email").description("The email of the user")
                                        .required(false),
                                    integer("has_pic")
                                        .description(
                                            "Whether the user has picture or not. 0 = No picture, 1 = Has picture.")
                                        .required(false),
                                    string("pic_hash").description("The user picture hash")
                                        .required(false),
                                    bool("active_flag").description("Whether the user is active or not")
                                        .required(false)))
                                .required(false),
                            object("picture")
                                .additionalProperties(object().properties(
                                    integer("id").description("The ID of the picture associated with the item")
                                        .required(false),
                                    string("item_type").description("The type of item the picture is related to")
                                        .required(false),
                                    integer("item_id").description("The ID of related item")
                                        .required(false),
                                    bool("active_flag").description("Whether the associated picture is active or not")
                                        .required(false),
                                    string("add_time").description("The add time of the picture")
                                        .required(false),
                                    string("update_time").description("The update time of the picture")
                                        .required(false),
                                    integer("added_by_user_id").description("The ID of the user who added the picture")
                                        .required(false),
                                    object("pictures")
                                        .properties(string("128").description("The URL of the 128*128 picture")
                                            .required(false),
                                            string("512").description("The URL of the 512*512 picture")
                                                .required(false))
                                        .required(false)))
                                .description("The picture that is associated with the item")
                                .required(false))
                        .required(false),
                    bool("success").description("If the response is successful or not")
                        .required(false))
                .metadata(
                    Map.of(
                        "responseType", ResponseType.JSON)))
        .sampleOutput(Map.<String, Object>ofEntries(Map.entry("success", true),
            Map.entry("data",
                List.of(Map.<String, Object>ofEntries(Map.entry("id", 1), Map.entry("company_id", 77),
                    Map.entry("owner_id",
                        Map.<String, Object>ofEntries(Map.entry("id", 10), Map.entry("name", "Will Smith"),
                            Map.entry("email", "will.smith@pipedrive.com"), Map.entry("has_pic", 0),
                            Map.entry("pic_hash",
                                "2611ace8ac6a3afe2f69ed56f9e08c6b"),
                            Map.entry("active_flag", true), Map.entry("value", 10))),
                    Map.entry("name", "Bolt"), Map.entry("open_deals_count", 1),
                    Map.entry("related_open_deals_count", 2), Map.entry("closed_deals_count", 3),
                    Map.entry("related_closed_deals_count", 1), Map.entry("email_messages_count", 2),
                    Map.entry("people_count", 1), Map.entry("activities_count", 2),
                    Map.entry("done_activities_count", 1), Map.entry("undone_activities_count", 0),
                    Map.entry("files_count", 0), Map.entry("notes_count", 0), Map.entry("followers_count", 1),
                    Map.entry("won_deals_count", 0), Map.entry("related_won_deals_count", 0),
                    Map.entry("lost_deals_count", 0), Map.entry("related_lost_deals_count", 0),
                    Map.entry("active_flag", true),
                    Map.entry("picture_id", Map.<String, Object>ofEntries(Map.entry("item_type", "person"),
                        Map.entry("item_id", 25), Map.entry("active_flag", true),
                        Map.entry("add_time", "2020-09-08 08:17:52"), Map.entry("update_time", "0000-00-00 00:00:00"),
                        Map.entry("added_by_user_id", 967055),
                        Map.entry("pictures", Map.<String, Object>ofEntries(Map.entry("128",
                            "https://pipedrive-profile-pics.s3.example.com/f8893852574273f2747bf6ef09d11cf14ac8f269_128.jpg"),
                            Map.entry("512",
                                "https://pipedrive-profile-pics.s3.example.com/f8893852574273f2747bf6ef09d11cfb2ac8f269_512.jpg"))),
                        Map.entry("value", 101))),
                    Map.entry("country_code", "USA"), Map.entry("first_char", "b"),
                    Map.entry("update_time", "2020-09-08 12:14:11"), Map.entry("add_time", "2020-02-25 10:04:08"), Map
                        .entry("visible_to", 3.0),
                    Map.entry("next_activity_date", LocalDate.of(2019, 11, 29)),
                    Map.entry("next_activity_time", "11:30:00"), Map.entry("next_activity_id", 128), Map.entry(
                        "last_activity_id", 34),
                    Map.entry("last_activity_date", LocalDate.of(2019, 11, 28)), Map.entry("label", 7),
                    Map.entry("address", "Mustamäe tee 3a, 10615 Tallinn"), Map.entry("address_subpremise", ""),
                    Map.entry("address_street_number", "3a"), Map.entry("address_route", "Mustamäe tee"),
                    Map.entry("address_sublocality", "Kristiine"), Map.entry("address_locality", "Tallinn"),
                    Map.entry("address_admin_area_level_1", "Harju maakond"),
                    Map.entry("address_admin_area_level_2", ""), Map.entry("address_country", "Estonia"), Map.entry(
                        "address_postal_code", 10616.0),
                    Map.entry("address_formatted_address", "Mustamäe tee 3a, 10616 Tallinn, Estonia"), Map
                        .entry("owner_name", "John Doe"),
                    Map.entry("cc_email", "org@pipedrivemail.com")))),
            Map.entry("additional_data",
                Map.<String, Object>ofEntries(Map.entry("pagination",
                    Map.<String, Object>ofEntries(Map.entry("start", 0), Map.entry("limit", 100),
                        Map.entry("more_items_in_collection", false), Map.entry("next_start", 100))))),
            Map.entry(
                "related_objects", Map
                    .<String, Object>ofEntries(
                        Map.entry("organization",
                            Map.<String, Object>ofEntries(Map.entry("1", Map.<String, Object>ofEntries(
                                Map.entry("id", 1), Map.entry("name", "Org Name"), Map.entry("people_count", 1),
                                Map.entry("owner_id", 123), Map.entry("address", "Mustamäe tee 3a, 10615 Tallinn"),
                                Map.entry("active_flag", true), Map.entry("cc_email", "org@pipedrivemail.com"))))),
                        Map.entry("user", Map.<String, Object>ofEntries(Map.entry("123",
                            Map.<String, Object>ofEntries(Map.entry("id", 123), Map.entry("name", "Jane Doe"),
                                Map.entry("email", "jane@pipedrive.com"), Map.entry("has_pic", 1),
                                Map.entry("pic_hash", "2611ace8ac6a3afe2f69ed56f9e08c6b"),
                                Map.entry("active_flag", true))))),
                        Map.entry("picture", Map.<String, Object>ofEntries(Map.entry("1", Map.<String, Object>ofEntries(
                            Map.entry("id", 1), Map.entry("item_type", "person"), Map.entry("item_id", 25),
                            Map.entry("active_flag", true), Map.entry("add_time", "2020-09-08 08:17:52"),
                            Map.entry("update_time", "0000-00-00 00:00:00"), Map.entry("added_by_user_id", 967055),
                            Map.entry("pictures", Map.<String, Object>ofEntries(Map.entry(
                                "128",
                                "https://pipedrive-profile-pics.s3.example.com/f8893852574273f2747bf6ef09d11cfb4ac8f269_128.jpg"),
                                Map.entry("512",
                                    "https://pipedrive-profile-pics.s3.example.com/f8893852574273f2747bf6ef09d11cfb4ac8f269_512.jpg")))))))))));

    private PipedriveGetOrganizationsAction() {
    }
}
