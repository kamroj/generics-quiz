package rojek.patryk.kamil.quiz;

import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rojek.patryk.kamil.communication.UserInput;
import rojek.patryk.kamil.quiz.LogReaderHandler.TestCaseFileException;

public class QuizMenuTest {
  @DataProvider()
  public static Object[][] testCasesName() {
    return new Object[][] {
        {"01_play_quiz"}, {"02_play_quiz"}
    };
  }

  @Test(dataProvider = "testCasesName", enabled = false) //todo fix clearing logs file every time method is rerun
  public void initialize_playQuiz_resultShouldBeAsExpectedInTestCase(String testCaseName) throws TestCaseFileException {
    String userSteps = LogReaderHandler.readUserInputTestCaseSteps(testCaseName);
    String expectedLogs = LogReaderHandler.readExpectedConsoleLogs(testCaseName);

    UserInput userInput = new UserInput(new Scanner(userSteps));
    QuizMenu menu = new QuizMenu(userInput);
    menu.initialize();
    String resultLogs = LogReaderHandler.readConsoleQuizLogs("quiz-logs.log");

    Assert.assertEquals(resultLogs, expectedLogs);
  }
}
