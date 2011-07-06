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
package org.exoplatform.social.client.core.model;

import org.exoplatform.social.client.api.model.RestProfile;

/**
 * Implementation of {@link org.exoplatform.social.client.api.model.RestProfile}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 29, 2011
 */
public class RestProfileImpl extends ModelImpl implements RestProfile {

  /**
   * Default constructor.
   */
  public RestProfileImpl() {

  }

  /**
   * Constructor to set values.
   *
   * @param identityId the identity id
   * @param fullName   the full name
   * @param avatarUrl  the avatar url
   */
  public RestProfileImpl(String identityId, String fullName, String avatarUrl) {
    setIdentityId(identityId);
    setFullName(fullName);
    setAvatarUrl(avatarUrl);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getIdentityId() {
    return getFieldAsString(Field.IDENTITY_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setIdentityId(String identityId) {
    setField(Field.IDENTITY_ID.toString(), identityId);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getFullName() {
    return getFieldAsString(Field.FULL_NAME.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setFullName(String fullName) {
    setField(Field.FULL_NAME.toString(), fullName);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getAvatarUrl() {
    return getFieldAsString(Field.AVATAR_URL.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setAvatarUrl(String avatarUrl) {
    setField(Field.AVATAR_URL.toString(), avatarUrl);
  }
}
