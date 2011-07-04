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

import org.apache.http.HttpResponse;
import org.exoplatform.social.client.api.auth.AccessDeniedException;
import org.exoplatform.social.client.api.common.RealtimeListAccess;
import org.exoplatform.social.client.api.model.Activity;
import org.exoplatform.social.client.api.model.Comment;
import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.model.Like;
import org.exoplatform.social.client.api.net.SocialHttpClient;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.exoplatform.social.client.core.model.ActivityRealTimeListAccess;
import org.exoplatform.social.client.core.model.LikeImpl;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Implementation of {@link ActivityService}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 28, 2011
 */
public class ActivityServiceImpl extends ServiceBase<Activity, ActivityService<Activity>> implements ActivityService<Activity> {
  private static final String BASE_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true);

  /**
   * {@inheritDoc}
   */
  @Override
  public Activity create(Activity newInstance) throws AccessDeniedException, ServiceException {
    final String POST_ACTIVITY_REQUEST_URL = BASE_URL+"activity.json";
    try {
      HttpResponse response = SocialHttpClientSupport.executePost(POST_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH,
                                                                  newInstance);
      int statusCode = response.getStatusLine().getStatusCode();
      if(statusCode != SocialHttpClient.STATUS.OK.getCode()){
          throw new ServiceException(ActivityServiceImpl.class,"invalid response: Status "+statusCode,null);
      } else {
        String responseContent = SocialHttpClientSupport.getContent(response);
        try{
          Activity activity = SocialJSONDecodingSupport.parser(Activity.class, responseContent);
          return activity;
        } catch (Exception e) {
          throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
        }
      }
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class, "There's error when execute request",null);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Activity get(String uuid) throws AccessDeniedException, ServiceException {
    final String GET_ACTIVITY_REQUEST_URL = BASE_URL+"activity/"+uuid+".json";
    try {
      HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
      int statusCode = response.getStatusLine().getStatusCode();
      if(statusCode != SocialHttpClient.STATUS.OK.getCode()){
          throw new ServiceException(ActivityServiceImpl.class,"invalid response: Status "+statusCode,null);
      } else {
        String responseContent = SocialHttpClientSupport.getContent(response);
        try{
          Activity activity = SocialJSONDecodingSupport.parser(Activity.class, responseContent);
          return activity;
        } catch (Exception e) {
          throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
        }
      }
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class, "There's error when execute request",null);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Activity update(Activity existingInstance) throws AccessDeniedException, ServiceException {
    throw new ServiceException(ActivityServiceImpl.class,"Do Not Support",null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Activity delete(Activity existingInstance) throws AccessDeniedException, ServiceException {
    final String DELETE_ACTIVITY_REQUEST_URL = BASE_URL+"activity/destroy/"+existingInstance.getId()+".json";
    try {
      HttpResponse response = SocialHttpClientSupport.executePost(DELETE_ACTIVITY_REQUEST_URL,POLICY.BASIC_AUTH);
      int statusCode = response.getStatusLine().getStatusCode();
      if(statusCode != SocialHttpClient.STATUS.OK.getCode()){
          throw new ServiceException(ActivityServiceImpl.class,"invalid response: Status " + statusCode, null);
      } else {
        String responseContent = SocialHttpClientSupport.getContent(response);
        try{
          Activity activity = SocialJSONDecodingSupport.parser(Activity.class, responseContent);
          return activity;
        } catch (Exception e) {
          throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
        }
      }
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class, "There's error when execute request",null);
    }
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public RealtimeListAccess<Activity> getActivityStream(Identity identity) throws AccessDeniedException,
                                                                          ServiceException {
    return new ActivityRealTimeListAccess(identity);
  }

  @Override
  public RealtimeListAccess<Activity> getSpacesActivityStream(Identity userIdentity) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RealtimeListAccess<Activity> getConnectionsActivityStream(Identity userIdentity) throws AccessDeniedException,
                                                                                                 ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RealtimeListAccess<Activity> getFeedActivityStream(Identity userIdentity) throws AccessDeniedException,
                                                                                          ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public Comment createComment(Activity existingActivity, Comment newComment) throws AccessDeniedException,
                                                                                     ServiceException {
    final String CREATE_COMMENT_REQUEST_URL = BASE_URL+"activity/"+existingActivity.getId()+"/comment.json";
    try {
      HttpResponse response = SocialHttpClientSupport.executePost(CREATE_COMMENT_REQUEST_URL,POLICY.BASIC_AUTH,newComment);
      int statusCode = response.getStatusLine().getStatusCode();
      if(statusCode != SocialHttpClient.STATUS.OK.getCode()){
          throw new ServiceException(ActivityServiceImpl.class,"invalid response: Status " + statusCode, null);
      } else {
        String responseContent = SocialHttpClientSupport.getContent(response);
        try{
          Comment comment = SocialJSONDecodingSupport.parser(Comment.class, responseContent);
          return comment;
        } catch (Exception e) {
          throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
        }
      }
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class, "There's error when execute request",null);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Comment getComment(String commentId) throws AccessDeniedException, ServiceException {
    throw new ServiceException(ActivityServiceImpl.class, "There's error when execute request",null);
//    final String GET_ACTIVITY_REQUEST_URL = BASE_URL+commentId+".json";
//    try {
//      HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL,POLICY.BASIC_AUTH);
//      int statusCode = response.getStatusLine().getStatusCode();
//      if(statusCode != ServiceException.HTTP_OK){
//          throw new ServiceException(ActivityServiceImpl.class,"invalid response: Status " + statusCode, null);
//      } else {
//        String responseContent = SocialHttpClientSupport.getContent(response);
//        try{
//          Comment comment = SocialJSONDecodingSupport.parser(Comment.class, responseContent);
//          return comment;
//        } catch (Exception e) {
//          throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
//        }
//      }
//    } catch (Exception e) {
//      throw new ServiceException(ActivityServiceImpl.class, "There's error when execute request",null);
//    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Comment deleteComment(Comment existingComment) throws AccessDeniedException, ServiceException {
    final String DELETE_COMMENT_REQUEST_URL = BASE_URL+"activity/"+existingComment.getActivityId() + "/comment/destroy/" +
                                            existingComment.getId() + ".json";
    try {
      HttpResponse response = SocialHttpClientSupport.executePost(DELETE_COMMENT_REQUEST_URL,POLICY.BASIC_AUTH);
      int statusCode = response.getStatusLine().getStatusCode();
      if(statusCode != SocialHttpClient.STATUS.OK.getCode()){
          throw new ServiceException(ActivityServiceImpl.class,"invalid response: Status " + statusCode, null);
      } else {
        String responseContent = SocialHttpClientSupport.getContent(response);
        try{
          Comment comment = SocialJSONDecodingSupport.parser(Comment.class, responseContent);
          return comment;
        } catch (Exception e) {
          throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
        }
      }
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class, "There's error when execute request",null);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Like like(Activity existingActivity) throws AccessDeniedException, ServiceException {
    final String LIKE_ACTIVITY_REQUEST_URL = BASE_URL+"activity/"+existingActivity.getId()+"/like.json";
    try {
      HttpResponse response = SocialHttpClientSupport.executePost(LIKE_ACTIVITY_REQUEST_URL,POLICY.BASIC_AUTH);
      int statusCode = response.getStatusLine().getStatusCode();
      if(statusCode != SocialHttpClient.STATUS.OK.getCode()){
          throw new ServiceException(ActivityServiceImpl.class,"invalid response: Status " + statusCode, null);
      } else {
        String responseContent = SocialHttpClientSupport.getContent(response);
        try{
          JSONObject responeJson = (JSONObject)JSONValue.parse(responseContent);
          if((Boolean) responeJson.get("like")){
            return new LikeImpl(existingActivity.getId(), null);
          } else {
            throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
          }
        } catch (Exception e) {
          throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
        }
      }
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class, "There's error when execute request",null);
    }
  }


  @Override
  public Like unlike(Activity existingActivity) throws AccessDeniedException, ServiceException {
    final String LIKE_ACTIVITY_REQUEST_URL = BASE_URL+"activity/"+existingActivity.getId()+"/like/destroy.json";
    try {
      HttpResponse response = SocialHttpClientSupport.executePost(LIKE_ACTIVITY_REQUEST_URL,POLICY.BASIC_AUTH);
      int statusCode = response.getStatusLine().getStatusCode();
      if(statusCode != SocialHttpClient.STATUS.OK.getCode()){
          throw new ServiceException(ActivityServiceImpl.class,"invalid response: Status " + statusCode, null);
      } else {
        String responseContent = SocialHttpClientSupport.getContent(response);
        try{
          JSONObject responeJson = (JSONObject)JSONValue.parse(responseContent);
          if(!(Boolean) responeJson.get("like")){
            return new LikeImpl(existingActivity.getId(), null);
          } else {
            throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
          }
        } catch (Exception e) {
          throw new ServiceException(ActivityServiceImpl.class,"invalid response",null);
        }
      }
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class, "There's error when execute request",null);
    }
  }

}
