package org.exoplatform.social.client.core.service;

import org.exoplatform.social.client.api.auth.AccessDeniedException;
import org.exoplatform.social.client.api.service.ServiceException;

/**
 * Defines the MockModel class which provide to the UnitTestCase.
 *
 * @author thanh_vucong
 *
 */
public class MockService extends AbstractLifecycle<MockModel, MockService> {

  @Override
  public MockModel create(MockModel newInstance) throws AccessDeniedException, ServiceException {
    // TODO Auto-generated method stub
    return null;
    
  }

  @Override
  public MockModel get(String uuid) throws AccessDeniedException, ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MockModel update(MockModel existingInstance) throws AccessDeniedException,
                                                     ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(MockModel existingInstance) throws AccessDeniedException, ServiceException {
    // TODO Auto-generated method stub
    
  }

}
