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
package org.exoplatform.social.client.api.model;

/**
 * Activity Stream model.
 *
 * @author <a href="http://hoatle.net">hoatle (hoatlevan at gmail dot com)</a>
 * @since Jun 29, 2011
 */
public class RestActivityStream extends Model {
  /**
   * The fields that represent the RestActivityStream object in json form.
   */
  public static enum Field {
    /**
     * the json field for type
     */
    TYPE("type"),
    /**
     * the json field for prettyId.
     */
    PRETTY_ID("prettyId"),
    /**
     * the json field for fullName.
     */    
    FULL_NAME("fullName"),
    /**
     * the json field for faviconUrl.
     */
    FAVICON_URL("faviconUrl"),
    /**
     * the json field for title.
     */
    TITLE("title"),
    /**
     * the json field for permaLink.
     */
    PERMALINK("permaLink");

    /**
     * The json field that the instance represents.
     */
    private final String jsonString;

    /**
     * create a field base on the a json element.
     *
     * @param jsonString the name of the element
     */
    private Field(String jsonString) {
      this.jsonString = jsonString;
    }

    /**
     * emit the field as a json element.
     *
     * @return the field name
     */
    @Override
    public String toString() {
      return jsonString;
    }
  }

  /**
   * Default constructor
   */
  public RestActivityStream() {

  }
  
  /**
   * Constructor to set values.
   *
   * @param type       the type
   * @param prettyId   the pretty id
   * @param faviconUrl the favicon url
   * @param title      the title
   * @param permaLink  the permalink
   */
  public RestActivityStream(String type, String prettyId, String fullName, String faviconUrl, String title, String permaLink) {
    setType(type);
    setPrettyId(prettyId);
    setFullName(fullName);
    setFaviconUrl(faviconUrl);
    setTitle(title);
    setPermaLink(permaLink);
  }
  
  /**
   * Gets the type of activity stream.
   *
   * @return the type
   */
  public String getType() {
    return getFieldAsString(Field.TYPE.toString());
  }

  /**
   * Sets the type of activity stream.
   *
   * @param type the type
   */
  public void setType(String type) {
    setField(Field.TYPE.toString(), type);
  }

  /**
   * Gets the pretty id from the activity stream.
   *
   * @return the pretty id
   */
  public String getPrettyId() {
    return getFieldAsString(Field.PRETTY_ID.toString());
  }

  /**
   * Sets the pretty id for the activity stream.
   *
   * @param prettyId the pretty id
   */
  public void setPrettyId(String prettyId) {
    setField(Field.PRETTY_ID.toString(), prettyId);
  }
  
  /**
   * Gets the full name of activity stream owner.
   *
   * @return the fullName of activity stream owner.
   * @since  1.0.0-alpha3 (Rest v1-alpha3)
   */
  public String getFullName() {
    return getFieldAsString(Field.FULL_NAME.toString());
  }

  /**
   * Sets the full name for the activity stream owner.
   *
   * @param fullName the full name
   * @since 1.0.0-alpha3 (Rest v1-alpha3)
   */
  public void setFullName(String fullName) {
    setField(Field.FULL_NAME.toString(), fullName);
  }
  
  /**
   * Gets the favicon url of the activity stream.
   *
   * @return the favicon url
   */
  public String getFaviconUrl() {
    return getFieldAsString(Field.FAVICON_URL.toString());
  }

  /**
   * Sets the favicon url for the activity stream.
   *
   * @param faviconUrl the favicon url
   */
  public void setFaviconUrl(String faviconUrl) {
    setField(Field.FAVICON_URL.toString(), faviconUrl);
  }

  /**
   * Gets activity stream's title.
   *
   * @return the activity stream's title
   */
  public String getTitle() {
    return getFieldAsString(Field.TITLE.toString());
  }

  /**
   * Sets the activity stream title.
   *
   * @param title the activity stream's title
   */
  public void setTitle(String title) {
    setField(Field.TITLE.toString(), title);
  }

  /**
   * Gets the permanent link for activity stream.
   *
   * @return the permanent link
   */
  public String getPermaLink() {
    return getFieldAsString(Field.PERMALINK.toString());
  }

  /**
   * Sets the permanent link for activity stream.
   *
   * @param permaLink the permanent link
   */
  public void setPermaLink(String permaLink) {
    setField(Field.PERMALINK.toString(), permaLink);
  }

}
