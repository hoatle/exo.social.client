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

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.net.SocialHttpClient;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public final class SocialHttpClientImpl implements SocialHttpClient {

  // Gzip of data shorter than this probably won't be worthwhile
  public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256;
  
  //Default connection and socket timeout of 60 seconds.  Tweak to taste.
  private static final int SOCKET_OPERATION_TIMEOUT = 60 * 1000;
  
  private final DefaultHttpClient delegate;
  
  /**
   * Create a new HttpClient with reasonable defaults.
   * @return SocialHttpClient for you to use for all your requests.
   */
  public static SocialHttpClient newInstance() {
    HttpParams params = new BasicHttpParams();

    // Turn off stale checking.  Our connections break all the time anyway,
    // and it's not worth it to pay the penalty of checking every time.
    HttpConnectionParams.setStaleCheckingEnabled(params, false);

    HttpConnectionParams.setConnectionTimeout(params, SOCKET_OPERATION_TIMEOUT);
    HttpConnectionParams.setSoTimeout(params, SOCKET_OPERATION_TIMEOUT);
    HttpConnectionParams.setSocketBufferSize(params, 8192);
    // Don't handle redirects -- return them to the caller.  Our code
    // often wants to re-POST after a redirect, which we must do ourselves.
    HttpClientParams.setRedirecting(params, false);

    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    ClientConnectionManager manager = new ThreadSafeClientConnManager(params, schemeRegistry);
    return new SocialHttpClientImpl(manager, params);
  }
  
  private SocialHttpClientImpl(ClientConnectionManager ccm, HttpParams params) {
    //delegate = new DefaultHttpClient(ccm, params);
    
    delegate = new DefaultHttpClient(ccm, params) {
      /*
      @Override
      protected BasicHttpProcessor createHttpProcessor() {
          // Add interceptor to prevent making requests from main thread.
          BasicHttpProcessor processor = super.createHttpProcessor();
          return processor;
      }*/
      
      @Override
      protected HttpContext createHttpContext() {
          // Same as DefaultHttpClient.createHttpContext() minus the
          // cookie store.
          HttpContext context = new BasicHttpContext();
          context.setAttribute(ClientContext.AUTHSCHEME_REGISTRY, getAuthSchemes());
          context.setAttribute(ClientContext.COOKIESPEC_REGISTRY, getCookieSpecs());
          context.setAttribute(ClientContext.CREDS_PROVIDER, getCredentialsProvider());
          return context;
      }
    };
    
    delegate.getCredentialsProvider().setCredentials(new AuthScope(SocialClientContext.getHost(), SocialClientContext.getPort()), 
                                            new UsernamePasswordCredentials(SocialClientContext.getUsername(), SocialClientContext.getPassword()));
    
  }
  
  @Override
  public HttpParams getParams() {
    
    return delegate.getParams();
  }

  @Override
  public ClientConnectionManager getConnectionManager() {
    return delegate.getConnectionManager();
  }

  @Override
  public HttpResponse execute(HttpUriRequest request) throws IOException, ClientProtocolException {
    return delegate.execute(request);
  }

  @Override
  public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException,
                                                                          ClientProtocolException {
    return delegate.execute(request, context);
  }

  @Override
  public HttpResponse execute(HttpHost target, HttpRequest request) throws IOException,
                                                                   ClientProtocolException {
    return delegate.execute(target, request);
  }

  @Override
  public HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws IOException,
                                                                                        ClientProtocolException {
    return delegate.execute(target, request, context);
  }

  @Override
  public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler) throws IOException,
                                                                                            ClientProtocolException {
    return delegate.execute(request, responseHandler);
  }

  @Override
  public <T> T execute(HttpUriRequest request,
                       ResponseHandler<? extends T> responseHandler,
                       HttpContext context) throws IOException, ClientProtocolException {
    return delegate.execute(request, responseHandler, context);

  }

  @Override
  public <T> T execute(HttpHost target,
                       HttpRequest request,
                       ResponseHandler<? extends T> responseHandler) throws IOException,
                                                                    ClientProtocolException {
    return delegate.execute(target, request, responseHandler);
  }

  @Override
  public <T> T execute(HttpHost target,
                       HttpRequest request,
                       ResponseHandler<? extends T> responseHandler,
                       HttpContext context) throws IOException, ClientProtocolException {
    return delegate.execute(target, request, responseHandler, context);
  }
  
  

}
