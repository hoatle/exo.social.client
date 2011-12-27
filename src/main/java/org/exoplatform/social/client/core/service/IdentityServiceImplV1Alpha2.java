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
import org.exoplatform.social.client.api.SocialClientLibException;
import org.exoplatform.social.client.api.UnsupportedMethodException;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.model.RestIdentityImpl;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.json.simple.parser.ParseException;

import static org.exoplatform.social.client.core.util.SocialHttpClientSupport.handleError;

/**
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since 10/6/11
 */
public class IdentityServiceImplV1Alpha2 implements IdentityService<RestIdentity> {

  private static final String BASE_URL = SocialHttpClientSupport.buildCommonRestPathFromContext(true);

  @Override
  public RestIdentity getIdentity(String identityProvider, String remoteId) throws SocialClientLibException {
    if ((identityProvider == null) || (remoteId == null)) throw new NullPointerException("Input param can not be null.");
    String targetURL = BASE_URL + "identity/" + identityProvider + "/" + remoteId + ".json";
    try {
      HttpResponse response = SocialHttpClientSupport.executeGet(targetURL, POLICY.BASIC_AUTH);
      handleError(response);
      return SocialJSONDecodingSupport.parser(RestIdentityImpl.class, response);
    } catch (IOException ioex) {
      throw new ServiceException(IdentityServiceImplV1Alpha2.class, "IOException when reads Json Content.", ioex);
    } catch (ParseException pex) {
      throw new ServiceException(IdentityServiceImplV1Alpha2.class, "ParseException when reads Json Content.", pex);
    }
  }

  @Override
  public String getIdentityId(String provider, String remoteId) throws SocialClientLibException {
    return getIdentity(provider, remoteId).getId();
  }

  @Override
  public RestIdentity create(RestIdentity newInstance) throws SocialClientLibException {
    throw new UnsupportedMethodException("Not Supported Yet.");
  }

  @Override
  public RestIdentity get(String uuid) throws SocialClientLibException {
    if (uuid == null) throw new NullPointerException("Input param can not be null");
    final String targetURL = BASE_URL + "identity/" + uuid + ".json";
    try {
      HttpResponse response = SocialHttpClientSupport.executeGet(targetURL, POLICY.BASIC_AUTH);
      handleError(response);
      return SocialJSONDecodingSupport.parser(RestIdentityImpl.class, response);
    } catch (IOException ioex) {
      throw new ServiceException(IdentityServiceImplV1Alpha2.class, "IOException when reads Json Content.", ioex);
    } catch (ParseException pex) {
      throw new ServiceException(IdentityServiceImplV1Alpha2.class, "ParseException when reads Json Content.", pex);
    }
  }

  @Override
  public RestIdentity update(RestIdentity existingInstance) throws SocialClientLibException {
    throw new UnsupportedMethodException("Not Supported Yet.");
  }

  @Override
  public RestIdentity delete(RestIdentity existingInstance) throws SocialClientLibException {
    throw new UnsupportedMethodException("Not Supported Yet.");
  }
}
