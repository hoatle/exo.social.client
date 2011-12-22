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
import org.exoplatform.social.client.api.SocialClientContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.exoplatform.social.client.api.SocialClientContext.SupportedVersion.V1_ALPHA3;

/**
 * The clientServiceFactory helper to get {@link org.exoplatform.social.client.api.ClientServiceFactory} to work
 * with services.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jul 1, 2011
 */
public class ClientServiceFactoryHelper {

  /**
   * Logger
   */
  private static final Logger LOG = LoggerFactory.getLogger(ClientServiceFactoryHelper.class);

  private static ClientServiceFactory clientServiceFactory;

  /**
   * Used for unit testing purpose mainly, this should not happen on actual client code when 2 rest api versions are used
   * at the same time
   **/
  private static String currentRestVersion = null;

  /**
   * Gets the clientServiceFactory.
   *
   * @return the clientServiceFactory
   */
  public static ClientServiceFactory getClientServiceFactory() {
    if (clientServiceFactory == null || isVersionChanged()) {
      currentRestVersion = SocialClientContext.getRestVersion();
      if (V1_ALPHA3.toString().equals(currentRestVersion)) {
        clientServiceFactory = new ClientServiceFactoryImplV1Alpha3();
      }
    }
    return clientServiceFactory;
  }

  private static boolean isVersionChanged() {
    if (!SocialClientContext.getRestVersion().equals(currentRestVersion)) {
      LOG.warn("restVersion changed, from: " + currentRestVersion + " to: " + SocialClientContext.getRestVersion());

      currentRestVersion = SocialClientContext.getRestVersion();
      return true;
    }
    return false;
  }

}
