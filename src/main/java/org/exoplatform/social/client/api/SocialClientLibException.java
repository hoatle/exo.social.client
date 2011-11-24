package org.exoplatform.social.client.api;

public class SocialClientLibException extends Exception {
  /**
   * Exception without any message.
   */
  public SocialClientLibException(){
    super();
  }

  /**
   * Exception with message.
   *
   * @param message the message
   */
  public SocialClientLibException(String message){
    super(message);
  }
  
  /**
   * Exception with message.
   *
   * @param message the message
   */
  public SocialClientLibException(String message, Throwable cause){
    super(message, cause);
  }
}
