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
import java.util.List;
import java.util.Map;

import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.model.RestProfile;
import org.exoplatform.social.client.core.util.SocialJSONDecodingSupport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.testng.Assert.assertEquals;

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
  public void shouldJsonActivityParser() throws Exception {

    String jsonActivity1 = "{\"id\": \"1a2b3c4d5e6f7g8h9j\","
                              + "\"title\": \"Hello World!!!\","
                              +"\"appId\": \"\","
                              + "\"type\": \"DEFAULT_ACTIVITY\","
                              +"\"postedTime\": 123456789," //timestamp
                              + "\"createdAt\": \"Fri Jun 17 06:42:26 +0000 2011\"," //The Date follows ISO 8601
                              + "\"priority\": 0.5, "//between 0.0 and 1.0, higher value => higher priority.
                              + "\"templateParams\": {},"
                              + "\"titleId\": \"\","
                              + "\"identityId\": \"123456789abcdefghi\"," //the identity id of the user who created this activity
                              + "\"liked\": true," //is liked (favorites) by this authenticated identity
                              + "\"likedByIdentities\": [{\"id\":1234567, \"providerId\":\"organization\", \"remoteId\":\"demo\", \"profile\":{\"fullName\":\"Demo GTN\", \"avatarUrl\":\"http://localhost:8080/profile/u/demo/avatar.jpg?u=12345\"}}],"
                              + "\"totalNumberOfLikes\": 20"
                              + "\"posterIdentity\": {\"id\":1234567, \"providerId\":\"organization\", \"remoteId\":\"demo\", \"profile\":{\"fullName\":\"Demo GTN\", \"avatarUrl\":\"http://localhost:8080/profile/u/demo/avatar.jpg?u=12345\"}}," //optional
                              + "\"comments\": [{}]," //optional
                              + "\"totalNumberOfComments\": 1234,"
                              +"\"activityStream\": {"
                              + "\"type\": \"user\"," // or "space"
                              + "\"fullName\": \"Root Root\","
                              + "\"prettyId\": \"root\"," // or space_abcde
                              + "\"faviconUrl\": \"http://demo3.exoplatform.org/favicons/exo-default.jpg\","
                              + "\"title\": \"Activity Stream of Root Root\","
                              + "\"permaLink\": \"http://localhost:8080/profile/root\""
                              +"}" //optional
                              +"}\"";

    RestActivityImpl model3 = SocialJSONDecodingSupport.parser(RestActivityImpl.class, jsonActivity1);
    assertEquals(model3.getIdentityId(), "123456789abcdefghi");

    //
    JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonActivity1);
    JSONArray jsonArray =  (JSONArray)jsonObject.get("likedByIdentities");
    //
    String actual = model3.getFieldAsString("likedByIdentities");

    assertEquals(actual, jsonArray.toJSONString());

    List<RestIdentityImpl> identities = SocialJSONDecodingSupport.JSONArrayObjectParser(RestIdentityImpl.class, actual);
    assertEquals(identities.size(), 1);
  }

  @Test
  public void shouldJsonActivityStreamArrayParser() throws Exception {

    String jsonActivity1 = "{\"activities\":[" +
                                      "{" +
                                      "\"appId\":null,\"identityId\":\"f845f6ed7f000101003ed4d98a09beb3\"," +
                                      "\"totalNumberOfComments\":0,\"liked\":false,\"templateParams\":{}," +
                                      "\"postedTime\":1309839511830,\"type\":\"DEFAULT_ACTIVITY\"," +
                                      "\"posterIdentity\":{},\"activityStream\":{}," +
                                      "\"id\":\"f884d11a7f000101000230e5c0e8a602\"," +
                                      "\"title\":\"hello\",\"priority\":null," +
                                      "\"createdAt\":\"Tue Jul 5 11:18:31 +0700 2011\"," +
                                      "\"likedByIdentities\":null,\"titleId\":null,\"comments\":null}" +
                           "]}";

    JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonActivity1);
    JSONArray jsonArray =  (JSONArray)jsonObject.get("activities");
    RestActivityImpl model3 = SocialJSONDecodingSupport.JSONArrayObjectParser(RestActivityImpl.class, jsonArray.toJSONString()).get(0);
    assertEquals(model3.getIdentityId(), "f845f6ed7f000101003ed4d98a09beb3");
  }

  @Test
  public void shouldJsonActivityStreamArrayParser1() throws Exception {

    String jsonActivity1 = "{"
                            + "\"activities\":["
                            + "{"
                            + "\"id\":\"1a2b3c4d5e6f7g8h9j\","
                            + "\"title\":\"Hello World!!!\","
                            + "\"appId\":\"\","
                            + "\"type\":\"DEFAULT_ACTIVITY\","
                            + "\"postedTime\":123456789,"
                            + "\"createdAt\":\"Fri Jun 17 06:42:26 +0000 2011\","
                            + "\"priority\":0.5,"
                            + "\"templateParams\":{"
                            + "},"
                            + "\"titleId\":\"\","
                            + "\"identityId\":\"123456789abcdefghi\","
                            + "\"liked\":true,"
                            + "\"likedByIdentities\":["
                            + "{"
                            + "\"id\":\"123456313efghi\","
                            + "\"providerId\":\"organization\","
                            + "\"remoteId\":\"demo\","
                            + "\"profile\":{"
                            + "\"fullName\":\"Demo GTN\","
                            + "\"avatarUrl\":\"http://localhost:8080/profile/u/demo/avatar.jpg?u=12345\""
                            + "}"
                            + "}"
                            + "],"
                            + "\"totalNumberOfLikes\":20,"
                            + "\"posterIdentity\":{"
                            + "\"id\":\"123456313efghi\","
                            + "\"providerId\":\"organization\","
                            + "\"remoteId\":\"demo\","
                            + "\"profile\":{"
                            + "\"fullName\":\"Demo GTN\","
                            + "\"avatarUrl\":\"http://localhost:8080/profile/u/demo/avatar.jpg?u=12345\""
                            + "}"
                            + "},"
                            + "\"comments\":["
                            + "{"
                            + "}"
                            + "],"
                            + "\"totalNumberOfComments\":1234,"
                            + "\"activityStream\":{"
                            + "\"type\":\"user\","
                            + "\"prettyId\":\"root\","
                            + "\"faviconUrl\":\"http://demo3.exoplatform.org/favicons/exo-default.jpg\","
                            + "\"title\":\"Activity Stream of Root Root\","
                            + "\"permaLink\":\"http://localhost:8080/profile/root\""
                            + "}"
                            + "},"
                            + "{"
                            + "\"id\":\"1a210983123f7g8h9j\","
                            + "\"title\":\"Hello World 1!!!\","
                            + "\"appId\":\"\","
                            + "\"type\":\"DEFAULT_ACTIVITY\","
                            + "\"postedTime\":123456789,"
                            + "\"createdAt\":\"Fri Jun 19 06:42:26 +0000 2011\","
                            + "\"priority\":0.5,"
                            + "\"templateParams\":{"
                            + "},"
                            + "\"titleId\":\"\","
                            + "\"identityId\":\"123456789abcdefghi\","
                            + "\"liked\":true,"
                            + "\"likedByIdentities\":["
                            + "{"
                            + "\"id\":\"123456313efghi\","
                            + "\"providerId\":\"organization\","
                            + "\"remoteId\":\"demo\","
                            + "\"profile\":{"
                            + "\"fullName\":\"Demo GTN\","
                            + "\"avatarUrl\":\"http://localhost:8080/profile/u/demo/avatar.jpg?u=12345\""
                            + "}"
                            + "}"
                            + "],"
                            + "\"totalNumberOfLikes\":20,"
                            + "\"posterIdentity\":{"
                            + "\"id\":\"123456313efghi\","
                            + "\"providerId\":\"organization\","
                            + "\"remoteId\":\"demo\","
                            + "\"profile\":{"
                            + "\"fullName\":\"Demo GTN\","
                            + "\"avatarUrl\":\"http://localhost:8080/profile/u/demo/avatar.jpg?u=12345\""
                            + "}"
                            + "},"
                            + "\"comments\":["
                            + "{"
                            + "}"
                            + "],"
                            + "\"totalNumberOfComments\":1234,"
                            + "\"activityStream\":{"
                            + "\"type\":\"user\","
                            + "\"fullName\":\"Root Root\","
                            + "\"prettyId\":\"root\","
                            + "\"faviconUrl\":\"http://demo3.exoplatform.org/favicons/exo-default.jpg\","
                            + "\"title\":\"Activity Stream of Root Root\","
                            + "\"permaLink\":\"http://localhost:8080/profile/root\""
                            + "}"
                            + "}"
                            + "]"
                            + "}";

    JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonActivity1);
    JSONArray jsonArray =  (JSONArray)jsonObject.get("activities");
    List<RestActivityImpl> activities = SocialJSONDecodingSupport.JSONArrayObjectParser(RestActivityImpl.class, jsonArray.toJSONString());
    assertEquals(activities.size(), 2);

    for(RestActivityImpl e : activities) {
      assertThat("PosterIdentity must not be null.", e.getPosterIdentity(), notNullValue());
      assertThat("ActivityStream must not be null.", e.getActivityStream(), notNullValue());
      assertThat("LikedByIdentity must not be null.", e.getAvailableLikes(), notNullValue());

      RestIdentity identity = e.getAvailableLikes().get(0);
      assertThat("RestProfile must not be null.", identity.getProfile(), notNullValue());

      RestProfile profile = identity.getProfile();
      assertThat(profile.getFullName(), equalTo("Demo GTN"));
      assertThat(profile.getAvatarUrl(), equalTo("http://localhost:8080/profile/u/demo/avatar.jpg?u=12345"));
    }
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
