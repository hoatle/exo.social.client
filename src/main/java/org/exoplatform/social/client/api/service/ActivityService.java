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
package org.exoplatform.social.client.api.service;

import org.exoplatform.social.client.api.SocialClientLibException;
import org.exoplatform.social.client.api.auth.AccessDeniedException;
import org.exoplatform.social.client.api.auth.NotFoundException;
import org.exoplatform.social.client.api.common.RealtimeListAccess;
import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestComment;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.model.RestLike;

/**
 * Activity Service.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface ActivityService<Activity> extends Service<Activity> {

  /**
   * Gets activity stream from an owner stream identity.
   *
   * For example:
   * <pre>
   *    RestIdentity demoIdentity = identityService.get("123456789abcdef");
   *    RealtimeListAccess<RestActivity> activityListAccess = activityService.getActivityStream(demoIdentity);
   * </pre>
   *
   * or:
   * <pre>
   *   RestIdentity spaceIdentity = new RestIdentityImpl();
   *   spaceIdentity.setProviderId("space");
   *   spaceIdentity.setRemoteId("hello_world");
   *   RealtimeListAccess<RestActivity> activityListAccess = activityService.getActivitySream(spaceIdentity);
   * </pre>
   *
   * @param  ownerStreamRestIdentity the owner stream identity, could be a user or space identity.
   * @return the real time list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */


  RealtimeListAccess<Activity> getActivityStream(RestIdentity ownerStreamRestIdentity) throws SocialClientLibException;
  /**
   * Get Activity Stream with input parameter (limit, number of comment, number of like);
   * @param restIdentity
   * @param queryParams
   * @return
   * @throws AccessDeniedException
   * @throws ServiceException
   * @since  1.0.0-alpha2
   */
  RealtimeListAccess<RestActivity> getActivityStream(RestIdentity restIdentity, QueryParams queryParams)
                                                                                    throws SocialClientLibException;
  /**
   * Create new Activity from current Identity to targetIdentity
   * @param newActivity Activity
   * @param queryParams the query params
   * @return
   * @throws AccessDeniedException
   * @throws ServiceException
   * @since  1.0.0-alpha2
   */
  RestActivity create(RestActivity newActivity, QueryParams queryParams) throws SocialClientLibException;


  /**
   * Gets all activities from spaces which a user is a member of that space aggregated into one stream.
   *
   * @param userRestIdentity the associated user identity
   * @return the real time list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getSpacesActivityStream(RestIdentity userRestIdentity) throws SocialClientLibException;


  /**
   * Gets all activities from spaces which a user is a member of that space aggregated into one stream with input parameter
   * (limit, number of comment, number of like);
   * @param restIdentity
   * @param queryParams
   * @return
   * @throws AccessDeniedException
   * @throws ServiceException
   * @since  1.0.0-alpha2
   */
  RealtimeListAccess<RestActivity> getSpacesActivityStream(RestIdentity restIdentity, QueryParams queryParams)
                                                                                    throws SocialClientLibException;

  /**
   * Gets all connections' activities aggregated into one stream.
   *
   * @param userRestIdentity the associated user identity
   * @return the real time list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getConnectionsActivityStream(RestIdentity userRestIdentity) throws SocialClientLibException;

  /**
   * Gets all connections' activities aggregated into one stream with input parameter (limit, number of comment, number of like);
   * @param restIdentity
   * @param queryParams
   * @return
   * @throws AccessDeniedException
   * @throws ServiceException
   * @since  1.0.0-alpha2
   */
  RealtimeListAccess<RestActivity> getConnectionsActivityStream(RestIdentity restIdentity, QueryParams queryParams)
                                                                                    throws SocialClientLibException;

  /**
   * Gets all activities from a stream owner, his connections and spaces aggregated into one stream.
   *
   * @param userRestIdentity the associated user identity
   * @return the realtime list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getFeedActivityStream(RestIdentity userRestIdentity) throws SocialClientLibException;

  /**
   * Gets all activities from a stream owner, his connections and spaces aggregated into one stream with input parameter
   * (limit, number of comment, number of like);
   * @param restIdentity
   * @param queryParams
   * @return
   * @throws AccessDeniedException
   * @throws ServiceException
   * @since  1.0.0-alpha2
   */
  RealtimeListAccess<RestActivity> getFeedActivityStream(RestIdentity restIdentity, QueryParams queryParams)
                                                                                    throws SocialClientLibException;

  /**
   * Creates a new comment to this activity.
   *
   * @param existingActivity the existing activity
   * @param newRestComment       the new created comment
   * @return the created comment
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RestComment createComment(Activity existingActivity, RestComment newRestComment) throws SocialClientLibException;

  /**
   * Gets an existing comment by its id.
   *
   * @param commentId the comment id
   * @return the existing comment with the specified id
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RestComment getComment(String commentId) throws SocialClientLibException;

  /**
   * Deletes an existing comment.
   *
   * @param existingRestComment the existing comment
   * @return the deleted comment
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RestComment deleteComment(RestComment existingRestComment) throws SocialClientLibException;


  /**
   * The authenticate identity likes an existing activity.
   *
   * @param existingActivity the existing activity
   * @return the created {@link org.exoplatform.social.client.api.model.RestLike} instance
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RestLike like(Activity existingActivity) throws SocialClientLibException;

  /**
   * The authenticated identity unlikes an existing activity.
   *
   * @param existingActivity the existing activity
   * @return the deleted {@link org.exoplatform.social.client.api.model.RestLike} instance.
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RestLike unlike(Activity existingActivity) throws SocialClientLibException;

  /**
   * Gets an existing instance by its activityId and limit the number of comment/like by by input parameter .
   * @param activityId the activityId
   * @param queryParams the query params
   * @return an existing instance
   * @throws AccessDeniedException
   * @throws ServiceException
   * @since v1-alpha2
   */
  Activity get(String activityId, QueryParams queryParams) throws SocialClientLibException;
}
