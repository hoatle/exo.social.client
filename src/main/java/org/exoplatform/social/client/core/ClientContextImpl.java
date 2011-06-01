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
package org.exoplatform.social.client.core;

import org.exoplatform.social.client.api.ClientContext;

/**
 * Implementation of {@link ClientContext}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 1, 2011.
 */
public class ClientContextImpl implements ClientContext {

  /**
   * The host domain name.
   */
  private String host = "";

  /**
   * The port number.
   */
  private int port = 0;

  /**
   * The portal container name.
   */
  private String portalContainerName = "";

  /**
   * The rest context name.
   */
  private String restContextName = "";

  /**
   * The rest version.
   */
  private String restVersion = "";

  /**
   * {@inheritDoc}
   */
  public String getHost() {
    return this.host;
  }

  /**
   * {@inheritDoc}
   */
  public void setHost(String host) {
    this.host = host;
  }

  /**
   * {@inheritDoc}
   */
  public int getPort() {
    return this.port;
  }

  /**
   * {@inheritDoc}
   */
  public void setPort(int port) {
    this.port = port;
  }

  /**
   * {@inheritDoc}
   */
  public String getPortalContainerName() {
    return this.portalContainerName;
  }

  /**
   * {@inheritDoc}
   */
  public void setPortalContainerName(String portalContainerName) {
    this.portalContainerName = portalContainerName;
  }

  /**
   * {@inheritDoc}
   */
  public String getRestContextName() {
    return this.restContextName;
  }

  /**
   * {@inheritDoc}
   */
  public void setRestContextName(String restContextName) {
    this.restContextName = restContextName;
  }

  /**
   * {@inheritDoc}
   */
  public String getRestVersion() {
    return this.restVersion;
  }

  /**
   * {@inheritDoc}
   */
  public void setRestVersion(String restVersion) {
    this.restVersion = restVersion;
  }
}
