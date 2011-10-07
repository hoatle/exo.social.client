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
package org.exoplatform.social.client.core.service;

import org.exoplatform.social.client.api.service.QueryParams;

/**
 * Implementation of {@link org.exoplatform.social.client.api.service.QueryParams}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Oct 6, 2011
 * @since 1.0.0-alpha2
 */
@SuppressWarnings("serial")
public class QueryParamsImpl implements QueryParams {
 
  private QueryParamOption queryParams[] = new QueryParamOption[0];
  /**
   * Locks object for change to listeners
   */
  private final Object lock = new Object();
  
  @Override
  public QueryParams append(QueryParamOption param) {
    
    synchronized(lock) {
      int n = -1;
      for (int i = 0; i < queryParams.length; i++) {
        if (queryParams[i].equals(param)) {
          n = i;
          break;
        }
      }
      
      //not found any QueryOptionParam in QueryParamOption[]
      if (n < 0) {
        QueryParamOption results[] = new QueryParamOption[queryParams.length + 1];
        System.arraycopy(queryParams, 0, results, 0, queryParams.length);
        //Add the Query Parameter to the new position.    
        results[queryParams.length] = param;
        queryParams = results;
      } else {
        queryParams[n].setValue(param.getValue());
      }
    }
    return this;
  }
  
  
  
  @Override
  public QueryParams remove(QueryParamOption param) {
    synchronized (lock) {
      int n = -1;
      for (int i = 0; i < queryParams.length; i++) {
        if (queryParams[i].equals(param)) {
          n = i;
          break;
        }
      }
      //not found any QueryOptionParam in QueryParamOption[]
      if (n < 0) {
        return this;
      }

      //Execute to remove the Query Param
      QueryParamOption results[] = new QueryParamOption[queryParams.length - 1];
      int j = 0;
      for (int i = 0; i < queryParams.length; i++) {
        if (i != n) {
          results[j++] = queryParams[i];
        }
      }
      queryParams = results;
    }
    return this;
  }

  @Override
  public String buildQuery() {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < queryParams.length; i++) {
      sb.append(queryParams[i].getQueryName()).append("=").append(queryParams[i].getValue());
      
      if (i < queryParams.length -1)
        sb.append("&");
    }
    return sb.toString();
  }

  @Override
  public void clear() {
    queryParams = new QueryParamOption[0];
  }
  
  @Override
  public QueryParamOption get(QueryParamOption param) {
    synchronized (lock) {
      int n = -1;
      for (int i = 0; i < queryParams.length; i++) {
        if (queryParams[i].equals(param)) {
          n = i;
          break;
        }
      }
      //not found any QueryOptionParam in QueryParamOption[]
      if (n < 0) {
        return null;
      }
      
      return queryParams[n];
    }//end lock
  }
  
}
