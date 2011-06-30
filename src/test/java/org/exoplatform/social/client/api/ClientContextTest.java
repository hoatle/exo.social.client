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
 * Unit Test for {@link SocialClientContext}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 28, 2011
 */
public class ClientContextTest {

  @Test
  public void shouldGetDefaultValues() {
    assertThat("ClientContext.getHost() must be null", SocialClientContext.getHost(), nullValue());
    assertThat("ClientContext.getPort() must return 0", SocialClientContext.getPort(), equalTo(0));
    assertThat("ClientContext.getPortalContainerName() must be null", SocialClientContext.getPortalContainerName(),
               nullValue());

    assertThat("ClientContext.getRestContextName() must be null", SocialClientContext.getRestContextName(), nullValue());
    assertThat("ClientContext.getRestVersion() must be null", SocialClientContext.getRestVersion(), nullValue());
    assertThat("ClientContext.getUsername() must be null", SocialClientContext.getUsername(), nullValue());
    assertThat("ClientContext.getPassword() must be null", SocialClientContext.getPassword(), nullValue());
  }

  @Test
  public void shouldGetSetValues() {
    SocialClientContext.setHost("http://platform35.demo.exoplatform.org");
    SocialClientContext.setPort(80);
    SocialClientContext.setPortalContainerName("portal");
    SocialClientContext.setRestContextName("rest");
    SocialClientContext.setRestVersion("v1-alpha1");
    SocialClientContext.setUsername("demo");
    SocialClientContext.setPassword("gtn");

    assertThat(SocialClientContext.getHost(), equalTo("http://platform35.demo.exoplatform.org"));
    assertThat(SocialClientContext.getPort(), equalTo(80));
    assertThat(SocialClientContext.getPortalContainerName(), equalTo("portal"));
    assertThat(SocialClientContext.getRestContextName(), equalTo("rest"));
    assertThat(SocialClientContext.getRestVersion(), equalTo("v1-alpha1"));
    assertThat(SocialClientContext.getUsername(), equalTo("demo"));
    assertThat(SocialClientContext.getPassword(), equalTo("gtn"));
  }

}
