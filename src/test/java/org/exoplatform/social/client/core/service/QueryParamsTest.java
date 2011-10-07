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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exoplatform.social.client.api.service.QueryParams;
import org.exoplatform.social.client.api.service.QueryParams.QueryParamOption;
import org.testng.annotations.Test;

/**
 * Unit test for {@link org.exoplatform.social.client.api.service.QueryParams}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  1.0.0-alpha2
 */
public class QueryParamsTest {

  @Test
  public void shouldBuildQuery() {
    QueryParams queryParams = new QueryParamsImpl();
    String queryPath = "";
    //add empty
    {
      queryPath = queryParams.buildQuery();
      //
      assertThat(queryPath, equalTo(""));
    }
    //add one Parameter
    {
      queryParams.clear();
      queryParams.append(QueryParams.IDENTITY_ID_PARAM.setValue("1234"));
      
      queryPath = queryParams.buildQuery();
      //      
      final String expectedQuery1 = "identity_id=1234";
      
      assertThat(queryPath, equalTo(expectedQuery1));
    }
    
    //add two Parameter
    {
      queryParams.clear();
      
      queryParams.append(QueryParams.IDENTITY_ID_PARAM.setValue("1234")).append(QueryParams.NUMBER_OF_COMMENTS_PARAM.setValue(2));
      
      queryPath = queryParams.buildQuery();
      //

      /*final String expectedQuery = "identity_id=1234&poster_identity=1&number_of_comments=10&number_of_likes=5" +
                                   "&activity_stream=t&limit=20&since_id=234567&max_id=345678";*/
      
      final String expectedQuery2 = "identity_id=1234&number_of_comments=2";
      
      assertThat(queryPath, equalTo(expectedQuery2));
    }
    
    //Remove parameter
    {
      queryParams.clear();
      queryParams.append(QueryParams.IDENTITY_ID_PARAM.setValue("1234"));
      queryParams.remove(QueryParams.IDENTITY_ID_PARAM);
      
      queryPath = queryParams.buildQuery();
      //
      final String expectedQuery3 = "";
      
      assertThat(queryPath, equalTo(expectedQuery3));
    }
    
    //add the Query Param Option which is existing. 
    {
      queryParams.clear();
      queryParams.append(QueryParams.IDENTITY_ID_PARAM.setValue("1234")).append(QueryParams.NUMBER_OF_COMMENTS_PARAM.setValue(5));

      queryPath = queryParams.buildQuery();
      
      final String expectedQuery4 = "identity_id=1234&number_of_comments=5";

      assertThat("QueryParamOption which is existing", queryPath, equalTo(expectedQuery4));
    }
    
    //add all parameter
    {
      queryParams.clear();
      queryParams.append(QueryParams.IDENTITY_ID_PARAM.setValue("1234"))
                 .append(QueryParams.POSTER_IDENTITY_PARAM.setValue("1"))
                 .append(QueryParams.NUMBER_OF_COMMENTS_PARAM.setValue(10))
                 .append(QueryParams.NUMBER_OF_LIKES_PARAM.setValue(5))
                 .append(QueryParams.ACTIVITY_STREAM_PARAM.setValue("t"))
                 .append(QueryParams.LIMIT_PARAM.setValue(20))
                 .append(QueryParams.SINCE_ID_PARAM.setValue("234567"))
                 .append(QueryParams.MAX_ID_PARAM.setValue("345678"));

      queryPath = queryParams.buildQuery();

      final String expectedQuery5 = "identity_id=1234&poster_identity=1&number_of_comments=10&number_of_likes=5" +
      "&activity_stream=t&limit=20&since_id=234567&max_id=345678";
      
      assertThat("All of QueryParamOption which is existing", queryPath, equalTo(expectedQuery5));
    }
  }
  
  @Test
  public void shouldGetQueryParam() {
    QueryParams queryParams = new QueryParamsImpl();
    //get QueryParamOption Null
    {
      QueryParamOption option = queryParams.get(QueryParams.NUMBER_OF_COMMENTS_PARAM);
      //
      assertThat(option, nullValue());
    }
    //get QueryParamOption Not Null
    {
      queryParams.clear();
      queryParams.append(QueryParams.IDENTITY_ID_PARAM.setValue("1234"));
      
      QueryParamOption option = queryParams.get(QueryParams.IDENTITY_ID_PARAM);
      
      assertThat(option, notNullValue());
            
      assertThat((String)option.getValue(), equalTo("1234"));
    }
    
    //get QueryParamOption Not Null with more existing
    {
      queryParams.clear();
      queryParams.append(QueryParams.IDENTITY_ID_PARAM.setValue("1234"))
                        .append(QueryParams.POSTER_IDENTITY_PARAM.setValue("1"))
                        .append(QueryParams.NUMBER_OF_COMMENTS_PARAM.setValue(10))
                        .append(QueryParams.NUMBER_OF_LIKES_PARAM.setValue(5))
                        .append(QueryParams.ACTIVITY_STREAM_PARAM)
                        .append(QueryParams.LIMIT_PARAM.setValue(20))
                        .append(QueryParams.SINCE_ID_PARAM.setValue("234567"))
                        .append(QueryParams.MAX_ID_PARAM.setValue("345678"));
      
      QueryParamOption option = queryParams.get(QueryParams.IDENTITY_ID_PARAM);
      
      assertThat(option, notNullValue());
            
      assertThat((String)option.getValue(), equalTo("1234"));
    }
  }

}
