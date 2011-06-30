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

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.exoplatform.social.client.api.auth.AccessDeniedException;
import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.model.IdentityImpl;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.json.simple.parser.ParseException;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 30, 2011  
 */
public class IdentityServiceImpl extends ServiceBase<Identity, IdentityService<Identity>> implements IdentityService<Identity> {

  @Override
  public Identity create(Identity newInstance) throws AccessDeniedException, ServiceException {
    return null;
  }

  @Override
  public Identity get(String uuid) throws AccessDeniedException, ServiceException {
    final String targetURL = "" + uuid;
    HttpResponse response = SocialHttpClientSupport.executeGet(targetURL, POLICY.BASIC_AUTH);
    try {
      return SocialJSONDecodingSupport.parser(IdentityImpl.class, response);
    } catch (IOException ioex) {
      throw new ServiceException(ActivityServiceImpl.class, "IOException when reads Json Content.", ioex);
      
    } catch (ParseException pex) {
      throw new ServiceException(ActivityServiceImpl.class, "ParseException when reads Json Content.", pex);
    }
  }

  @Override
  public Identity update(Identity existingInstance) throws AccessDeniedException, ServiceException {
    return null;
  }

  @Override
  public void delete(Identity existingInstance) throws AccessDeniedException, ServiceException {
    // TODO Auto-generated method stub
    
  }

}
