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

import java.util.ArrayList;
import java.util.List;

import org.exoplatform.social.client.api.ClientServiceFactory;
import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestComment;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.ClientServiceFactoryHelper;
import org.exoplatform.social.client.core.model.RestActivityImpl;
import org.exoplatform.social.client.core.model.RestCommentImpl;
import org.exoplatform.social.client.core.net.AbstractClientTest;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Unit Test for {@link org.exoplatform.social.client.api.service.ActivityService}'s implementation.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jul 3, 2011
 */
public class ActivityServiceIT extends AbstractClientTest {

  private ActivityService<RestActivity> activityService;
  private IdentityService<RestIdentity> identityService;

  private List<RestActivity> tearDownActivityList;

  public void setUp() {
    super.setUp();
    ClientServiceFactory clientServiceFactory = ClientServiceFactoryHelper.getClientServiceFactory();
    activityService = clientServiceFactory.createActivityService();
    identityService = clientServiceFactory.createIdentityService();
    tearDownActivityList = new ArrayList<RestActivity>();
  }

  public void tearDown() {
    startSessionAs("demo", "gtn");
    for (RestActivity activity: tearDownActivityList) {
      activityService.delete(activity);
    }
    startSessionAsAnonymous();
    tearDownActivityList = null;
    activityService = null;
    identityService = null;
    super.tearDown();
  }

  /**
   * Tests the case when not authenticated
   */
  @Test
  public void shouldBeForbidden() {
    try {
      activityService.get("notfound");
      fail("Expecting ServiceException from ActivityService#get(String)");
    } catch (ServiceException se) {

    }
    RestActivity activity = new RestActivityImpl();
    activity.setTitle("Hello There");
    try {
      activityService.create(activity);
      fail("Expecting ServiceException from ActivityService#create(RestActivity)");
    } catch (ServiceException se) {

    }
    try {
      activityService.update(activity);
      fail("Expecting ServiceException from ActivityService#update(RestActivity)");
    } catch (ServiceException se) {

    }

    //create a activity to demo's stream
    startSessionAs("demo", "gtn");
    RestActivity demoActivity = createActivities(1).get(0);
    startSessionAsAnonymous();

    RestComment comment = new RestCommentImpl();
    comment.setText("comment");

    try {
      activityService.createComment(demoActivity, comment);
      fail("Expecting ServiceException from ActivityService#createComment(RestActivity, RestComment)");
    } catch (ServiceException se) {

    }




  }

  @Test
  public void shouldBeUnsupported() {

  }

  @Test
  public void shouldNotFound() {

  }


  @Test
  public void shouldCreate() {

  }

  @Test
  public void shouldGet() {

  }

  @Test
  public void shouldNotUpdate() {

  }

  @Test
  public void shouldDelete() {

  }



  /*
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
    RestLike restLike = restActivityResult.getLikes().get(0);
    assertThat(restLike.getIdentityId() , equalTo(demoIdentityId));

    RestCommentImpl comment = new RestCommentImpl();
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
  */

  /*
  @Test
  public void testGetActivitySteam() {
    startSessionAs("demo", "gtn");

    String demoIdentityId = identityService.getIdentityId("organization", "demo");
    RestIdentity demoIdentity = identityService.get(demoIdentityId);

    int i = 1;
    createActivities(i);
    RealtimeListAccess<RestActivity> activityListAccess = activityService.getActivityStream(demoIdentity);
    assertEquals(activityListAccess.getSize(), equalTo(1));
    /*
    for(int j = 0; i < j; i++){
      assertThat(result.load(j, j+1)[0].getTitle(), equalTo(new Integer(j).toString()));
    }
    RestActivity[] resultArray = result.load(0, i);
    for (RestActivity restActivity : resultArray) {
      activityService.delete(restActivity);
    }
    // TODO: Cause the Rest API don't provide relationship and space interface so
    // we cannot create data for test connectionActivityStream and spaceActivitySteam.
    // Improve in next version
  }
  */

  private List<RestActivity> createActivities(int numberOfActivity) {
    List<RestActivity> createdActivityList = new ArrayList<RestActivity>();
    for (int i = 0; i < numberOfActivity; i++) {
      RestActivity restActivityToCreate = new RestActivityImpl();
      restActivityToCreate.setTitle("test " + i);
      RestActivity createdActivity = activityService.create(restActivityToCreate);
      createdActivityList.add(createdActivity);
      tearDownActivityList.add(createdActivity);
    }
    return createdActivityList;
  }
}
