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
package org.exoplatform.social.client.api.net;

import org.apache.http.client.HttpClient;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public interface SocialHttpClient extends HttpClient {
  public enum STATUS{
    ACCEPTED(202),
    BAD_GATEWAY(502),
    BAD_METHOD(405),
    BAD_REQUEST(400),
    CLIENT_TIMEOUT(408),
    CONFLICT(409),
    CREATED(201),
    ENTITY_TOO_LARGE(413),
    FORBIDDEN(403),
    GATEWAY_TIMEOUT(504),
    GONE(410),
    INTERNAL_ERROR(500),
    LENGTH_REQUIRED(411),
    MOVED_PERM(301),
    MOVED_TEMP(302),
    MULT_CHOICE(300),
    NO_CONTENT(204),
    NOT_ACCEPTABLE(406),
    NOT_AUTHORITATIVE(203),
    NOT_FOUND(404),
    NOT_IMPLEMENTED(501),
    NOT_MODIFIED(304),
    OK(200),
    PARTIAL(206),
    PAYMENT_REQUIRED(402),
    PRECON_FAILED(412),
    PROXY_AUTH(407),
    REQ_TOO_LONG(414),
    RESET(205),
    SEE_OTHER(303),
    SERVER_ERROR(500),
    UNAUTHORIZED(401),
    UNAVAILABLE(503),
    UNSUPPORTED_TYPE(415),
    USE_PROXY(305),
    VERSION(505);
    
    private int code;
    private STATUS(int code){
      this.code = code;
    }
    public int getCode(){
      return code;
    }
  }
  
  public enum POLICY {
    NO_AUTH,
    BASIC_AUTH
  }
  /**
   * Setting the basic authenticate which uses 
   * the username/password in <code>SocialClientContext</code>
   */
  public void setBasicAuthenticateToRequest();
}
