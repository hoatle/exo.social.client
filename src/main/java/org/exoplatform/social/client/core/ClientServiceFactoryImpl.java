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
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.VersionService;
import org.exoplatform.social.client.core.service.ActivityServiceImpl;
import org.exoplatform.social.client.core.service.IdentityServiceImpl;
import org.exoplatform.social.client.core.service.VersionServiceImpl;

/**
 * Implementation for {@link org.exoplatform.social.client.api.ClientServiceFactory}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since June 28, 2011
 */
public class ClientServiceFactoryImpl implements ClientServiceFactory {

  private VersionService versionService;
  private ActivityService activityService;
  private IdentityService identityService;

  /**
   * {@inheritDoc}
   */
  @Override
  public VersionService createVersionService() {
    if (versionService == null) {
      versionService = new VersionServiceImpl();
    }
    return versionService;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ActivityService createActivityService() {
    if (activityService == null) {
      activityService = new ActivityServiceImpl();
    }
    return activityService;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IdentityService createIdentityService() {
    if (identityService == null) {
      identityService = new IdentityServiceImpl();
    }
    return identityService;
  }

}
