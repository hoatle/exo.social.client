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
package org.exoplatform.social.client.core;


import org.exoplatform.social.client.api.ClientServiceFactory;
import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.service.ActivityService;
import org.exoplatform.social.client.api.service.IdentityService;
import org.exoplatform.social.client.api.service.VersionService;

/**
 * The base abstract class for integration test. This class is provided for extending to set the
 * restVersion for use by implementing {@link #setRestVersion()}.
 *
 * It's required for all tests to check {@link #canRunTest()} to make sure if the rest vesion is not supported
 * by server, just pass.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since 1.0.0-alpha2
 */
public abstract class AbstractClientTest {

  protected VersionService versionService;
  protected IdentityService<RestIdentity> identityService;
  protected ActivityService<RestActivity> activityService;

  private String defaultRestVersion;

  private boolean canRun = false;

  /**
   * template method
   */
  protected void beforeSetup() {

  }

  public void setUp() {
    beforeSetup();
    defaultRestVersion = SocialClientContext.getRestVersion();

    SocialClientContext.setProtocol("http");
    // Load host and port from System properties if available
    SocialClientContext.setHost(System.getProperty("social.server.host", "127.0.0.1"));
    SocialClientContext.setPort(Integer.getInteger("social.server.port", 8080));
    SocialClientContext.setPortalContainerName("socialdemo");
    SocialClientContext.setRestContextName("rest-socialdemo");
    setRestVersion();
    ClientServiceFactory clientServiceFactory = ClientServiceFactoryHelper.getClientServiceFactory();
    versionService = clientServiceFactory.createVersionService();
    String[] supportedVersions = versionService.getSupported();
    for (String supportedVersion : supportedVersions) {
      if (supportedVersion.equals(SocialClientContext.getRestVersion())) {
        canRun = true;
        break;
      }
    }
    identityService = clientServiceFactory.createIdentityService();
    activityService = clientServiceFactory.createActivityService();
    afterSetup();
  }

  /**
   * template method
   */
  protected void afterSetup() {

  }

  protected abstract void setRestVersion();

  /**
   * template method
   */
  protected void beforeTearDown() {

  }

  public void tearDown() {
    beforeTearDown();
    SocialClientContext.setProtocol("http");
    SocialClientContext.setHost(null);
    SocialClientContext.setPort(0);
    SocialClientContext.setPortalContainerName(null);
    SocialClientContext.setRestContextName(null);
    SocialClientContext.setRestVersion(defaultRestVersion);
    startSessionAsAnonymous();
    afterTearDown();
  }

  /**
   * template method
   */
  protected void afterTearDown() {

  };

  /**
   * To checks if the rest version is supported by the server to run tests, otherwise, just pass.
   *
   * @return a boolean value
   */
  protected boolean canRunTest() {
    return canRun;
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

}
