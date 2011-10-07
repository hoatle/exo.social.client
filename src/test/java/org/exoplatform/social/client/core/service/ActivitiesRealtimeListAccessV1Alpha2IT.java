package org.exoplatform.social.client.core.service;

import java.util.ArrayList;
import java.util.List;

import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.core.AbstractClientTestV1Alpha2;
import org.exoplatform.social.client.core.model.RestActivityImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.testng.Assert.fail;

public class ActivitiesRealtimeListAccessV1Alpha2IT extends AbstractClientTestV1Alpha2 {
  private List<RestActivity> tearDownActivityList;
  
  @BeforeMethod
  @Override
  public void setUp() {
    super.setUp();
  }

  @Override
  public void afterSetup() {
    tearDownActivityList = new ArrayList<RestActivity>();
  }

  @Override
  public void beforeTearDown() {
    startSessionAs("demo", "gtn");
    for (RestActivity activity : tearDownActivityList) {
      activityService.delete(activity);
    }
  }

  @AfterMethod
  @Override
  public void tearDown() {
    super.tearDown();
  }
  
  @Test
  public void testWithGetRealtimeActivityWithLimit100() {
//    not stable ???
//    startSessionAs("demo", "gtn");
//    RestIdentity restIdentity = identityService.getIdentity("organization", "demo");
//    createActivities(200);
//    
//    RealtimeListAccess<RestActivity> activities = new ActivitiesRealtimeListAccessV1Alpha2(restIdentity, ActivityType.ACTIVITY_STREAM, null);
//    assertThat("RealtimeListAccess<RestActivity> getOlder().size should have size = 100", 100, equalTo(activities.loadAsList(0, 100).size()));
    
  }
  
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
