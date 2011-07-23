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

import org.exoplatform.social.client.api.model.RestComment;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Unit Test for {@link RestCommentImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 26, 2011
 */
public class CommentImplTest {

  @Test
  public void shouldCreateInstanceAndGetFields() {
    final String id = "123sdge234";
    final String identityId = "136492yf9wfhw";
    final String activityId = "12345689abcdefgh";
    final long postedTime = System.currentTimeMillis();
    final String createdAt = "Tue Jun 21 15:09:19 +0700 2011";
    RestComment restComment = new RestCommentImpl(id, identityId, activityId, postedTime, createdAt);
    assertThat("restComment must not be null", restComment, notNullValue());
    assertThat("restComment.getId() must return: " + id, restComment.getId(), equalTo(id));
    assertThat("restComment.getIdentityId() must return: " + identityId, restComment.getIdentityId(), equalTo(identityId));
    assertThat("restComment.getActivityId() must return: " + activityId, restComment.getActivityId(), equalTo(activityId));
    assertThat("restComment.getPostedTime() must return: " + postedTime, restComment.getPostedTime(), equalTo(postedTime));
    assertThat("restComment.getCreatedAt() must return: " + createdAt, restComment.getCreatedAt(), equalTo(createdAt));
  }

  @Test
  public void shouldGetActivity() {
    //TODO Complete this
  }

  @Test
  public void shouldGetIdentity() {
    //TODO Complete this
  }
}
