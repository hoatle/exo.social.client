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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.exoplatform.social.client.api.net.SocialHttpClientException;
import org.exoplatform.social.client.core.util.SocialHttpClientSupport;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public class DumpHttpResponse {
  private static final Logger LOGGER = LoggerFactory.getLogger(DumpHttpResponse.class);
  
  /**
   * Dump the HttpResponse content which Rest Service to return.
   * @param entity Entity to dump
   * @throws ParseException
   * @throws IOException
   */
  public static void dumpContent(HttpResponse response) throws SocialHttpClientException {
    String responseContent = SocialHttpClientSupport.getContent(response);
    if (responseContent.length() > 0) {
      LOGGER.debug("\n\n++++++++++CONTENT OF RESPONSE+++++++++++++++++++++++\n\n");
      LOGGER.debug("RESPONSE CONTENT::" + responseContent);
      try {
          Map contentMap = SocialJSONDecodingSupport.parser(responseContent);
          Set<Entry> list = contentMap.entrySet();
          for(Entry e : list) {
            LOGGER.debug(e.getKey() +  "::" + e.getValue());
          }
      } catch (org.json.simple.parser.ParseException pex) {
        throw new SocialHttpClientException("dumpContent() is parsing error.", pex);
      }
      
    }
  }

  /**
   * Dump the HttpResponse header which Rest Service to return.
   * @param response response to dump
   */
  public static void dumpHeader(HttpResponse response) {
    Header[] headers = response.getAllHeaders();
    LOGGER.debug("\n\n++++++++++HEADER OF RESPONSE+++++++++++++++++++++++\n\n");
    for (int i = 0; i < headers.length; i++) {
      LOGGER.debug(headers[i].getName() + " : " + headers[i].getValue());
    }

  }
}
