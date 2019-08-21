package rojek.patryk.kamil.communication;

import java.util.ResourceBundle;

class TextLocalizator {
  private static ResourceBundle bundle;

  static {
    bundle = getBundle(Language.POLISH);
  }

  static String getMessageFromBundle(String key) {
    return bundle.getString(key);
  }

  static void setBundle(Language language) {
    bundle = getBundle(language);
  }

  private static ResourceBundle getBundle(Language language) {
    return ResourceBundle.getBundle(language.name);
  }
}
