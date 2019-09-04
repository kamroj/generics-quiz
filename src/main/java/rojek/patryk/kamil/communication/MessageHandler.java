package rojek.patryk.kamil.communication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StringFormattedMessage;

/**
 * Handles messages in entire app using {@link Logger} API and {@link TextLocalizator}. Two of the
 * main functionalities are logging or retrieving messages from {@link java.util.ResourceBundle
 * ResourceBundle}.
 *
 * @author Kamil Rojek
 */
public class MessageHandler {
  private static final Logger logger = LogManager.getLogger(MessageHandler.class);

  public static void logMessage(String message) {
    logger.info(message);
  }

  public static void logFormattedMessage(String pattern, Object... args) {
    StringFormattedMessage message = new StringFormattedMessage(pattern, args);
    logMessage(message.getFormattedMessage());
  }

  /**
   * Logs message from the {@link java.util.ResourceBundle ResourceBundle} using {@link
   * TextLocalizator}.
   *
   * @param key {@code String} key pointing to specific value in {@code ResourceBundle properties}.
   */
  public static void logMessageFromBundle(String key) {
    String messageFromBundle = TextLocalizator.getMessageFromBundle(key);
    logMessage(messageFromBundle);
  }

  /**
   * Retrieves message from the {@link java.util.ResourceBundle ResourceBundle} using {@link
   * TextLocalizator}.
   *
   * @param key {@code String} pointing to specific value in {@code ResourceBundle properties}.
   * @return {@code String value} of the property specified by provided Key.
   */
  public static String getMessageFromBundle(String key) {
    return TextLocalizator.getMessageFromBundle(key);
  }

  /**
   * Changes properties file describing language to the other. Languages available:
   *
   * <ul>
   *   <li>polish
   *   <li>english
   * </ul>
   *
   * @param language app language
   */
  public static void changeLanguage(Language language) {
    TextLocalizator.setBundle(language);
  }
}
