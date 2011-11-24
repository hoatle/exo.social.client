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
 * Exception when one method is called but it is not implemented or supported yet.
 * 
 * @author <a href="mailto:hanhvq@exoplatform.com">Hanh Vi Quoc</a>
 * @since Jul 29, 2011  
 */
public class UnsupportedMethodException extends RuntimeException{

  /**
   * Exception without any message.
   */
  public UnsupportedMethodException() {
    super();
  }

  /**
   * Exception with message.
   * 
   * @param message
   */
  public UnsupportedMethodException(String message) {
    super(message);
  }
}
