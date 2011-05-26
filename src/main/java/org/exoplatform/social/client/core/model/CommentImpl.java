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


import org.exoplatform.social.client.api.model.Activity;
import org.exoplatform.social.client.api.model.Comment;
import org.exoplatform.social.client.api.model.Identity;

/**
 * Implementation of {@link Comment}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 26, 2011
 */
public class CommentImpl extends ModelImpl implements Comment {

  /**
   * Constructor without any params.
   */
  public CommentImpl() {

  }

  /**
   * Constructor.
   *
   * @param id         the comment id
   * @param userId     the user id
   * @param activityId the activity id
   * @param postedTime the posted time
   */
  public CommentImpl(String id, String userId, String activityId, Long postedTime) {
    setId(id);
    setUserId(userId);
    setActivityId(activityId);
    setPostedTime(postedTime);
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
  public String getContent() {
    return getFieldAsString(Field.CONTENT.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setContent(String content) {
    setField(Field.CONTENT.toString(), content);
  }

  /**
   * {@inheritDoc}
   */
  public Long getPostedTime() {
    return (Long) getField(Field.POSTED_TIME.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setPostedTime(Long postedTime) {
    setField(Field.POSTED_TIME.toString(), postedTime);
  }

  /**
   * {@inheritDoc}
   */
  public Activity getActivity() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  /**
   * {@inheritDoc}
   */
  public Identity getIdentity() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
