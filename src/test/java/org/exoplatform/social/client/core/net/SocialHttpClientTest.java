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

import org.exoplatform.social.client.api.net.SocialHttpClient;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public class SocialHttpClientTest extends AbstractClientTest {

  private SocialHttpClient socialHttpClient;

  public void setUp() {
    super.setUp();
    socialHttpClient = SocialHttpClientImpl.newInstance();
  }

  public void tearDown() {
    super.tearDown();
    socialHttpClient = null;
  }

  /**
   * Tests {@link org.exoplatform.social.client.api.net.SocialHttpClient#setBasicAuthenticateToRequest()}.
   */
  @Test
  public void testSetBasicAuthenticateToRequest() {

  }

  /**
   * Tests {@link org.exoplatform.social.client.api.net.SocialHttpClient#getParams()}.
   */
  @Test
  public void testGetParams() {

  }

  /**
   * Tests {@link org.exoplatform.social.client.api.net.SocialHttpClient#getConnectionManager()}.
   */
  @Test
  public void testGetConnectionManager() {

  }

  /**
   * Tests {@link SocialHttpClient#execute(org.apache.http.client.methods.HttpUriRequest)}.
   */
  @Test
  public void testExecuteARequest() {

  }

  /**
   * Tests {@link SocialHttpClient#execute(org.apache.http.client.methods.HttpUriRequest,
   * org.apache.http.protocol.HttpContext)}.
   */
  @Test
  public void testExecuteARequestWithContext() {

  }

  /**
   * Tests {@link SocialHttpClient#execute(org.apache.http.HttpHost, org.apache.http.HttpRequest)}.
   */
  @Test
  public void testExecuteARequestToATarget() {

  }

  /**
   * Tests {@link SocialHttpClient#execute(org.apache.http.HttpHost, org.apache.http.HttpRequest,
   * org.apache.http.protocol.HttpContext)}.
   */
  @Test
  public void testExecuteARequestToATargetWithContext() {

  }

  /**
   * Tests {@link SocialHttpClient#execute(org.apache.http.client.methods.HttpUriRequest,
   * org.apache.http.client.ResponseHandler)}.
   */
  @Test
  public void testExecuteARequestWithResponseHandler() {

  }

  /**
   * Tests {@link SocialHttpClient#execute(org.apache.http.client.methods.HttpUriRequest,
   * org.apache.http.client.ResponseHandler, org.apache.http.protocol.HttpContext)}.
   */
  @Test
  public void testExecuteARequestWithResponseHandlerAndContext() {

  }

  /**
   * Tests {@link SocialHttpClient#execute(org.apache.http.HttpHost, org.apache.http.HttpRequest,
   * org.apache.http.client.ResponseHandler, org.apache.http.protocol.HttpContext)}.
   */
  @Test
  public void testExcecuteARequestToATargetWithResponseHandler() {

  }

  /**
   * Tests {@link SocialHttpClient#execute(org.apache.http.HttpHost, org.apache.http.HttpRequest,
   * org.apache.http.client.ResponseHandler, org.apache.http.protocol.HttpContext)}.
   */
  @Test
  public void testExecuteARequestToATargetWithResponseHandlerAndContext() {

  }

}
