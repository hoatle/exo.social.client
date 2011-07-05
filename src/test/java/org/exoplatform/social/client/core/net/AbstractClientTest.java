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
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.ServiceException;
import org.exoplatform.social.client.core.service.IdentityServiceImpl;
import org.junit.After;
import org.junit.Before;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public abstract class AbstractClientTest {

  protected IdentityService<Identity> identityService;
  
  @Before
  public void setUp() {
    SocialClientContext.setProtocol("http");
    // Load host and port from System properties if available
    SocialClientContext.setHost(System.getProperty("social.server.host","127.0.0.1"));
    SocialClientContext.setPort(Integer.getInteger("social.server.port",8080));
    SocialClientContext.setPortalContainerName("socialdemo");
    SocialClientContext.setRestContextName("rest-socialdemo");
    SocialClientContext.setRestVersion("v1-alpha1");
    SocialClientContext.setIsDeveloping(true);
    identityService = new IdentityServiceImpl();
  }
  
  @After
  public void tearDown() {
    SocialClientContext.setProtocol("http");
    SocialClientContext.setHost(null);
    SocialClientContext.setPort(0);
    SocialClientContext.setPortalContainerName(null);
    SocialClientContext.setRestContextName(null);
    SocialClientContext.setRestVersion("v1-alpha1");
    SocialClientContext.setIsDeveloping(false);
    startSessionAsAnonymous();
    identityService = null;
  }

  /**
   * Starts new session to make any request as anonymous user.
   */
  public void startSessionAsAnonymous() {
    SocialClientContext.setUsername(null);
    SocialClientContext.setPassword(null);
  }

  /**
   * Starts new session as a authenticated user (with username and password) to make any request.
   *
   * @param username  the username
   * @param password  the password
   */
  public void startSessionAs(String username, String password) {
    SocialClientContext.setUsername(username);
    SocialClientContext.setPassword(password);
  }
  /**
   * Support to get the IdentityId value.
   * @return
   */
  protected String getDemoIdentityId() throws ServiceException {
    return identityService.getIdentityId("organization", "demo");
  }
  
}
