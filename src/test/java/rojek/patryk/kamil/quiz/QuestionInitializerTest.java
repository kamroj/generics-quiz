package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.quiz.QuestionCategory.COUNT_MISTAKES;
import static rojek.patryk.kamil.quiz.QuestionCategory.IS_TRUE;
import static rojek.patryk.kamil.quiz.QuestionCategory.WILL_COMPILE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QuestionInitializerTest {

  @Test
  public void initialize_countMistakePack_returnPackWithTwoQuestions() {
    QuestionsPack questionPack = QuestionInitializer.initialize(COUNT_MISTAKES).getQuestionPack();
    Assert.assertEquals(2, questionPack.getQuestionsQuantity());
  }

  @Test(invocationCount = 100)
  public void
      initializeCountMistakePack_checkQuestionsPartsWithNoQuestionShuffle_shouldGiveSameResultsAsExpected()
          throws NoQuestionException {
    QuestionsPack questionPack =
        QuestionInitializer.initialize(COUNT_MISTAKES).getQuestionPack();

    Question firstQuestion = questionPack.getQuestion();
    Question secondQuestion = questionPack.getQuestion();

    // First question assertion
    Assert.assertEquals(
        firstQuestion.getDescription(),
        "class test1 {\n" + "  void testMethod () {\n" + "    test test;\n" + "  }\n" + "}\n");
    Assert.assertEquals(firstQuestion.getAnswer(), "1");
    Assert.assertEquals(
        firstQuestion.getExplanation(), "\ntest explanation\n" + "123 test explanation 123\n\n");

    // Second question assertion
    Assert.assertEquals(
        secondQuestion.getDescription(),
        "class test2 {\n" + "  void testMethod () {\n" + "    test test;\n" + "  }\n" + "}\n");
    Assert.assertEquals(secondQuestion.getAnswer(), "2");
    Assert.assertEquals(
        secondQuestion.getExplanation(), "\ntest explanation\n" + "123 test explanation 123\n\n");
  }

  @Test
  public void initializeIsTrue_CheckQuestionsParts_shouldGiveSameResultsAsExpected()
      throws NoQuestionException {
    QuestionsPack questionPack = QuestionInitializer.initialize(IS_TRUE).getQuestionPack();

    Question firstQuestion = questionPack.getQuestion();
    Question secondQuestion = questionPack.getQuestion();

    // First question assertion
    Assert.assertEquals(firstQuestion.getDescription(), "test 1 description test\n");
    Assert.assertEquals(firstQuestion.getAnswer(), "y");
    Assert.assertEquals(firstQuestion.getExplanation(), "\ntest 1 explanation\n\n");

    // Second question assertion
    Assert.assertEquals(secondQuestion.getDescription(), "test 2 description test\n");
    Assert.assertEquals(secondQuestion.getAnswer(), "y");
    Assert.assertEquals(secondQuestion.getExplanation(), "\ntest 2 explanation\n\n");
  }

  @Test
  public void initializeWillCompile_CheckQuestionsParts_shouldGiveSameResultsAsExpected()
      throws NoQuestionException {
    QuestionsPack questionPack = QuestionInitializer.initialize(WILL_COMPILE).getQuestionPack();

    Question firstQuestion = questionPack.getQuestion();
    Question secondQuestion = questionPack.getQuestion();

    // First question assertion
    Assert.assertEquals(firstQuestion.getDescription(), "test 1 description test\n");
    Assert.assertEquals(firstQuestion.getAnswer(), "y");
    Assert.assertEquals(firstQuestion.getExplanation(), "\ntest 1 explanation\n\n");

    // Second question assertion
    Assert.assertEquals(secondQuestion.getDescription(), "test 2 description test\n");
    Assert.assertEquals(secondQuestion.getAnswer(), "y");
    Assert.assertEquals(secondQuestion.getExplanation(), "\ntest 2 explanation\n\n");
  }

  @Test
  public void initialize_categoryIsTrueWithQuestionLimitSetToOne_shouldQuestionPackSizeBe1() {
    QuestionsPack questionPack =
        QuestionInitializer.initialize(IS_TRUE).withLimit(1).getQuestionPack();
    Assert.assertEquals(questionPack.getQuestionsQuantity(), 1);
  }

  @Test
  public void initialize_categoryIsTrueWithQuestionLimitSetToZero_shouldQuestionPackSizeBeEmpty() {
    QuestionsPack questionPack =
        QuestionInitializer.initialize(IS_TRUE).withLimit(0).getQuestionPack();
    Assert.assertEquals(questionPack.getQuestionsQuantity(), 0);
  }

  @Test
  public void initialize_categoryIsTrueWithQuestionLimitSetToMinus1_shouldQuestionPackSizeBe0() {
    QuestionsPack questionPack =
        QuestionInitializer.initialize(IS_TRUE).withLimit(-1).getQuestionPack();
    Assert.assertEquals(questionPack.getQuestionsQuantity(), 0);
  }
}
