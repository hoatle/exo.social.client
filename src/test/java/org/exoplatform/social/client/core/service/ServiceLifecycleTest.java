package org.exoplatform.social.client.core.service;

import org.exoplatform.social.client.api.event.Lifecycle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Test for {@link Lifecycle}.
 */
public class ServiceLifecycleTest extends AbstractLifecycleTest {

  @Before
  public void setUp() throws Exception {
    super.setUp();
    mockService = new MockService();
    captureLifecycle = new MockLifecycleListener();
    captureCRUDLifecycle = new MockCRUDLifecycleListener();
    mockService.addLifecycleListener(captureLifecycle);
    mockService.addCRUDLifecycleListener(captureCRUDLifecycle);
  }
  
  @After
  public void tearDown() throws Exception {
    super.tearDown();
  }
  
  @Test
  public void startService() throws Exception {
    mockService.start();
    Assert.assertTrue(mockService.started);
    
    Assert.assertTrue(captureLifecycle.hasEvent(Lifecycle.BEFORE_START_EVENT));
    Assert.assertTrue(captureLifecycle.hasEvent(Lifecycle.START_EVENT));
    Assert.assertTrue(captureLifecycle.hasEvent(Lifecycle.BEFORE_START_EVENT));
  }
  
  @Test
  public void stopService() throws Exception {
    mockService.start();
    Assert.assertTrue(captureLifecycle.hasEvent(Lifecycle.BEFORE_START_EVENT));
    Assert.assertTrue(captureLifecycle.hasEvent(Lifecycle.START_EVENT));
    Assert.assertTrue(captureLifecycle.hasEvent(Lifecycle.BEFORE_START_EVENT));
    Assert.assertTrue(mockService.started);
    
    mockService.stop();
    Assert.assertTrue(captureLifecycle.hasEvent(Lifecycle.BEFORE_STOP_EVENT));
    Assert.assertTrue(captureLifecycle.hasEvent(Lifecycle.STOP_EVENT));
    Assert.assertTrue(captureLifecycle.hasEvent(Lifecycle.BEFORE_STOP_EVENT));
    Assert.assertFalse(mockService.started);
  }
  
  @Test
  public void checkCRUDLifecycleListenerToService() throws Exception {
    Assert.assertEquals(1, mockService.findCRUDLifecycleListeners().length);
  }
  
  @Test
  public void checkLifecycleListenerToService() throws Exception {
    Assert.assertEquals(1, mockService.findLifecycleListeners().length);
  }
  
}
