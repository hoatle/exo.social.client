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

import org.exoplatform.social.client.api.event.PropertyChangeListener;
import org.exoplatform.social.client.api.model.Model;
import org.exoplatform.social.client.core.util.PropertyChangeSupport;
import org.json.simple.JSONObject;

/**
 * ModelImpl implements {@link Model}.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 20, 2011
 */
public class ModelImpl extends JSONObject implements Model {

  /**
   * The property change event support for this model.
   */
  protected PropertyChangeSupport propertyChanges = new PropertyChangeSupport(this);
  /**
   * {@inheritDoc}
   */
  @Override
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
  @Override
  public boolean hasField(String fieldName) {
    return containsKey(fieldName);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getField(String fieldName) {
    return get(fieldName);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map getFieldAsMap(String fieldName) {
    return (Map) get(fieldName);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List getFieldAsList(String fieldName) {
    return (List) get(fieldName);
  }

  /**
   * {@inheritDoc}
   */
  @Override
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
  @Override
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
  @Override
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
  @Override
  public void setField(String fieldName, Object value) {
    //Raise event when change value of property.
    propertyChanges.propertyChange(fieldName, get(fieldName), value);
    put(fieldName, value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
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


  /**
   * {@inheritDoc}
   */
  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChanges.addPropertyChangeListener(listener);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChanges.removeLifecycleListener(listener);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PropertyChangeListener[] findPropertyChangeListeners() {
    return propertyChanges.findPropertyChangeListeners();
  }

}
