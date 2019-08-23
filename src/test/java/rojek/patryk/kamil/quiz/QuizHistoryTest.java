package rojek.patryk.kamil.quiz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
  public void testPrintHistory() throws IOException {
    String expectedResult =
        "###############################################################################################################\n"
            + "Treść zadania 1: \n"
            + "desc\n"
            + "Twoja odpowiedź: Lorem ipsum\n"
            + "Prawidłowa odpowiedź: answer\n"
            + "Wyjaśnienie: expl\n"
            + "###############################################################################################################\n"
            + "###############################################################################################################\n"
            + "Treść zadania 2: \n"
            + "desc\n"
            + "Twoja odpowiedź: Lorem ipsum answer\n"
            + "Prawidłowa odpowiedź: Lorem ipsum\n"
            + "Wyjaśnienie: expl\n"
            + "###############################################################################################################\n";

    quizHistory.printHistory();
    String result = Files.readString(Paths.get("src/test/resources/quiz-logs.log"));

    Assert.assertEquals(result.replaceAll("\\s", ""), expectedResult.replaceAll("\\s", ""));
  }
}
