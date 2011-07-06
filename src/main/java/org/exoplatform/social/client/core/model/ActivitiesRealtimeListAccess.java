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
package org.exoplatform.social.client.core.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.HttpResponse;
import org.exoplatform.social.client.api.common.RealtimeListAccess;
import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.service.ActivityServiceImpl;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Created by The eXo Platform SAS
 * Author : phuonglm
 *          phuonglm@exoplatform.com
 * Jul 5, 2011  
 */
public class ActivitiesRealtimeListAccess implements RealtimeListAccess<RestActivity> {

  /** The activity type.*/
  public static enum ActivityType {
    /** Activities of identity, connections of identity, spaces where identity is manager or member. */
    ACTIVITY_FEED,
    /** Activities of identity (provider is organization or space). */
    ACTIVITY_STREAM,
    /** Activities of connections of identity. */
    CONNECTIONS_ACTIVITIES,
    /** Activities of spaces where identity is member or manager. */
    USER_SPACE_ACTIVITIES
  }
  /** The activity type. */
  private ActivityType activityType;
  
  /** The identity. */
  private RestIdentity ownerIdentity;
  
  /** The base url. */
  private static final String BASE_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true);
  
  /**
   * The constructor.
   * 
   * @param ownerIdentity
   * @param activityType
   */
  public ActivitiesRealtimeListAccess(RestIdentity ownerIdentity, ActivityType activityType) {
    this.ownerIdentity = ownerIdentity;
    this.activityType = activityType;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public int getNumberOfNewer(RestActivity baseElement) {
    //TODO
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getNumberOfOlder(RestActivity baseElement) {
    //TODO
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean hasNewer(RestActivity baseElement) {
    return this.loadNewerAsList(baseElement, 1).size() > 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean hasOlder(RestActivity baseElement) {
    return this.loadOlderAsList(baseElement, 1).size() > 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RestActivity[] loadNewer(RestActivity baseElement, int limit) {
    return this.convertListToArray(this.loadNewerAsList(baseElement, limit), RestActivity.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<RestActivity> loadNewerAsList(RestActivity baseElement, int limit) {
    String requestURL = null;
    HttpResponse response = null;
    
    switch (activityType) {
      case ACTIVITY_STREAM: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/user/newer/" + baseElement.getId() + ".json?limit=" + limit;
        break;
      }
      
      case ACTIVITY_FEED: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/feed/newer/" + baseElement.getId() + ".json?limit=" + limit;
        break;
      }
      
      case CONNECTIONS_ACTIVITIES: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/connections/newer/" + baseElement.getId() + ".json?limit=" + limit;
        break;
      }
      
      case USER_SPACE_ACTIVITIES: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/spaces/newer/" + baseElement.getId() + ".json?limit=" + limit;
        break;
      }
    }
    response = SocialHttpClientSupport.executeGet(requestURL, POLICY.BASIC_AUTH);
    return this.getListActivitiesFromResponse(response);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RestActivity[] loadOlder(RestActivity baseElement, int limit) {
    return this.convertListToArray(this.loadOlderAsList(baseElement, limit), RestActivity.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<RestActivity> loadOlderAsList(RestActivity baseElement, int limit) {
    String requestURL = null;
    HttpResponse response = null;
    
    switch (activityType) {
      case ACTIVITY_STREAM: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/user/older/" + baseElement.getId() + ".json?limit=" + limit;
        break;
      }
      
      case ACTIVITY_FEED: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/feed/older/" + baseElement.getId() + ".json?limit=" + limit;
        break;
      }
      
      case CONNECTIONS_ACTIVITIES: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/connections/older/" + baseElement.getId() + ".json?limit=" + limit;
        break;
      }
      
      case USER_SPACE_ACTIVITIES: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/spaces/older/" + baseElement.getId() + ".json?limit=" + limit;
        break;
      }
    }
    response = SocialHttpClientSupport.executeGet(requestURL, POLICY.BASIC_AUTH);
    return this.getListActivitiesFromResponse(response);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getSize() {
    //TODO
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RestActivity[] load(int index, int limit) {
    return this.convertListToArray(this.loadAsList(index, limit), RestActivity.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<RestActivity> loadAsList(int index, int limit) {
    String requestURL = null;
    HttpResponse response = null;
    switch (activityType) {
      case ACTIVITY_STREAM: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/user/default.json?limit=" + limit;
        break;
      }
      
      case ACTIVITY_FEED: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/feed/default.json?limit=" + limit;
        break;
      }
      
      case CONNECTIONS_ACTIVITIES: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/connections/default.json?limit=" + limit;
        break;
      }
      
      case USER_SPACE_ACTIVITIES: {
        requestURL = BASE_URL + "activity_stream/" + this.ownerIdentity.getId() + "/spaces/default.json?limit=" + limit;
        break;
      }
    }
    response = SocialHttpClientSupport.executeGet(requestURL, POLICY.BASIC_AUTH);
    return this.getListActivitiesFromResponse(response);
  }

  /**
   * Gets the activity type.
   * 
   * @return
   */
  public ActivityType getActivityType() {
    return this.activityType;
  }

  /**
   * Sets the activity type.
   * 
   * @param activityType
   */
  public void setActivityType(ActivityType activityType) {
    this.activityType = activityType;
  }

  /**
   * Gets the identity.
   * 
   * @return
   */
  public RestIdentity getOwnerIdentity() {
    return this.ownerIdentity;
  }
  
  /**
   * Sets the identity.
   * 
   * @param ownerIdentity
   */
  public void setOwnerIdentity(RestIdentity ownerIdentity) {
    this.ownerIdentity = ownerIdentity;
  }
  
  /**
   * Gets the list activities from response.
   * 
   * @param response
   * @return
   */
  private List<RestActivity> getListActivitiesFromResponse(HttpResponse response) {
    try {
      JSONObject jsonObject = (JSONObject) JSONValue.parse(SocialHttpClientSupport.getContent(response));
      JSONArray jsonArray =  (JSONArray)jsonObject.get("activities");
      List<RestActivityImpl> activities = SocialJSONDecodingSupport.JSONArrayObjectParser(RestActivityImpl.class, jsonArray.toJSONString());
      List<RestActivity> copyRestActivities = new ArrayList(activities);
      Collections.copy(copyRestActivities, activities);
      return copyRestActivities;
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
    }
  }
  
  /**
   * Converts a list to an array.
   * 
   * @param list List to be converted to array.
   * @param type Type of list's and array's element.
   * @return An array with the same type of element in list.
   */
  private <T> T[] convertListToArray(List<T> list, Class<T> type) {
    return list.toArray((T[])java.lang.reflect.Array.newInstance(type, list.size()));
  }
}
