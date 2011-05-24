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
package org.exoplatform.social.client.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.exoplatform.social.client.api.model.Model;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * ModelImplTest implements {@link Model}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 20, 2011
 */
public class ModelImpl extends JSONObject implements Model {

  /**
   * Returns the complete set of properties associated with the model instance.
   */
  public String[] getFieldNames() {
    int i = 0;
    String[] fieldNames = new String[size()];

    Set<Map.Entry<String, Object>> fields = entrySet();
    for (Map.Entry<String, Object> field : fields) {
      fieldNames[i] = field.getKey();
      i++;
    }

    return fieldNames;
  }

  /**
   * Returns {@code true} if a value is associated with the specified field name, {@code false} otherwise.
   *
   * @param fieldName name of field to look up
   */
  public boolean hasField(String fieldName) {
    return containsKey(fieldName);
  }

  /**
   * Returns the value of the specified field as an Object.
   *
   * @param fieldName name of field whose value is to be returned
   */
  public Object getField(String fieldName) {
    return get(fieldName);
  }

  /**
   * Returns the value of the specified field as a {@link Map}. Equivalent to {@code (Map) getField(fieldName)}, hence
   * this method will throw a ClassCastException if the field does not implement Map.
   *
   * @param fieldName name of field whose value is to be returned
   * @see ClassCastException
   */
  public Map getFieldAsMap(String fieldName) {
    return (Map) get(fieldName);
  }

  /**
   * Returns the value of the specified field as a {@link java.util.List}. Equivalent to {@code (List)
   * getField(fieldName)}, hence this method will throw a ClassCastException if the field does not implement List.
   *
   * @param fieldName name of field whose value is to be returned
   * @see ClassCastException
   */
  public List getFieldAsList(String fieldName) {
    return (List) get(fieldName);
  }

  /**
   * Returns the value of the specified field as a {@link String}. Equivalent to {@code (String) getField(fieldName)},
   * hence this method will throw a ClassCastException if the field is not of type String.
   *
   * @param fieldName name of field whose value is to be returned
   * @see ClassCastException
   */
  public String getFieldAsString(String fieldName) {
    try {
      return (String) get(fieldName);
    } catch (ClassCastException e) {
      return "" + get(fieldName);
    }
  }

  /**
   * Returns {@code true} if the value of the specified field implements {@link Map}, {@code false} otherwise.
   *
   * @param fieldName name of field to look up
   */
  public boolean isFieldMultikeyed(String fieldName) {
    Object field = get(fieldName);
    if (field.getClass().equals(String.class) ||
            field.getClass().equals(JSONArray.class)) {
      return false;
    }

    return true;
  }

  /**
   * Returns {@code true} if the value of the specified field implements {@link List}, {@code false} otherwise.
   *
   * @param fieldName name of field to look up
   */
  public boolean isFieldMultivalued(String fieldName) {
    Object field = get(fieldName);
    if (field.getClass().equals(JSONArray.class)) {
      return true;
    }

    return false;
  }

  /**
   * Sets the value of the specified field to the passed Object.
   *
   * @param fieldName name of field to set
   * @param value     object to associate with passed field name
   */
  public void setField(String fieldName, Object value) {
    put(fieldName, value);
  }

  /**
   * Adds the passed Object to the list field with the specified name.
   *
   * @param fieldName name of list field for which the passed item should be added
   * @param item      item to add
   */
  protected void addToListField(String fieldName, Object item) {
    List<Object> listField;

    if (containsKey(fieldName)) {
      listField = getFieldAsList(fieldName);
    } else {
      listField = new ArrayList<Object>();
    }

    listField.add(item);
    put(fieldName, listField);
  }

}
