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
package org.exoplatform.social.client.api.event;


/**
 * General purpose exception that is thrown to indicate a lifecycle related
 * problem.  Such exceptions should generally be considered fatal to the
 * operation of the application containing this component.
 */
public final class LifecycleException extends RuntimeException {


  //------------------------------------------------------------ Constructors


  /**
   * Construct a new LifecycleException with no other information.
   */
  public LifecycleException() {

    this(null, null);

  }


  /**
   * Construct a new LifecycleException for the specified message.
   *
   * @param message Message describing this exception
   */
  public LifecycleException(String message) {

    this(message, null);

  }


  /**
   * Construct a new LifecycleException for the specified throwable.
   *
   * @param cause Throwable that caused this exception
   */
  public LifecycleException(Throwable cause) {

    this(null, cause);

  }


  /**
   * Construct a new LifecycleException for the specified message
   * and throwable.
   *
   * @param message   Message describing this exception
   * @param cause Throwable that caused this exception
   */
  public LifecycleException(String message, Throwable cause) {

    super();
    this.message = message;
    this.cause = cause;

  }


  //------------------------------------------------------ Instance Variables


  /**
   * The error message passed to our constructor (if any)
   */
  protected String message = null;


  /**
   * The underlying exception or error passed to our constructor (if any)
   */
  protected Throwable cause = null;


  //---------------------------------------------------------- Public Methods


  /**
   * Returns the message associated with this exception, if any.
   */
  public String getMessage() {

    return (message);

  }


  /**
   * Returns the throwable that caused this exception, if any.
   */
  public Throwable getCause() {

    return (cause);

  }


  /**
   * Returns a formatted string that describes this exception.
   */
  public String toString() {

    StringBuffer sb = new StringBuffer("LifecycleException:  ");
    if (message != null) {
      sb.append(message);
      if (cause != null) {
        sb.append(":  ");
      }
    }
    if (cause != null) {
      sb.append(cause.toString());
    }
    return (sb.toString());

  }


}
