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

import java.util.HashMap;
import java.util.Map;

import org.exoplatform.social.client.api.model.Activity;
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
    final long postedTime = System.currentTimeMillis();
    Activity activity = new ActivityImpl();
    assertThat("activity must not be null", activity, notNullValue());
    activity.setId(id);
    activity.setAppId(appId);
    activity.setPostedTime(postedTime);
    activity.setPriority(priority);
    activity.setTitle(title);

    assertThat("activity.getAppId() must return: " + appId, activity.getAppId(), equalTo(appId));
    assertThat("activity.getId() must return: " + id, activity.getId(), equalTo(id));
    assertThat("activity.getPostedTime() must return: " + postedTime, activity.getPostedTime(), equalTo(postedTime));
    assertThat("activity.getPriority() must return: " + priority , activity.getPriority(), equalTo(priority));
    assertThat("activity.getTemplateParameter(\"foo\") must return null", activity.getTemplateParameter("foo"),
            nullValue());
    assertThat("activity.getTemplateParams() must return null", activity.getTemplateParams(), nullValue());
    assertThat("activity.getTitle() must return: " + title, activity.getTitle(), equalTo(title));
    assertThat("activity.getTitleId() must return null", activity.getTitleId(), nullValue());

    final Map<String, String> templateParams = new HashMap<String, String>();
    final String titleId = "title Id, title id";
    templateParams.put("foo", "bar");
    templateParams.put("foo2", "bar2");
    activity.setTemplateParams(templateParams);
    activity.setTitleId(titleId);

    assertThat("activity.getTemplateParams() must return: " + templateParams, activity.getTemplateParams(),
            equalTo(templateParams));
    assertThat("activity.getTemplateParameter(\"foo\") must return: bar", activity.getTemplateParameter("foo"),
            equalTo("bar"));
    assertThat("activity.getTemplateParameter(\"foo2\") must return: bar2",
            activity.getTemplateParameter("foo2"),
            equalTo("bar2"));
    assertThat("activity.getTitleId() must return: " + titleId, activity.getTitleId(), equalTo(titleId));
    activity.addTemplateParameter("foo3", "bar3");
    assertThat("activity.getTemplateParameter(\"foo3\") must return: bar3", activity.getTemplateParameter("foo3"),
            equalTo("bar3"));
  }

  @Test
  public void shouldGetLikes() {
    //TODO complete this
  }

  @Test
  public void shouldGetPosterIdentity() {
    //TODO complete this
  }

  @Test
  public void shouldGetAvailableComments() {
    //TODO Complete this
  }

  @Test
  public void shouldGetTotalNumberOfComments() {
    //TODO complete this
  }

  @Test
  public void shouldGetTotalComments() {
    //TODO complete this
  }

  @Test
  public void shouldGetActivityStream() {
    //TODO complete this
  }

}
