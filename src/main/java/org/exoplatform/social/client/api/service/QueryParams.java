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
package org.exoplatform.social.client.api.service;


/**
 * This class allows setting query params for services, this usually the optional params.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Oct 6, 2011
 * @since 1.0.0-alpha2
 */
public interface QueryParams {
  
  public final static QueryParamOption IDENTITY_ID_PARAM = new QueryParamOption("identity_id", null);
  
  public final static QueryParamOption POSTER_IDENTITY_PARAM = new QueryParamOption("poster_identity", null);
  
  public final static QueryParamOption NUMBER_OF_COMMENTS_PARAM = new QueryParamOption("number_of_comments", null);
  
  public final static QueryParamOption NUMBER_OF_LIKES_PARAM = new QueryParamOption("number_of_likes", null) {};
  
  public final static QueryParamOption ACTIVITY_STREAM_PARAM = new QueryParamOption("activity_stream", null) {};
  
  public final static QueryParamOption LIMIT_PARAM = new QueryParamOption("limit", null) {};
  
  public final static QueryParamOption SINCE_ID_PARAM = new QueryParamOption("since_id", null) {};
  
  public final static QueryParamOption MAX_ID_PARAM = new QueryParamOption("max_id", null) {};

  /**
   * Append the query parameter for build URL Request.
   * @param param
   * @return
   */
  QueryParams append(QueryParamOption param);
  
  /**
   * Removes the query parameter.
   * @param param
   * @return
   */
  QueryParams remove(QueryParamOption param);
  /**
   * Builds the query string based on the setted value.
   * For example output: limit=20&since_id=1234&number_of_comments=7
   *
   * @return
   */
  String buildQuery();
  
  /**
   * Clear all of Query Parameters.
   */
  void clear();
  /**
   * Gets QueryParamOption which was existing.
   * @param param
   * @return
   */
  QueryParamOption get(QueryParamOption param);
  /**
   * Defines the Query Parameter for create Base URL.
   * @author thanh_vucong
   *
   * @param <T>
   */
  public static class QueryParamOption {
    private final String queryName;
    private Object value;
    
    public QueryParamOption(final String queryName, Object defaultValue) {
      this.queryName = queryName;
      this.value = defaultValue;
    }

    /**
     * Gets query parameter name
     * @return
     */
    public String getQueryName() {
      return queryName;
    }

    /**
     * Gets the default value for query parameter.
     * @return  T
     */
    public Object getValue() {
      return value;
    }
    
    /**
     * Sets value for Query Parameter
     * @param value
     */
    public QueryParamOption setValue(Object value) {
      this.value = value;
      return this;
    }
    
    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      
      QueryParamOption other = null;
      if (obj instanceof QueryParamOption) {
        other = (QueryParamOption) obj;
      } else {
        return false;
      }
      
      return this.queryName.equals(other.queryName);
    }
    
    
  }
}
