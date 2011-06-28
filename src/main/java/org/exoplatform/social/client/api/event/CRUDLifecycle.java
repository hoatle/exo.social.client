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
 * Common interface for component CRUD life cycle methods.
 * In order to provide a consistent event management and broadcasting to create, update and delete the model.
 * 
 * @author thanh_vucong
 *
 */
public interface CRUDLifecycle<M> {

  /**
   * The CRUDLifecycleEvent type for the "component create" event.
   */
  public static final String CREATE_EVENT = "create";

  /**
   * The CRUDLifecycleEvent type for the "component before create"
   */
  public static final String BEFORE_CREATE_EVENT = "before_create";

  /**
   * The CRUDLifecycleEvent type for the "component after create"
   */
  public static final String AFTER_CREATE_EVENT = "after_create";

  /**
   * The CRUDLifecycleEvent type for the "component update" event.
   */
  public static final String UPDATE_EVENT = "update";

  /**
   * The CRUDLifecycleEvent type for the "component before update"
   */
  public static final String BEFORE_UPDATE_EVENT = "before_update";
  /**
   * The CRUDLifecycleEvent type for the "component after update"
   */
  public static final String AFTER_UPDATE_EVENT = "after_update";

  /**
   * The CRUDLifecycleEvent type for the "component delete" event.
   */
  public static final String DELETE_EVENT = "delete";

  /**
   * The CRUDLifecycleEvent type for the "component before delete"
   */
  public static final String BEFORE_DELETE_EVENT = "before_delete";
  /**
   * The CRUDLifecycleEvent type for the "component after delete"
   */
  public static final String AFTER_DELETE_EVENT = "after_delete";

  /**
   * Gets the lifecycle listeners associated with this lifecycle. If this
   * Lifecycle has no listeners registered, a zero-length array is returned.
   *
   * @return array of listeners registered
   */
  public CRUDLifecycleListener<M>[] findCRUDLifecycleListeners();
  
  /**
   * Removes a CRUDLifecycleEvent listener from this component.
   *
   * @param listener The listener to be removed
   */
  public void removeCRUDLifecycleListener(CRUDLifecycleListener<M> listener);
  
  /**
   * Adds a CRUDLifecycleEvent listener to this component.
   *
   * @param listener The listener to to be added
   */
  public void addCRUDLifecycleListener(CRUDLifecycleListener<M> listener);
  
}
