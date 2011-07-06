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

import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.model.Like;

/**
 * Implementation of {@link Like}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 20, 2011
 */
public class LikeImpl extends ModelImpl implements Like {

  /**
   * Constructor without param.
   */
  public LikeImpl() {

  }

  /**
   * Constructor.
   *
   * @param activityId the activity id
   * @param identityId the identity id
   */
  public LikeImpl(String activityId, String identityId) {
    setActivityId(activityId);
    setIdentityId(identityId);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getActivityId() {
    return getFieldAsString(Field.ACTIVITY_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setActivityId(String activityId) {
    setField(Field.ACTIVITY_ID.toString(), activityId);
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
  public RestActivity getActivity() {
    //TODO implement this
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RestIdentity getIdentity() {
    //TODO implement this
    return null;
  }

}
