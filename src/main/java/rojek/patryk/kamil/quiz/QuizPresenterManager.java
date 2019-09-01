package rojek.patryk.kamil.quiz;

import java.util.EnumMap;
import rojek.patryk.kamil.communication.UserInput;

class QuizPresenterManager {
  private EnumMap<QuestionCategory, QuizPresenter> presenterEnumMap =
      new EnumMap<>(QuestionCategory.class);
  private UserInput userInput;
  private boolean shuffleQuestions = true;

  QuizPresenterManager(UserInput userInput) {
    this.userInput = userInput;
    initializeQuizCategories();
  }

  private void initializeQuizCategories() {
    QuizPresenter willCompile = new WillCompileQuizCategoryPresenter(userInput);
    QuizPresenter isTrue = new IsTrueQuizCategoryPresenter(userInput);
    QuizPresenter countMistakes = new CountMistakesQuizCategoryPresenter(userInput);

    addPresenter(willCompile, isTrue, countMistakes);
  }

  private void addPresenter(QuizPresenter... presenter) {
    for (QuizPresenter p : presenter) {
      presenterEnumMap.put(p.getPresenterCategory(), p);
    }
  }

  void shuffleQuestions(boolean shuffle) {
    this.shuffleQuestions = shuffle;
  }

  private void printQuizSummary() {
    QuizHistory.getInstance().printHistory();
    QuizAnswerChecker answerChecker = new QuizAnswerChecker();
    answerChecker.printAnswersResult();
  }

  void startQuiz() {
    if (shuffleQuestions) {
      presenterEnumMap.values().forEach(QuizPresenter::shuffleQuestions);
    }
    presenterEnumMap.values().forEach(QuizPresenter::displayQuiz);
    printQuizSummary();
  }

  int getQuestionsQuantityFor(QuestionCategory category) {
    QuizPresenter presenter = presenterEnumMap.get(category);
    return presenter.getQuestionsQuantity();
  }

  void changeQuestionsLimitForCategory(int limit, QuestionCategory category) {
    QuizPresenter presenter = presenterEnumMap.get(category);
    presenter.setQuestionsLimit(limit);
  }
}
