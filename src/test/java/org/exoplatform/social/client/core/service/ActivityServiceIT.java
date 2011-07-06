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
import org.exoplatform.social.client.api.model.Activity;
import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.model.Like;
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.model.ActivityImpl;
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

  private ActivityService<Activity> activityService;
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

    Activity activityToCreate = new ActivityImpl();
    activityToCreate.setTitle("Hello PhuongLM!!!");
    Activity activityResult = activityService.create(activityToCreate);

    assertThat(activityResult.getId(), notNullValue());

    assertThat(activityResult.getTitle(), equalTo("Hello PhuongLM!!!"));
    assertThat(activityResult.getIdentityId(), equalTo(demoIdentityId));
    assertThat(activityResult.getLikes().size(), equalTo(0));

    activityService.like(activityResult);

    String createdActivityId = activityResult.getId();
    activityResult = activityService.get(createdActivityId);

    assertThat(activityResult.getId(), equalTo(createdActivityId));
    assertThat(activityResult.getIdentityId(), equalTo(demoIdentityId));
    assertThat(activityResult.getLikes().size(), equalTo(1));
    Like like = activityResult.getLikes().get(0);
    assertThat(like.getIdentityId() , equalTo(demoIdentityId));

    CommentImpl comment = new CommentImpl();
    comment.setText("hello");

    activityService.createComment(activityResult, comment);

    activityResult = activityService.get(createdActivityId);
    assertThat(activityResult.getTotalNumberOfComments(), equalTo(1));
    assertThat(activityResult.getAvailableComments().get(0).getText(), equalTo("hello"));


    activityService.delete(activityResult);

    try {
      activityResult = activityService.get(createdActivityId);
      fail("failed to check if Activity deleted.");
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
    RealtimeListAccess<Activity> result = activityService.getActivityStream(demoIdentity);
    for(int j = 0; i < j; i++){
      assertThat(result.load(j, j+1)[0].getTitle(), equalTo(new Integer(j).toString()));
    }
    Activity[] resultArray = result.load(0, i);
    for (Activity activity : resultArray) {
      activityService.delete(activity);
    }
    // TODO: Cause the Rest API don't provide relationship and space interface so
    // we cannot create data for test conntectionActivityStream and spaceActivitySteam.
    // Improve in next verison
  }

  public void createActivities(int numberOfActivity){
    for (int i = 0 ; i < numberOfActivity ; i++){
      Activity activityToCreate = new ActivityImpl();
      activityToCreate.setTitle(""+i);
      activityService.create(activityToCreate);
    }
  }
}
