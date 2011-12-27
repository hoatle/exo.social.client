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
package org.exoplatform.social.client.core;

import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.UnsupportedRestVersionException;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit Test for {@link org.exoplatform.social.client.api.SocialClientContext}'s implementation.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 28, 2011
 */
public class SocialClientContextTest {

  @Test
  public void shouldGetDefaultValues() {
    assertThat(SocialClientContext.getProtocol(), equalTo("http"));
    assertThat("SocialClientContext.getHost() must be null", SocialClientContext.getHost(), nullValue());
    assertThat("SocialClientContext.getPort() must return 0", SocialClientContext.getPort(), equalTo(0));
    assertThat("SocialClientContext.getPortalContainerName() must be null", SocialClientContext.getPortalContainerName(),
               nullValue());

    assertThat("SocialClientContext.getRestContextName() must be null", SocialClientContext.getRestContextName(), nullValue());
    assertThat("SocialClientContext.getRestVersion() must return: v1-alpha3", SocialClientContext.getRestVersion(),
            equalTo("v1-alpha3"));
    assertThat("SocialClientContext.getUsername() must be null", SocialClientContext.getUsername(), nullValue());
    assertThat("SocialClientContext.getPassword() must be null", SocialClientContext.getPassword(), nullValue());
    assertThat("SocialClientContext.isDeveloping() must return false", SocialClientContext.isDeveloping(),
               equalTo(false));
  }

  @Test
  public void shouldSupportV1Alpha1() {
    SocialClientContext.setRestVersion("v1-alpha1");
  }

  @Test
  public void shouldSupportV1Alpha2() {
    SocialClientContext.setRestVersion("v1-alpha2");
  }

  @Test
  public void shouldSupportV1Alpha3() {
    SocialClientContext.setRestVersion("v1-alpha3");
  }


  @Test(expectedExceptions = UnsupportedRestVersionException.class)
  public void shouldThrowExceptionIfNotSupported() {
    SocialClientContext.setRestVersion("v1");
  }

  @Test
  public void shouldGetSetValues() {
    SocialClientContext.setHost("http://platform35.demo.exoplatform.org");
    SocialClientContext.setPort(80);
    SocialClientContext.setPortalContainerName("portal");
    SocialClientContext.setRestContextName("rest");
    SocialClientContext.setRestVersion("v1-alpha3");
    SocialClientContext.setUsername("demo");
    SocialClientContext.setPassword("gtn");
    SocialClientContext.setIsDeveloping(true);

    assertThat(SocialClientContext.getHost(), equalTo("http://platform35.demo.exoplatform.org"));
    assertThat(SocialClientContext.getPort(), equalTo(80));
    assertThat(SocialClientContext.getPortalContainerName(), equalTo("portal"));
    assertThat(SocialClientContext.getRestContextName(), equalTo("rest"));
    assertThat(SocialClientContext.getRestVersion(), equalTo("v1-alpha3"));
    assertThat(SocialClientContext.getUsername(), equalTo("demo"));
    assertThat(SocialClientContext.getPassword(), equalTo("gtn"));
    assertThat("SocialClientContext.isDeveloping() must return true", SocialClientContext.isDeveloping(),
              equalTo(true));
  }

}
