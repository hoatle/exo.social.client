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
package org.exoplatform.social.client.api.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Unit Test for {@link ActivityImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 26, 2011
 */
public class ActivityImplTest {

  @Test
  public void shouldCreateInstanceAndGetFields() {
    final String id = "12345678";
    final String appId = "an_application_id";
    final double priority = 0.9;
    final String title = "title foo";
    final String userId = "demo";
    final long postedTime = System.currentTimeMillis();
    final long updatedTime = System.currentTimeMillis() + 100;
    Date updated = new Date(updatedTime);
    Activity activity = new ActivityImpl();
    assertThat("activity must not be null", activity, notNullValue());
    activity.setId(id);
    activity.setAppId(appId);
    activity.setPostedTime(postedTime);
    activity.setPriority(priority);
    activity.setTitle(title);
    activity.setUserId(userId);
    activity.setUpdated(updated);

    assertThat("activity.getAppId() must return: " + appId, activity.getAppId(), equalTo(appId));
    assertThat("activity.getBody() must return null", activity.getBody(), nullValue());
    assertThat("activity.getBodyId() must return null", activity.getBodyId(), nullValue());
    assertThat("activity.getExternalId() must return null", activity.getExternalId(), nullValue());
    assertThat("activity.getId() must return: " + id, activity.getId(), equalTo(id));
    assertThat("activity.getPostedTime() must return: " + postedTime, activity.getPostedTime(), equalTo(postedTime));
    assertThat("activity.getPriority() must return: " + priority , activity.getPriority(), equalTo(priority));
    assertThat("activity.getStreamFaviconUrl() must return null", activity.getStreamFaviconUrl(), nullValue());
    assertThat("activity.getStreamSourceUrl() must return null", activity.getStreamSourceUrl(), nullValue());
    assertThat("activity.getStreamTitle() must return null", activity.getStreamTitle(), nullValue());
    assertThat("activity.getStreamUrl() must return null", activity.getStreamUrl(), nullValue());
    assertThat("activity.getTemplateParameter(\"foo\") must return null", activity.getTemplateParameter("foo"),
            nullValue());
    assertThat("activity.getTemplateParams() must return null", activity.getTemplateParams(), nullValue());
    assertThat("activity.getTitle() must return: " + title, activity.getTitle(), equalTo(title));
    assertThat("activity.getTitleId() must return null", activity.getTitleId(), nullValue());
    assertThat("activity.getUpdated() must return: " + updated, activity.getUpdated(), equalTo(updated));
    assertThat("activity.getUrl() must return null", activity.getUrl(), nullValue());
    assertThat("activity.getUserId() must return: " + userId, activity.getUserId(), equalTo(userId));

    final String body = "Body Body Body";
    final String bodyId = "Body Id, Body Id";
    final String externalId = "example.com:externalId";
    final String streamFaviconUrl = "http://example.com/favicon.ico";
    final String streamSourceUrl = "http://platform35.demo.exoplatform.org/profile/demo";
    final String streamTitle = "activity stream of Demo";
    final String streamUrl = "http://platform35.demo.exoplatform.org/activity/demo";
    final Map<String, String> templateParams = new HashMap<String, String>();
    final String titleId = "title Id, title id";
    final String url = "http://platform35.demo.exoplatform.org/activity/demo/123456789";
    templateParams.put("foo", "bar");
    templateParams.put("foo2", "bar2");
    activity.setBody(body);
    activity.setBodyId(bodyId);
    activity.setExternalId(externalId);
    activity.setStreamFaviconUrl(streamFaviconUrl);
    activity.setStreamSourceUrl(streamSourceUrl);
    activity.setStreamTitle(streamTitle);
    activity.setStreamUrl(streamUrl);
    activity.setTemplateParams(templateParams);
    activity.setTitleId(titleId);
    activity.setUrl(url);

    assertThat("activity.getBody() must return: " + body, activity.getBody(), equalTo(body));
    assertThat("activity.getBodyId() must return: " + bodyId, activity.getBodyId(), equalTo(bodyId));
    assertThat("activity.getExternalId() must return: " + externalId, activity.getExternalId(), equalTo(externalId));
    assertThat("activity.getStreamFaviconUrl() must return: " + streamFaviconUrl, activity.getStreamFaviconUrl(),
            equalTo(streamFaviconUrl));
    assertThat("activity.getStreamSourceUrl() must return: " + streamSourceUrl, activity.getStreamSourceUrl(),
            equalTo(streamSourceUrl));
    assertThat("activity.getStreamTitle() must return: " + streamTitle, activity.getStreamTitle(),
            equalTo(streamTitle));
    assertThat("activity.getStreamUrl() must return: " + streamUrl, activity.getStreamUrl(), equalTo(streamUrl));
    assertThat("activity.getTemplateParams() must return: " + templateParams, activity.getTemplateParams(),
            equalTo(templateParams));
    assertThat("activity.getTemplateParameter(\"foo\") must return: bar", activity.getTemplateParameter("foo"),
            equalTo("bar"));
    assertThat("activity.getTemplateParameter(\"foo2\") must return: bar2",
            activity.getTemplateParameter("foo2"),
            equalTo("bar2"));
    assertThat("activity.getTitleId() must return: " + titleId, activity.getTitleId(), equalTo(titleId));
    assertThat("activity.getUrl() must return: " + url, activity.getUrl(), equalTo(url));
    activity.addTemplateParameter("foo3", "bar3");
    assertThat("activity.getTemplateParameter(\"foo3\") must return: bar3", activity.getTemplateParameter("foo3"),
            equalTo("bar3"));
  }

  @Test
  public void shouldGetLikes() {
    //TODO complete this
  }

  @Test
  public void shouldGetComments() {
    //TODO Complete this
  }
}
