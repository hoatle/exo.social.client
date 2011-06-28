package org.exoplatform.social.client.core.util;

import org.exoplatform.social.client.api.event.PropertyChangeEvent;
import org.exoplatform.social.client.api.event.PropertyChangeListener;

/**
 * Making the Mock object which provide to make the UnitTestCase for PropertyChangeSupportTest class.
 * 
 * @author thanh_vucong
 *
 */
public class MockPropertyChangeListener implements PropertyChangeListener {

  private PropertyChangeEvent event;
  @Override
  public void propertyChange(PropertyChangeEvent event) {
    this.event = event;
  }
  
  /**
   * Retrieves the property name when Model raise the event to this listener.
   *
   * @return propertyName String.
   */
  public String getPropertyName() {
    if (event == null) return null;
    
    return event.getPropertyName();
  }
  
  /**
   * Retrieves the oldValue of the property specified by property name.
   *
   * @return  
   */
  public Object getOldValue() {
    if (event == null) return null;
    
    return event.getOldValue();
  }
  
  /**
   * Retrieves the newValue of the property which will be assigned
   * to the property specified by property name.
   *
   * @return newValue of property.
   */
  public Object getNewValue() {
    if (event == null) return null;
    
    return event.getNewValue();
  }

}
