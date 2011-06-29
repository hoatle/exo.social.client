/*
 * Copyright (C) 2011 hoatle.net.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exoplatform.social.client.api;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link ClientContext}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 28, 2011
 */
public class ClientContextTest {

  @Test
  public void shouldGetDefaultValues() {
    assertThat("ClientContext.getHost() must be null", ClientContext.getHost(), nullValue());
    assertThat("ClientContext.getPort() must return 0", ClientContext.getPort(), equalTo(0));
    assertThat("ClientContext.getPortalContainerName() must be null", ClientContext.getPortalContainerName(),
               nullValue());

    assertThat("ClientContext.getRestContextName() must be null", ClientContext.getRestContextName(), nullValue());
    assertThat("ClientContext.getRestVersion() must be null", ClientContext.getRestVersion(), nullValue());
    assertThat("ClientContext.getUsername() must be null", ClientContext.getUsername(), nullValue());
    assertThat("ClientContext.getPassword() must be null", ClientContext.getPassword(), nullValue());
  }

  @Test
  public void shouldGetSetValues() {
    ClientContext.setHost("http://platform35.demo.exoplatform.org");
    ClientContext.setPort(80);
    ClientContext.setPortalContainerName("portal");
    ClientContext.setRestContextName("rest");
    ClientContext.setRestVersion("v1-alpha1");
    ClientContext.setUsername("demo");
    ClientContext.setPassword("gtn");

    assertThat(ClientContext.getHost(), equalTo("http://platform35.demo.exoplatform.org"));
    assertThat(ClientContext.getPort(), equalTo(80));
    assertThat(ClientContext.getPortalContainerName(), equalTo("portal"));
    assertThat(ClientContext.getRestContextName(), equalTo("rest"));
    assertThat(ClientContext.getRestVersion(), equalTo("v1-alpha1"));
    assertThat(ClientContext.getUsername(), equalTo("demo"));
    assertThat(ClientContext.getPassword(), equalTo("gtn"));
  }

}
