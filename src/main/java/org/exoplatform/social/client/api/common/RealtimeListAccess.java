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
package org.exoplatform.social.client.api.common;

import java.util.List;

/**
 * The extension of {@link ListAccess} for accessing list item with real-time support.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since May 19, 2011
 */
public interface RealtimeListAccess<E> extends ListAccess<E> {

  /**
   * Checks if there is newer elements than the provided element.
   *
   * @param baseElement the based element
   * @return true if there is any newer element, otherwise, false
   */
  boolean hasNewer(E baseElement);

  /**
   * Gets the number of newer elements based on the provided element.
   *
   * @param baseElement the provided based element
   * @return number of newer elements if any
   */
  int getNumberOfNewer(E baseElement);


  /**
   * Loads newer elements based on the provided element.
   *
   * @param baseElement the based element
   * @param limit       number of newer elements to load
   * @return an array of newer elements
   */
  E[] loadNewer(E baseElement, int limit);

  /**
   * Loads newer elements based on the provided element.
   *
   * @param baseElement the based element
   * @param limit       number of newer elements to load
   * @return a list of newer elements
   */
  List<E> loadNewerAsList(E baseElement, int limit);

  /**
   * Checks if there is older elements than the provided element.
   *
   * @param baseElement the based element
   * @return true if there is any older element, otherwise, false
   */
  boolean hasOlder(E baseElement);

  /**
   * Gets the number of older elements based on the provided element.
   *
   * @param baseElement the provided element
   * @return number of older elements if any
   */
  int getNumberOfOlder(E baseElement);

  /**
   * Loads older elements based on the provided based element.
   *
   * @param baseElement the based element
   * @param limit       number of older elements to load
   * @return an array of older elements
   */
  E[] loadOlder(E baseElement, int limit);

  /**
   * Loads older elements based on the provided based element.
   *
   * @param baseElement the based element
   * @param limit       number of older elements to load
   * @return a list of older elements
   */
  List<E> loadOlderAsList(E baseElement, int limit);

}
