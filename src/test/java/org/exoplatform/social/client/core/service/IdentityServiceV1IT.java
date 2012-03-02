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

import org.exoplatform.social.client.api.SocialClientLibException;
import org.exoplatform.social.client.api.UnsupportedMethodException;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.model.RestProfile;
import org.exoplatform.social.client.core.AbstractClientTestV1;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.testng.Assert.fail;

/**
 * Unit Test for {@link IdentityServiceImplV1}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jul 1, 2011
 */
public class IdentityServiceV1IT extends AbstractClientTestV1 {


  @BeforeMethod
  @Override
  public void setUp() {
    super.setUp();
  }

  @Override
  public void afterSetup() {
    startSessionAs("demo", "gtn");
  }

  @AfterMethod
  @Override
  public void tearDown() {
    super.tearDown();
  }

  /**
   * Test the case create a new identity.
   */
  @Test(expectedExceptions = UnsupportedMethodException.class)
  public void testCreate() throws SocialClientLibException {
    if (!canRunTest()) {
      throw new UnsupportedMethodException();
    }
    identityService.create(new RestIdentity());
  }

  /**
   * Test the case update an existing identity.
   */
  @Test(expectedExceptions = UnsupportedMethodException.class)
  public void testUpdate() throws SocialClientLibException {
    if (!canRunTest()) {
      throw new UnsupportedMethodException();
    }
    identityService.update(identityService.get(getDemoIdentity().getId()));
  }

  /**
   * Test the case delete an existing identity.
   */
  @Test(expectedExceptions = UnsupportedMethodException.class)
  public void testDelete() throws SocialClientLibException {
    if (!canRunTest()) {
      throw new UnsupportedMethodException();
    }
    identityService.delete(identityService.get(getDemoIdentity().getId()));
  }

  /**
   * Test the case get an identity by its id.
   */
  @Test
  public void testGetIdentity() throws SocialClientLibException {
    if (!canRunTest()) {
      return;
    }
    String id = getDemoIdentity().getId();
    RestIdentity identity = identityService.get(id);
    assertThat("Identity must not be null", identity, notNullValue());
    assertThat("Identity provider must be organization", identity.getProviderId(), equalTo("organization"));
    assertThat("RemoteId must be demo", identity.getRemoteId(), equalTo("demo"));

    RestProfile profile = identity.getProfile();
    assertThat("profile must not be null", profile, notNullValue());
    assertThat("profile.getAvatarUrl() must not be null", profile.getAvatarUrl(), notNullValue());
    assertThat("profile.getFullName() must return: Demo gtn", profile.getFullName(), equalTo("Demo gtn"));

    try {
      identity = identityService.get(null);
      fail("Expecting NullPointerException from IdentityService#get(String)");
    } catch (NullPointerException npe) {
    }
  }

  /**
   * Test the case get id of identity.
   */
  @Test
  public void testGetIdentityId() throws SocialClientLibException {
    if (!canRunTest()) {
      return;
    }
    String expectedId = getDemoIdentity().getId();
    String resultId = identityService.getIdentityId("organization", "demo");
    assertThat("identity id must be " + expectedId, resultId, equalTo(expectedId));

    try {
      resultId = identityService.getIdentityId(null, "demo");
      fail("Expecting NullPointerException from IdentityService#getIdentityId(String, String)");
    } catch (NullPointerException npe) {
    }

    try {
      resultId = identityService.getIdentityId(null, null);
      fail("Expecting NullPointerException from IdentityService#getIdentityId(String, String)");
    } catch (NullPointerException npe) {
    }
  }

  @Test
  public void testGetIdentityByProviderAndRemoteId() throws Exception {
    if (!canRunTest()) {
      return;
    }
    RestIdentity restIdentity = identityService.getIdentity("organization", "demo");
    assertThat("RestIdentity must not null.", restIdentity, notNullValue());
    assertThat("RemoteId must be demo", "demo", equalTo(restIdentity.getRemoteId()));
    assertThat("Provider must be organization", "organization", equalTo(restIdentity.getProviderId()));
    RestProfile restProfile = restIdentity.getProfile();
    assertThat("Avatar URL must not be null", restProfile.getAvatarUrl(), notNullValue());
    assertThat("Profile's full name must be Demo gtn", "Demo gtn", equalTo(restProfile.getFullName()));
  }
}
