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

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/**
 * The client context to hold states of: host, port, portalContainerName,
 * restContextName and rest version and auth schema.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public class SocialClientContext {

  /**
   * Gets host of the portal container to access services.
   *
   * @return the host
   */
  public static String getHost() {
    return host;
  }

  /**
   * Sets host of the portal container to access services.
   *
   * @param newHost the host
   */
  public static void setHost(String newHost) {
    host = newHost;
  }

  /**
   * Gets port of the portal container to access services.
   *
   * @return the port
   */
  public static int getPort() {
    return port;
  }

  /**
   * Sets port of the portal container to access services.
   *
   * @param newPort the port
   */
  public static void setPort(int newPort) {
    port = newPort;
  }

  /**
   * Gets portal container name of the portal container.
   * For example: socialdemo, portal, intranet...
   *
   * @return the portal container name
   */
  public static String getPortalContainerName() {
    return portalContainerName;
  }

  /**
   * Sets the portal container name of the portal container.
   *
   * @param newPortalContainerName the portal container name
   */
  public static void setPortalContainerName(String newPortalContainerName) {
    portalContainerName = newPortalContainerName;
  }

  /**
   * Gets the rest context name of the portal container.
   *
   * @return the rest context name
   */
  public static String getRestContextName() {
    return restContextName;
  }

  /**
   * Sets the rest context name of the portal container.
   *
   * @param newRestContextName the rest context name
   */
  public static void setRestContextName(String newRestContextName) {
    restContextName = newRestContextName;
  }


  /**
   * Gets the eXo Social Rest version.
   *
   * @return the eXo Social Rest version
   */
  public static String getRestVersion() {
    return restVersion;
  }

  /**
   * Sets the eXo Social Rest version.
   *
   * @param newRestVersion the eXo Social Rest version
   */
  public static void setRestVersion(String newRestVersion) {
    restVersion = newRestVersion;
  }

  /**
   * Gets the user name for basic authentication.
   *
   * @return the user name
   */
  public static String getUsername() {
    return username;
  }

  /**
   * Sets the user name for basic authentication.
   *
   * @param newUsername the user name
   */
  public static void setUsername(String newUsername) {
    username = newUsername;
  }

  /**
   * Gets the password for basic authentication
   *
   * @return the password
   */
  public static String getPassword() {
    return password;
  }

  /**
   * Sets the password for basic authentication.
   *
   * @param newPassword the password
   */
  public static void setPassword(String newPassword) {
    password = newPassword;
  }

  

  /**
   * Gets protocol of the portal container to access services.
   * @return
   */
  public static String getProtocol() {
    return protocol;
  }

  /**
   * Sets protocol of the portal container to access services.
   * @param protocol
   */
  public static void setProtocol(String protocol) {
    SocialClientContext.protocol = protocol;
  }

  /**
   * Gets current request and response context.
   *
   * @return current context
   */
  public Context getCurrentContext() {
    return currentContext;
  }
  

  /**
   * Getting Development mode.
   * @return
   */
  public static boolean isDeveloping() {
    return isDeveloping;
  }

  /**
   * Sets current request and response context.
   *
   * @param currentContext the current context
   */
  public void setCurrentContext(Context currentContext) {
    this.currentContext = currentContext;
  }

  private static String host;
  private static int port;
  private static String protocol = "http";
  private static String portalContainerName;
  private static String restContextName;
  private static String restVersion = "v1-alpha1";
  private static String username = "demo";
  private static String password = "gtn";
  private static boolean isDeveloping = true;
  
  private Context currentContext;


  /**
   * Keeping the HttpRequest and HttpResponse for Social RestService
   * @author thanh_vucong
   *
   */
  public class Context {
    private HttpRequest  request;

    private HttpResponse response;

    public Context(HttpRequest request, HttpResponse response) {
      this.request = request;
      this.response = response;
    }

    public HttpRequest getRequest() {
      return request;
    }

    public HttpResponse getResponse() {
      return response;
    }
  }
}
