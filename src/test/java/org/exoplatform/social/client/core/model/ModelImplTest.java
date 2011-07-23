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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exoplatform.social.client.api.model.Model;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * Unit test for {@link ModelImpl}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 20, 2011
 */
public class ModelImplTest {

  @Test
  public void shouldCreateModelInstance() {
    Model model = new ModelImpl();
    model.put("param1", "key1");
    assertNotNull("model must not be null", model);
  }

  @Test
  public void shouldGetAllFieldNames() {
    Model model = new ModelImpl();
    model.put("para1", "value1");
    model.put("para2", "value2");
    String[] expected = {"para1", "para2"};
    String[] actual = model.getFieldNames();
    //assertArrayEquals("actual must return: " + actual, expected, actual);
    assertThat(actual, equalTo(expected));
  }

  @Test
  public void shouldHasField() {
    Model model = new ModelImpl();
    model.put("para1", "value1");
    model.put("para2", "value2");
    model.put("para3", "value3");
    assertThat("model.hasField(\"para1\") must return true", model.hasField("para1"), equalTo(true));
    assertThat("model.hasField(\"para2\") must return true", model.hasField("para3"), equalTo(true));
    assertThat("model.hasField(\"para3\") must return true", model.hasField("para3"), equalTo(true));
    assertThat("model.hasField(\"para4\") must return false", model.hasField("para4"), equalTo(false));
  }

  @Test
  public void shouldGetField() {
    Model model = new ModelImpl();
    model.put("para1", "value1");
    model.put("para2", "value2");
    model.put("para3", "value3");
    model.put("para4", new String[]{"hello", "world"});

    String value1 = model.getFieldAsString("para1");
    assertThat("value1 must not be null", value1, notNullValue());
    assertEquals("value1 must be \"value1\"", "value1", value1);
    assertThat("value1 must be: value1", value1, equalTo("value1"));
    assertThat("model.getField(\"para5\") must be null", model.getField("para5"), nullValue());
  }

  @Test
  public void shouldGetFieldAsMap() {
    Model model = new ModelImpl();
    Map<String, String> hashMap = new HashMap<String, String>();
    hashMap.put("hashMapKey", "hashMapValue");
    model.put("para1", hashMap);

    Map<String, String> expected = model.getFieldAsMap("para1");
    assertThat("expected must be: " + hashMap, expected, equalTo(hashMap));
    assertThat("model.getFieldAsMap(\"para2\") must return null", model.getFieldAsMap("para2"), nullValue());
  }


  @Test
  public void shouldGetFieldAsList() {
    Model model = new ModelImpl();
    List<String> list = new ArrayList<String>();
    list.add("value1");
    list.add("value2");
    list.add("value3");

    model.put("para1", list);
    List<String> actualList = model.getFieldAsList("para1");
    assertThat("actualList must be: " + list, actualList, equalTo(list));
    assertThat("model.getFieldAsList(\"para2\") must return null", model.getFieldAsList("para2"), nullValue());
  }

  @Test
  public void shouldGetFieldAsString() {
    Model model = new ModelImpl();
    final String stringValue = "string value";
    model.put("key", stringValue);

    String value = model.getFieldAsString("key");

    assertThat("value must be: " + stringValue, value, is(stringValue));
  }

  @Test
  public void shouldWorkWithIsFieldMultikeyed() {

    final Map<String, String> myMap = new HashMap<String, String>();
    myMap.put("mapKey", "mapValue");

    Model model = new ModelImpl();
    model.put("keyMap", myMap);
    model.put("keyString", "string value");

    assertThat("model.isFieldMultikeyed(\"keyMap\") must be true", model.isFieldMultikeyed("keyMap"), is(true));
    assertThat("model.isFieldMultikeyed(\"keyString\") must be false", model.isFieldMultikeyed("keyString"), is(false));
  }

  @Test
  public void shouldWorkWithIsFieldMultivalued() {
    final List<String> myList = new ArrayList<String>();
    myList.add("foo");
    myList.add("bar");
    Model model = new ModelImpl();
    model.put("keyList", myList);
    model.put("keyString", "string value");

    assertThat("model.isFieldMultivalued(\"keyList\") must be true", model.isFieldMultivalued("keyList"), is(true));
    assertThat("model.isFieldMultivalued(\"keyString\") must be false", model.isFieldMultivalued("keyString"),
            is(false));
  }

  @Test
  public void shouldWorkWithSetField() {
    Model model = new ModelImpl();
    model.setField("fooKey", "fooValue");
    assertThat("model.getFieldAsString(\"fooKey\") must be: fooValue", model.getFieldAsString("fooKey"),
            equalTo("fooValue"));
    model.setField("fooKey", "barValue");
    assertThat("model.getFieldAsString(\"fooKey\") must be: barValue", model.getFieldAsString("fooKey"),
            equalTo("barValue"));
  }

  @Test
  public void shouldWorkWithAddToListField() {
    Model model = new ModelImpl();
    final String fooKey = "fooKey";
    model.addToListField(fooKey, "hello");
    assertThat("model.isFieldMultivalued(fooKey) must be true", model.isFieldMultivalued(fooKey), is(true));
    model.addToListField(fooKey, "world");
    assertThat("model.getFieldAsList(fooKey).size() must return 2", model.getFieldAsList(fooKey).size(), is(2));
    assertThat("(String)model.getFieldAsList(fooKey).get(0) must return hello",
               (String)model.getFieldAsList(fooKey).get(0), equalTo("hello"));
    assertThat("(String)model.getFieldAsList(fooKey).get(1) must return world",
               (String)model.getFieldAsList(fooKey).get(1), equalTo("world"));
  }


}
