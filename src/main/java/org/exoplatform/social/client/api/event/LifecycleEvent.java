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
 * General event for notifying listeners of significant changes on a component
 * that implements the Lifecycle interface.
 * 
 * @author thanh_vucong
 *
 */
public class LifecycleEvent<M, L> extends Event {

  /**
   * The event type this instance represents.
   */
  private String type = null;
  /**
   * The event data associated with this event.
   */
  private L data = null;
  /**
   * The Lifecycle on which this event occurred.
   */
  private Lifecycle<M,L> source = null;
  
  /**
   * Construct a new LifecycleEvent with the specified parameters.
   * 
   * @param source Component on which this event occurred
   * @param type Event type (required)
   */
  public LifecycleEvent(Lifecycle<M,L> source, String type) {
   this(source, type, null);
  }
  
  /**
   * Construct a new LifecycleEvent with the specified parameters.
   * 
   * @param source Component on which this event occurred
   * @param type Event type (required)
   * @param data Event data (if any)
   */
  public LifecycleEvent(Lifecycle<M,L> source, String type, L data) {
    this.source = source;
    this.type = type;
    this.data = data;
  }
  
  /**
   * Return the event type of this event.
   * @return
   */
  public String getType() {
    return type;
  }

  /**
   * Return the event data of this event.
   * @return
   */
  public L getData() {
    return data;
  }

  /**
   * Return the Lifecycle on which this event occurred.
   * @return
   */
  public Lifecycle<M,L> getSource() {
    return source;
  }
  
}
