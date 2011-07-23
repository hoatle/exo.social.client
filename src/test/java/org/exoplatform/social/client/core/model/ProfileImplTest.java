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

import org.exoplatform.social.client.api.model.RestProfile;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit Test for {@link RestProfileImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 29, 2011
 */
public class ProfileImplTest {

  @Test
  public void shouldGetDefaultValues() {
    RestProfile restProfile = new RestProfileImpl();
    assertThat("restProfile.getIdentityId() must be null", restProfile.getIdentityId(), nullValue());
    assertThat("restProfile.getFullName() must be null", restProfile.getFullName(), nullValue());
    assertThat("restProfile.getAvatarUrl() must be null", restProfile.getAvatarUrl(), nullValue());
  }

  @Test
  public void shouldGetSettedValues() {
    final String identityId = "123456789";
    final String fullName = "Demo Gtn";
    final String avatarUrl = "http://platform35.demo.exoplatform.org/restProfile/avatar/demo.jpg";
    RestProfile restProfile = new RestProfileImpl(identityId, fullName, avatarUrl);

    assertThat("restProfile.getIdentityId() must return: " + identityId, restProfile.getIdentityId(), equalTo(identityId));
    assertThat("restProfile.getFullName() must return: " + fullName, restProfile.getFullName(), equalTo(fullName));
    assertThat("restProfile.getAvatarUrl() must return: " + avatarUrl, restProfile.getAvatarUrl(), equalTo(avatarUrl));
  }
}
