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
package org.exoplatform.social.client.core.net;

import java.util.Map;

import org.apache.http.HttpResponse;
import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.model.Identity;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.core.model.IdentityImpl;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.junit.After;
import org.junit.Before;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public abstract class AbstractClientTest {

  @Before
  public void setUp() throws Exception {
    SocialClientContext.setPort(8080);
    SocialClientContext.setUsername("root");
    SocialClientContext.setPassword("gtn");
    SocialClientContext.setProtocol("http");
  }
  
  @After
  public void tearDown() throws Exception {
    SocialClientContext.setPort(0);
    SocialClientContext.setUsername(null);
    SocialClientContext.setPassword(null);
    SocialClientContext.setProtocol(null);
  }
  
  
  /**
   * Getting the DemoIdenityt
   * @return
   * @throws Exception
   */
  protected String getDemoIdentityId() throws Exception {
    final String targetURL = "/" + SocialClientContext.getRestContextName() + "/socialdemo/social/identity/demo/id/show.json";
    HttpResponse response = SocialHttpClientSupport.executeGet(targetURL, POLICY.BASIC_AUTH);
    SocialHttpClientSupport.handleError(response);
    String content = SocialHttpClientSupport.getContent(response);
    Map identityMap = SocialJSONDecodingSupport.parser(content);
    return (String) identityMap.get("id");
  }
  /**
   * 
   * @param uid
   * @return
   * @throws Exception
   */
  private Identity getDemoIdentityById(String uid) throws Exception {
    final String targetURL = "/" + SocialClientContext.getRestContextName() + "/api/social/v1-alpha1/portal/identity/" + uid + ".json";
    HttpResponse response = SocialHttpClientSupport.executeGet(targetURL, POLICY.BASIC_AUTH);
    SocialHttpClientSupport.handleError(response);
    DumpHttpResponse.dumpHeader(response);
    DumpHttpResponse.dumpContent(response);
    Identity gotDemoIdentity = SocialJSONDecodingSupport.parser(IdentityImpl.class, response);
    return gotDemoIdentity;
  }
}
