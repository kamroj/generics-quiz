package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.quiz.QuestionCategory.WILL_COMPILE;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QuizSettingsTest {

  @DataProvider
  public static Object[][] validSettingsValues() {
    return new Object[][] {{2}, {4}, {12}, {29}, {333}};
  }

  @Test(dataProvider = "validSettingsValues")
  public void setQuestionQuantityForCategory_setTValidQuestionsQuantityForWillCompileCategory_returnCorrectQuantity(int value) {
    QuizSettings settings = new QuizSettings();

    settings.setQuestionQuantityForCategory(WILL_COMPILE, value);

    Assert.assertEquals(settings.getQuestionQuantityForCategory(WILL_COMPILE), value);
  }

  @Test
  public void setQuestionQuantityForCategory_setNegativeQuestionQuantityValue_returnMaxIntegerQuestionQuantity() {
    QuizSettings settings = new QuizSettings();

    settings.setQuestionQuantityForCategory(WILL_COMPILE, -1);

    Assert.assertEquals(settings.getQuestionQuantityForCategory(WILL_COMPILE), Integer.MAX_VALUE);
  }

}
