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

import java.util.List;

import org.exoplatform.social.client.api.auth.AccessDeniedException;
import org.exoplatform.social.client.api.common.Period;
import org.exoplatform.social.client.api.common.RealtimeListAccess;
import org.exoplatform.social.client.api.model.Comment;
import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.model.Like;

/**
 * Activity Service.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface ActivityService<Activity> extends Service<Activity> {

  /**
   * Gets activity stream which is associated with an identity: that user, his connections and his spaces' activities.
   * These activities are filtered by specifying the list of app ids and the period of time that created these
   * activities.
   *
   * For example:
   * <pre>
   *    Identity demoIdentity = identityService.get("123456789abcdef");
   *    List<String> appIds = new ArrayList<String>();
   *    appIds.add("all"); //all means all the activity types
   *    //appIds.add("default"); // default means all the defined default activity types.
   *    Period period = new PeriodImpl(12345, 23456);
   *    RealtimeListAccess<Activity> activityListAccess = activityService.getActivityStream(demoIdentity, appIds, period);
   * </pre>
   *
   * @param identity the identity
   * @param appIds the list of identities
   * @param period the period of time
   * @return the real time list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getActivityStream(Identity identity, List<String> appIds,
                                                 Period period) throws AccessDeniedException, ServiceException;

  /**
   * Gets activity stream associated with an identity: that user, his connections and his spaces' activities.
   * <p/>
   * All these activities will be merged into one stream. This will return only activities with default core types.
   *
   * Short hand for:
   * <pre>
   *   getActivityStream(Identity, null, null);
   * </pre>
   *
   * @return the real time list access of {@link Activity}.
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getActivityStream(Identity identity) throws AccessDeniedException, ServiceException;

  /**
   * Gets activity stream associated with an identity: that user, his connections and his spaces' activities by
   * specifying the type of activities to be retrieved.
   * <p/>
   * All these activities will be merged into one stream. Short hand for:
   * <pre>
   *   getActivityStream(Identity, List<String>, null);
   * </pre>
   *
   * @return the real time list access of {@link Activity}.
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getActivityStream(Identity identity, List<String> appIds) throws AccessDeniedException,
          ServiceException;

  /**
   * Gets activity stream associated with an identity: that user, his connections and his spaces' activities which are
   * specified in a period of time. Short hand for:
   * <pre>
   *   getActivityStream(Identity, null, Period);
   * </pre>
   *
   * @param identity the identity.
   * @param period   the period of time
   * @return the real time list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getActivityStream(Identity identity, Period period) throws AccessDeniedException,
                                                                                          ServiceException;

  /**
   * Gets activity stream from a provided list of {@link Identity} by specifying identity list,
   * the list of app ids to be retrieved and the period of time.
   *
   * @param identityList the identity list
   * @param appIds the app id list
   * @param period the period of time
   * @return the realtime list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getActivityStream(List<Identity> identityList, List<String> appIds,
                                                 Period period) throws AccessDeniedException, ServiceException;

  /**
   * Gets activity stream from a provided list of {@link Identity}. Short hand for:
   * <pre>
   *   getActivityStream(List<Identity>, null, null);
   * </pre>
   *
   * @param identityList the list of identities
   * @return the real time list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getActivityStream(List<Identity> identityList) throws AccessDeniedException,
                                                                                     ServiceException;


  /**
   * Gets activity stream from a provided list of {@link Identity} and specifying the activity with matched app ids
   * to be retrieved. Short hand for:
   * <pre>
   *   getActivityStream(List<Identity>, List<String>, null);
   * </pre>
   *
   * @param identityList the identity list
   * @param appIds the list of app ids
   * @return the real time list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getActivityStream(List<Identity> identityList,
                                                 List<String> appIds) throws AccessDeniedException, ServiceException;

  /**
   * Gets activity stream from a provided list of {@link Identity} which is specified in a period of time.
   * Short hand for:
   * <pre>
   *   getActivityStream(identityList, null, period);
   * </pre>
   *
   * @param identityList the list of identities
   * @param period       the period of time
   * @return the real time list access
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  RealtimeListAccess<Activity> getActivityStream(List<Identity> identityList,
                                                 Period period) throws AccessDeniedException, ServiceException;

  /**
   * Creates a new comment to this activity.
   *
   * @param existingActivity the existing activity
   * @param newComment       the new created comment
   * @return the created comment
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  Comment createComment(Activity existingActivity, Comment newComment) throws AccessDeniedException, ServiceException;

  /**
   * Gets an existing comment by its id.
   *
   * @param commentId the comment id
   * @return the existing comment with the specified id
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  Comment getComment(String commentId) throws AccessDeniedException, ServiceException;

  /**
   * Updates an existing comment.
   *
   * @param existingComment
   * @return the updated comment
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  Comment updateComment(Comment existingComment) throws AccessDeniedException, ServiceException;

  /**
   * Deletes an existing comment.
   *
   * @param existingComment the existing comment
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  void deleteComment(Comment existingComment) throws AccessDeniedException, ServiceException;


  /**
   * An identity likes an activity.
   *
   * @param existingActivity the existing activity
   * @param existingIdentity the existing identity
   * @return the created {@link Like} instance
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  Like like(Activity existingActivity, Identity existingIdentity) throws AccessDeniedException, ServiceException;

  /**
   * Gets a like by its id.
   *
   * @param likeId the like id
   * @return a like instance specified by likeId
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  Like getLike(String likeId) throws AccessDeniedException, ServiceException;

  /**
   * An identity unlikes an activity.
   *
   * @param existingLike the existing like
   * @throws AccessDeniedException
   * @throws ServiceException
   */
  void unlike(Like existingLike) throws AccessDeniedException, ServiceException;

}
