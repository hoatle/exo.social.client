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
package org.exoplatform.social.client.core;


import org.exoplatform.social.client.api.SocialClientContext;
import org.exoplatform.social.client.api.service.ServiceException;

/**
 * The base abstract class for integration tests of of Social Rest APIs v1-alpha1.
 *
 * It's required for all tests to check {@link #canRunTest()} to make sure if the rest version is not supported
 * by server, just pass.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since 1.0.0-alpha2
 */
public abstract class AbstractClientTestV1Alpha1 extends AbstractClientTest {

  /**
   * {@inheritDoc}
   */
  protected void setRestVersion() {
    SocialClientContext.setRestVersion("v1-alpha1");
  }

  /**
   * Support to get the IdentityId value.
   * @return
   */
  protected String getDemoIdentityId() throws ServiceException {
    return identityService.getIdentityId("organization", "demo");
  }


}
