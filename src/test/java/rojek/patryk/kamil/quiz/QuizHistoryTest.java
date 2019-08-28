package rojek.patryk.kamil.quiz;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rojek.patryk.kamil.quiz.LogReaderHandler.TestCaseFileException;

public class QuizHistoryTest {
  private QuizHistory quizHistory;

  @BeforeTest
  public void setUp() {
    this.quizHistory = QuizHistory.getInstance();
  }

  @Test
  public void getInstance_objectIsNotNull() {
    Assert.assertNotNull(quizHistory);
  }

  @Test(priority = 1)
  public void updateHistory_updateHistoryWithOneQuestion_returnQuestionHistorySize1() {
    Question question = new Question();

    question.setDescription("desc");
    question.setAnswer("answer");
    question.setExplanation("expl");
    quizHistory.updateHistory(question, "Lorem ipsum");

    Assert.assertEquals(quizHistory.getQuestionsAndAnswers().size(), 1);
  }

  @Test(priority = 2)
  public void getQuestionsAndAnswers_putOneQuestion_returnSameQuestionFromHistory() {
    Question question = new Question();

    question.setDescription("desc");
    question.setAnswer("Lorem ipsum");
    question.setExplanation("expl");
    quizHistory.updateHistory(question, "Lorem ipsum answer");
    Map<Question, String> questionsAndAnswers = quizHistory.getQuestionsAndAnswers();
    String answer = questionsAndAnswers.get(question);

    Assert.assertEquals(answer, "Lorem ipsum answer");
  }

  @Test(priority = 3)
  public void testPrintHistory() throws TestCaseFileException {
    String expectedResult = LogReaderHandler.readExpectedConsoleLogs("quiz-history-expected-log");

    quizHistory.printHistory();
    String resultLogs = LogReaderHandler.readConsoleQuizLogs("quiz-logs-test.log");

    Assert.assertEquals(resultLogs, expectedResult);
  }
}
