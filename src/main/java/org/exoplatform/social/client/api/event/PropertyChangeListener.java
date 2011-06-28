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
 * The <code>PropertyChangeListener</code> is fired whenever a bean changes a "bound"
 * property. You can register a PropertyChangeListerner with a source bean to handle when property updates.
 * 
 * @author thanh_vucong
 *
 */
public interface PropertyChangeListener {

  /**
   * Gets called when a bound property is changed.
   *
   * @param event A <code>PropertyChangeEvent</code> object describing 
   * the event source and the property that has changed.
   */
  public void propertyChange(PropertyChangeEvent event);
}
