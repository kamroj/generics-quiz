package rojek.patryk.kamil.quiz;

import org.testng.Assert;
import org.testng.annotations.Test;
import rojek.patryk.kamil.quiz.LogReaderHandler.TestCaseFileException;

public class LogReaderHandlerTest {

  @Test
  public void readUserInputSteps_shouldReturnExpectedUserInputSteps() throws TestCaseFileException {
    String steps = LogReaderHandler.readUserInputTestCaseSteps("log-reader-test-correct");
    String expectedSteps = "1 y y y y 1 1";

    Assert.assertEquals(steps, expectedSteps);
  }

  @Test(expectedExceptions = TestCaseFileException.class)
  public void readUserInputSteps_whenNoStepsIncludedInTestCaseFile_shouldThrowTestCaseFileException() throws TestCaseFileException {
    LogReaderHandler.readUserInputTestCaseSteps("log-reader-test-nosteps");
  }

  @Test(expectedExceptions = TestCaseFileException.class)
  public void readUserInputSteps_whenNoLogsIncluded_shouldThrowTestCaseFileException() throws TestCaseFileException {
    LogReaderHandler.readExpectedConsoleLogs("log-reader-test-nologs");
  }

  @Test
  public void readExpectedConsoleLogs_shouldReturnExpectedConsleLogsWithoutWhitespaces()
      throws TestCaseFileException {
    String consoleLogs = LogReaderHandler.readExpectedConsoleLogs("log-reader-test-correct");
    String expectedConsoleLogs = "1:Rozpocznijquiz2:Zmieńilośćpytań3:Opisprojektu";

    Assert.assertEquals(consoleLogs, expectedConsoleLogs);
  }

  @Test
  public void readConsoleQuizLogs_shouldReturnStringWithoutWhitespaces()
      throws TestCaseFileException {
    String consoleLogs = LogReaderHandler.readConsoleQuizLogs("quiz-logs-for-test.log");
    String expectedLogs = "1:Rozpocznijquiz2:Zmieńilośćpytań3:Opisprojektu";

    Assert.assertEquals(consoleLogs, expectedLogs);
  }
}
