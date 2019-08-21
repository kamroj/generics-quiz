package rojek.patryk.kamil.quiz;

import java.util.Scanner;
import rojek.patryk.kamil.communication.UserInput;

abstract class TrueFalseQuizPresenter extends QuizPresenter {
  TrueFalseQuizPresenter(QuestionCategory questionCategory) {
    super.questionsPack = QuestionInitializer.initialize(questionCategory).getQuestionPack();
  }

  TrueFalseQuizPresenter(QuestionCategory questionCategory, int questionLimit) {
    super.questionsPack =
        QuestionInitializer.initialize(questionCategory).withLimit(questionLimit).getQuestionPack();
  }

  @Override
  protected void askForAnswer(Question question) {
    UserInput userInput = new UserInput(new Scanner(System.in));
    String answer = userInput.getConfirmationInput();
    quizHistory.updateHistory(question, answer);
  }

  @Override
  protected abstract void displayCategoryDescription();
}
