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
 * The Service Exception class.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 19, 2011
 */
public class ServiceException extends RuntimeException {

  public String classService;

  /**
   * Constructor for ServiceException.
   *
   * @param classService the class service
   * @param message      the message of exception
   * @param cause        the cause of exception
   */
  public ServiceException(Class classService, String message, Throwable cause) {
    super(message, cause);
    this.classService = classService.getName();
  }

  /**
   * Gets the class service that cause the exception.
   *
   * @return the class service FQN
   */
  public String getClassService() {
    return classService;
  };

}
