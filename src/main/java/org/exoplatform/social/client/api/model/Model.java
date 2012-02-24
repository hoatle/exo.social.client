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
package org.exoplatform.social.client.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.exoplatform.social.client.api.event.PropertyChangeListener;
import org.exoplatform.social.client.api.util.PropertyChangeSupport;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

/**
 * The general model extends {@link org.json.simple.JSONObject}'s interfaces.
 * <p/>
 * Inspiration taken from: http://code.google.com/p/opensocial-java-client/source/browse/trunk/java/src/org/opensocial/models/Model.java
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public abstract class Model extends JSONObject implements Map, JSONAware, JSONStreamAware {

  /**
   * The property change event support for this model.
   */
  protected PropertyChangeSupport propertyChanges = new PropertyChangeSupport(this);
  
  /**
   * Returns the complete set of properties associated with the model instance.
   *
   * @return a string array
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
   * @return a boolean value
   */
  public boolean hasField(String fieldName) {
    return containsKey(fieldName);
  }

  /**
   * Returns the value of the specified field as an Object.
   *
   * @param fieldName name of field whose value is to be returned
   * @return an object associated with fieldName
   */
  public Object getField(String fieldName) {
    return get(fieldName);
  }

  /**
   * Returns the value of the specified field as a {@link Map}. Equivalent to {@code (Map) getField(fieldName)}, hence
   * this method will throw a ClassCastException if the field does not implement Map.
   *
   * @param fieldName name of field whose value is to be returned
   * @return a map associated with fieldName
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
   * @return a list associated with fieldName
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
   * @return a string associated with fieldName
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
   * @return a boolean value
   */
  public boolean isFieldMultikeyed(String fieldName) {
    Object field = get(fieldName);
    if (field instanceof Map) {
      return true;
    }

    return false;
  }

  /**
   * Returns {@code true} if the value of the specified field implements {@link List}, {@code false} otherwise.
   *
   * @param fieldName name of field to look up
   * @return a boolean value
   */
  public boolean isFieldMultivalued(String fieldName) {
    Object field = get(fieldName);
    if (field instanceof List) {
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
  //Raise event when change value of property.
    propertyChanges.propertyChange(fieldName, get(fieldName), value);
    put(fieldName, value);
  }

  /**
   * Adds the passed Object to the list field with the specified name.
   *
   * @param fieldName name of list field for which the passed item should be added
   * @param item      item to add
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
  
  /**
   * Adds a property change event listener to this model
   * 
   * @param listener The listener to be added
   */
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChanges.addPropertyChangeListener(listener);
  }
  
  /**
   * Removes a property change event listener which was added to this model.
   *
   * @param listener The listener to be removed.
   */
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChanges.removeLifecycleListener(listener);
  }
  
  /**
   * Gets the property change listeners registered and associated with this property change listener. If this
   * property change has no listeners registered, a zero-length array is returned.
   * 
   * @return an array of listeners
   */
  public PropertyChangeListener[] findPropertyChangeListeners() {
    return propertyChanges.findPropertyChangeListeners();
  }
}
