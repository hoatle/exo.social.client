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

import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.model.RestProfile;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.json.simple.parser.ParseException;

/**
 * Implementation of {@link org.exoplatform.social.client.api.model.RestIdentity}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 25, 2011
 */
public class RestIdentityImpl extends ModelImpl implements RestIdentity {

  /**
   * The associated restProfile with this identity.
   */
  private RestProfile restProfile;

  /**
   * Constructor without any param.
   */
  public RestIdentityImpl() {

  }

  /**
   * Constructor.
   *
   * @param id         the identity id
   * @param providerId the identity provider id
   * @param remoteId   the remote id
   */
  public RestIdentityImpl(String id, String providerId, String remoteId, RestProfile restProfile) {
    setId(id);
    setProviderId(providerId);
    setRemoteId(remoteId);
    setProfile(restProfile);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getId() {
    return getFieldAsString(Field.ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setId(String id) {
    setField(Field.ID.toString(), id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getProviderId() {
    return getFieldAsString(Field.PROVIDER_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setProviderId(String providerId) {
    setField(Field.PROVIDER_ID.toString(), providerId);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getRemoteId() {
    return getFieldAsString(Field.REMOTE_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setRemoteId(String remoteId) {
    setField(Field.REMOTE_ID.toString(), remoteId);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RestProfile getProfile() {
    String jsonProfile = getFieldAsString(Field.PROFILE.toString());
    try {
      return jsonProfile == null ? new RestProfileImpl() : SocialJSONDecodingSupport.parser(RestProfileImpl.class, jsonProfile);
    } catch (ParseException pex) {
      return new RestProfileImpl();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setProfile(RestProfile newRestProfile) {
    this.restProfile = newRestProfile;
  }

}
