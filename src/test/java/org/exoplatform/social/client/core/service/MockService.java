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

import org.exoplatform.social.client.api.auth.AccessDeniedException;
import org.exoplatform.social.client.api.service.ServiceException;

/**
 * Defines the MockModel class which provide to the UnitTestCase.
 *
 * @author thanh_vucong
 *
 */
public class MockService extends ServiceBase<MockModel, MockService> {

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
  public MockModel delete(MockModel existingInstance) throws AccessDeniedException, ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

}
