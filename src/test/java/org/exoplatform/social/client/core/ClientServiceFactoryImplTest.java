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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Unit test for {@link ClientServiceFactoryImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jul 1, 2011
 */
public class ClientServiceFactoryImplTest {

  private ClientServiceFactory clientServiceFactory;


  @BeforeMethod
  public void setUp() {
    clientServiceFactory = new ClientServiceFactoryImpl();
  }

  @AfterMethod
  public void tearDown() {
    clientServiceFactory = null;
  }


  @Test
  public void shouldGetVersionService() {
    VersionService versionService = clientServiceFactory.createVersionService();
    assertThat("versionService must not be null", versionService, notNullValue());
  }


  @Test
  public void shouldGetActivityService() {
    ActivityService activityService = clientServiceFactory.createActivityService();
    assertThat("activityService must not be null", activityService, notNullValue());
  }

  @Test
  public void shouldGetIdentityService() {
    IdentityService identityService = clientServiceFactory.createIdentityService();
    assertThat("identityService must not be null", identityService, notNullValue());
  }

}
