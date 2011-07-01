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
 * The Service Exception class.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 19, 2011
 */
public class ServiceException extends RuntimeException {
  
  public static final int HTTP_ACCEPTED = 202;
  public static final int HTTP_BAD_GATEWAY = 502;
  public static final int HTTP_BAD_METHOD = 405;
  public static final int HTTP_BAD_REQUEST = 400;
  public static final int HTTP_CLIENT_TIMEOUT = 408;
  public static final int HTTP_CONFLICT = 409;
  public static final int HTTP_CREATED = 201;
  public static final int HTTP_ENTITY_TOO_LARGE = 413;
  public static final int HTTP_FORBIDDEN = 403;
  public static final int HTTP_GATEWAY_TIMEOUT = 504;
  public static final int HTTP_GONE = 410;
  public static final int HTTP_INTERNAL_ERROR = 500;
  public static final int HTTP_LENGTH_REQUIRED = 411;
  public static final int HTTP_MOVED_PERM = 301;
  public static final int HTTP_MOVED_TEMP = 302;
  public static final int HTTP_MULT_CHOICE = 300;
  public static final int HTTP_NO_CONTENT = 204;
  public static final int HTTP_NOT_ACCEPTABLE = 406;
  public static final int HTTP_NOT_AUTHORITATIVE = 203;
  public static final int HTTP_NOT_FOUND = 404;
  public static final int HTTP_NOT_IMPLEMENTED = 501;
  public static final int HTTP_NOT_MODIFIED = 304;
  public static final int HTTP_OK = 200;
  public static final int HTTP_PARTIAL = 206;
  public static final int HTTP_PAYMENT_REQUIRED = 402;
  public static final int HTTP_PRECON_FAILED = 412;
  public static final int HTTP_PROXY_AUTH = 407;
  public static final int HTTP_REQ_TOO_LONG = 414;
  public static final int HTTP_RESET = 205;
  public static final int HTTP_SEE_OTHER = 303;
  public static final int HTTP_SERVER_ERROR = 500;
  public static final int HTTP_UNAUTHORIZED = 401;
  public static final int HTTP_UNAVAILABLE = 503;
  public static final int HTTP_UNSUPPORTED_TYPE = 415;
  public static final int HTTP_USE_PROXY = 305;
  public static final int HTTP_VERSION = 505;


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
  }

}
