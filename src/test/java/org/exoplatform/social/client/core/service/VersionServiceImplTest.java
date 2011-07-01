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

import junit.framework.Assert;

import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.service.VersionService;
import org.exoplatform.social.client.core.net.AbstractClientTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 30, 2011  
 */
public class VersionServiceImplTest extends AbstractClientTest {

  private VersionService service = null;
  @Before
  public void setUp() throws Exception {
    super.setUp();
    service = new VersionServiceImpl();
  }
  
  @After
  public void tearDown() throws Exception {
    super.tearDown();
    service = null;
  }
   
  @Test
  public void testGetLatestVersion() throws Exception {
    String version = service.getLatest();
    Assert.assertEquals("Verifying rest service version.", SocialClientContext.getRestVersion(), version);
  }
  
  @Test
  public void testGetSupportedVersion() throws Exception {
    String[] versions = service.getSupported();
    Assert.assertTrue("Rest Service version support greater than zero.", versions.length > 0);
    Assert.assertEquals("Verifying rest service version.", SocialClientContext.getRestVersion(), versions[0]);
  }
  
}
