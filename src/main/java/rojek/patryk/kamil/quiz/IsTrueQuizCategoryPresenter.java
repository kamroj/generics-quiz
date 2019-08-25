package rojek.patryk.kamil.quiz;

import rojek.patryk.kamil.communication.MessageHandler;
import rojek.patryk.kamil.communication.UserInput;

class IsTrueQuizCategoryPresenter extends TrueFalseQuizPresenter {
  IsTrueQuizCategoryPresenter(UserInput userInput) {
    super(userInput, QuestionCategory.IS_TRUE);
  }

  IsTrueQuizCategoryPresenter(UserInput userInput, int questionLimit) {
    super(userInput, QuestionCategory.IS_TRUE, questionLimit);
  }

  @Override
  protected void displayCategoryDescription() {
    MessageHandler.logMessageFromBundle("IS_TRUE_CATEGORY_DESCRIPTION");
  }
}
