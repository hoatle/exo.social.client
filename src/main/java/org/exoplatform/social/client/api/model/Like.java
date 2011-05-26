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

/**
 * The like item of an activity.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface Like extends Model {

  /**
   * The fields that represent the Identity object in json form. <p/> <p> All of the fields that comments can have.
   * </p>
   */
  public static enum Field {
    /**
     * the json field for activityId.
     */
    ACTIVITY_ID("activityId"),
    /**
     * the json field for identityId.
     */
    IDENTITY_ID("identityId");

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
   * Gets the activity id.
   *
   * @return the activity id
   */
  String getActivityId();

  /**
   * Sets the activity id.
   *
   * @param activityId the activity id
   */
  void setActivityId(String activityId);

  /**
   * Gets identity id.
   *
   * @return the identity id
   */
  String getIdentityId();

  /**
   * Sets identity id.
   *
   * @param identityId the identity id
   */
  void setIdentityId(String identityId);

  /**
   * Gets the activity associated with this like.
   * <p/>
   * This method must be lazy loading.
   *
   * @return the activity
   */
  Activity getActivity();

  /**
   * Gets the identity associated with this like.
   * <p/>
   * This method must be lazy loading.
   *
   * @return the identity
   */
  Identity getIdentity();
}
