package rojek.patryk.kamil.quiz;

import rojek.patryk.kamil.communication.MessageHandler;

class IsTrueQuizCategoryPresenter extends TrueFalseQuizPresenter {
  IsTrueQuizCategoryPresenter() {
    super(QuestionCategory.IS_TRUE);
  }

  IsTrueQuizCategoryPresenter(int questionLimit) {
    super(QuestionCategory.IS_TRUE, questionLimit);
  }

  @Override
  protected void displayCategoryDescription() {
    MessageHandler.logMessageFromBundle("IS_TRUE_CATEGORY_DESCRIPTION");
  }
}
