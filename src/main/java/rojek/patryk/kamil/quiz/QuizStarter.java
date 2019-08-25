package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.quiz.QuestionCategory.COUNT_MISTAKES;
import static rojek.patryk.kamil.quiz.QuestionCategory.IS_TRUE;
import static rojek.patryk.kamil.quiz.QuestionCategory.WILL_COMPILE;

import rojek.patryk.kamil.communication.UserInput;

class QuizStarter {
  private QuizManager quizManager = new QuizManager();
  private UserInput userInput;
  private QuizSettings settings;

  QuizStarter(UserInput userInput, QuizSettings settings) {
    this.userInput = userInput;
    this.settings = settings;
  }

  void run() {
    initializeQuizCategories();
    quizManager.startQuiz();
    quizManager.printQuizSummary();
  }

  private void initializeQuizCategories() {
    QuizPresenter willCompile =
        new WillCompileQuizCategoryPresenter(userInput, settings.getQuestionQuantityForCategory(WILL_COMPILE));
    QuizPresenter isTrue =
        new IsTrueQuizCategoryPresenter(userInput, settings.getQuestionQuantityForCategory(IS_TRUE));
    QuizPresenter countMistakes =
        new CountMistakesQuizCategoryPresenter(userInput, settings.getQuestionQuantityForCategory(COUNT_MISTAKES));

    quizManager.addPresenter(willCompile, isTrue, countMistakes);
  }
}
