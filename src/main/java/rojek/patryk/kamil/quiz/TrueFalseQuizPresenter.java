package rojek.patryk.kamil.quiz;

import java.util.Scanner;
import rojek.patryk.kamil.communication.UserInput;

abstract class TrueFalseQuizPresenter extends QuizPresenter {
  TrueFalseQuizPresenter(UserInput userInput, QuestionCategory questionCategory) {
    super(userInput);
    super.questionsPack = QuestionInitializer.initialize(questionCategory).getQuestionPack();
  }

  TrueFalseQuizPresenter(UserInput userInput, QuestionCategory questionCategory, int questionLimit) {
    super(userInput);
    super.questionsPack =
        QuestionInitializer.initialize(questionCategory).withLimit(questionLimit).getQuestionPack();
  }

  @Override
  protected void askForAnswer(Question question) {
    String answer = super.userInput.getConfirmationInput();
    quizHistory.updateHistory(question, answer);
  }

  @Override
  protected abstract void displayCategoryDescription();
}
