package rojek.patryk.kamil.quiz;

import rojek.patryk.kamil.communication.UserInput;

abstract class TrueFalseQuizPresenter extends QuizPresenter {
  TrueFalseQuizPresenter(UserInput userInput, QuestionCategory questionCategory) {
    super(userInput, questionCategory);
  }

  TrueFalseQuizPresenter(UserInput userInput, QuestionCategory questionCategory, int questionLimit) {
    super(userInput, questionCategory, questionLimit);
  }

  @Override
  protected void askForAnswer(Question question) {
    String answer = super.userInput.getConfirmationInput();
    quizHistory.updateHistory(question, answer);
  }

  @Override
  protected abstract void displayCategoryDescription();
}
