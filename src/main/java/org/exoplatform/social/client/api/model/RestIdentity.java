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

import org.exoplatform.social.client.api.util.SocialJSONDecodingSupport;
import org.json.simple.parser.ParseException;

/**
 * eXo Social Identity.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public class RestIdentity extends Model {

  /**
   * The fields that represent the Identity object in json form.
   *
   * <p>
   * All of the fields that comments can have.
   * </p>
   *
   */
  public static enum Field {
    /** the json field for identity id. */
    ID("id"),
    /** the json field for userId. */
    PROVIDER_ID("providerId"),
    /** the json field for activityId. */
    REMOTE_ID("remoteId"),
    /**the json profile object*/
    PROFILE("profile");

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
   * The associated restProfile with this identity.
   */
  private RestProfile restProfile;

  /**
   * Constructor without any param.
   */
  public RestIdentity() {

  }

  /**
   * Constructor.
   *
   * @param id         the identity id
   * @param providerId the identity provider id
   * @param remoteId   the remote id
   */
  public RestIdentity(String id, String providerId, String remoteId, RestProfile restProfile) {
    setId(id);
    setProviderId(providerId);
    setRemoteId(remoteId);
    setProfile(restProfile);
  }
  
  /**
   * Gets the identity id.
   *
   * @return the identity id
   */
  public String getId() {
    return getFieldAsString(Field.ID.toString());
  }

  /**
   * Sets the identity id.
   *
   * @param id the identity id
   */
  public void setId(String id) {
    setField(Field.ID.toString(), id);
  }

  /**
   * Gets identity provider id.
   *
   * @return the provider id
   */
  public String getProviderId() {
    return getFieldAsString(Field.PROVIDER_ID.toString());
  }

  /**
   * Sets identity provider id.
   *
   * @param providerId the provider id
   */
  public void setProviderId(String providerId) {
    setField(Field.PROVIDER_ID.toString(), providerId);
  }

  /**
   * Gets the remote identity id.
   * @return the remote id
   */
  public String getRemoteId() {
    return getFieldAsString(Field.REMOTE_ID.toString());
  }

  /**
   * Sets the remote identity id.
   *
   * @param remoteId the remote id
   */
  public void setRemoteId(String remoteId) {
    setField(Field.REMOTE_ID.toString(), remoteId);
  }

  /**
   * Gets the profile associated with this identity.
   *
   * @return the associated profile.
   */
  public RestProfile getProfile() {
    String jsonProfile = getFieldAsString(Field.PROFILE.toString());
    try {
      return jsonProfile == null ? new RestProfile() : SocialJSONDecodingSupport.parser(RestProfile.class, jsonProfile);
    } catch (ParseException pex) {
      return new RestProfile();
    }
  }

  /**
   * Sets the profile associated with this identity.
   *
   * @param restProfile the associated profile.
   */
  public void setProfile(RestProfile restProfile) {
    this.restProfile = restProfile;
  }
}
