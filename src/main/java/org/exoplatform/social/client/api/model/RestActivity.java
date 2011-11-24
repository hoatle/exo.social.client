/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.social.client.api.model;

import org.exoplatform.social.client.api.SocialClientLibException;

import java.util.List;
import java.util.Map;

/**
 * eXo Social Activity model based on OpenSocial Activity Spec 0.8.1:
 * http://www.opensocial.org/Technical-Resources/opensocial-spec-v081/opensocial-reference#opensocial.Activity
 * and <tt>org.exoplatform.social.core.activity.model.ExoSocialActivity</tt> class on eXo Social project.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface RestActivity extends Model {
  public final static String DOC_ACTIVITY_TYPE = "DOC_ACTIVITY";
  public final static String DEFAULT_ACTIVITY_TYPE = "DEFAULT_ACTIVITY";
  public final static String LINK_ACTIVITY_TYPE = "LINK_ACTIVITY";
  
  /**
   * The fields that represent the activity object in json form.
   */
  public static enum Field {
    /** the json field for id. */
    ID("id"),
    /** the json field for title. */
    TITLE("title"),
    /** the json field for body. */
    BODY("body"),
    /** the json field for appId. */
    APP_ID("appId"),
    /** the json field for type. */
    TYPE("type"),
    /** the json field for postedTime. */
    POSTED_TIME("postedTime"),
    /** the json field for posterIdentity. */
    POSTER_IDENTITY("posterIdentity"),
    /** the json field for createdAt. */
    CREATED_AT("createdAt"),
    /** the json field for priority. */
    PRIORITY("priority"),
    /** the json field for templateParams. */
    TEMPLATE_PARAMS("templateParams"),
    /** the json field for titleId. */
    TITLE_ID("titleId"),
    /** the json field for identityId. */
    IDENTITY_ID("identityId"),
    /** the json field for liked. */
    LIKED("liked"),
    /** the json field for likedByIdentities */
    LIKED_BY_IDENTITIES("likedByIdentities"),
    /** the json field for Comments */
    COMMENTS("comments"),
    /** the json field for numberOfCommens */
    TOTAL_NUMBER_OF_COMMENTS("totalNumberOfComments"),
    /** the json field for numberOfLikes */
    TOTAL_NUMBER_OF_LIKES("totalNumberOfLikes"),
    /** the json field for activityStream */
    ACTIVITY_STREAM("activityStream");

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
   * Sets the body fields of Activity, this field is optional and use to storage the extended attribute of activity.
   * @param body
   */
  void setBody(String body);
  
  /**
   * gets the body fields of Activity, this field is optional and use to storage the extended attribute of activity.
   * @return
   */
  String getBody();
  
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
   * Gets a string specifying the type of activity. Container support for this field is REQUIRED.
   *
   * @return A string specifying the application that this activity is associated with
   */
  String getType();

  /**
   * Sets a string specifying the type of activity. Container support for this field is REQUIRED.
   *
   * @param appId A string specifying the application that this activity is associated with
   */
  void setType(String type);
  
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
   * Gets the priority, a number between 0 and 1 representing the relative priority of this activity
   * in relation to other activities from the same source. Container support for this field is
   * OPTIONAL.
   *
   * @return a number between 0 and 1 representing the relative priority of this activity in
   *         relation to other activities from the same source
   */
  Double getPriority();

  /**
   * Sets the priority, a number between 0 and 1 representing the relative priority of this activity
   * in relation to other activities from the same source. Container support for this field is
   * OPTIONAL.
   *
   * @param priority a number between 0 and 1 representing the relative priority of this activity in
   *                relation to other activities from the same source.
   */
  void setPriority(Double priority);

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
   * Gets a string uuid of the identity who created this activity.
   *
   * @return a string ID of the identity who created this activity.
   */
  String getIdentityId();

  /**
   * Sets a string uuid of the identity who created this activity.
   *
   * @param identityId a string ID of the identity who created this activity.
   */
  void setIdentityId(String identityId);

  /**
   * Checks if this activity is liked by current user.
   *
   * @return boolean value
   */
  boolean isLiked();

  /**
   * Gets the poster identity who created this activity.
   *
   * @return the poster identity
   */
  RestIdentity getPosterIdentity() throws SocialClientLibException;

  /**
   * Gets the available list of comments for this activity.
   * Return Number of latest comments of this activity.
   *
   * @return Number of latest comments
   * @see #getTotalComments()
   */
  List<RestComment> getAvailableComments();
  
  /**
   * Gets the available list of likes for this activity.
   * Return Number of latest likes of this activity.
   *
   * @return Number of latest likes
   * @see #getTotalLikes()
   */
  List<RestIdentity> getAvailableLikes();

  /**
   * Sets the available list of comments for this activity.
   *
   * @param restCommentList available comment list
   */
  void setAvailableComments(List<RestComment> restCommentList);


  /**
   * Gets the number of total comments.
   *
   * @return the the number of total comments
   */
  int getTotalNumberOfComments();

  /**
   * Gets the total number of comments.
   *
   * @return the total comment list
   */
  List<RestComment> getTotalComments() throws SocialClientLibException;
  
  /**
   * Gets the number of total likes.
   *
   * @return the the number of total likes
   */
  int getTotalNumberOfLikes();

  /**
   * Gets the total number of likes.
   *
   * @return the total like list
   */
  List<RestIdentity> getTotalLikes() throws SocialClientLibException;

  /**
   * Gets activity stream.
   *
   * This is lazy loading.
   *
   * @return the associated activity stream.
   */
  RestActivityStream getActivityStream() throws SocialClientLibException;


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
