package rojek.patryk.kamil.quiz;

import static org.testng.Assert.*;

import java.util.Scanner;
import org.testng.annotations.Test;
import rojek.patryk.kamil.communication.UserInput;

public class QuizMenuTest {

  @Test
  public void initialize_shouldDisplayMenuOptions() {
    UserInput userInput = new UserInput(new Scanner("1 y y y y 1 1"));
    QuizMenu menu = new QuizMenu(userInput);

    menu.initialize();
  }
}