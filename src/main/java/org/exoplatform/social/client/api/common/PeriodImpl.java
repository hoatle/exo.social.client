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
 * Created by The eXo Platform SAS
 * Implementation of {@link Period}
 * Author : vien_levan
 *          vien_levan@exoplatform.com
 * Jun 1, 2011  
 */
public class PeriodImpl implements Period {
  /**
   * The start time (timestamp).
   */
  private long startTime;
  
  /**
   * The end time (timestamp).
   */
  private long endTime;
  
  /**
   * The constructor.
   * 
   * @param startTime the start timestamp
   * @param endTime the end timestamp
   */
  public PeriodImpl(long startTime, long endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }
  
  /**
   * The constructor.
   */
  public PeriodImpl() {
    this(0, 0);
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public long getEndTime() {
    return this.endTime;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public long getStartTime() {
    return this.startTime;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setStartTime(long startTime) {
    this.startTime = startTime;
  }
}
