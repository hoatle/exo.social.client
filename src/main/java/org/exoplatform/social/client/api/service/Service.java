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
package org.exoplatform.social.client.api.service;

/**
 * eXo Social Service.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface Service<T> {

  /**
   * Creates a new instance.
   *
   * @param newInstance new instance
   * @return the created instance
   * @throws ServiceException
   */
  T create(T newInstance) throws ServiceException;

  /**
   * Gets an existing instance by its uuid.
   * @param uuid the uuid
   * @return an existing instance
   * @throws ServiceException
   */
  T get(String uuid) throws ServiceException;

  /**
   * Updates an existing instance.
   *
   * @param existingInstance
   * @return new updated instance
   * @throws ServiceException
   */
  T update(T existingInstance) throws ServiceException;

  /**
   * Deletes an existing instance.
   *
   * @param existingInstance
   * @throws ServiceException
   */
  void delete(T existingInstance) throws ServiceException;

}
