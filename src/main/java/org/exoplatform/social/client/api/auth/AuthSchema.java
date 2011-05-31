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
package org.exoplatform.social.client.api.auth;

import org.exoplatform.social.client.api.ClientContext;

import com.google.inject.ImplementedBy;

/**
 * The authentication and authorization schema. The schema could be Basic or OAuth
 * auth schema.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 19, 2011
 */
@ImplementedBy(BasicAuthSchemaImpl.class)
public interface AuthSchema {

  /**
   * Sets the client context for context awareness.
   *
   * @param clientContext the client context.
   */
  public void setClientContext(ClientContext clientContext);

  /**
   * Check if a user is authenticated to service provider.
   *
   * @return true or false.
   */
  boolean isAuthenticated();

  /**
   * Authenticates with the service provider.
   *
   * @return true or false.
   */
  boolean authenticate();
}
