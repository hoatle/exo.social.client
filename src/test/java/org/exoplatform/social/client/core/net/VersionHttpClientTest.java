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

import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 30, 2011  
 */
public class VersionHttpClientTest extends AbstractClientTest {

  @Before
  public void setUp() throws Exception {
    super.setUp();
    
  }
  
  @After
  public void tearDown() throws Exception {
    super.tearDown();
  }
  
  @Test
  public void testGetLatestVersion() throws Exception {
    final String targetURL = "/rest-socialdemo/api/social/version/latest.json";
    HttpResponse response = SocialHttpClientSupport.executeGet(targetURL, POLICY.NO_AUTH);
    Assert.assertNotNull("HttpResponse must not be NULL.", response);
    DumpHttpResponse.dumpHeader(response);
    DumpHttpResponse.dumpContent(response);
    
    String body = SocialHttpClientSupport.getContent(response);
    Map versionMap = SocialJSONDecodingSupport.parser(body);
    Assert.assertEquals("Verifying the version of rest service.", SocialClientContext.getRestVersion(), versionMap.get("version"));
    
  }
  
  @Test
  public void testGetSupportedVersion() throws Exception {
    final String targetURL = "/rest-socialdemo/api/social/version/supported.json";
    HttpResponse response = SocialHttpClientSupport.executeGet(targetURL, POLICY.NO_AUTH);
    Assert.assertNotNull("HttpResponse must not be NULL.", response);
    DumpHttpResponse.dumpHeader(response);
    DumpHttpResponse.dumpContent(response);
    
    String body = SocialHttpClientSupport.getContent(response);
    
    Map versionMap = SocialJSONDecodingSupport.parser(body);
    String supportedVersion = (String) versionMap.get("versions");
    String[] versions = supportedVersion.split(",");
    Assert.assertTrue("Verifying the version of rest service.", versions.length > 0);
  }
}
