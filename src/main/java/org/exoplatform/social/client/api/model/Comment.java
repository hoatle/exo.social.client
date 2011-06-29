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

/**
 * The Comment model.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface Comment extends Model {

  /**
   * The fields that represent the Comment object in json form.
   *
   * <p>
   * All of the fields that comments can have.
   * </p>
   *
   */
  public static enum Field {
    ID("id"),
    /** the json field for userId. */
    IDENTITY_ID("identityId"),
    /** the json field for activityId. */
    ACTIVITY_ID("activityId"),
     /** the json field for streamTitle. */
    CONTENT("content"),
    /** the json field for postedTime. */
    POSTED_TIME("postedTime"),
    /** the json field for createdAt. */
    CREATED_AT("createdAt");

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
   * Gets the comment id.
   *
   * @return the comment id
   */
  String getId();

  /**
   * Sets the comment id.
   *
   * @param id the comment id
   */
  void setId(String id);

  /**
   * Gets identity id who posted this comment.
   *
   * @return the identity id
   */
  String getIdentityId();

  /**
   * Sets identity id who posted this comment.
   *
   * @param identidyId the identity id
   */
  void setIdentityId(String identidyId);

  /**
   * Gets the activity id which is associated with this comment.
   *
   * @return the activity id.
   */
  String getActivityId();

  /**
   * Sets the activity which is associated with this comment.
   *
   * @param activityId the activity id
   */
  void setActivityId(String activityId);

  /**
   * Gets the comment content.
   *
   * @return the comment content.
   */
  String getContent();

  /**
   * Sets the comment content.
   *
   * @param content the comment content
   */
  void setContent(String content);

  /**
   * Gets the posted time of this comment as timestamp value.
   *
   * @return the posted time of this comment
   */
  Long getPostedTime();

  /**
   * Sets the posted time of this comment as timestamp value.
   *
   * @param postedTime the posted time of this comment.
   */
  void setPostedTime(Long postedTime);

  /**
   * Gets the created at of this comment as a time string value.
   *
   * @return the time string value
   */
  String getCreatedAt();

  /**
   * Sets the created at of this comment as a time string value.
   *
   * @param createdAt the time string value
   */
  void setCreatedAt(String createdAt);

  /**
   * Gets the activity is associated with this comment.
   *
   * This must be lazy loading for better performance.
   *
   * @return the activity
   */
  Activity getActivity();

  /**
   * Gets the identity who commented.
   *
   * This must be lazy loading for better performance.
   *
   * @return the identity
   */
  Identity getIdentity();
}
