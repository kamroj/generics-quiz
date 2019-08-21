package rojek.patryk.kamil.communication;

import java.util.Map;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserInputTest {
  @DataProvider
  public static Object[][] inputFrom0To9999() {
    return new Object[][] {
      {"0"}, {"1"}, {"10"}, {"41"}, {"99"}, {"131"}, {"649"}, {"1200"}, {"3123"}, {"9999"}
    };
  }

  @Test(dataProvider = "inputFrom0To9999")
  public void getNumericInput_putNumericValueInRange0To9999_returnInputValue(String input) {
    UserInput userInput = new UserInput(new Scanner(input));
    String result = userInput.getNumericInput();
    Assert.assertEquals(result, input);
  }

  @DataProvider
  public static Object[][] invalidInput() {
    return new Object[][] {
      {"-1", "1"},
      {"1.1", "1"},
      {"a", "1"},
      {"~", "1"},
      {"!", "1"},
      {" ", "1"},
      {";", "1"},
      {"0.0", "1"},
      {"-0.1", "1"},
      {"10000", "1"}
    };
  }

  @Test(dataProvider = "invalidInput")
  public void getNumericInput_putFirstInvalidNumericValueThenSecondValid_returnInputValue(
      String firstInput, String secondInput) {

    UserInput userInput = new UserInput(new Scanner(firstInput + " " + secondInput));
    String result = userInput.getNumericInput();
    Assert.assertEquals(result, secondInput);
  }

  @DataProvider
  public static Object[][] validConfirmationInputs() {
    return new Object[][] {{"y"}, {"Y"}, {"n"}, {"N"}};
  }

  @Test(dataProvider = "validConfirmationInputs")
  public void getConfirmationInput_putValidConfirmationInput_returnInputValue(String input) {
    UserInput userInput = new UserInput(new Scanner(input));
    String result = userInput.getConfirmationInput();
    Assert.assertEquals(result, input.toLowerCase());
  }

  @DataProvider
  public static Object[][] validInputsForMap() {
    return new Object[][] {{"1"}, {"2"}, {"3"}};
  }

  @Test(dataProvider = "validInputsForMap")
  public void getValidMapKeyIntegerInput_putValidInput_returnInputValue(String input) {
    Map<Integer, Integer> options = Map.of(1, 1, 2, 2, 3, 3);
    UserInput userInput = new UserInput(new Scanner(input));
    int result = userInput.getValidMapKeyIntegerInput(options);
    Assert.assertEquals(result, Integer.parseInt(input));
  }

  @DataProvider
  public static Object[][] invalidInputsForMap() {
    return new Object[][] {
      {"0", "1"}, {"4", "1"}, {"a", "1"}, {" ", "1"}, {"~", "1"}, {"1.1", "1"}
    };
  }

  @Test(dataProvider = "invalidInputsForMap")
  public void
      getValidMapKeyIntegerInput_putFirstInvalidNumericValueThenSecondValid_returnInputValue(
          String firstInput, String secondInput) {
    Map<Integer, Integer> options = Map.of(1, 1, 2, 2, 3, 3);
    UserInput userInput = new UserInput(new Scanner(firstInput + " " + secondInput));
    int result = userInput.getValidMapKeyIntegerInput(options);
    Assert.assertEquals(result, Integer.parseInt(secondInput));
  }
}
