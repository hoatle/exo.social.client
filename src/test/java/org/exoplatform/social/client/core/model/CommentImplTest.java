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

import org.exoplatform.social.client.api.model.Comment;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link CommentImpl}.
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
    Comment comment = new CommentImpl(id, identityId, activityId, postedTime, createdAt);
    assertThat("comment must not be null", comment, notNullValue());
    assertThat("comment.getId() must return: " + id, comment.getId(), equalTo(id));
    assertThat("comment.getIdentityId() must return: " + identityId, comment.getIdentityId(), equalTo(identityId));
    assertThat("comment.getActivityId() must return: " + activityId, comment.getActivityId(), equalTo(activityId));
    assertThat("comment.getPostedTime() must return: " + postedTime, comment.getPostedTime(), equalTo(postedTime));
    assertThat("comment.getCreatedAt() must return: " + createdAt, comment.getCreatedAt(), equalTo(createdAt));
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
