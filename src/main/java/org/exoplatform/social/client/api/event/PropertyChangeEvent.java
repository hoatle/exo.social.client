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
package org.exoplatform.social.client.api.event;

/**
 * A <code>PropertyChangeEvent</code> event gets delivered whenever a model 
 * changes a "bound" or "constrained" property.
 * A <code>PropertyChangeEvent</code> object is sent as an argument 
 * to the PropertyChangeListener handling.
 * 
 * Normally PropertyChangeEvent are accompanied by the name and the old
 * and new value of the changed property. If the new value is a primitive 
 * type (such as int or boolean) it must be wrapped as the corresponding 
 * java.lang.* Object type (such as Integer or Boolean)
 * 
 * @author thanh_vucong
 *
 */
public class PropertyChangeEvent extends Event {

  /**
   * The object on which the Event initially occurred.
   */
  protected transient Object  source;
  
  /**
   * name of the property that changed. May be null, if not known. 
   */
  private String propertyName;
  
  /**
   * New value for property. May be null if not known.
   */
  private Object newValue;
  
  /**
   * Previous value for property. May be null if not known.
   */
  private Object oldValue;
  
  /**
   * Constructs a new <code>PropertyChangeEvent</code>
   * 
   * @param source The bean that fired the event.
   * @param propertyName The programmatic name of the property that was changed.
   * @param oldValue The old value of the property.
   * @param newValue The new value of the property
   */
  public PropertyChangeEvent(Object source, String propertyName, Object oldValue, Object newValue) {
    this.source = source;
    this.propertyName = propertyName;
    this.newValue = newValue;
    this.oldValue = oldValue;
  }

  /**
   * Gets the programmatic name of the property that was changed.
   * 
   * @return The programmatic name of the property that was changed.
   * May be null if multiple properties have changed.
   */
  public String getPropertyName() {
    return propertyName;
  }
  
  /**
   * Gets the object on which the Event initially occurred.
   * @return
   */
  public Object getSource() {
    return source;
  }

 
  /**
   * Gets the new value for the property, expressed as an Object.
   * May be null if multiple properties have changed.
   * 
   * @return The new value for the property, expressed as an Object.
   *  May be null if multiple properties have changed.
   */
  public Object getNewValue() {
    return newValue;
  }

  /**
   * Gets the old value for the property, expressed as an Object.
   * May be null if multiple properties have changed.
   * @return
   */
  public Object getOldValue() {
    return oldValue;
  }

}
