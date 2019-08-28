package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.communication.MessageHandler.getMessageFromBundle;
import static rojek.patryk.kamil.communication.MessageHandler.logFormattedMessage;
import static rojek.patryk.kamil.communication.MessageHandler.logMessage;
import static rojek.patryk.kamil.communication.MessageHandler.logMessageFromBundle;

import rojek.patryk.kamil.communication.UserInput;

abstract class QuizPresenter {
  private QuestionsPack questionsPack;
  private QuestionCategory presenterCategory;
  QuizHistory quizHistory = QuizHistory.getInstance();
  UserInput userInput;

  QuizPresenter(UserInput userInput, QuestionCategory category) {
    this.userInput = userInput;
    this.presenterCategory = category;
    this.questionsPack = QuestionInitializer.initialize(presenterCategory).getQuestionPack();
  }

  QuizPresenter(UserInput userInput, QuestionCategory category, int questionLimit) {
    this.userInput = userInput;
    this.presenterCategory = category;
    this.questionsPack =
        QuestionInitializer.initialize(category).withLimit(questionLimit).getQuestionPack();
  }

  void displayQuiz() {
    if(questionsPack.getQuestionsQuantity() == 0)
      return;
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

  QuestionCategory getPresenterCategory() {
    return presenterCategory;
  }

  int getCategoryQuestionsQuantity() {
    return questionsPack.getQuestionsQuantity();
  }

  protected abstract void displayCategoryDescription();

  protected abstract void askForAnswer(Question question);
}
