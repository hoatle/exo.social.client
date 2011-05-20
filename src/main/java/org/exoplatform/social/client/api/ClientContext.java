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
package org.exoplatform.social.client.api;

import org.exoplatform.social.client.api.auth.AuthSchema;

/**
 * The client context to hold states of: host, port, portalContainerName,
 * restContextName and rest version and auth schema.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface ClientContext {

  /**
   * Gets the auth schema.
   *
   * @return the auth schema.
   */
  AuthSchema getAuthSchema();

  /**
   * Sets the auth schema.
   *
   * @param authSchema
   */
  void setAuthSchema(AuthSchema authSchema);

  /**
   * Gets host of the portal container to access services.
   *
   * @return the host
   */
  String getHost();

  /**
   * Sets host of the portal container to access services.
   *
   * @param host the host
   */
  void setHost(String host);

  /**
   * Gets port of the portal container to access services.
   *
   * @return the port
   */
  int getPort();

  /**
   * Sets port of the portal container to access services.
   *
   * @param port the port
   */
  void setPort(int port);

  /**
   * Gets portal container name of the portal container.
   * For example: socialdemo, portal, intranet...
   *
   * @return the portal container name
   */
  String getPortalContainerName();

  /**
   * Sets the portal container name of the portal container.
   *
   * @param portalContainerName the portal container name
   */
  void setPortalContainerName(String portalContainerName);

  /**
   * Gets the rest context name of the portal container.
   *
   * @return the rest context name
   */
  String getRestContextName();

  /**
   * Sets the rest context name of the portal container.
   *
   * @param restContextName the rest context name
   */
  void setRestContextName(String restContextName);

  /**
   * Gets the eXo Social Rest version.
   *
   * @return the eXo Social Rest version
   */
  String getRestVersion();

  /**
   * Set the eXo Social Rest version.
   *
   * @param restVersion the eXo Social Rest version
   */
  void setRestVersion(String restVersion);

}
