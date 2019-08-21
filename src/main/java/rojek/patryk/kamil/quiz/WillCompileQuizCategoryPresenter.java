package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.communication.MessageHandler.logMessageFromBundle;

class WillCompileQuizCategoryPresenter extends TrueFalseQuizPresenter {
  WillCompileQuizCategoryPresenter() {
    super(QuestionCategory.WILL_COMPILE);
  }

  WillCompileQuizCategoryPresenter(int questionLimit) {
    super(QuestionCategory.WILL_COMPILE, questionLimit);
  }

  @Override
  protected void displayCategoryDescription() {
    logMessageFromBundle("WILL_COMPILE_CATEGORY_DESCRIPTION");
  }
}
