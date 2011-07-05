package org.exoplatform.social.client.core.model;

import java.util.List;

import org.apache.http.HttpResponse;
import org.exoplatform.social.client.api.common.RealtimeListAccess;
import org.exoplatform.social.client.api.model.Activity;
import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.net.SocialHttpClient;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.service.ActivityServiceImpl;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ActivityRealTimeListAccess implements RealtimeListAccess<Activity> {
  private static final String BASE_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true);
  private Identity identity;

  public ActivityRealTimeListAccess(Identity identity) {
    this.identity = identity;
  }

  @Override
  public Activity[] load(int index, int limit) {
    String GET_FEED_URL =  BASE_URL+identity.getId()+"/user/default.json";
    try {
      HttpResponse response = SocialHttpClientSupport.executeGet(GET_FEED_URL,POLICY.BASIC_AUTH);
      JSONObject jsonObject = (JSONObject) JSONValue.parse(SocialHttpClientSupport.getContent(response));
      JSONArray jsonArray =  (JSONArray)jsonObject.get("activities");
      List<ActivityImpl> activities = SocialJSONDecodingSupport.JSONArrayObjectParser(ActivityImpl.class, jsonArray.toJSONString());
      return (ActivityImpl[]) activities.toArray();
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class, e.getMessage(),null);
    }
  }

  @Override
  public List<Activity> loadAsList(int index, int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getSize() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean hasNewer(Activity baseElement) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getNumberOfNewer(Activity baseElement) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Activity[] loadNewer(Activity baseElement, int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Activity> loadNewerAsList(Activity baseElement, int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasOlder(Activity baseElement) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getNumberOfOlder(Activity baseElement) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Activity[] loadOlder(Activity baseElement, int limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Activity> loadOlderAsList(Activity baseElement, int limit) {
    // TODO Auto-generated method stub
    return null;
  }

}
