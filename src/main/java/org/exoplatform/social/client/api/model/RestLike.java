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
 * The like item of an activity.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public class RestLike extends Model {

  /**
   * The fields that represent the RestLike object in json form. <p/>
   * <p> All of the fields that RestLike can have.
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
   * Constructor without param.
   */
  public RestLike() {

  }

  /**
   * Constructor.
   *
   * @param activityId the activity id
   * @param identityId the identity id
   */
  public RestLike(String activityId, String identityId) {
    setActivityId(activityId);
    setIdentityId(identityId);
  }
  
  /**
   * Gets the activity id.
   *
   * @return the activity id
   */
  public String getActivityId() {
    return getFieldAsString(Field.ACTIVITY_ID.toString());
  }

  /**
   * Sets the activity id.
   *
   * @param activityId the activity id
   */
  public void setActivityId(String activityId) {
    setField(Field.ACTIVITY_ID.toString(), activityId);
  }

  /**
   * Gets the identity id.
   *
   * @return the identity id
   */
  public String getIdentityId() {
    return getFieldAsString(Field.IDENTITY_ID.toString());
  }

  /**
   * Sets the identity id.
   *
   * @param identityId the identity id
   */
  public void setIdentityId(String identityId) {
    setField(Field.IDENTITY_ID.toString(), identityId);
  }

  /**
   * Gets the activity associated with this like.
   * <p/>
   * This method must be lazy loading.
   *
   * @return the activity
   */
  public RestActivity getActivity() {
    //TODO implement this
    return null;
  }

  /**
   * Gets the identity associated with this like.
   * <p/>
   * This method must be lazy loading.
   *
   * @return the identity
   */
  public RestIdentity getIdentity() {
    //TODO implement this
    return null;
  }
}
