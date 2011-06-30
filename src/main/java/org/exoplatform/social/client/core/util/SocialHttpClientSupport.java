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
package org.exoplatform.social.client.core.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.message.BasicHeader;
import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.net.SocialHttpClient;
import org.exoplatform.social.client.core.net.SocialHttpClientImpl;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public class SocialHttpClientSupport {

  /**
   * Invokes the social rest service via Get
   * @param targetURL 
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executeGet(String targetURL) throws ClientProtocolException, IOException {
    SocialHttpClient httpClient = SocialHttpClientImpl.newInstance();
    
    HttpGet httpget = new HttpGet(targetURL);
    Header header = new BasicHeader("Content-Type", "application/json");
    httpget.setHeader(header);
    
    HttpHost targetHost = new HttpHost(SocialClientContext.getHost(), SocialClientContext.getPort(), SocialClientContext.getProtocol()); 
    return httpClient.execute(targetHost, httpget);
   
  }
  
  /**
   * Invokes the social rest service via Post
   * @param targetURL 
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executePost(String targetURL) throws ClientProtocolException, IOException {
    HttpHost targetHost = new HttpHost(SocialClientContext.getHost(), SocialClientContext.getPort(), SocialClientContext.getProtocol()); 
    HttpClient httpClient = SocialHttpClientImpl.newInstance();

    HttpPost httppost = new HttpPost(targetURL);
    Header header = new BasicHeader("Content-Type", "application/json");
    httppost.setHeader(header);
    return httpClient.execute(targetHost, httppost);
   
  }
  
  
  /**
   * Executes the HttpResponse with read the content to buffered.
   * @param response HttpResponse to process.
   * @return
   * @throws IllegalStateException
   * @throws IOException
   */
  public static HttpEntity processContent(HttpResponse response) throws IllegalStateException, IOException {
    if (response == null)
      throw new NullPointerException("HttpResponse argument is not NULL.");
    HttpEntity entity = response.getEntity();
    //Reading the content to the buffered.
    if (entity != null) {
      entity = new BufferedHttpEntity(entity);
    }
    return entity;
  }
  
  /**
   * Checks the entity and close InputStream
   * @param entity
   * @throws IllegalStateException
   * @throws IOException
   */
  public static void consume(HttpEntity entity) throws IllegalStateException, IOException {
    if (entity.isStreaming()) {
      InputStream inputstream = entity.getContent();
      if (inputstream != null) {
        inputstream.close();
      }
    }
  }
}
