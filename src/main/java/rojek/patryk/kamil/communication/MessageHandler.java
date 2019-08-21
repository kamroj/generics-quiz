package rojek.patryk.kamil.communication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StringFormattedMessage;

public class MessageHandler {
  private static final Logger logger = LogManager.getLogger(MessageHandler.class);

  public static void logMessage(String message) {
    logger.info(message);
  }

  public static void logFormattedMessage(String pattern, Object ... args) {
    StringFormattedMessage message = new StringFormattedMessage(pattern, args);
    logMessage(message.getFormattedMessage());
  }

  public static void logMessageFromBundle(String key) {
    String messageFromBundle = TextLocalizator.getMessageFromBundle(key);
    logMessage(messageFromBundle);
  }

  public static String getMessageFromBundle(String key) {
    return TextLocalizator.getMessageFromBundle(key);
  }

  public static void changeLanguage(Language language) {
    TextLocalizator.setBundle(language);
  }
}
