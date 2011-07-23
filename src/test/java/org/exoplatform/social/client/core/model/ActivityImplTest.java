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

import org.exoplatform.social.client.api.model.RestActivity;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Unit Test for {@link RestActivityImpl}.
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
    RestActivity restActivity = new RestActivityImpl();
    assertThat("restActivity must not be null", restActivity, notNullValue());
    restActivity.setId(id);
    restActivity.setAppId(appId);
    restActivity.setPostedTime(postedTime);
    restActivity.setPriority(priority);
    restActivity.setTitle(title);

    assertThat("restActivity.getAppId() must return: " + appId, restActivity.getAppId(), equalTo(appId));
    assertThat("restActivity.getId() must return: " + id, restActivity.getId(), equalTo(id));
    assertThat("restActivity.getPostedTime() must return: " + postedTime, restActivity.getPostedTime(), equalTo(postedTime));
    assertThat("restActivity.getPriority() must return: " + priority , restActivity.getPriority(), equalTo(priority));
    assertThat("restActivity.getTemplateParameter(\"foo\") must return null", restActivity.getTemplateParameter("foo"),
            nullValue());
    assertThat("restActivity.getTemplateParams() must return null", restActivity.getTemplateParams(), nullValue());
    assertThat("restActivity.getTitle() must return: " + title, restActivity.getTitle(), equalTo(title));
    assertThat("restActivity.getTitleId() must return null", restActivity.getTitleId(), nullValue());

    final Map<String, String> templateParams = new HashMap<String, String>();
    final String titleId = "title Id, title id";
    templateParams.put("foo", "bar");
    templateParams.put("foo2", "bar2");
    restActivity.setTemplateParams(templateParams);
    restActivity.setTitleId(titleId);

    assertThat("restActivity.getTemplateParams() must return: " + templateParams, restActivity.getTemplateParams(),
            equalTo(templateParams));
    assertThat("restActivity.getTemplateParameter(\"foo\") must return: bar", restActivity.getTemplateParameter("foo"),
            equalTo("bar"));
    assertThat("restActivity.getTemplateParameter(\"foo2\") must return: bar2",
            restActivity.getTemplateParameter("foo2"),
            equalTo("bar2"));
    assertThat("restActivity.getTitleId() must return: " + titleId, restActivity.getTitleId(), equalTo(titleId));
    restActivity.addTemplateParameter("foo3", "bar3");
    assertThat("restActivity.getTemplateParameter(\"foo3\") must return: bar3", restActivity.getTemplateParameter("foo3"),
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
