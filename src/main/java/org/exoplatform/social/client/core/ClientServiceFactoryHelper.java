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
package org.exoplatform.social.client.core;

import org.exoplatform.social.client.api.ClientServiceFactory;

/**
 * The clientServiceFactory helper to get {@link org.exoplatform.social.client.api.ClientServiceFactory} to work
 * with services.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jul 1, 2011
 */
public class ClientServiceFactoryHelper {

  private static ClientServiceFactory clientServiceFactory;

  /**
   * Gets the clientServiceFactory.
   *
   * @return the clientServiceFactory
   */
  public static ClientServiceFactory getClientServiceFactory() {
    if (clientServiceFactory == null) {
      clientServiceFactory = new ClientServiceFactoryImpl();
    }
    return clientServiceFactory;
  }

}
