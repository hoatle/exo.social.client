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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.exoplatform.social.client.api.model.Model;
import org.json.simple.JSONObject;

/**
 * ModelImplTest implements {@link Model}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 20, 2011
 */
public class ModelImpl extends JSONObject implements Model {

  /**
   * {@inheritDoc}
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
   * {@inheritDoc}
   */
  public boolean hasField(String fieldName) {
    return containsKey(fieldName);
  }

  /**
   * {@inheritDoc}
   */
  public Object getField(String fieldName) {
    return get(fieldName);
  }

  /**
   * {@inheritDoc}
   */
  public Map getFieldAsMap(String fieldName) {
    return (Map) get(fieldName);
  }

  /**
   * {@inheritDoc}
   */
  public List getFieldAsList(String fieldName) {
    return (List) get(fieldName);
  }

  /**
   * {@inheritDoc}
   */
  public String getFieldAsString(String fieldName) {
    try {
      return (String) get(fieldName);
    } catch (ClassCastException e) {
      return "" + get(fieldName);
    }
  }

  /**
   * {@inheritDoc}
   */
  public boolean isFieldMultikeyed(String fieldName) {
    Object field = get(fieldName);
    if (field instanceof Map) {
      return true;
    }

    return false;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isFieldMultivalued(String fieldName) {
    Object field = get(fieldName);
    if (field instanceof List) {
      return true;
    }

    return false;
  }

  /**
   * {@inheritDoc}
   */
  public void setField(String fieldName, Object value) {
    put(fieldName, value);
  }

  /**
   * {@inheritDoc}
   */
  public void addToListField(String fieldName, Object item) {
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
