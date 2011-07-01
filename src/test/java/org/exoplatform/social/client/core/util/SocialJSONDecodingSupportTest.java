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

import java.util.Map;

import junit.framework.Assert;

import org.exoplatform.social.client.core.model.ActivityImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 30, 2011  
 */
public class SocialJSONDecodingSupportTest {

  @Before
  public void setUp() throws Exception {
    
  }
  
  @After
  public void tearDown() throws Exception {
    
  }
  
  @Test
  public void testJSONParserWithClassType() throws Exception {
    String jsonActivity = "{\"numberOfComments\":1,\"identityId\":\"d5039b437f0001010011fd153a4fcbd8\",\"liked\":true,}";
    ActivityImpl model = SocialJSONDecodingSupport.parser(ActivityImpl.class, jsonActivity);
    Assert.assertEquals("d5039b437f0001010011fd153a4fcbd8", model.getIdentityId());
  }
  
  @Test
  public void testJSONParser() throws Exception {
    String jsonActivity = "{\"numberOfComments\":1,\"identityId\":\"d5039b437f0001010011fd153a4fcbd8\",\"liked\":true,}";
    Map modelMap = SocialJSONDecodingSupport.parser(jsonActivity);
    Assert.assertEquals("d5039b437f0001010011fd153a4fcbd8", modelMap.get("identityId"));
  }
}
