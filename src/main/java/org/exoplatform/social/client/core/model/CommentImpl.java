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
   * @param identityId the identity id
   * @param activityId the activity id
   * @param postedTime the posted time
   */
  public CommentImpl(String id, String identityId, String activityId, Long postedTime, String createdAt) {
    setId(id);
    setIdentityId(identityId);
    setActivityId(activityId);
    setPostedTime(postedTime);
    setCreatedAt(createdAt);
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
  public String getContent() {
    return getFieldAsString(Field.CONTENT.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setContent(String content) {
    setField(Field.CONTENT.toString(), content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getPostedTime() {
    return (Long) getField(Field.POSTED_TIME.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPostedTime(Long postedTime) {
    setField(Field.POSTED_TIME.toString(), postedTime);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getCreatedAt() {
    return getFieldAsString(Field.CREATED_AT.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setCreatedAt(String createdAt) {
    setField(Field.CREATED_AT.toString(), createdAt);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Activity getActivity() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Identity getIdentity() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
