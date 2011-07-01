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

import org.exoplatform.social.client.api.auth.AccessDeniedException;
import org.exoplatform.social.client.api.event.Lifecycle;

/**
 * eXo Social Service.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface Service<M> {

  /**
   * Creates a new instance.
   *
   * @param newInstance new instance
   * @return the created instance
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  M create(M newInstance) throws AccessDeniedException, ServiceException;

  /**
   * Gets an existing instance by its uuid.
   * @param uuid the uuid
   * @return an existing instance
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  M get(String uuid) throws AccessDeniedException, ServiceException;

  /**
   * Updates an existing instance.
   *
   * @param existingInstance
   * @return new updated instance
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  M update(M existingInstance) throws AccessDeniedException, ServiceException;

  /**
   * Deletes an existing instance.
   *
   * @param existingInstance
   * @return DeletedInstance
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  M delete(M existingInstance) throws AccessDeniedException, ServiceException;

}
