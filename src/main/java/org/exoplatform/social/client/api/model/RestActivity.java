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
package org.exoplatform.social.client.api.model;

import static org.exoplatform.social.client.api.util.SocialHttpClientSupport.handleError;

import org.apache.http.HttpResponse;
import org.exoplatform.social.client.api.SocialClientLibException;
import org.exoplatform.social.client.api.net.SocialHttpClientException;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.QueryParams;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.ClientServiceFactoryHelper;
import org.exoplatform.social.client.core.service.QueryParamsImpl;
import org.exoplatform.social.client.api.util.SocialHttpClientSupport;
import org.exoplatform.social.client.api.util.SocialJSONDecodingSupport;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * eXo Social Activity model based on OpenSocial Activity Spec 0.8.1:
 * http://www.opensocial.org/Technical-Resources/opensocial-spec-v081/opensocial-reference#opensocial.Activity
 * and <tt>org.exoplatform.social.core.activity.model.ExoSocialActivity</tt> class on eXo Social project.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public class RestActivity extends Model {
  
  /**
   * The logger
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(RestActivity.class);
  
  public final static String DOC_ACTIVITY_TYPE = "DOC_ACTIVITY";
  public final static String DEFAULT_ACTIVITY_TYPE = "DEFAULT_ACTIVITY";
  public final static String LINK_ACTIVITY_TYPE = "LINK_ACTIVITY";
  
  /**
   * The fields that represent the activity object in json form.
   */
  public static enum Field {
    /** the json field for id. */
    ID("id"),
    /** the json field for title. */
    TITLE("title"),
    /** the json field for body. */
    BODY("body"),
    /** the json field for appId. */
    APP_ID("appId"),
    /** the json field for type. */
    TYPE("type"),
    /** the json field for postedTime. */
    POSTED_TIME("postedTime"),
    /** the json field for posterIdentity. */
    POSTER_IDENTITY("posterIdentity"),
    /** the json field for createdAt. */
    CREATED_AT("createdAt"),
    /** the json field for priority. */
    PRIORITY("priority"),
    /** the json field for templateParams. */
    TEMPLATE_PARAMS("templateParams"),
    /** the json field for titleId. */
    TITLE_ID("titleId"),
    /** the json field for identityId. */
    IDENTITY_ID("identityId"),
    /** the json field for liked. */
    LIKED("liked"),
    /** the json field for likedByIdentities */
    LIKED_BY_IDENTITIES("likedByIdentities"),
    /** the json field for Comments */
    COMMENTS("comments"),
    /** the json field for numberOfCommens */
    TOTAL_NUMBER_OF_COMMENTS("totalNumberOfComments"),
    /** the json field for numberOfLikes */
    TOTAL_NUMBER_OF_LIKES("totalNumberOfLikes"),
    /** the json field for activityStream */
    ACTIVITY_STREAM("activityStream");

    /**
     * The json field that the instance represents.
     */
    private final String jsonString;

    /**
     * create a field base on the a json element.
     *
     * @param jsonString the name of the element
     */
    private Field(String jsonString) {
      this.jsonString = jsonString;
    }

    /**
     * emit the field as a json element.
     *
     * @return the field name
     */
    @Override
    public String toString() {
      return jsonString;
    }
  }

  /**
   * Constructor without any params.
   */
  public RestActivity() {

  }
  
  /**
   * Gets a string ID that is permanently associated with this activity. Container support for this
   * field is OPTIONAL.
   *
   * @return a string ID that is permanently associated with this activity.
   */
  public String getId() {
    return getFieldAsString(Field.ID.toString());
  }

  /**
   * Sets a string ID that is permanently associated with this activity. Container support for this
   * field is OPTIONAL.
   *
   * @param id a string ID that is permanently associated with this activity.
   */
  public void setId(String id) {
    setField(Field.ID.toString(), id);
  }


  /**
   * Gets a string specifying the primary text of an activity. Container support for this field is
   * REQUIRED.
   *
   * Titles may only have the following HTML tags: &lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The
   * container may ignore this formatting when rendering the activity.
   *
   * @return astring specifying the primary text of an activity.
   */
  public String getTitle() {
    return getFieldAsString(Field.TITLE.toString());
  }

  /**
   * Sets a string specifying the primary text of an activity. Container support for this field is
   * REQUIRED.
   *
   * Titles may only have the following HTML tags: &lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The
   * container may ignore this formatting when rendering the activity.
   *
   * @param title a string specifying the primary text of an activity.
   */
  public void setTitle(String title) {
    setField(Field.TITLE.toString(), title);
  }

  /**
   * Gets a string specifying the title template message ID in the gadget spec. Container support for
   * this field is REQUIRED.
   *
   * The title is the primary text of an activity. Titles may only have the following HTML tags:
   * <&lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The container may ignore this formatting when
   * rendering the activity.
   *
   * @return a string specifying the title template message ID in the gadget spec.
   */
  public String getTitleId() {
    return getFieldAsString(Field.TITLE_ID.toString());
  }

  /**
   * Sets the body fields of Activity, this field is optional and use to storage the extended attribute of activity.
   * @param body
   */
  public void setBody(String body) {
    setField(Field.BODY.toString(), body);
  }
  
  /**
   * gets the body fields of Activity, this field is optional and use to storage the extended attribute of activity.
   * @return
   */
  public String getBody() {
    return getFieldAsString(Field.BODY.toString());
  }
  
  /**
   * Sets a string specifying the title template message ID in the gadget spec. Container support for
   * this field is REQUIRED.
   *
   * The title is the primary text of an activity. Titles may only have the following HTML tags:
   * <&lt;b&gt; &lt;i&gt;, &lt;a&gt;, &lt;span&gt;. The container may ignore this formatting when
   * rendering the activity.
   *
   * @param titleId a string specifying the title template message ID in the gadget spec.
   */
  public void setTitleId(String titleId) {
    setField(Field.TITLE_ID.toString(), titleId);
  }

  /**
   * Gets a string specifying the application that this activity is associated with. Container
   * support for this field is REQUIRED.
   *
   * @return A string specifying the application that this activity is associated with
   */
  public String getAppId() {
    return getFieldAsString(Field.APP_ID.toString());
  }

  /**
   * Sets a string specifying the application that this activity is associated with. Container
   * support for this field is REQUIRED.
   *
   * @param appId A string specifying the application that this activity is associated with
   */
  public void setAppId(String appId) {
    setField(Field.APP_ID.toString(), appId);
  }

  /**
   * Gets a string specifying the type of activity. Container support for this field is REQUIRED.
   *
   * @return A string specifying the application that this activity is associated with
   */
  public String getType() {
    return getFieldAsString(Field.TYPE.toString());
  }

  /**
   * Sets a string specifying the type of activity. Container support for this field is REQUIRED.
   *
   * @param appId A string specifying the application that this activity is associated with
   */
  public void setType(String type) {
    setField(Field.TYPE.toString() , type);
  }
  
  /**
   * Gets the time at which this activity took place in milliseconds since the epoch. Container
   * support for this field is OPTIONAL.
   *
   * Higher priority ones are higher in the list.
   *
   * @return The time at which this activity took place in milliseconds since the epoch
   */
  public Long getPostedTime() {
    return (Long) getField(Field.POSTED_TIME.toString());
  }

  /**
   * Sets the time at which this activity took place in milliseconds since the epoch Container
   * support for this field is OPTIONAL.
   *
   * This value can not be set by the end user.
   *
   * @param postedTime the time at which this activity took place in milliseconds since the epoch
   */
  public void setPostedTime(Long postedTime) {
    setField(Field.POSTED_TIME.toString(), postedTime);
  }

  /**
   * Gets the priority, a number between 0 and 1 representing the relative priority of this activity
   * in relation to other activities from the same source. Container support for this field is
   * OPTIONAL.
   *
   * @return a number between 0 and 1 representing the relative priority of this activity in
   *         relation to other activities from the same source
   */
  public Double getPriority() {
    return (Double) getField(Field.PRIORITY.toString());
  }

  /**
   * Sets the priority, a number between 0 and 1 representing the relative priority of this activity
   * in relation to other activities from the same source. Container support for this field is
   * OPTIONAL.
   *
   * @param priority a number between 0 and 1 representing the relative priority of this activity in
   *                relation to other activities from the same source.
   */
  public void setPriority(Double priority) {
    setField(Field.PRIORITY.toString(), priority);
  }

 /**
   * Gets a map of custom key/value pairs associated with this activity. Container support for this
   * field is OPTIONAL.
   *
   * @return a map of custom key/value pairs associated with this activity.
   */
  public Map<String, String> getTemplateParams() {
    return getFieldAsMap(Field.TEMPLATE_PARAMS.toString());
  }

  /**
   * Set a map of custom key/value pairs associated with this activity. The data has type
   * {@link Map<String, Object>}. The object may be either a String or a Person. When
   * passing in a person with key PersonKey, can use the following replacement variables in the
   * template:
   * <ul>
   * <li>PersonKey.DisplayName - Display name for the person</li>
   * <li>PersonKey.ProfileUrl. URL of the person's profile</li>
   * <li>PersonKey.Id - The ID of the person</li>
   * <li>PersonKey - Container may replace with DisplayName, but may also optionally link to the
   * user.</li>
   * </ul>
   * Container support for this field is OPTIONAL.
   *
   * @param templateParams a map of custom key/value pairs associated with this activity.
   */
  public void setTemplateParams(Map<String, String> templateParams) {
    setField(Field.TEMPLATE_PARAMS.toString(), templateParams);
  }

  /**
   * Gets a string uuid of the identity who created this activity.
   *
   * @return a string ID of the identity who created this activity.
   */
  public String getIdentityId() {
    return getFieldAsString(Field.IDENTITY_ID.toString());
  }

  /**
   * Sets a string uuid of the identity who created this activity.
   *
   * @param identityId a string ID of the identity who created this activity.
   */
  public void setIdentityId(String identityId) {
    setField(Field.IDENTITY_ID.toString(), identityId);
  }

  /**
   * Checks if this activity is liked by current user.
   *
   * @return boolean value
   */
  public boolean isLiked() {
    return Boolean.parseBoolean(getFieldAsString(Field.LIKED.toString()));
  }

  /**
   * Gets the poster identity who created this activity.
   *
   * @return the poster identity
   */
  public RestIdentity getPosterIdentity() throws SocialClientLibException {
    String posterIdentityString = getFieldAsString(Field.POSTER_IDENTITY.toString());
    RestIdentity restIdentity = null;

    if (posterIdentityString != null && posterIdentityString.length() > 2) {
      try{
        restIdentity = SocialJSONDecodingSupport.parser(RestIdentity.class, posterIdentityString);
      } catch (Exception e) {
        throw new ServiceException(ActivityService.class,e.getMessage(), e);
      }
    } else {
      IdentityService service = ClientServiceFactoryHelper.getClientServiceFactory().createIdentityService();
      restIdentity = (RestIdentity) service.get(this.getIdentityId());
    }
    return restIdentity;
  }

  /**
   * Gets the available list of comments for this activity.
   * Return Number of latest comments of this activity.
   *
   * @return Number of latest comments
   * @see #getTotalComments()
   */
  public List<RestComment> getAvailableComments() {
    try{
      String commentsJSON = this.getFieldAsString(RestActivity.Field.COMMENTS.toString());
      List<? extends RestComment> comments = SocialJSONDecodingSupport.JSONArrayObjectParser(RestComment.class, commentsJSON);
      return (List<RestComment>) comments;
    } catch (Exception e) {
      throw new ServiceException(ActivityService.class,e.getMessage(), e);
    }
  }
  
  /**
   * Gets the available list of likes for this activity.
   * Return Number of latest likes of this activity.
   *
   * @return Number of latest likes
   * @see #getTotalLikes()
   */
  public List<RestIdentity> getAvailableLikes() {
    try{
      String likedByIdentitiesJSON = this.getFieldAsString(RestActivity.Field.LIKED_BY_IDENTITIES.toString());
      List<? extends RestIdentity> likedByIdentities = SocialJSONDecodingSupport.JSONArrayObjectParser(RestIdentity.class, likedByIdentitiesJSON);
      return (List<RestIdentity>) likedByIdentities;
    } catch (Exception e) {
      throw new ServiceException(ActivityService.class,e.getMessage(), e);
    }
  }

  /**
   * Sets the available list of comments for this activity.
   *
   * @param restCommentList available comment list
   */
  public void setAvailableComments(List<RestComment> restCommentList) {
    //TODO implements this
  }


  /**
   * Gets the number of total comments.
   *
   * @return the the number of total comments
   */
  public int getTotalNumberOfComments() {
    return Integer.parseInt(this.getFieldAsString(RestActivity.Field.TOTAL_NUMBER_OF_COMMENTS.toString()));
  }

  /**
   * Gets the total number of comments.
   *
   * @return the total comment list
   */
  public List<RestComment> getTotalComments() throws SocialClientLibException {
    final String GET_ACTIVITY_REQUEST_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true)+"activity/"+this.getId()+"/comments.json";


    try{
      HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
      SocialHttpClientSupport.handleError(response);
      String responseContent = SocialHttpClientSupport.getContent(response);

      List<? extends RestComment> comments = SocialJSONDecodingSupport.JSONArrayObjectParser(RestComment.class, responseContent);
      return (List<RestComment>)comments;
    } catch (IOException e) {
      throw new ServiceException(ActivityService.class,e.getMessage(), e);
    } catch (ParseException e) {
      throw new ServiceException(ActivityService.class,e.getMessage(), e);
    }
  }
  
  /**
   * Gets the number of total likes.
   *
   * @return the the number of total likes
   */
  public int getTotalNumberOfLikes() {
    return Integer.parseInt(this.getFieldAsString(RestActivity.Field.TOTAL_NUMBER_OF_LIKES.toString()));
  }

  /**
   * Gets the total number of likes.
   *
   * @return the total like list
   */
  public List<RestIdentity> getTotalLikes() throws SocialClientLibException {
    final String GET_ACTIVITY_REQUEST_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true)
                                            + "activity/" + this.getId() + "/likes.json";
    try {
      HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
      String responseContent = SocialHttpClientSupport.getContent(response);
      handleError(response);
      List<? extends RestIdentity> likedByIdentities = SocialJSONDecodingSupport.JSONArrayObjectParser(RestIdentity.class, responseContent);
      return (List<RestIdentity>) likedByIdentities;
    } catch (SocialHttpClientException e) {
      throw new ServiceException(ActivityService.class,e.getMessage(), e);
    } catch (IOException e) {
      throw new ServiceException(ActivityService.class,e.getMessage(), e);
    } catch (ParseException e) {
      throw new ServiceException(ActivityService.class,e.getMessage(), e);
    }
  }

  /**
   * Gets activity stream.
   *
   * This is lazy loading.
   *
   * @return the associated activity stream.
   */
  public RestActivityStream getActivityStream() throws SocialClientLibException {
    String activityStreamJSON = this.getFieldAsString(RestActivity.Field.ACTIVITY_STREAM.toString());
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("activityStreamJSON: " + activityStreamJSON);
    }
    RestActivityStream restActivityStream = null;
    try {
      // if no activity stream json is fetched, the json string is "{}"
      if (activityStreamJSON != null && activityStreamJSON.length() > 2) {
        restActivityStream = SocialJSONDecodingSupport.parser(RestActivityStream.class, activityStreamJSON);
      } else {
        final QueryParams queryParamBuilder = new QueryParamsImpl().append(QueryParams.ACTIVITY_STREAM_PARAM.setValue("t"));
        final String GET_ACTIVITY_REQUEST_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true)
                                                          + "activity/" + this.getId() + ".json?" + queryParamBuilder.buildQuery();
        HttpResponse response = SocialHttpClientSupport.executeGet(GET_ACTIVITY_REQUEST_URL, POLICY.BASIC_AUTH);
        handleError(response);
        RestActivity activity = SocialJSONDecodingSupport.parser(RestActivity.class, response);
        //get ActivityStream when JSON content is existing.
        restActivityStream = activity.getActivityStream();

        //caching for ActivityStreamJSON content in this RestActivity which avoid Request again.
        this.setField(RestActivity.Field.ACTIVITY_STREAM.toString(), activity.getFieldAsString(RestActivity.Field.ACTIVITY_STREAM.toString()));
      }
    } catch (SocialHttpClientException e) {
      throw new ServiceException(ActivityService.class, e.getMessage(), e);
    } catch (ParseException e) {
      throw new ServiceException(ActivityService.class, e.getMessage(), e);
    } catch (IOException e) {
      throw new ServiceException(ActivityService.class, e.getMessage(), e);
    }
    return restActivityStream;
  }


  /**
   * Returns the template parameter with the specified name.
   * This is a helper method.
   *
   * @param name name of template parameter whose value is to be returned
   * @return a string associated with a name
   */
  public String getTemplateParameter(String name) {
    Map<String, String> templateParams = getTemplateParams();
    if (templateParams != null) {
      return templateParams.get(name);
    }
    return null;
  }

  /**
   * Adds a new template parameter with the specified name and value.
   * This is a helper method.
   *
   * @param name  name of new template parameter to add
   * @param value value of template parameter to associate with passed name
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
