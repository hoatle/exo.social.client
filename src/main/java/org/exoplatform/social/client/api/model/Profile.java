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
 * eXo Social Profile Model: for information for identities.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface Profile extends Model {
  /**
   * The fields that represent the Profile object in json form. <p/> </p>
   */
  public static enum Field {
    /**
     * The json field for identityId.
     */
    IDENTITY_ID("identityId"),

    /**
     * The json field for fullName.
     */
    FULL_NAME("fullName"),

    /**
     * The json field for avatarUrl.
     */
    AVATAR_URL("avatarUrl");

    /**
     * The json field that the instance represents.
     */
    private final String jsonString;

    /**
     * Creates a field base on the a json element.
     *
     * @param jsonString the name of the element
     */
    private Field(String jsonString) {
      this.jsonString = jsonString;
    }

    /**
     * Emits the field as a json element.
     *
     * @return the field name
     */
    @Override
    public String toString() {
      return jsonString;
    }
  }

  /**
   * Gets the identity id associated with this profile.
   *
   * @return the identity id
   */
  String getIdentityId();

  /**
   * Sets the identity id associated with this profile.
   *
   * @param identityId the identity id
   */
  void setIdentityId(String identityId);

  /**
   * Gets the full name of the associated identity.
   *
   * @return the full name
   */
  String getFullName();

  /**
   * Sets the full name of the associated identity.
   *
   * @param fullName the full name
   */
  void setFullName(String fullName);

  /**
   * Gets the avatar url of the associated identity.
   *
   * @return the avatar url
   */
  String getAvatarUrl();

  /**
   * Sets the avatar url of the associated identity.
   *
   * @param avatarUrl the avatar url
   */
  void setAvatarUrl(String avatarUrl);

}