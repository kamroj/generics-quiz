package rojek.patryk.kamil.communication;

import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Gets an input from the user, validates it and returns value of specific type if the input meets
 * the conditions. In case user provides incorrect input, will be asked for typing input again.
 *
 * @author Kamil Rojek
 */
public class UserInput {
  private Scanner scanner;

  public UserInput(Scanner scanner) {
    this.scanner = scanner;
  }

  /**
   * Asks the user for confirmation input (Yy/Nn) which means yes or no. If user types different
   * confirmation input, will be queried for typing it again.
   *
   * @return {@code String}: <strong>y</strong> - yes or <strong>n</strong> - no
   */
  public String getConfirmationInput() {
    MessageHandler.logMessageFromBundle("GIVE_CONFIRM_ANSWER");
    String input =
        getInputFromUser(
            InputValidator::confirmationInput,
            MessageHandler.getMessageFromBundle("GIVE_CONFIRM_ANSWER_TIP"));
    return input.toLowerCase();
  }

  /**
   * Asks the user for integer input from 0 - 9999. If user types a out of range value will be
   * queried for typing the value again.
   *
   * @return {@code String} numeric value.
   */
  public String getNumericInput() {
    MessageHandler.logMessageFromBundle("GIVE_NUMERIC_ANSWER");
    return getInputFromUser(
        InputValidator::numericInput,
        MessageHandler.getMessageFromBundle("GIVE_NUMERIC_ANSWER_TIP"));
  }

  /**
   * Asks the user for choosing one of the options specified by {@code Map<Integer, ?>}. If user
   * types an option that the Map does not contain, will be queried for typing the option again.
   *
   * @param map option map with key type of Integer and any type of value.
   * @return valid integer key pointing to specific option.
   */
  public int getValidMapKeyIntegerInput(Map<Integer, ?> map) {
    MessageHandler.logMessageFromBundle("CHOOSE_OPTION");
    String input =
        getInputFromUser(
            InputValidator::validMapKeyIntegerInput,
            map,
            MessageHandler.getMessageFromBundle("CHOOSE_OPTION_TIP"));
    return Integer.parseInt(input);
  }

  private String getInputFromUser(Predicate<String> check, String message) {
    String input = scanner.next();

    while (!check.test(input)) {
      System.out.println(message);
      input = scanner.next();
    }
    return input;
  }

  private String getInputFromUser(
      BiPredicate<Map<Integer, ?>, String> check, Map<Integer, ?> map, String message) {
    String input = scanner.next();

    while (!check.test(map, input)) {
      System.out.println(message);
      input = scanner.next();
    }
    return input;
  }
}
