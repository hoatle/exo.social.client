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

import org.exoplatform.social.client.core.AbstractClientTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Jun 30, 2011  
 */
public class VersionServiceIT extends AbstractClientTest {

  @BeforeMethod
  public void setUp() {
    super.setUp();
  }


  @AfterMethod
  public void tearDown() {
    super.tearDown();
  }

  @Override
  protected void setRestVersion() {
    //do nothing
  }

  @Test
  public void testGetLatestVersion() throws Exception {
    String latestVersion = versionService.getLatest();
    assertThat("latestVersion must not be null", latestVersion, notNullValue());
  }
  
  @Test
  public void testGetSupportedVersion() throws Exception {
    String[] versions = versionService.getSupported();
    assertThat("versions.length must be greater than 0", versions.length > 0, equalTo(true));
  }
  
}
