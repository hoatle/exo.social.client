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
package org.exoplatform.social.client.core.model;

import org.exoplatform.social.client.api.model.RestActivityStream;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit Test for {@link RestActivityStreamImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 29, 2011
 */
public class RestActivityStreamImplTest {

  @Test
  public void shouldGetDefaultValues() {
    RestActivityStream restActivityStream = new RestActivityStreamImpl();
    assertThat("restActivityStream.getType() must be null", restActivityStream.getType(), nullValue());
    assertThat("restActivityStream.getPrettyId() must be null", restActivityStream.getPrettyId(), nullValue());
    assertThat("restActivityStream.getFullName() must be null", restActivityStream.getFullName(), nullValue());
    assertThat("restActivityStream.getFaviconUrl() must be null", restActivityStream.getFaviconUrl(), nullValue());
    assertThat("restActivityStream.getPermaLink() must be null", restActivityStream.getPermaLink(), nullValue());
    assertThat("restActivityStream.getTitle() must be null", restActivityStream.getTitle(), nullValue());
  }

  @Test
  public void shouldGetSettedValues() {
    final String type = "user";
    final String prettyId = "demo";
    final String fullName = "Demo Demo";
    final String faviconUrl = "";
    final String permaLink = "http://platform35.demo.exoplatform.org/portal/classic/profile/demo";
    final String title = "Activity Stream of Demo";
    RestActivityStream restActivityStream = new RestActivityStreamImpl(type, prettyId, fullName, faviconUrl, title, permaLink);

    assertThat("restActivityStream.getType() must return: " + type, restActivityStream.getType(), equalTo(type));
    assertThat("restActivityStream.getPrettyId() must return: " + prettyId, restActivityStream.getPrettyId(), equalTo(prettyId));
    assertThat("restActivityStream.getFullName() must return: " + fullName, restActivityStream.getFullName(), equalTo(fullName));

    assertThat("restActivityStream.getFaviconUrl() must return: " + faviconUrl, restActivityStream.getFaviconUrl(),
                equalTo(faviconUrl));
    assertThat("restActivityStream.getPermaLink() must return: " + permaLink, restActivityStream.getPermaLink(),
                equalTo(permaLink));
    assertThat("restActivityStream.getTitle() must return: " + title, restActivityStream.getTitle(), equalTo(title));
  }



}
