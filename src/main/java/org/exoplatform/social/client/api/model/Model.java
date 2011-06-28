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

import java.util.List;
import java.util.Map;

import org.exoplatform.social.client.api.event.PropertyChangeListener;
import org.json.simple.JSONAware;
import org.json.simple.JSONStreamAware;

/**
 * The general model extends {@link org.json.simple.JSONObject}'s interfaces.
 * <p/>
 * Inspiration taken from: http://code.google.com/p/opensocial-java-client/source/browse/trunk/java/src/org/opensocial/models/Model.java
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface Model extends Map, JSONAware, JSONStreamAware {

  /**
   * Returns the complete set of properties associated with the model instance.
   *
   * @return a string array
   */
  String[] getFieldNames();

  /**
   * Returns {@code true} if a value is associated with the specified field name, {@code false} otherwise.
   *
   * @param fieldName name of field to look up
   * @return a boolean value
   */
  boolean hasField(String fieldName);

  /**
   * Returns the value of the specified field as an Object.
   *
   * @param fieldName name of field whose value is to be returned
   * @return an object associated with fieldName
   */
  Object getField(String fieldName);

  /**
   * Returns the value of the specified field as a {@link Map}. Equivalent to {@code (Map) getField(fieldName)}, hence
   * this method will throw a ClassCastException if the field does not implement Map.
   *
   * @param fieldName name of field whose value is to be returned
   * @return a map associated with fieldName
   * @see ClassCastException
   */
  Map getFieldAsMap(String fieldName);

  /**
   * Returns the value of the specified field as a {@link java.util.List}. Equivalent to {@code (List)
   * getField(fieldName)}, hence this method will throw a ClassCastException if the field does not implement List.
   *
   * @param fieldName name of field whose value is to be returned
   * @return a list associated with fieldName
   * @see ClassCastException
   */
  List getFieldAsList(String fieldName);

  /**
   * Returns the value of the specified field as a {@link String}. Equivalent to {@code (String) getField(fieldName)},
   * hence this method will throw a ClassCastException if the field is not of type String.
   *
   * @param fieldName name of field whose value is to be returned
   * @return a string associated with fieldName
   * @see ClassCastException
   */
  String getFieldAsString(String fieldName);

  /**
   * Returns {@code true} if the value of the specified field implements {@link Map}, {@code false} otherwise.
   *
   * @param fieldName name of field to look up
   * @return a boolean value
   */
  boolean isFieldMultikeyed(String fieldName);

  /**
   * Returns {@code true} if the value of the specified field implements {@link List}, {@code false} otherwise.
   *
   * @param fieldName name of field to look up
   * @return a boolean value
   */
  boolean isFieldMultivalued(String fieldName);

  /**
   * Sets the value of the specified field to the passed Object.
   *
   * @param fieldName name of field to set
   * @param value     object to associate with passed field name
   */
  void setField(String fieldName, Object value);

  /**
   * Adds the passed Object to the list field with the specified name.
   *
   * @param fieldName name of list field for which the passed item should be added
   * @param item      item to add
   */
  void addToListField(String fieldName, Object item);
  
  /**
   * Adds a property change event listener to this model
   * 
   * @param listener The listener to be added
   */
  void addPropertyChangeListener(PropertyChangeListener listener);
  
  /**
   * Removes a property change event listener which was added to this model.
   *
   * @param listener The listener to be removed.
   */
  void removePropertyChangeListener(PropertyChangeListener listener);
  
  /**
   * Gets the property change listeners registered and associated with this property change listener. If this
   * property change has no listeners registered, a zero-length array is returned.
   * 
   * @return an array of listeners
   */
  PropertyChangeListener[] findPropertyChangeListeners();
}
