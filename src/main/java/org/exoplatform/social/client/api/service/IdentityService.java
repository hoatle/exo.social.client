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
package org.exoplatform.social.client.api.service;

import org.exoplatform.social.client.api.SocialClientLibException;

/**
 * eXo Social Account Service
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 19, 2011
 */
public interface IdentityService<Identity> extends Service<Identity> {

  /**
   * Gets an identity by its identity provider and remote id.
   *
   * @param identityProvider the identity provider
   * @param remoteId the remote id
   * @return the identity
   * @throws ServiceException
   * @since  1.0.0-alpha2
   */
  Identity getIdentity(String identityProvider, String remoteId) throws SocialClientLibException;

  
  /**
   * Gets the identity id from a remote id.
   *
   * @param remoteId the remote id
   * @return the uuid
   * @deprecated Use {@link #getIdentity(String, String)} then getIdentityId() instead.
   */
  @Deprecated
  String getIdentityId(String provider, String remoteId) throws SocialClientLibException;
}
