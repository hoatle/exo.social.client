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

import org.exoplatform.social.client.api.model.RestLike;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link RestLikeImpl}
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 24, 2011
 */
public class RestLikeImplTest {

  @Test
  public void shouldCreateLikeInstance() {
    final String activityId = "1234";
    final String identityId = "abcdegheogi30";
    RestLike restLike = new RestLikeImpl(activityId, identityId);
    assertThat("restLike must not be null", restLike, notNullValue());
    assertThat("restLike.getActivityId() must return: " + activityId , restLike.getActivityId(), equalTo(activityId));
    assertThat("restLike.getIdentityId() must return: " + identityId, restLike.getIdentityId(), equalTo(identityId));
  }


  @Test
  public void shouldGetIdentity() {

  }

  @Test
  public void shouldGetActivity() {


  }

}
