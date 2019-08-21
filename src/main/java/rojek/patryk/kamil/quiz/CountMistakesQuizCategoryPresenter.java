package rojek.patryk.kamil.quiz;

import java.util.Scanner;
import rojek.patryk.kamil.communication.MessageHandler;
import rojek.patryk.kamil.communication.UserInput;

class CountMistakesQuizCategoryPresenter extends QuizPresenter {

  CountMistakesQuizCategoryPresenter() {
    super.questionsPack =
        QuestionInitializer.initialize(QuestionCategory.COUNT_MISTAKES).getQuestionPack();
  }

  CountMistakesQuizCategoryPresenter(int questionLimit) {
    super.questionsPack =
        QuestionInitializer.initialize(QuestionCategory.COUNT_MISTAKES)
            .withLimit(questionLimit)
            .getQuestionPack();
  }

  @Override
  protected void askForAnswer(Question question) {
    UserInput userInput = new UserInput(new Scanner(System.in));
    String answer = userInput.getNumericInput();
    quizHistory.updateHistory(question, answer);
  }

  @Override
  protected void displayCategoryDescription() {
    MessageHandler.getMessageFromBundle("COUNT_MISTAKES_CATEGORY_DESCRIPTION");
  }
}
