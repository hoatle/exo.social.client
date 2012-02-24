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

import org.exoplatform.social.client.api.model.Model;


public class MockModel extends Model {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  public static enum Field {
    ID("id"),CONTENT("content");
    
    /**
     * The json field that the instance represents.
     */
    private final String jsonString;

    /**
     * creates a field base on the a json element.
     *
     * @param jsonString the name of the element
     */
    private Field(String jsonString) {
      this.jsonString = jsonString;
    }

    /**
     * emits the field as a json element.
     *
     * @return the field name
     */
    @Override
    public String toString() {
      return jsonString;
    }
  }

  

}
