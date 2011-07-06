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

import org.exoplatform.social.client.api.model.RestProfile;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.core.net.AbstractClientTest;
import org.junit.Test;

import junit.framework.Assert;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link IdentityServiceImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jul 1, 2011
 */
public class IdentityServiceIT extends AbstractClientTest {

  @Override
  public void setUp() {
    super.setUp();
    startSessionAs("demo", "gtn");
  }

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
    Assert.assertNotNull("RestIdentity must not null.", restIdentity);
    Assert.assertEquals("IdentityID must be equal " + demoIdentityId, demoIdentityId, restIdentity.getId());
    Assert.assertEquals("RemoteID must be equal demo", "demo", restIdentity.getRemoteId());
    Assert.assertEquals("ProviderID must be equal organization", "organization", restIdentity.getProviderId());
    RestProfile profile = restIdentity.getProfile();
    Assert.assertNull("AvatarURL is null", profile.getAvatarUrl());
    Assert.assertEquals("profile's fullname must be equals Demo gtn", "Demo gtn", profile.getFullName());
    
  }


}
