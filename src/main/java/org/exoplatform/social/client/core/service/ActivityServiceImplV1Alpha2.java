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

import org.exoplatform.social.client.api.auth.AccessDeniedException;
import org.exoplatform.social.client.api.common.RealtimeListAccess;
import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestComment;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.model.RestLike;
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.ServiceException;

/**
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since 10/6/11
 */
public class ActivityServiceImplV1Alpha2 implements ActivityService<RestActivity> {
  @Override
  public RealtimeListAccess<RestActivity> getActivityStream(RestIdentity ownerStreamRestIdentity) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RealtimeListAccess<RestActivity> getSpacesActivityStream(RestIdentity userRestIdentity) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RealtimeListAccess<RestActivity> getConnectionsActivityStream(RestIdentity userRestIdentity) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RealtimeListAccess<RestActivity> getFeedActivityStream(RestIdentity userRestIdentity) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RestComment createComment(RestActivity existingActivity, RestComment newRestComment) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RestComment getComment(String commentId) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RestComment deleteComment(RestComment existingRestComment) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RestLike like(RestActivity existingActivity) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RestLike unlike(RestActivity existingActivity) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RestActivity create(RestActivity newInstance) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RestActivity get(String uuid) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RestActivity update(RestActivity existingInstance) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public RestActivity delete(RestActivity existingInstance) throws AccessDeniedException, ServiceException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
