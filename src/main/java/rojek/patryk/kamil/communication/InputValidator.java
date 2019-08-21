package rojek.patryk.kamil.communication;

import java.util.Map;
import java.util.regex.Pattern;

class InputValidator {
  static boolean numericInput(String input) {
    return isMatching(input, "^\\d{1,4}+$");
  }

  static boolean confirmationInput(String input) {
    return isMatching(input, "[yY]{1}|[nN]{1}");
  }

  private static boolean isMatching(String input, String pattern) {
    Pattern p = Pattern.compile(pattern);
    return p.matcher(input).matches();
  }

  static boolean validMapKeyIntegerInput(Map<Integer, ?> map, String input) {
    if (!numericInput(input)) return false;
    return map.containsKey(Integer.parseInt(input));
  }
}
