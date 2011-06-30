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
import org.apache.http.util.EntityUtils;
import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.net.SocialHttpClient;
import org.exoplatform.social.client.api.net.SocialHttpClient.POLICY;
import org.exoplatform.social.client.api.net.SocialHttpClientException;
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
   * @param withBasicAuthenticate Making the Request to Rest Service with Basic Authenticate.
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executeGet(String targetURL, POLICY authPolicy) throws SocialHttpClientException {
    SocialHttpClient httpClient = SocialHttpClientImpl.newInstance();
    if (POLICY.BASIC_AUTH == authPolicy) { 
      httpClient.setBasicAuthenticateToRequest();
    }
    
    HttpGet httpGet = new HttpGet(targetURL);
    Header header = new BasicHeader("Content-Type", "application/json");
    httpGet.setHeader(header);
    
    
    HttpHost targetHost = new HttpHost(SocialClientContext.getHost(), SocialClientContext.getPort(), SocialClientContext.getProtocol()); 
    try {
      return httpClient.execute(targetHost, httpGet);
    } catch (ClientProtocolException cpex) {
      throw new SocialHttpClientException(cpex.toString(), cpex);
    } catch (IOException ioex) {
      throw new SocialHttpClientException(ioex.toString(), ioex);
    }
  }
  
  /**
   * Invokes the social rest service via Post
   * @param targetURL 
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executePost(String targetURL) throws SocialHttpClientException {
    HttpHost targetHost = new HttpHost(SocialClientContext.getHost(), SocialClientContext.getPort(), SocialClientContext.getProtocol()); 
    HttpClient httpClient = SocialHttpClientImpl.newInstance();

    
    HttpPost httpPost = new HttpPost(targetURL);
    Header header = new BasicHeader("Content-Type", "application/json");
    httpPost.setHeader(header);
    
    
    try {
      return httpClient.execute(targetHost, httpPost);
    } catch (ClientProtocolException cpex) {
      throw new SocialHttpClientException(cpex.toString(), cpex);
    } catch (IOException ioex) {
      throw new SocialHttpClientException(ioex.toString(), ioex);
    }
   
  }
  
  
  /**
   * Executes the HttpResponse with read the content to buffered.
   * @param response HttpResponse to process.
   * @return
   * @throws IllegalStateException
   * @throws IOException
   */
  public static HttpEntity processContent(HttpResponse response) throws SocialHttpClientException {
    if (response == null)
      throw new NullPointerException("HttpResponse argument is not NULL.");
    HttpEntity entity = response.getEntity();
    //Reading the content to the buffered.
    if (entity != null) {
      try {
        entity = new BufferedHttpEntity(entity);
      } catch (IOException ioex) {
        throw new SocialHttpClientException(ioex.toString(), ioex);
      }
    }
    return entity;
  }
  
  /**
   * Executes the HttpResponse with read the content to buffered.
   * @param response HttpResponse to process.
   * @return Content of HttpResponse.
   * @throws IllegalStateException
   * @throws IOException
   */
  public static String getContent(HttpResponse response) throws SocialHttpClientException {
    if (response == null)
      throw new NullPointerException("HttpResponse argument is not NULL.");
    HttpEntity entity = processContent(response);
    String content;
    try {
      if (entity.getContentLength() != -1) {
        content = EntityUtils.toString(entity);
      } else {
        throw new SocialHttpClientException("Content of response is empty.");
      }
    } catch (IOException ioex) {
      throw new SocialHttpClientException(ioex.toString(), ioex);
    }
    return content;
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
  /**
   *
   * @author Ly Minh Phuong - http://phuonglm.net
   * @param isPrivate
   * @return
   */
  public static String buildURLFromContext(boolean isPrivate){
    String privateURL = "";
    if(isPrivate){
      privateURL = "private";
    }
    return SocialClientContext.getProtocol()+"://"+SocialClientContext.getHost()+":"+ SocialClientContext.getPort()+
           "/" + SocialClientContext.getRestContextName() + "/" +privateURL + "/api/social/"+ SocialClientContext.getRestVersion() +
           "/" + SocialClientContext.getPortalContainerName() + "/";
  }
}
