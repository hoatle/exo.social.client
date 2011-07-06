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
public interface RestActivityStream {
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
   * Gets the type of activity stream.
   *
   * @return the type
   */
  String getType();

  /**
   * Sets the type of activity stream.
   *
   * @param type the type
   */
  void setType(String type);

  /**
   * Gets the pretty id from the activity stream.
   *
   * @return the pretty id
   */
  String getPrettyId();

  /**
   * Sets the pretty id for the activity stream.
   *
   * @param prettyId the pretty id
   */
  void setPrettyId(String prettyId);

  /**
   * Gets the favicon url of the activity stream.
   *
   * @return the favicon url
   */
  String getFaviconUrl();

  /**
   * Sets the favicon url for the activity stream.
   *
   * @param faviconUrl the favicon url
   */
  void setFaviconUrl(String faviconUrl);

  /**
   * Gets activity stream's title.
   *
   * @return the activity stream's title
   */
  String getTitle();

  /**
   * Sets the activity stream title.
   *
   * @param title the activity stream's title
   */
  void setTitle(String title);

  /**
   * Gets the permanent link for activity stream.
   *
   * @return the permanent link
   */
  String getPermaLink();

  /**
   * Sets the permanent link for activity stream.
   *
   * @param permaLink the permanent link
   */
  void setPermaLink(String permaLink);

}
