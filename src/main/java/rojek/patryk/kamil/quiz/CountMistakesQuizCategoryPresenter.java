package rojek.patryk.kamil.quiz;

import rojek.patryk.kamil.communication.MessageHandler;
import rojek.patryk.kamil.communication.UserInput;

class CountMistakesQuizCategoryPresenter extends QuizPresenter {

  CountMistakesQuizCategoryPresenter(UserInput userInput) {
    super(userInput, QuestionCategory.COUNT_MISTAKES);
  }

  CountMistakesQuizCategoryPresenter(UserInput userInput, int questionLimit) {
    super(userInput, QuestionCategory.COUNT_MISTAKES, questionLimit);
  }

  @Override
  protected void askForAnswer(Question question) {
    String answer = super.userInput.getNumericInput();
    quizHistory.updateHistory(question, answer);
  }

  @Override
  protected void displayCategoryDescription() {
    MessageHandler.getMessageFromBundle("COUNT_MISTAKES_CATEGORY_DESCRIPTION");
  }
}
