package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.communication.MessageHandler.getMessageFromBundle;
import static rojek.patryk.kamil.communication.MessageHandler.logFormattedMessage;
import static rojek.patryk.kamil.communication.MessageHandler.logMessage;
import static rojek.patryk.kamil.communication.MessageHandler.logMessageFromBundle;

abstract class QuizPresenter {
  QuizHistory quizHistory = QuizHistory.getInstance();
  QuestionsPack questionsPack;

  void displayQuiz() {
    categoryDescription();
    askQuestions();
  }

  private void categoryDescription() {
    logMessageFromBundle("DRAW_SEPARATOR_STARS");
    logFormattedMessage(getMessageFromBundle("TASK_TYPE"), questionsPack.category);
    displayCategoryDescription();
    logMessageFromBundle("DRAW_SEPARATOR_STARS");
  }

  private void askQuestions() {
    while (true) {
      try {
        Question question = questionsPack.getQuestion();
        logMessageFromBundle("DRAW_SEPARATOR_LINES");
        logMessage(question.getDescription());
        askForAnswer(question);
        logMessageFromBundle("DRAW_SEPARATOR_LINES");
      } catch (NoQuestionException e) {
        break;
      }
    }
  }

  protected abstract void displayCategoryDescription();

  protected abstract void askForAnswer(Question question);
}
