package rojek.patryk.kamil.communication;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InputValidatorTest {

  @DataProvider
  public static Object[][] inputFrom0To9999() {
    return new Object[][] {
      {"0"}, {"1"}, {"10"}, {"41"}, {"99"}, {"131"}, {"649"}, {"1200"}, {"3123"}, {"9999"}
    };
  }

  @Test(dataProvider = "inputFrom0To9999")
  public void integerInput_putNumericValueInRange0To9999_returnTrue(String input) {
    boolean isValid = InputValidator.numericInput(input);
    Assert.assertTrue(isValid);
  }

  @DataProvider
  public static Object[][] invalidInput() {
    return new Object[][] {
      {"-1"}, {"1.1"}, {"a"}, {"~"}, {"!"}, {" "}, {";"}, {"0.0"}, {"-0.1"}, {"10000"}
    };
  }

  @Test(dataProvider = "invalidInput")
  public void integerInput_putInvalidNumericValue_returnTrue(String input) {
    boolean isValid = InputValidator.numericInput(input);
    Assert.assertFalse(isValid);
  }

  @DataProvider
  public static Object[][] validConfirmationInputs() {
    return new Object[][] {{"y"}, {"Y"}, {"n"}, {"N"}};
  }

  @Test(dataProvider = "validConfirmationInputs")
  public void confirmationInput_putValidConfirmationInput_returnTrue(String input) {
    boolean isValid = InputValidator.confirmationInput(input);
    Assert.assertTrue(isValid);
  }

  @DataProvider
  public static Object[][] invalidConfirmationInputs() {
    return new Object[][] {{"yY"}, {"Yy"}, {"nN"}, {"Nn"}, {"1"}, {"1"}, {"~"}, {" "}, {";"}};
  }

  @Test(dataProvider = "invalidConfirmationInputs")
  public void confirmationInput_putInvalidConfirmationInput_returnTrue(String input) {
    boolean isValid = InputValidator.confirmationInput(input);
    Assert.assertFalse(isValid);
  }

  @DataProvider
  public static Object[][] validInputsForMap() {
    return new Object[][] {{"1"}, {"2"}, {"3"}};
  }

  @Test(dataProvider = "validInputsForMap")
  public void validMapKeyIntegerInput_putValidInput_returnTrue(String input) {
    Map<Integer, Integer> options = Map.of(1, 1, 2, 2, 3, 3);
    boolean isValid = InputValidator.validMapKeyIntegerInput(options, input);
    Assert.assertTrue(isValid);
  }

  @DataProvider
  public static Object[][] invalidInputsForMap() {
    return new Object[][] {{"0"}, {"4"}, {"a"}, {" "}, {"~"}, {"1.1"}};
  }

  @Test(dataProvider = "invalidInputsForMap")
  public void validMapKeyIntegerInput_putInvalidInput_returnFalse(String input) {
    Map<Integer, Integer> options = Map.of(1, 1, 2, 2, 3, 3);
    boolean isValid = InputValidator.validMapKeyIntegerInput(options, input);
    Assert.assertFalse(isValid);
  }
}
