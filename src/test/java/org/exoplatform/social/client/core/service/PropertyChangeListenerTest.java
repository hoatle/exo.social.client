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

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

/**
 * Unit Test for {@link org.exoplatform.social.client.api.event.PropertyChangeListener}.
 */
public class PropertyChangeListenerTest extends AbstractLifecycleTest {

  @BeforeMethod
  public void setUp() throws Exception {
    super.setUp();
    capturePropertyChange = new MockPropertyChangeListener();
    mockModel = new MockModel();
    mockModel.addPropertyChangeListener(capturePropertyChange);
  }
  
  @AfterMethod
  public void tearDown() throws Exception {
    super.tearDown();
    capturePropertyChange = null;
    mockModel = null;
    
  }
  
  @Test
  public void checkPropertyChangeListener() throws Exception {
    assertEquals(1, mockModel.findPropertyChangeListeners().length);
  }
  
  @Test
  public void handlePropertyChangeListener() throws Exception {
    mockModel.setField(MockModel.Field.ID.toString(), "newValue");
    assertTrue(capturePropertyChange.eventHolder.containsKey(MockModel.Field.ID.toString()));
    assertEquals(MockModel.Field.ID.toString(),
            capturePropertyChange.eventHolder.get(MockModel.Field.ID.toString()).getPropertyName());
    assertEquals("newValue", capturePropertyChange.eventHolder.get(MockModel.Field.ID.toString()).getNewValue());
    assertNull(capturePropertyChange.eventHolder.get(MockModel.Field.ID.toString()).getOldValue());
  }
  
  @Test
  public void checkOldValue() throws Exception {
    mockModel.setField(MockModel.Field.ID.toString(), "oldValue");
    mockModel.setField(MockModel.Field.ID.toString(), "newValue");
    
    assertEquals(1, capturePropertyChange.eventHolder.size());
    assertTrue(capturePropertyChange.eventHolder.containsKey(MockModel.Field.ID.toString()));
    assertEquals(MockModel.Field.ID.toString(),
            capturePropertyChange.eventHolder.get(MockModel.Field.ID.toString()).getPropertyName());
    assertEquals("newValue", capturePropertyChange.eventHolder.get(MockModel.Field.ID.toString()).getNewValue());
    assertEquals("oldValue", capturePropertyChange.eventHolder.get(MockModel.Field.ID.toString()).getOldValue());
  }
  
  @Test
  public void checkRaiseEventCountSameField() throws Exception {
    mockModel.setField(MockModel.Field.ID.toString(), "oldValue");
    mockModel.setField(MockModel.Field.ID.toString(), "newValue");
    assertEquals(capturePropertyChange.eventHolder.size(), 1);
  }
  @Test
  public void checkRaiseEventCountNotSameField() throws Exception {
    mockModel.setField(MockModel.Field.ID.toString(), "oldValue");
    mockModel.setField(MockModel.Field.CONTENT.toString(), "oldContentValue");
    
    assertEquals(capturePropertyChange.eventHolder.size(), 2);
   
  }
  
  
  
  
}
