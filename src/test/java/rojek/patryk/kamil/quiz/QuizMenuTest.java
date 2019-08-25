package rojek.patryk.kamil.quiz;

import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;
import rojek.patryk.kamil.communication.UserInput;
import rojek.patryk.kamil.quiz.LogReaderHandler.TestCaseFileException;

public class QuizMenuTest {

  @Test
  public void initialize_shouldDisplayMenuOptions() throws TestCaseFileException {
    String testCaseName = "01_play_quiz";
    String userSteps = LogReaderHandler.readUserInputTestCaseSteps(testCaseName);
    String expectedLogs = LogReaderHandler.readExpectedConsoleLogs(testCaseName);

    UserInput userInput = new UserInput(new Scanner(userSteps));
    QuizMenu menu = new QuizMenu(userInput);
    menu.initialize();
    String resultLogs = LogReaderHandler.readConsoleQuizLogs("quiz-logs.log");

    Assert.assertEquals(resultLogs, expectedLogs);
  }
}
