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

import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.core.model.ActivityImpl;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public class SocialHttpClientTest extends AbstractClientTest {
  @Before
  public void setUp() throws Exception {
    super.setUp();
   
  }
  
  @After
  public void tearDown() throws Exception {
    super.tearDown();
    
  }
   
  @Test
  public void testExecuteGetActivityWithHttpClient() throws Exception {
    final String targetURL = "/rest-socialdemo/private/api/social/v1-alpha1/socialdemo/activity/d51715397f0001010077b5d08ddf12fc.json?poster_identity=1&number_of_comments=10&activity_stream=t";
    HttpResponse response = SocialHttpClientSupport.executeGet(targetURL, POLICY.BASIC_AUTH);
    Assert.assertNotNull("HttpResponse must not be NULL.", response);
    DumpHttpResponse.dumpHeader(response);
    HttpEntity entity = SocialHttpClientSupport.processContent(response);
    Assert.assertNotNull("HttpEntity must not be NULL.", entity);
    DumpHttpResponse.dumpContent(entity);
    
    if (entity.getContentLength() != -1) {
      String body = EntityUtils.toString(entity);
      ActivityImpl model = SocialJSONDecodingSupport.parser(ActivityImpl.class, body);
      Assert.assertTrue(model.getId().length() > 0);
    }
    SocialHttpClientSupport.consume(entity);
  }
  
  
  @Test
  public void testExecuteGetActivityWithNotDump() throws Exception {
    final String targetURL = "/rest-socialdemo/private/api/social/v1-alpha1/socialdemo/activity/d51715397f0001010077b5d08ddf12fc.json?poster_identity=1&number_of_comments=10&activity_stream=t";
    HttpResponse response = SocialHttpClientSupport.executeGet(targetURL, POLICY.BASIC_AUTH);
    Assert.assertNotNull("HttpResponse must not be NULL.", response);
    ActivityImpl model = SocialJSONDecodingSupport.parser(ActivityImpl.class, response);
    Assert.assertTrue(model.getId().length() > 0);
  }
  
  @Test
  public void testGetByteArrayForPostActivity() throws Exception {
    String jsonActivity = "{\"title\":\"title from SocialHttlClientTest\",\"identityId\":\"d5039b437f0001010011fd153a4fcbd8\",\"liked\":true}";
    ActivityImpl model = SocialJSONDecodingSupport.parser(ActivityImpl.class, jsonActivity);
    System.out.println(model.toJSONString());
    Assert.assertNotNull(model);
    byte[] data = SocialHttpClientSupport.convertModelToByteArray(model);
    Assert.assertNotNull(data);
    Assert.assertTrue(data.length > 0);
  }
}
