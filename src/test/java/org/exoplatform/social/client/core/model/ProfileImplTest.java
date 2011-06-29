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
package org.exoplatform.social.client.core.model;

import org.exoplatform.social.client.api.model.Profile;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link ProfileImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 29, 2011
 */
public class ProfileImplTest {

  @Test
  public void shouldGetDefaultValues() {
    Profile profile = new ProfileImpl();
    assertThat("profile.getIdentityId() must be null", profile.getIdentityId(), nullValue());
    assertThat("profile.getFullName() must be null", profile.getFullName(), nullValue());
    assertThat("profile.getAvatarUrl() must be null", profile.getAvatarUrl(), nullValue());
  }

  @Test
  public void shouldGetSettedValues() {
    final String identityId = "123456789";
    final String fullName = "Demo Gtn";
    final String avatarUrl = "http://platform35.demo.exoplatform.org/profile/avatar/demo.jpg";
    Profile profile = new ProfileImpl(identityId, fullName, avatarUrl);

    assertThat("profile.getIdentityId() must return: " + identityId, profile.getIdentityId(), equalTo(identityId));
    assertThat("profile.getFullName() must return: " + fullName, profile.getFullName(), equalTo(fullName));
    assertThat("profile.getAvatarUrl() must return: " + avatarUrl, profile.getAvatarUrl(), equalTo(avatarUrl));
  }
}
