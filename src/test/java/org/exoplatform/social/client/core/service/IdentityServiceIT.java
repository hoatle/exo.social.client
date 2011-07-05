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

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import junit.framework.Assert;

import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.model.Profile;
import org.exoplatform.social.client.core.net.AbstractClientTest;
import org.junit.Test;

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
    Identity identity = identityService.get(demoIdentityId);
    Assert.assertNotNull("Identity must not null.", identity);
    Assert.assertEquals("IdentityID must be equal " + demoIdentityId, demoIdentityId, identity.getId());
    Assert.assertEquals("RemoteID must be equal demo", "demo", identity.getRemoteId());
    Assert.assertEquals("ProviderID must be equal organization", "organization", identity.getProviderId());
    Profile profile = identity.getProfile();
    Assert.assertNull("AvatarURL is null", profile.getAvatarUrl());
    Assert.assertEquals("Profile's fullname must be equals Demo gtn", "Demo gtn", profile.getFullName());
    
  }


}
