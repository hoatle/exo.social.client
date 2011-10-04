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
package org.exoplatform.social.client.api;

/**
 * Exception for the case that the client wants to use the rest version is not supported.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  1.0.0-alpha2
 * @since  Oct 4, 2011
 */
public class UnsupportedRestVersionException extends RuntimeException {

  /**
   * Default constructor.
   */
  public UnsupportedRestVersionException() {
    super();
  }

  /**
   * Constructor with message.
   *
   * @param msg the message
   */
  public UnsupportedRestVersionException(String msg) {
    super(msg);
  }
}
