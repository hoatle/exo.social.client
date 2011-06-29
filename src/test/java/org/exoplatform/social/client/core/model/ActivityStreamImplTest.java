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

import org.exoplatform.social.client.api.model.ActivityStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link ActivityStreamImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 29, 2011
 */
public class ActivityStreamImplTest {

  @Test
  public void shouldGetDefaultValues() {
    ActivityStream activityStream = new ActivityStreamImpl();
    assertThat("activityStream.getType() must be null", activityStream.getType(), nullValue());
    assertThat("activityStream.getPrettyId() must be null", activityStream.getPrettyId(), nullValue());
    assertThat("activityStream.getFaviconUrl() must be null", activityStream.getFaviconUrl(), nullValue());
    assertThat("activityStream.getPermaLink() must be null", activityStream.getPermaLink(), nullValue());
    assertThat("activityStream.getTitle() must be null", activityStream.getTitle(), nullValue());
  }

  @Test
  public void shouldGetSettedValues() {
    final String type = "user";
    final String prettyId = "demo";
    final String faviconUrl = "";
    final String permaLink = "http://platform35.demo.exoplatform.org/portal/classic/profile/demo";
    final String title = "Activity Stream of Demo";
    ActivityStream activityStream = new ActivityStreamImpl(type, prettyId, faviconUrl, title, permaLink);

    assertThat("activityStream.getType() must return: " + type, activityStream.getType(), equalTo(type));
    assertThat("activityStream.getPrettyId() must return: " + prettyId, activityStream.getPrettyId(), equalTo(prettyId));
    assertThat("activityStream.getFaviconUrl() must return: " + faviconUrl, activityStream.getFaviconUrl(),
                equalTo(faviconUrl));
    assertThat("activityStream.getPermaLink() must return: " + permaLink, activityStream.getPermaLink(),
                equalTo(permaLink));
    assertThat("activityStream.getTitle() must return: " + title, activityStream.getTitle(), equalTo(title));
  }



}
