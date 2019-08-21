package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.quiz.QuestionCategory.COUNT_MISTAKES;
import static rojek.patryk.kamil.quiz.QuestionCategory.IS_TRUE;
import static rojek.patryk.kamil.quiz.QuestionCategory.WILL_COMPILE;

class QuizStarter {
  private QuizManager quizManager = new QuizManager();
  private QuizSettings settings;

  QuizStarter(QuizSettings settings) {
    this.settings = settings;
  }

  void run() {
    initializeQuizCategories();
    quizManager.startQuiz();
    quizManager.printQuizSummary();
  }

  private void initializeQuizCategories() {
    QuizPresenter willCompile =
        new WillCompileQuizCategoryPresenter(settings.getQuestionQuantityForCategory(WILL_COMPILE));
    QuizPresenter isTrue =
        new IsTrueQuizCategoryPresenter(settings.getQuestionQuantityForCategory(IS_TRUE));
    QuizPresenter countMistakes =
        new CountMistakesQuizCategoryPresenter(settings.getQuestionQuantityForCategory(COUNT_MISTAKES));

    quizManager.addPresenter(willCompile, isTrue, countMistakes);
  }
}
