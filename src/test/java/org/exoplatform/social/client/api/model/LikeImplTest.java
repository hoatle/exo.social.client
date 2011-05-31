/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.social.client.api.model;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link LikeImpl}
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 24, 2011
 */
public class LikeImplTest {

  @Test
  public void shouldCreateLikeInstance() {
    final String activityId = "1234";
    final String userId = "demo";
    Like like = new LikeImpl(activityId, userId);
    assertThat("like must not be null", like, notNullValue());
    assertThat("like.getActivityId() must return: " + activityId , like.getActivityId(), equalTo(activityId));
    assertThat("like.getIdentityId() must return: " + userId, like.getUserId(), equalTo(userId));
  }


  @Test
  public void shouldGetIdentity() {

  }

  @Test
  public void shouldGetActivity() {


  }

}
