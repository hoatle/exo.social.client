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

import org.exoplatform.social.client.api.SocialClientContext;
import org.junit.After;
import org.junit.Before;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 29, 2011  
 */
public abstract class AbstractClientTest {

  @Before
  public void setUp() throws Exception {
    SocialClientContext.setHost("127.0.0.1");
    SocialClientContext.setPort(8080);
    SocialClientContext.setUsername("demo");
    SocialClientContext.setPassword("gtn");
    SocialClientContext.setProtocol("http");
  }
  
  @After
  public void tearDown() throws Exception {

    SocialClientContext.setHost(null);
    SocialClientContext.setPort(0);
    SocialClientContext.setUsername(null);
    SocialClientContext.setPassword(null);
    SocialClientContext.setProtocol(null);
  }
}
