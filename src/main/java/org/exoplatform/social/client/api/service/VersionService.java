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

/**
 * VersionService is used to get the latest and supported social rest api version.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 29, 2011
 */
public interface VersionService {
  /**
   * Gets the latest social rest api version, this version number should be used as the latest and stable version.
   * This latest version is consider to include all new features and updates.
   *
   * @return the latest version
   */
  String getLatest() throws ServiceException;

  /**
   * Gets the supported social rest api versions, this is for backward compatible. If a client application is using
   * an older social rest api version, it should just work. The array MUST have the latest to oldest order. For
   * example: [v2, v1, v1-beta1], not [v1, v2, v1-beta1]
   *
   * @return an array of supported versions
   */
  String[] getSupported() throws ServiceException;
}
