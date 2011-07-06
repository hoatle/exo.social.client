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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exoplatform.social.client.api.model.Activity;
import org.exoplatform.social.client.api.model.ActivityStream;
import org.exoplatform.social.client.api.model.Comment;
import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.model.Like;

/**
 * Implementation of {@link Activity}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 26, 2011
 */
public class ActivityImpl extends ModelImpl implements Activity {

  /**
   * Constructor without any params.
   */
  public ActivityImpl() {

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
  public String getTitle() {
    return getFieldAsString(Field.TITLE.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTitle(String title) {
    setField(Field.TITLE.toString(), title);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getTitleId() {
    return getFieldAsString(Field.TITLE_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTitleId(String titleId) {
    setField(Field.TITLE_ID.toString(), titleId);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getAppId() {
    return getFieldAsString(Field.APP_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setAppId(String appId) {
    setField(Field.APP_ID.toString(), appId);
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
  public Double getPriority() {
    return (Double) getField(Field.PRIORITY.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPriority(Double priority) {
    setField(Field.PRIORITY.toString(), priority);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, String> getTemplateParams() {
    return getFieldAsMap(Field.TEMPLATE_PARAMS.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTemplateParams(Map<String, String> templateParams) {
    setField(Field.TEMPLATE_PARAMS.toString(), templateParams);
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
  public boolean isLiked() {
    return Boolean.parseBoolean(getFieldAsString(Field.LIKED.toString()));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Like> getLikes() {
    //TODO implement this
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Identity getPosterIdentity() {
    //TODO implement this
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPosterIdentity(Identity posterIdentity) {
    //TODO implement this
    //To change body of implemented methods use File | Settings | File Templates.
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Comment> getAvailableComments() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  /**
   * {@inheritDoc}
   * @param commentList available comment list
   */
  @Override
  public void setAvailableComments(List<Comment> commentList) {
    //TODO implements this
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getTotalNumberOfComments() {
    //TODO implement this
    return 0;  //To change body of implemented methods use File | Settings | File Templates.
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Comment> getTotalComments() {
    //TODO implement this
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ActivityStream getActivityStream() {
    //TODO implement this
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  /**
   * {@inheritDoc}
   */
  public String getTemplateParameter(String name) {
    Map<String, String> templateParams = getTemplateParams();
    if (templateParams != null) {
      return templateParams.get(name);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public void addTemplateParameter(String name, String value) {
    Map<String, String> templateParams = getTemplateParams();
    if (templateParams == null) {
      templateParams = new HashMap<String, String>();
    }
    templateParams.put(name, value);
    setTemplateParams(templateParams);
  }
}
