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
 * Common interface for component life cycle methods.
 * In order to provide a consistent to start and stop the component.
 * 
 * @author thanh_vucong
 *
 */
public interface Lifecycle<M,S> {

  /**
   * The LifecycleEvent type for the "component start" event.
   */
  public static final String START_EVENT = "start";

  /**
   * The LifecycleEvent type for the "component before start"
   */
  public static final String BEFORE_START_EVENT = "before_start";

  /**
   * The LifecycleEvent type for the "component after start"
   */
  public static final String AFTER_START_EVENT = "after_start";

  /**
   * The LifecycleEvent type for the "component stop" event.
   */
  public static final String STOP_EVENT = "stop";

  /**
   * The LifecycleEvent type for the "component before stop"
   */
  public static final String BEFORE_STOP_EVENT = "before_stop";
  /**
   * The LifecycleEvent type for the "component after start"
   */
  public static final String AFTER_STOP_EVENT = "after_stop";

  /**
   * The LifecycleEvent type for the "component destroy"
   */
  public static final String DESTROY_EVENT = "destroy";
 
  
  /**
   * Get the lifecycle listeners associated with this lifecycle. If this 
   * Lifecycle has no listeners registered, a zero-length array is returned.
   */
  public LifecycleListener<M,S>[] findLifecycleListeners();
  
  /**
   * Remove a LifecycleEvent listener from this component.
   *
   * @param listener The listener to remove
   */
  public void removeLifecycleListener(LifecycleListener<M,S> listener);
  
  /**
   * Add a LifecycleEvent listener to this component.
   *
   * @param listener The listener to add
   */
  public void addLifecycleListener(LifecycleListener<M,S> listener);


  /**
   * Prepare for the beginning of active use of the public methods of this
   * component.  This method should be called before any of the public
   * methods of this component are utilized.  It should also send a
   * LifecycleEvent of type START_EVENT to any registered listeners.
   *
   * @throws LifecycleException if this component detects a fatal error
   *                            that prevents this component from being used
   */
  public void start() throws LifecycleException;


  /**
   * Gracefully terminate the active use of the public methods of this
   * component.  This method should be the last one called on a given
   * instance of this component.  It should also send a LifecycleEvent
   * of type STOP_EVENT to any registered listeners.
   *
   * @throws LifecycleException if this component detects a fatal error
   *                            that needs to be reported
   */
  public void stop() throws LifecycleException;
  
}
