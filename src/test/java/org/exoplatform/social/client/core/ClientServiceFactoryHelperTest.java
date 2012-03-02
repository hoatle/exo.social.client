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
import org.exoplatform.social.client.api.SocialClientContext.SupportedVersion;
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.core.service.ActivityServiceImplV1;
import org.exoplatform.social.client.core.service.IdentityServiceImplV1;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Uni test for {@link ClientServiceFactoryHelper}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jul 1, 2011
 */
public class ClientServiceFactoryHelperTest {

  @Test
  public void shouldSupportLatest() {
    ClientServiceFactory clientServiceFactory = ClientServiceFactoryHelper.getClientServiceFactory();
    assertThat("clientServiceFactory must not be null", clientServiceFactory, notNullValue());
  }



  @Test
  public void shouldSupportV1() {
    SocialClientContext.setRestVersion(SupportedVersion.V1.toString());
    ClientServiceFactory clientServiceFactory = ClientServiceFactoryHelper.getClientServiceFactory();
    ActivityService activityService = clientServiceFactory.createActivityService();
    assertThat("activityService must be instance of ActivityServiceImplV1",
               activityService instanceof ActivityServiceImplV1,
               equalTo(true));
    IdentityService identityService = clientServiceFactory.createIdentityService();
    assertThat("identityService must be instance of IdentityServiceImplV1",
               identityService instanceof IdentityServiceImplV1,
               equalTo(true));
  }

}
