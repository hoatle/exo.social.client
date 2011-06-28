package org.exoplatform.social.client.core.util;

import org.exoplatform.social.client.api.event.LifecycleEvent;
import org.exoplatform.social.client.api.event.LifecycleListener;
import org.exoplatform.social.client.core.service.MockModel;
import org.exoplatform.social.client.core.service.MockService;

public class MockLifecycleListener implements LifecycleListener<MockModel, MockService> {

  private LifecycleEvent<MockModel, MockService> event = null;
  @Override 
  public void broadcast(LifecycleEvent<MockModel, MockService> event) {
    this.event = event;
    
  }
  
  /**
   * 
   * @return
   */
  public String getEventType() {
    if (event == null) return null;
    return event.getType();
  }
  

}
