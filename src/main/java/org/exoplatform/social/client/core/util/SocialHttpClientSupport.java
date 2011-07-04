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
import java.io.StringWriter;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.model.Model;
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
   * Invokes the social rest service via Get method
   * @param targetURL 
   * @param authPolicy POLICY.NO_AUTH/POLICY.BASIC_AUTH
   * @param params HttpParams for Request
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executeGet(String targetURL, POLICY authPolicy, HttpParams params) throws SocialHttpClientException {
    SocialHttpClient httpClient = SocialHttpClientImpl.newInstance();
    if (POLICY.BASIC_AUTH == authPolicy) { 
      httpClient.setBasicAuthenticateToRequest();
    }
    
    HttpGet httpGet = new HttpGet(targetURL);
    Header header = new BasicHeader("Content-Type", "application/json");
    httpGet.setHeader(header);
    //Get method with the HttpParams
    if (params != null) {
      httpGet.setParams(params);
    }
    
    HttpHost targetHost = new HttpHost(SocialClientContext.getHost(), SocialClientContext.getPort(), SocialClientContext.getProtocol());
    //Debugging in the devlopment mode
    if (SocialClientContext.isDeveloping()) {
      dumpHttpRequestHeader(httpGet);
    }
    try {
      return httpClient.execute(targetHost, httpGet);
    } catch (ClientProtocolException cpex) {
      throw new SocialHttpClientException(cpex.toString(), cpex);
    } catch (IOException ioex) {
      throw new SocialHttpClientException(ioex.toString(), ioex);
    }
  }
  
  /**
   * Invokes the social rest service via Get method
   * @param targetURL 
   * @param authPolicy POLICY.NO_AUTH/POLICY.BASIC_AUTH
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executeGet(String targetURL, POLICY authPolicy) throws SocialHttpClientException {
    return executeGet(targetURL, authPolicy, null);
  }
  
  /**
   * Invokes the social rest service via Post method
   * @param targetURL 
   * @param authPolicy POLICY.NO_AUTH/POLICY.BASIC_AUTH
   * @param params HttpParams for Request
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executePost(String targetURL, POLICY authPolicy, HttpParams params, Model model) throws SocialHttpClientException {
    HttpHost targetHost = new HttpHost(SocialClientContext.getHost(), SocialClientContext.getPort(), SocialClientContext.getProtocol()); 
    HttpClient httpClient = SocialHttpClientImpl.newInstance();

    
    HttpPost httpPost = new HttpPost(targetURL);
    Header header = new BasicHeader("Content-Type", "application/json");
    httpPost.setHeader(header);
    //Post method with the HttpParams
    if (params != null) {
      httpPost.setParams(params);
    }
    try {
      
      //Provides when uses post so does not have any data.
      byte[] postData = convertModelToByteArray(model);
      if (postData != null) {
        ByteArrayEntity entity = new ByteArrayEntity(convertModelToByteArray(model));
        httpPost.setEntity(entity);
      }
      //Debugging in the devlopment mode
      if (SocialClientContext.isDeveloping()) {
        dumpHttpRequestHeader(httpPost);
      }
      return httpClient.execute(targetHost, httpPost);
    } catch (ClientProtocolException cpex) {
      throw new SocialHttpClientException(cpex.toString(), cpex);
    } catch (IOException ioex) {
      throw new SocialHttpClientException(ioex.toString(), ioex);
    }
   
  }
  
  /**
   * Invokes the social rest service via Post method with <code>Model</code> and HttpParams is null.
   * @param targetURL 
   * @param authPolicy POLICY.NO_AUTH/POLICY.BASIC_AUTH
   * @param params HttpParams for Request
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executePost(String targetURL, POLICY authPolicy, HttpParams params) throws SocialHttpClientException {
    return executePost(targetURL, authPolicy, params, null);
  }
  
  /**
   * Invokes the social rest service via Post method with <code>Model</code> is null and HttpParams.
   * @param targetURL 
   * @param authPolicy POLICY.NO_AUTH/POLICY.BASIC_AUTH
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executePost(String targetURL, POLICY authPolicy, Model model) throws SocialHttpClientException {
    return executePost(targetURL, authPolicy, null, model);
  }
  /**
   * Invokes the social rest service via Post but both <code>Model</code> and HttpParams are null.
   * 
   * @param targetURL
   * @param authPolicy POLICY.NO_AUTH/POLICY.BASIC_AUTH
   * @return
   * @throws SocialHttpClientException
   */
  public static HttpResponse executePost(String targetURL, POLICY authPolicy) throws SocialHttpClientException {
    return executePost(targetURL, authPolicy, null, null);
  }
  
  
  
  
  /**
   * Invokes the social rest service via Delete method with HttpParams
   * @param targetURL 
   * @param authPolicy POLICY.NO_AUTH/POLICY.BASIC_AUTH
   * @param params HttpParams for Request
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executeDelete(String targetURL, POLICY authPolicy, HttpParams params) throws SocialHttpClientException {
    HttpHost targetHost = new HttpHost(SocialClientContext.getHost(), SocialClientContext.getPort(), SocialClientContext.getProtocol()); 
    HttpClient httpClient = SocialHttpClientImpl.newInstance();

    
    HttpDelete httpDelete = new HttpDelete(targetURL);
    Header header = new BasicHeader("Content-Type", "application/json");
    httpDelete.setHeader(header);
    //Delete method with the HttpParams
    if (params != null) {
      httpDelete.setParams(params);
    }
    try {
      //Debugging in the devlopment mode
      if (SocialClientContext.isDeveloping()) {
        dumpHttpRequestHeader(httpDelete);
      }
      return httpClient.execute(targetHost, httpDelete);
    } catch (ClientProtocolException cpex) {
      throw new SocialHttpClientException(cpex.toString(), cpex);
    } catch (IOException ioex) {
      throw new SocialHttpClientException(ioex.toString(), ioex);
    }
   
  }
  
  
  /**
   * Invokes the social rest service via Delete method with HttpParams is null.
   * @param targetURL 
   * @param authPolicy POLICY.NO_AUTH/POLICY.BASIC_AUTH
   * @return
   * @throws IOException 
   * @throws ClientProtocolException 
   */
  public static HttpResponse executeDelete(String targetURL, POLICY authPolicy) throws SocialHttpClientException {
    return executeDelete(targetURL, authPolicy, null);
  }
  
  
  /**
   * Gets the byte array from Model object which provides 
   * to HttpPost to Rest Service.
   * 
   * @param model Model object
   * @return
   * @throws IOException
   */
  public static byte[] convertModelToByteArray(Model model) throws IOException {
    if (model == null) {
      return null;
    }
    StringWriter writer = new StringWriter();
    model.writeJSONString(writer);
    return writer.getBuffer().toString().getBytes("UTF-8");
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
    //contentObtained = false: Content does not get yet.
    //contentObtained = true: Content is buffered by BufferedHttpEntity.
    if (entity != null && entity.isStreaming()) {
      try {
        entity = new BufferedHttpEntity(entity);
        //important to setEntity return to Response. If don't assign again, next to get
        //, you can not get the response content 
        response.setEntity(entity);
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
   * Handling the error code which contains in HttpResponse. 
   * @param response HttpResponse
   * @throws SocialHttpClientException
   */
  public static void handleError(HttpResponse response) throws SocialHttpClientException {
    if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
      throw new SocialHttpClientException(response.getStatusLine().toString());
    }
  }
  
  /**
   * Dump the HttpRequestHeader for debugging.
   * @param request
   */
  public static void dumpHttpRequestHeader(HttpRequest request) {
    Header[] headers = request.getAllHeaders();
    System.out.println("\n\n++++++++++HEADER OF RESPONSE+++++++++++++++++++++++\n\n");
    for (int i = 0; i < headers.length; i++) {
      System.out.println(headers[i].getName() + " : " + headers[i].getValue());
    }
  }
}
