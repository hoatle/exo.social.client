package org.exoplatform.social.client.api.auth;

/**
 * Created by PhuongLM
 * User: phuonglm http://phuonglm.net
 * Date: 11/22/11
 * Time: 2:56 PM
 */
public class NotFoundException extends Exception {
  /**
   * Exception without any message.
   */
  public NotFoundException(){
    super();
  }

  /**
   * Exception with message.
   *
   * @param message the message
   */
  public NotFoundException(String message){
    super(message);
  }
}
