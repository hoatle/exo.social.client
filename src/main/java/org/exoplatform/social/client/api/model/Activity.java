/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.social.client.api.model;

import java.util.Date;
import java.util.Map;

import org.exoplatform.social.client.api.common.ListAccess;

/**
 * eXo Social Activity model based on OpenSocial Activity Spec 0.8.1:
 * http://www.opensocial.org/Technical-Resources/opensocial-spec-v081/opensocial-reference#opensocial.Activity
 * and <tt>org.exoplatform.social.core.activity.model.ExoSocialActivity</tt> class on eXo Social project.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface Activity extends Model {

  /**
   * The fields that represent the activity object in json form.
   *
   * <p>
   * All of the fields that activities can have.
   * </p>
   * <p>
   * It is only OPTIONAL to set one of TITLE_ID or TITLE. In addition, if you are using any
   * variables in your title or title template, you must set TEMPLATE_PARAMS.
   * </p>
   * <p>
   * Other possible fields to set are: URL, MEDIA_ITEMS, BODY_ID, BODY, EXTERNAL_ID, PRIORITY,
   * STREAM_TITLE, STREAM_URL, STREAM_SOURCE_URL, and STREAM_FAVICON_URL.
   * </p>
   * <p>
   * Containers are only OPTIONAL to use TITLE_ID or TITLE, they may ignore additional parameters.
   * </p>
   *
   */
  public static enum Field {
    /** the json field for appId. */
    APP_ID("appId"),
    /** the json field for body. */
    BODY("body"),
    /** the json field for bodyId. */
    BODY_ID("bodyId"),
    /** the json field for externalId. */
    EXTERNAL_ID("externalId"),
    /** the json field for id. */
    ID("id"),
    /** the json field for updated. */
    LAST_UPDATED("updated"), /* Needed to support the RESTful api */
    /** the json field for mediaItems. */
    //MEDIA_ITEMS("mediaItems"), /* Not yet supported */
    /** the json field for postedTime. */
    POSTED_TIME("postedTime"),
    /** the json field for priority. */
    PRIORITY("priority"),
    /** the json field for streamFaviconUrl. */
    STREAM_FAVICON_URL("streamFaviconUrl"),
    /** the json field for streamSourceUrl. */
    STREAM_SOURCE_URL("streamSourceUrl"),
    /** the json field for streamTitle. */
    STREAM_TITLE("streamTitle"),
    /** the json field for streamUrl. */
    STREAM_URL("streamUrl"),
    /** the json field for templateParams. */
    TEMPLATE_PARAMS("templateParams"),
    /** the json field for title. */
    TITLE("title"),
    /** the json field for titleId. */
    TITLE_ID("titleId"),
    /** the json field for url. */
    URL("url"),
    /** the json field for userId. */
    USER_ID("userId");

    /**
     * The json field that the instance represents.
     */
    private final String jsonString;

    /**
     * create a field base on the a json element.
     *
     * @param jsonString the name of the element
     */
    private Field(String jsonString) {
      this.jsonString = jsonString;
    }

    /**
     * emit the field as a json element.
     *
     * @return the field name
     */
    @Override
    public String toString() {
      return jsonString;
    }
  }

  /**
   * Gets a string ID that is permanently associated with this activity. Container support for this
   * field is OPTIONAL.
   *
   * @return a string ID that is permanently associated with this activity.
   */
  String getId();

  /**
   * Sets a string ID that is permanently associated with this activity. Container support for this
   * field is OPTIONAL.
   *
   * @param id a string ID that is permanently associated with this activity.
   */
  void setId(String id);


  /**
   * Gets a string specifying the primary text of an activity. Container support for this field is
   * REQUIRED.
   *
   * Titles may only have the following HTML tags: &lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The
   * container may ignore this formatting when rendering the activity.
   *
   * @return astring specifying the primary text of an activity.
   */
  String getTitle();

  /**
   * Sets a string specifying the primary text of an activity. Container support for this field is
   * REQUIRED.
   *
   * Titles may only have the following HTML tags: &lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The
   * container may ignore this formatting when rendering the activity.
   *
   * @param title a string specifying the primary text of an activity.
   */
  void setTitle(String title);

  /**
   * Gets a string specifying the title template message ID in the gadget spec. Container support for
   * this field is REQUIRED.
   *
   * The title is the primary text of an activity. Titles may only have the following HTML tags:
   * <&lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The container may ignore this formatting when
   * rendering the activity.
   *
   * @return a string specifying the title template message ID in the gadget spec.
   */
  String getTitleId();

  /**
   * Sets a string specifying the title template message ID in the gadget spec. Container support for
   * this field is REQUIRED.
   *
   * The title is the primary text of an activity. Titles may only have the following HTML tags:
   * <&lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The container may ignore this formatting when
   * rendering the activity.
   *
   * @param titleId a string specifying the title template message ID in the gadget spec.
   */
  void setTitleId(String titleId);

  /**
   * Gets a string specifying the application that this activity is associated with. Container
   * support for this field is REQUIRED.
   *
   * @return A string specifying the application that this activity is associated with
   */
  String getAppId();

  /**
   * Sets a string specifying the application that this activity is associated with. Container
   * support for this field is REQUIRED.
   *
   * @param appId A string specifying the application that this activity is associated with
   */
  void setAppId(String appId);

  /**
   * Gets a string specifying an optional expanded version of an activity. Container support for this
   * field is OPTIONAL.
   *
   * @return a string specifying an optional expanded version of an activity.
   */
  String getBody();

  /**
   * Sets a string specifying an optional expanded version of an activity. Container support for this
   * field is OPTIONAL.
   *
   * Bodies may only have the following HTML tags:&lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The
   * container may ignore this formatting when rendering the activity.
   *
   * @param body a string specifying an optional expanded version of an activity.
   */
  void setBody(String body);

  /**
   * Gets a string specifying the body template message ID in the gadget spec. Container support for
   * this field is OPTIONAL.
   *
   * Bodies may only have the following HTML tags: &lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The
   * container may ignore this formatting when rendering the activity.
   *
   * @return a string specifying the body template message ID in the gadget spec.
   */
  String getBodyId();

  /**
   * Sets a string specifying the body template message ID in the gadget spec. Container support for
   * this field is OPTIONAL.
   *
   * @param bodyId a string specifying the body template message ID in the gadget spec.
   */
  void setBodyId(String bodyId);

  /**
   * Gets an optional string ID generated by the posting application. Container support for this
   * field is OPTIONAL.
   *
   * @return An optional string ID generated by the posting application.
   */
  String getExternalId();

  /**
   * Sets an optional string ID generated by the posting application. Container support for this
   * field is OPTIONAL.
   *
   * @param externalId An optional string ID generated by the posting application.
   */
  void setExternalId(String externalId);

  /**
   * Gets the time at which this activity took place in milliseconds since the epoch. Container
   * support for this field is OPTIONAL.
   *
   * Higher priority ones are higher in the list.
   *
   * @return The time at which this activity took place in milliseconds since the epoch
   */
  Long getPostedTime();

  /**
   * Sets the time at which this activity took place in milliseconds since the epoch Container
   * support for this field is OPTIONAL.
   *
   * This value can not be set by the end user.
   *
   * @param postedTime the time at which this activity took place in milliseconds since the epoch
   */
  void setPostedTime(Long postedTime);


  /**
   * Gets the last updated date of the Activity, additional to the Opensocial specification for the
   * REST-API. Container support for this field is OPTIONAL.
   *
   * @return the last updated date
   */
  Date getUpdated();

  /**
   * Sets the last updated date of the Activity, additional to the Opensocial specification for the
   * REST-API. Container support for this field is OPTIONAL.
   *
   * @param updated the last updated date
   */
  void setUpdated(Date updated);

  /**
   * Gets the priority, a number between 0 and 1 representing the relative priority of this activity
   * in relation to other activities from the same source. Container support for this field is
   * OPTIONAL.
   *
   * @return a number between 0 and 1 representing the relative priority of this activity in
   *         relation to other activities from the same source
   */
  Float getPriority();

  /**
   * Sets the priority, a number between 0 and 1 representing the relative priority of this activity
   * in relation to other activities from the same source. Container support for this field is
   * OPTIONAL.
   *
   * @param priority a number between 0 and 1 representing the relative priority of this activity in
   *                relation to other activities from the same source.
   */
  void setPriority(Float priority);

  /**
   * Gets a string specifying the URL for the stream's favicon. Container support for this field is
   * OPTIONAL.
   *
   * @return a string specifying the URL for the stream's favicon.
   */
  String getStreamFaviconUrl();

  /**
   * Sets a string specifying the URL for the stream's favicon. Container support for this field is
   * OPTIONAL.
   *
   * @param streamFaviconUrl a string specifying the URL for the stream's favicon.
   */
  void setStreamFaviconUrl(String streamFaviconUrl);

  /**
   * Gets a string specifying the stream's source URL. Container support for this field is OPTIONAL.
   *
   * @return a string specifying the stream's source URL.
   */
  String getStreamSourceUrl();

  /**
   * Sets a string specifying the stream's source URL. Container support for this field is OPTIONAL.
   *
   * @param streamSourceUrl a string specifying the stream's source URL.
   */
  void setStreamSourceUrl(String streamSourceUrl);

  /**
   * Gets a string specifying the title of the stream. Container support for this field is OPTIONAL.
   *
   * @return a string specifying the title of the stream.
   */
  String getStreamTitle();

  /**
   * Sets a string specifying the title of the stream. Container support for this field is OPTIONAL.
   *
   * @param streamTitle a string specifying the title of the stream.
   */
  void setStreamTitle(String streamTitle);

  /**
   * Gets a string specifying the stream's URL. Container support for this field is OPTIONAL.
   *
   * @return a string specifying the stream's URL.
   */
  String getStreamUrl();

  /**
   * Sets a string specifying the stream's URL. Container support for this field is OPTIONAL.
   *
   * @param streamUrl a string specifying the stream's URL.
   */
  void setStreamUrl(String streamUrl);

 /**
   * Gets a map of custom key/value pairs associated with this activity. Container support for this
   * field is OPTIONAL.
   *
   * @return a map of custom key/value pairs associated with this activity.
   */
  Map<String, String> getTemplateParams();

  /**
   * Set a map of custom key/value pairs associated with this activity. The data has type
   * {@link Map<String, Object>}. The object may be either a String or a Person. When
   * passing in a person with key PersonKey, can use the following replacement variables in the
   * template:
   * <ul>
   * <li>PersonKey.DisplayName - Display name for the person</li>
   * <li>PersonKey.ProfileUrl. URL of the person's profile</li>
   * <li>PersonKey.Id - The ID of the person</li>
   * <li>PersonKey - Container may replace with DisplayName, but may also optionally link to the
   * user.</li>
   * </ul>
   * Container support for this field is OPTIONAL.
   *
   * @param templateParams a map of custom key/value pairs associated with this activity.
   */
  void setTemplateParams(Map<String, String> templateParams);


  /**
   * Gets a string specifying the URL that represents this activity. Container support for this field
   * is OPTIONAL.
   *
   * @return a string specifying the URL that represents this activity.
   */
  String getUrl();

  /**
   * Sets a string specifying the URL that represents this activity. Container support for this field
   * is OPTIONAL.
   *
   * @param url a string specifying the URL that represents this activity.
   */
  void setUrl(String url);

  /**
   * Gets a string ID of the user who this activity is for. Container support for this field is
   * OPTIONAL.
   *
   * @return a string ID of the user who this activity is for.
   */
  String getUserId();

  /**
   * Sets a string ID of the user who this activity is for. Container support for this field is
   * OPTIONAL.
   *
   * @param userId a string ID of the user who this activity is for.
   */
  void setUserId(String userId);

  /**
   * Gets list access of likes.
   * This is eXo Social's extended feature.
   *
   * @return list of likes
   */
  ListAccess<Like> getLikes();

  /**
   * Gets list access of comments for this activity.
   * This is eXo Social's extended feature.
   *
   * @return list of comments.
   */
  ListAccess<Comment> getComments();

  /**
   * Returns the template parameter with the specified name.
   * This is a helper method.
   *
   * @param name name of template parameter whose value is to be returned
   * @return a string associated with a name
   */
  String getTemplateParameter(String name);

  /**
   * Adds a new template parameter with the specified name and value.
   * This is a helper method.
   *
   * @param name  name of new template parameter to add
   * @param value value of template parameter to associate with passed name
   */
  void addTemplateParameter(String name, String value);

}
