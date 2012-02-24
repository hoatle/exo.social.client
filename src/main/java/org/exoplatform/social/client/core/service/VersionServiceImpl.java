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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.api.service.VersionService;
import org.exoplatform.social.client.api.util.SocialJSONDecodingSupport;

import static org.exoplatform.social.client.api.util.SocialHttpClientSupport.*;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 30, 2011  
 */
public class VersionServiceImpl implements VersionService {

  private final static String VERSION_FIELD = "version";
  private final static String SUPPORTED_FIELD = "versions";
  @Override
  public String getLatest() throws ServiceException{
    final String targetURL = "/" + SocialClientContext.getRestContextName() + "/api/social/version/latest.json";
    try {
      HttpResponse response = executeGet(targetURL, POLICY.NO_AUTH);
      handleError(response);
      String content = getContent(response);
      Map versionMap = SocialJSONDecodingSupport.parser(content);
      return (String) versionMap.get(VERSION_FIELD);
    } catch (Exception pex) {
      throw new ServiceException(VersionServiceImpl.class, "Failed to getLatest version", pex);
    }
  }

  @Override
  public String[] getSupported() throws ServiceException {
    final String targetURL = "/" + SocialClientContext.getRestContextName() + "/api/social/version/supported.json";
    try {
      HttpResponse response = executeGet(targetURL, POLICY.NO_AUTH);
      String content = getContent(response);
      handleError(response);
      Map versionMap = SocialJSONDecodingSupport.parser(content);
      List supportVersion = (LinkedList) versionMap.get(SUPPORTED_FIELD);
      return (String[]) supportVersion.toArray(new String[0]);
    } catch (Exception pex) {
      throw new ServiceException(VersionServiceImpl.class, "Failed to getSupported versions", pex);
    }
  }

  
}
