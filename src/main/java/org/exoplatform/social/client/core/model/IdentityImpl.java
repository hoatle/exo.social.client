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
package org.exoplatform.social.client.core.model;

import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.model.Profile;

/**
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 25, 2011
 */
public class IdentityImpl extends ModelImpl implements Identity {


  /**
   * Constructor without any param
   */
  public IdentityImpl() {

  }

  /**
   * Constructor.
   *
   * @param id         the identity id
   * @param providerId the identity provider id
   * @param remoteId   the remote id
   */
  public IdentityImpl(String id, String providerId, String remoteId) {
    setId(id);
    setProviderId(providerId);
    setRemoteId(remoteId);
  }

  /**
   * {@inheritDoc}
   */
  public String getId() {
    return getFieldAsString(Field.ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setId(String id) {
    setField(Field.ID.toString(), id);
  }

  /**
   * {@inheritDoc}
   */
  public String getProviderId() {
    return getFieldAsString(Field.PROVIDER_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setProviderId(String providerId) {
    setField(Field.PROVIDER_ID.toString(), providerId);
  }

  /**
   * {@inheritDoc}
   */
  public String getRemoteId() {
    return getFieldAsString(Field.REMOTE_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setRemoteId(String remoteId) {
    setField(Field.REMOTE_ID.toString(), remoteId);
  }

  /**
   * {@inheritDoc}
   */
  public Profile getProfile() {
    //TODO implement this
    return null;
  }
}
