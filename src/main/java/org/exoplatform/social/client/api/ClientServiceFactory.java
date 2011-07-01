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

import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.VersionService;

/**
 * The main entry point to get eXo Social Services.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface ClientServiceFactory {

  /**
   * Gets version service to find information about latest and supported social rest ap versions.
   *
   * @return the version service
   */
  VersionService createVersionService();

  /**
   * Gets activity service to work with activities.
   *
   * @return the activity service
   */
  ActivityService createActivityService();
  /**
   * Gets account service for getting or updating identity info.
   *
   * @return the identity service
   */
  IdentityService createIdentityService();

}
