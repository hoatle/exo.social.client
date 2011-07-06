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

import org.exoplatform.social.client.api.common.RealtimeListAccess;
import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.model.Like;
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.model.RestActivityImpl;
import org.exoplatform.social.client.core.model.CommentImpl;
import org.exoplatform.social.client.core.net.AbstractClientTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit Test for {@link org.exoplatform.social.client.api.service.ActivityService}'s implementation.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jul 3, 2011
 */
public class ActivityServiceIT extends AbstractClientTest {

  private ActivityService<RestActivity> activityService;
  private IdentityService<Identity> identityService;

  public void setUp() {
    super.setUp();
    activityService = new ActivityServiceImpl();
    identityService = new IdentityServiceImpl();
  }

  public void tearDown() {
    activityService = null;
    identityService = null;
    super.tearDown();
  }
  @Test
  public void testCreateGetDeleteActivity() {
    startSessionAs("demo", "gtn");
    String demoIdentityId = identityService.getIdentityId("organization", "demo");

    RestActivity restActivityToCreate = new RestActivityImpl();
    restActivityToCreate.setTitle("Hello PhuongLM!!!");
    RestActivity restActivityResult = activityService.create(restActivityToCreate);

    assertThat(restActivityResult.getId(), notNullValue());

    assertThat(restActivityResult.getTitle(), equalTo("Hello PhuongLM!!!"));
    assertThat(restActivityResult.getIdentityId(), equalTo(demoIdentityId));
    assertThat(restActivityResult.getLikes().size(), equalTo(0));

    activityService.like(restActivityResult);

    String createdActivityId = restActivityResult.getId();
    restActivityResult = activityService.get(createdActivityId);

    assertThat(restActivityResult.getId(), equalTo(createdActivityId));
    assertThat(restActivityResult.getIdentityId(), equalTo(demoIdentityId));
    assertThat(restActivityResult.getLikes().size(), equalTo(1));
    Like like = restActivityResult.getLikes().get(0);
    assertThat(like.getIdentityId() , equalTo(demoIdentityId));

    CommentImpl comment = new CommentImpl();
    comment.setText("hello");

    activityService.createComment(restActivityResult, comment);

    restActivityResult = activityService.get(createdActivityId);
    assertThat(restActivityResult.getTotalNumberOfComments(), equalTo(1));
    assertThat(restActivityResult.getAvailableComments().get(0).getText(), equalTo("hello"));


    activityService.delete(restActivityResult);

    try {
      restActivityResult = activityService.get(createdActivityId);
      fail("failed to check if RestActivity deleted.");
    } catch (ServiceException e) {
      //expected
    }
  }
  @Test
  public void testGetActivitySteam() {
    startSessionAs("demo", "gtn");

    String demoIdentityId = identityService.getIdentityId("organization", "demo");
    Identity demoIdentity = identityService.get(demoIdentityId);

    int i = 10;
    createActivities(i);
    RealtimeListAccess<RestActivity> result = activityService.getActivityStream(demoIdentity);
    for(int j = 0; i < j; i++){
      assertThat(result.load(j, j+1)[0].getTitle(), equalTo(new Integer(j).toString()));
    }
    RestActivity[] resultArray = result.load(0, i);
    for (RestActivity restActivity : resultArray) {
      activityService.delete(restActivity);
    }
    // TODO: Cause the Rest API don't provide relationship and space interface so
    // we cannot create data for test conntectionActivityStream and spaceActivitySteam.
    // Improve in next verison
  }

  public void createActivities(int numberOfActivity){
    for (int i = 0 ; i < numberOfActivity ; i++){
      RestActivity restActivityToCreate = new RestActivityImpl();
      restActivityToCreate.setTitle(""+i);
      activityService.create(restActivityToCreate);
    }
  }
}
