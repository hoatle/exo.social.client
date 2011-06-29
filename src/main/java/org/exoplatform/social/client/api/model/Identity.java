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
 * eXo Social Identity.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface Identity extends Model {

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
    REMOTE_ID("remoteId");

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
   * Gets the identity id.
   *
   * @return the identity id
   */
  String getId();

  /**
   * Sets the identity id.
   *
   * @param id the identity id
   */
  void setId(String id);

  /**
   * Gets identity provider id.
   *
   * @return the provider id
   */
  String getProviderId();

  /**
   * Sets identity provider id.
   *
   * @param providerId the provider id
   */
  void setProviderId(String providerId);

  /**
   * Gets the remote identity id.
   * @return the remote id
   */
  String getRemoteId();

  /**
   * Sets the remote identity id.
   *
   * @param remoteId the remote id
   */
  void setRemoteId(String remoteId);
}
