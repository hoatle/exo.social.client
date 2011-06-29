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

import org.exoplatform.social.client.api.model.ActivityStream;

/**
 * Implementation of {@link ActivityStream}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 29, 2011
 */
public class ActivityStreamImpl extends ModelImpl implements ActivityStream {

  /**
   * Default constructor
   */
  public ActivityStreamImpl() {

  }

  /**
   * Constructor to set values.
   *
   * @param type       the type
   * @param prettyId   the pretty id
   * @param faviconUrl the favicon url
   * @param title      the title
   * @param permaLink  the permalink
   */
  public ActivityStreamImpl(String type, String prettyId, String faviconUrl, String title, String permaLink) {
    setType(type);
    setPrettyId(prettyId);
    setFaviconUrl(faviconUrl);
    setTitle(title);
    setPermaLink(permaLink);
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public String getType() {
    return getFieldAsString(Field.TYPE.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setType(String type) {
    setField(Field.TYPE.toString(), type);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getPrettyId() {
    return getFieldAsString(Field.PRETTY_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPrettyId(String prettyId) {
    setField(Field.PRETTY_ID.toString(), prettyId);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getFaviconUrl() {
    return getFieldAsString(Field.FAVICON_URL.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setFaviconUrl(String faviconUrl) {
    setField(Field.FAVICON_URL.toString(), faviconUrl);
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
  public String getPermaLink() {
    return getFieldAsString(Field.PERMALINK.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPermaLink(String permanLink) {
    setField(Field.PERMALINK.toString(), permanLink);
  }
}
