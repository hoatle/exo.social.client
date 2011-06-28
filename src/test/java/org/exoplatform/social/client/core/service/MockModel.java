package org.exoplatform.social.client.core.service;

import org.exoplatform.social.client.core.model.ModelImpl;

public class MockModel extends ModelImpl {
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
