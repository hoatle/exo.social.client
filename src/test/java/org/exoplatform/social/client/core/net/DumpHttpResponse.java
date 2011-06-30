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

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public class DumpHttpResponse {

  /**
   * Dump the HttpResponse content which Rest Service to return.
   * @param entity Entity to dump
   * @throws ParseException
   * @throws IOException
   */
  public static void dumpContent(HttpEntity entity) throws ParseException, IOException {
    if (entity.getContentLength() != -1) {
      String body = EntityUtils.toString(entity);
      System.out.println("BODY::" + body);
    }
  }

  /**
   * Dump the HttpResponse header which Rest Service to return.
   * @param response response to dump
   */
  public static void dumpHeader(HttpResponse response) {
    Header[] headers = response.getAllHeaders();
    System.out.println("\n\n++++++++++HEADER OF RESPONSE+++++++++++++++++++++++\n\n");
    for (int i = 0; i < headers.length; i++) {
      System.out.println(headers[i].getName() + " : " + headers[i].getValue());
    }

  }
}
