/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.social.client.core;

import org.exoplatform.social.client.api.ClientContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link ClientContextImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 1, 2011
 */
public class ClientContextImplTest {

  /**
   * The client context instance.
   */
  private ClientContext clientContext;

  @Before
  public void runBeforeEveryTest() {
    clientContext = new ClientContextImpl();
  }

  @After
  public void runAfterEveryTest() {
    clientContext = null;
  }


  @Test
  public void shouldGetDefaultValues() {
    assertThat("clientContext must not be null", clientContext, notNullValue());
    //asserts default values
    assertThat("clientContext.getHost() must return an empty string", clientContext.getHost(), equalTo(""));
    assertThat("clientContext.getPort() must return 0", clientContext.getPort(), equalTo(0));
    assertThat("clientContext.getPortalContainerName() must return an empty string",
            clientContext.getPortalContainerName(), equalTo(""));
    assertThat("clientContext.getRestContextName() must return an empty string",
            clientContext.getRestContextName(), equalTo(""));
    assertThat("clientContext.getRestVersion() must return an empty string",
            clientContext.getRestVersion(), equalTo(""));
  }

  @Test
  public void shouldGetAndSetHost() {
    final String host = "http://platform35.demo.exoplatform.org/";
    clientContext.setHost(host);
    assertThat("clientContext.getHost() must return: " + host, clientContext.getHost(), equalTo(host));
  }

  @Test
  public void shouldGetAndSetPort() {
    final int port = 80;
    clientContext.setPort(port);
    assertThat("clientContext.getPort() must return: " + port, clientContext.getPort(), equalTo(port));
  }

  @Test
  public void shouldGetAndSetPortalContainerName() {
    final String portalContainerName = "portal";
    clientContext.setPortalContainerName(portalContainerName);
    assertThat("clientContext.getPortalContainerName() must return: " + portalContainerName,
            clientContext.getPortalContainerName(), equalTo(portalContainerName));
  }

  @Test
  public void shouldGetAndSetRestContextName() {
    final String restContextName = "rest";
    clientContext.setRestContextName(restContextName);
    assertThat("clientContext.getRestContextName() must return: " + restContextName,
            clientContext.getRestContextName(), equalTo(restContextName));
  }

  @Test
  public void shouldGetAndSetRestVersion() {
    final String restVersion = "v1-alpha1";
    clientContext.setRestVersion(restVersion);
    assertThat("clientContext.getRestVersion() must return: " + restVersion,
            clientContext.getRestVersion(), equalTo(restVersion));
  }

}
