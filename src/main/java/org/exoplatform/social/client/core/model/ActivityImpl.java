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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.exoplatform.social.client.api.model.Activity;
import org.exoplatform.social.client.api.model.ActivityStream;
import org.exoplatform.social.client.api.model.Comment;
import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.model.Like;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.service.ActivityServiceImpl;
import org.exoplatform.social.client.core.service.IdentityServiceImpl;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Implementation of {@link Activity}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 26, 2011
 */
public class ActivityImpl extends ModelImpl implements Activity {

  /**
   * Constructor without any params.
   */
  public ActivityImpl() {

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getId() {
    return getFieldAsString(Field.ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setId(String id) {
    setField(Field.ID.toString(), id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getTitle() {
    return getFieldAsString(Field.TITLE.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTitle(String title) {
    setField(Field.TITLE.toString(), title);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getTitleId() {
    return getFieldAsString(Field.TITLE_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTitleId(String titleId) {
    setField(Field.TITLE_ID.toString(), titleId);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getAppId() {
    return getFieldAsString(Field.APP_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setAppId(String appId) {
    setField(Field.APP_ID.toString(), appId);
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public Long getPostedTime() {
    return (Long) getField(Field.POSTED_TIME.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPostedTime(Long postedTime) {
    setField(Field.POSTED_TIME.toString(), postedTime);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Double getPriority() {
    return (Double) getField(Field.PRIORITY.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPriority(Double priority) {
    setField(Field.PRIORITY.toString(), priority);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, String> getTemplateParams() {
    return getFieldAsMap(Field.TEMPLATE_PARAMS.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTemplateParams(Map<String, String> templateParams) {
    setField(Field.TEMPLATE_PARAMS.toString(), templateParams);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getIdentityId() {
    return getFieldAsString(Field.IDENTITY_ID.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setIdentityId(String identityId) {
    setField(Field.IDENTITY_ID.toString(), identityId);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isLiked() {
    return Boolean.parseBoolean(getFieldAsString(Field.LIKED.toString()));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Like> getLikes() {
    try{
      String likedIdentityString = this.getFieldAsString(Activity.Field.LIKED_BY_IDENTITIES.toString());
      List<Like> result = new ArrayList<Like>();
      if(likedIdentityString !=null){
        JSONArray identitiesArray = (JSONArray) JSONValue.parse(likedIdentityString);
        for(Object identityJsonItem : identitiesArray){
          JSONObject jsonObject = (JSONObject) identityJsonItem;
          
          Like likeItem = new LikeImpl();
          likeItem.setIdentityId((String) jsonObject.get("id"));          
          likeItem.setActivityId(this.getId());
          result.add(likeItem);
        }
      }
      return result;
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class,e.getMessage(),null);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Identity getPosterIdentity() {
    return new IdentityServiceImpl().get(this.getIdentityId());
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public List<Comment> getAvailableComments() {
    final String GET_ACTIVITY_REQUEST_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true)+"activity/"+this.getId()+".json?number_of_comments=5";
    try{
      HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
      String responseContent = SocialHttpClientSupport.getContent(response);
      
      JSONObject jsonObject = (JSONObject) JSONValue.parse(responseContent);
      JSONArray commentsJsonarray = (JSONArray) jsonObject.get("comments");
      
      List<CommentImpl> comments = SocialJSONDecodingSupport.JSONArrayObjectParser(CommentImpl.class, commentsJsonarray.toJSONString());
      List<Comment> result = new ArrayList<Comment>();
      result.addAll(comments);
      return result;
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class,e.getMessage(),null);
    }
    
  }

  /**
   * {@inheritDoc}
   * @param commentList available comment list
   */
  @Override
  public void setAvailableComments(List<Comment> commentList) {
    //TODO implements this
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getTotalNumberOfComments() {

    return Integer.parseInt(this.getFieldAsString(Activity.Field.TOTAL_NUMBER_OF_COMMENTS.toString()));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Comment> getTotalComments() {
    final String GET_ACTIVITY_REQUEST_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true)+"activity/"+this.getId()+"/comments.json";
    try{
      HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
      String responseContent = SocialHttpClientSupport.getContent(response);
      List<CommentImpl> comments = SocialJSONDecodingSupport.JSONArrayObjectParser(CommentImpl.class, responseContent);
      List<Comment> result = new ArrayList<Comment>();
      result.addAll(comments);
      return result;
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class,e.getMessage(),null);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ActivityStream getActivityStream() {
    final String GET_ACTIVITY_REQUEST_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true)+"activity/"+this.getId()+"/comment.json?activity_stream=1";
    try{
      HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
      String responseContent = SocialHttpClientSupport.getContent(response);
      
      JSONObject jsonObject = (JSONObject) JSONValue.parse(responseContent);
      JSONObject activityStreamJson = (JSONObject) jsonObject.get("activityStream");
      ActivityStreamImpl activityStream = SocialJSONDecodingSupport.parser(ActivityStreamImpl.class, activityStreamJson.toJSONString());
      return activityStream;
    } catch (Exception e) {
      throw new ServiceException(ActivityServiceImpl.class,e.getMessage(),null);
    }
  }

  /**
   * {@inheritDoc}
   */
  public String getTemplateParameter(String name) {
    Map<String, String> templateParams = getTemplateParams();
    if (templateParams != null) {
      return templateParams.get(name);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public void addTemplateParameter(String name, String value) {
    Map<String, String> templateParams = getTemplateParams();
    if (templateParams == null) {
      templateParams = new HashMap<String, String>();
    }
    templateParams.put(name, value);
    setTemplateParams(templateParams);
  }
}
