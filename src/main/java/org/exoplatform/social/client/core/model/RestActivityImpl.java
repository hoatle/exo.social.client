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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestActivityStream;
import org.exoplatform.social.client.api.model.RestComment;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.QueryParams;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.ClientServiceFactoryHelper;
import org.exoplatform.social.client.core.service.QueryParamsImpl;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;

/**
 * Implementation of {@link org.exoplatform.social.client.api.model.RestActivity}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 26, 2011
 */
public class RestActivityImpl extends ModelImpl implements RestActivity {

  /**
   * Constructor without any params.
   */
  public RestActivityImpl() {

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
  public RestIdentity getPosterIdentity() {
    String posterIdentityString = getFieldAsString(Field.POSTER_IDENTITY.toString());
    RestIdentity restIdentity = null;
    
    if (posterIdentityString != null && posterIdentityString.length() >0) {
      try{
        restIdentity = SocialJSONDecodingSupport.parser(RestIdentityImpl.class, posterIdentityString);
      } catch (Exception e) {
        throw new ServiceException(ActivityService.class,e.getMessage(),null);
      }
    } else {
      IdentityService service = ClientServiceFactoryHelper.getClientServiceFactory().createIdentityService();
      restIdentity = (RestIdentity) service.get(this.getIdentityId());
    }
    return restIdentity;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public List<RestComment> getAvailableComments() {
    try{
      String commentsJSON = this.getFieldAsString(RestActivity.Field.COMMENTS.toString());
      List<? extends RestComment> comments = SocialJSONDecodingSupport.JSONArrayObjectParser(RestCommentImpl.class, commentsJSON);
      return (List<RestComment>) comments;
    } catch (Exception e) {
      throw new ServiceException(ActivityService.class,e.getMessage(),null);
    }
    
  }
  
  

  /**
   * {@inheritDoc}
   * @param restCommentList available comment list
   */
  @Override
  public void setAvailableComments(List<RestComment> restCommentList) {
    //TODO implements this
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getTotalNumberOfComments() {

    return Integer.parseInt(this.getFieldAsString(RestActivity.Field.TOTAL_NUMBER_OF_COMMENTS.toString()));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<RestComment> getTotalComments() {
    final String GET_ACTIVITY_REQUEST_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true)+"activity/"+this.getId()+"/comments.json";
    try{
      HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
      String responseContent = SocialHttpClientSupport.getContent(response);
      List<? extends RestComment> comments = SocialJSONDecodingSupport.JSONArrayObjectParser(RestCommentImpl.class, responseContent);
      return (List<RestComment>)comments;
    } catch (Exception e) {
      throw new ServiceException(ActivityService.class,e.getMessage(),null);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RestActivityStream getActivityStream() {
    String activityStreamJSON = this.getFieldAsString(RestActivity.Field.ACTIVITY_STREAM.toString());
    RestActivityStream restActivityStream = null;
    try {
      if (activityStreamJSON != null && activityStreamJSON.length() > 0) {
        restActivityStream = (RestActivityStream) SocialJSONDecodingSupport.parser(RestActivityStreamImpl.class, activityStreamJSON);
      } else {
        final QueryParams queryParamBuilder = new QueryParamsImpl().append(QueryParams.ACTIVITY_STREAM_PARAM.setValue("t")); 
        final String GET_ACTIVITY_REQUEST_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true)
                                                          + "activity/" + this.getId() + ".json?" + queryParamBuilder.buildQuery();
        HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
        
        RestActivity activity = (RestActivity) SocialJSONDecodingSupport.parser(RestActivityImpl.class, response);
        //get ActivityStream when JSON content is existing.
        restActivityStream = activity.getActivityStream();
        
        //caching for ActivityStreamJSON content in this RestActivity which avoid Request again.
        this.setField(RestActivity.Field.ACTIVITY_STREAM.toString(), activity.getFieldAsString(RestActivity.Field.ACTIVITY_STREAM.toString()));
      }
    } catch (Exception e) {
      throw new ServiceException(ActivityService.class, e.getMessage(), null);
    }
    return restActivityStream;
  }

  /**
   * {@inheritDoc}
   */
  @Override
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
  @Override
  public void addTemplateParameter(String name, String value) {
    Map<String, String> templateParams = getTemplateParams();
    if (templateParams == null) {
      templateParams = new HashMap<String, String>();
    }
    templateParams.put(name, value);
    setTemplateParams(templateParams);
  }
  
  @Override
  public int getTotalNumberOfLikes() {
    return Integer.parseInt(this.getFieldAsString(RestActivity.Field.TOTAL_NUMBER_OF_LIKES.toString()));
  }

  @Override
  public List<RestIdentity> getTotalLikes() {
    final String GET_ACTIVITY_REQUEST_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true)
        + "activity/" + this.getId() + "/likes.json";
    try {
      HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
      String responseContent = SocialHttpClientSupport.getContent(response);
      List<? extends RestIdentity> likedByIdentities = SocialJSONDecodingSupport.JSONArrayObjectParser(RestIdentityImpl.class, responseContent);
      return (List<RestIdentity>) likedByIdentities;
    } catch (Exception e) {
      throw new ServiceException(ActivityService.class,e.getMessage(),null);
    }
  }

  @Override
  public List<RestIdentity> getAvailableLikes() {
    try{
      String likedByIdentitiesJSON = this.getFieldAsString(RestActivity.Field.LIKED_BY_IDENTITIES.toString());
      List<? extends RestIdentity> likedByIdentities = SocialJSONDecodingSupport.JSONArrayObjectParser(RestIdentityImpl.class, likedByIdentitiesJSON);
      return (List<RestIdentity>) likedByIdentities;
    } catch (Exception e) {
      throw new ServiceException(ActivityService.class,e.getMessage(),null);
    }
  }
  
  
}
