/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.social.client.core.common;

import org.exoplatform.social.client.api.common.Period;
import org.exoplatform.social.client.core.common.PeriodImpl;

import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by The eXo Platform SAS
 * Unit Test for {@link PeriodImpl}
 * Author : vien_levan
 *          vien_levan@exoplatform.com
 * @since Jun 1, 2011  
 */
public class PeriodImplTest {
  /**
   * Tests {@link PeriodImpl#getEndTime()}
   */
  @Test
  public void shouldGetEndTime() {
    Period period = new PeriodImpl();
    assertThat("period must not be null", period, notNullValue());
    assertThat("period.getEndTime() must return: " + 0L, period.getEndTime(), equalTo(0L));
    
    period.setEndTime(2000);
    assertThat("period.getEndTime() must return: 2000", period.getEndTime(), equalTo(2000L));
    
    period = new PeriodImpl(100, 200);
    assertThat("period.getEndTime() must return: 200", period.getEndTime(), equalTo(200L));
    
    period.setEndTime(500);
    assertThat("period.getEndTime() must return: 500", period.getEndTime(), equalTo(500L));
  }
  
  /**
   * Tests {@link PeriodImpl#getStartTime()}
   */
  @Test
  public void shouldGetStartTime() {
    Period period = new PeriodImpl();
    assertThat("period must not be null", period, notNullValue());
    assertThat("period.getStartTime() must return: 0", period.getStartTime(), equalTo(0L));
    
    period.setStartTime(20);
    assertThat("period.getStartTime() must return: 20", period.getStartTime(), equalTo(20L));
    
    period = new PeriodImpl(1000, 2000);
    assertThat("period.getStartTime() must return: 1000", period.getStartTime(), equalTo(1000L));
    
    period.setStartTime(1500);
    assertThat("period.getStartTime() must return: 1500", period.getStartTime(), equalTo(1500L));
  }
  
  /**
   * Tests {@link PeriodImpl#setEndTime(long)}
   */
  @Test
  public void testSetEndTime() {
    Period period = new PeriodImpl();
    assertThat("period must not be null", period, notNullValue());
    assertThat("period.getEndTime() must return: 0", period.getEndTime(), equalTo(0L));
    
    period.setEndTime(5000);
    assertThat("period.getEndTime() must return: 5000", period.getEndTime(), equalTo(5000L));
    
    period.setEndTime(500);
    assertThat("period.getEndTime() must return: 500", period.getEndTime(), equalTo(500L));
  }
  
  /**
   * Tests {@link PeriodImpl#setStartTime(long)}
   */
  @Test
  public void testSetStartTime() {
    Period period = new PeriodImpl();
    assertThat("period must not be null", period, notNullValue());
    assertThat("period.getStartTime() must return: 0", period.getStartTime(), equalTo(0L));
    
    period.setStartTime(100);
    assertThat("period.getStartTime() must return: 100", period.getStartTime(), equalTo(100L));
    
    period.setStartTime(1000);
    assertThat("period.getStartTime() must return: 1000", period.getStartTime(), equalTo(1000L));
  }
}
