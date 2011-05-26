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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.exoplatform.social.client.api.common.ListAccess;
import org.exoplatform.social.client.api.model.Activity;
import org.exoplatform.social.client.api.model.Comment;
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
  public String getTitle() {
    return getFieldAsString(Field.TITLE.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setTitle(String title) {
    setField(Field.TITLE.toString(), title);
  }

  /**
   * {@inheritDoc}
   */
  public String getTitleId() {
    return getFieldAsString(Field.TITLE_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setTitleId(String titleId) {
    setField(Field.TITLE_ID.toString(), titleId);
  }

  /**
   * {@inheritDoc}
   */
  public String getAppId() {
    return getFieldAsString(Field.APP_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setAppId(String appId) {
    setField(Field.APP_ID.toString(), appId);
  }

  /**
   * {@inheritDoc}
   */
  public String getBody() {
    return getFieldAsString(Field.BODY.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setBody(String body) {
    setField(Field.BODY.toString(), body);
  }

  /**
   * {@inheritDoc}
   */
  public String getBodyId() {
    return getFieldAsString(Field.BODY_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setBodyId(String bodyId) {
    setField(Field.BODY_ID.toString(), bodyId);
  }

  /**
   * {@inheritDoc}
   */
  public String getExternalId() {
    return getFieldAsString(Field.EXTERNAL_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setExternalId(String externalId) {
    setField(Field.EXTERNAL_ID.toString(), externalId);
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
  public Date getUpdated() {
    return (Date) getField(Field.UPDATED.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setUpdated(Date updated) {
    setField(Field.UPDATED.toString(), updated);
  }

  /**
   * {@inheritDoc}
   */
  public Double getPriority() {
    return (Double) getField(Field.PRIORITY.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setPriority(Double priority) {
    setField(Field.PRIORITY.toString(), priority);
  }

  /**
   * {@inheritDoc}
   */
  public String getStreamFaviconUrl() {
    return getFieldAsString(Field.STREAM_FAVICON_URL.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setStreamFaviconUrl(String streamFaviconUrl) {
    setField(Field.STREAM_FAVICON_URL.toString(), streamFaviconUrl);
  }

  /**
   * {@inheritDoc}
   */
  public String getStreamSourceUrl() {
    return getFieldAsString(Field.STREAM_SOURCE_URL.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setStreamSourceUrl(String streamSourceUrl) {
    setField(Field.STREAM_SOURCE_URL.toString(), streamSourceUrl);
  }

  /**
   * {@inheritDoc}
   */
  public String getStreamTitle() {
    return getFieldAsString(Field.STREAM_TITLE.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setStreamTitle(String streamTitle) {
    setField(Field.STREAM_TITLE.toString(), streamTitle);
  }

  /**
   * {@inheritDoc}
   */
  public String getStreamUrl() {
    return getFieldAsString(Field.STREAM_URL.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setStreamUrl(String streamUrl) {
    setField(Field.STREAM_URL.toString(), streamUrl);
  }

  /**
   * {@inheritDoc}
   */
  public Map<String, String> getTemplateParams() {
    return getFieldAsMap(Field.TEMPLATE_PARAMS.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setTemplateParams(Map<String, String> templateParams) {
    setField(Field.TEMPLATE_PARAMS.toString(), templateParams);
  }

  /**
   * {@inheritDoc}
   */
  public String getUrl() {
    return getFieldAsString(Field.URL.toString());
  }

  /**
   * {@inheritDoc}
   */
  public void setUrl(String url) {
    setField(Field.URL.toString(), url);
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

  public ListAccess<Like> getLikes() {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  public ListAccess<Comment> getComments() {
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
