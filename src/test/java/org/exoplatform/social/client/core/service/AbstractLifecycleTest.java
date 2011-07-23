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
package org.exoplatform.social.client.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.exoplatform.social.client.api.event.CRUDLifecycleEvent;
import org.exoplatform.social.client.api.event.CRUDLifecycleListener;
import org.exoplatform.social.client.api.event.Lifecycle;
import org.exoplatform.social.client.api.event.LifecycleEvent;
import org.exoplatform.social.client.api.event.LifecycleListener;
import org.exoplatform.social.client.api.event.PropertyChangeEvent;
import org.exoplatform.social.client.api.event.PropertyChangeListener;
import org.exoplatform.social.client.api.model.Model;

public abstract class AbstractLifecycleTest {

  protected Model mockModel = null;
  protected ServiceBase<MockModel, MockService> mockService = null;
  protected MockLifecycleListener captureLifecycle = null;
  protected MockCRUDLifecycleListener captureCRUDLifecycle = null;
  protected MockPropertyChangeListener capturePropertyChange = null;

  public void setUp() throws Exception {

  }
  
  public void tearDown() throws Exception {
    captureLifecycle = null;
    captureCRUDLifecycle = null;
    mockService = null;
  }
  
  /**
   * Defines the MockEvent class.
   *
   * @author thanh_vucong
   *
   */
  public class MockLifecycEvent extends LifecycleEvent<MockModel, MockService> {

    public MockLifecycEvent(Lifecycle<MockModel, MockService> source, String type) {
      super(source, type);

    }
  }

  /**
   * Defines the MockListener class.
   */
  public class MockLifecycleListener implements LifecycleListener<MockModel, MockService> {

    Collection<String> events = new ArrayList<String>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void broadcast(LifecycleEvent<MockModel, MockService> event) {
      recordEvent(event);
    }
    /**
     * Verifies the event type which has been raised to this listener.
     * @param eventName
     * @return
     */
    public boolean hasEvent(String eventName) {
      return events.contains(eventName);
    }
    
    /**
     * Supports to record the event which raise to this listener.
     * @param event
     */
    private void recordEvent(LifecycleEvent<MockModel, MockService> event) {
      events.add(event.getType());
    }
  }
  
  /**
   * Defines the MockCRUDListener which uses for UnitTestCase.
   *
   * @author thanh_vucong
   *
   */
  public class MockCRUDLifecycleListener implements CRUDLifecycleListener<MockModel> {

    Collection<String> events = new ArrayList<String>();
    @Override
    public void broadcast(CRUDLifecycleEvent<MockModel> event) {
      recordEvent(event);
      
    }
    /**
     * Verifies the event type which has been raised to this listener.
     *
     * @param eventName
     * @return
     */
    public boolean hasEvent(String eventName) {
      return events.contains(eventName);
    }
    
    /**
     * Supports to record the event which raise to this listener.
     *
     * @param event
     */
    private void recordEvent(CRUDLifecycleEvent<MockModel> event) {
      events.add(event.getType());
    }
  }

  /**
   * Defined the mock class for PropertyChangeListener.
   */
  public class MockPropertyChangeListener implements PropertyChangeListener {

    Map<String, PropertyChangeEvent> eventHolder = new HashMap<String, PropertyChangeEvent>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
      recordEvent(event);
    }
    
    /**
     * Verifies the event type which has been raised to this listener.
     *
     * @param propertyName
     * @return
     */
    public boolean hasEvent(String propertyName) {
      return eventHolder.containsKey(propertyName);
    }
    
    /**
     * Supports to record the event which raise to this listener.
     *
     * @param event
     */
    private void recordEvent(PropertyChangeEvent event) {
      eventHolder.put(event.getPropertyName(), event);
    }
    
  }
  
}
