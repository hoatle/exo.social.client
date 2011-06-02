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
   * @param userId the user id
   */
  public LikeImpl(String activityId, String userId) {
    setActivityId(activityId);
    setUserId(userId);
  }

  /**
   * {@inheritDoc}
   */
  public String getActivityId() {
    return getFieldAsString(Field.ACTIVITY_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setActivityId(String activityId) {
    setField(Field.ACTIVITY_ID.toString(), activityId);
  }

  /**
   * {@inheritDoc}
   */
  public String getUserId() {
    return getFieldAsString(Field.USER_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setUserId(String userId) {
    setField(Field.USER_ID.toString(), userId);
  }

  /**
   * {@inheritDoc}
   */
  public Activity getActivity() {
    //TODO implement this
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public Identity getIdentity() {
    //TODO implement this
    return null;
  }

}
