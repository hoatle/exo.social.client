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

import org.exoplatform.social.client.api.model.Identity;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link IdentityImpl}
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 25, 2011
 */
public class IdentityImplTest {

  @Test
  public void shouldCreteInstanceAndGetFields() {
    Identity identity = new IdentityImpl("123", "organization", "demo");
    assertThat("identity.getId() must return 123", identity.getId(), equalTo("123"));
    assertThat("identity.getProviderId() must return organization", identity.getProviderId(), equalTo("organization"));
    assertThat("identity.getRemoteId() must return demo", identity.getRemoteId(), equalTo("demo"));
    //assertThat("identity.getProfile() must not be null", identity.getProfile(), notNullValue());
  }
}
