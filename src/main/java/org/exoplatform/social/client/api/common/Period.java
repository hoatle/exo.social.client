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

/**
 * This Period is used to indicate the start and end time.
 * The start and end are timestamp values.
 *
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since  May 20, 2011
 */
public interface Period {
  /**
   * Gets the start time.
   *
   * @return the star time
   */
  long getStartTime();

  /**
   * Sets the star time.
   *
   * @param startTime the star time
   */
  void setStartTime(long startTime);

  /**
   * Gets the stop time.
   *
   * @return the stop time
   */
  long getStopTime();

  /**
   * Sets the stop time.
   * @param stopTime the stop time
   */
  void setStopTime(long stopTime);
}
