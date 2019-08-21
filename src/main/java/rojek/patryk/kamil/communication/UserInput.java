package rojek.patryk.kamil.communication;

import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class UserInput {

  private Scanner scanner;

  public UserInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public String getConfirmationInput() {
    MessageHandler.logMessageFromBundle("GIVE_CONFIRM_ANSWER");
    String input =
        getInputFromUser(
            InputValidator::confirmationInput,
            MessageHandler.getMessageFromBundle("GIVE_CONFIRM_ANSWER_TIP"));
    return input.toLowerCase();
  }

  public String getNumericInput() {
    MessageHandler.logMessageFromBundle("GIVE_NUMERIC_ANSWER");
    return getInputFromUser(
        InputValidator::numericInput,
        MessageHandler.getMessageFromBundle("GIVE_NUMERIC_ANSWER_TIP"));
  }

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
