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
package org.exoplatform.social.client.core.service;

import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.model.RestProfile;
import org.exoplatform.social.client.core.net.AbstractClientTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Unit Test for {@link IdentityServiceImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jul 1, 2011
 */
public class IdentityServiceIT extends AbstractClientTest {

  @BeforeMethod
  @Override
  public void setUp() {
    super.setUp();
    startSessionAs("demo", "gtn");
  }

  @AfterMethod
  @Override
  public void tearDown() {
    super.tearDown();
  }

  @Test
  public void testGet() {
    //TODO gets an identity by its id
  }


  @Test
  public void testGetIdentityId() {
    String identityId = identityService.getIdentityId("organization", "demo");
    assertThat("identityId must not be null", identityId, notNullValue());
  }
  
  @Test
  public void testGetIdentityById() throws Exception {
    
    String demoIdentityId = getDemoIdentityId();
    RestIdentity restIdentity = identityService.get(demoIdentityId);
    assertThat("RestIdentity must not not be null.", restIdentity, notNullValue());
    assertThat("restIdentity.getId() must return: " + demoIdentityId, restIdentity.getId(), equalTo(demoIdentityId));
    assertThat("restIdentity.getRemoteId() must return: demo", restIdentity.getRemoteId(), equalTo("demo"));
    assertThat("restIdentity.getProviderId() must return: organization",
               restIdentity.getProviderId(), equalTo("organization"));
    RestProfile profile = restIdentity.getProfile();
    assertThat("profile must not be null", profile, notNullValue());
    assertThat("profile.getAvatarUrl() must be null", profile.getAvatarUrl(), nullValue());
    assertThat("profile.getFullName() must return: Demo gtn", profile.getFullName(), equalTo("Demo gtn"));
  }


}
