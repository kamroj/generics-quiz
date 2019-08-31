package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.quiz.QuestionCategory.COUNT_MISTAKES;
import static rojek.patryk.kamil.quiz.QuestionCategory.IS_TRUE;
import static rojek.patryk.kamil.quiz.QuestionCategory.WILL_COMPILE;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import rojek.patryk.kamil.communication.UserInput;

class QuizPresenterManager {
  private List<QuizPresenter> presenters;
  private EnumMap<QuestionCategory, Integer> questionQuantity =
      new EnumMap<>(QuestionCategory.class);
  private UserInput userInput;
  private QuizSettings settings;
  private boolean shuffleQuestions = true;

  QuizPresenterManager(UserInput userInput, QuizSettings settings) {
    this.userInput = userInput;
    this.settings = settings;
    initializeQuizCategories();
  }

  private void initializeQuizCategories() {
    QuizPresenter willCompile =
        new WillCompileQuizCategoryPresenter(
            userInput, settings.getQuestionQuantityForCategory(WILL_COMPILE));
    QuizPresenter isTrue =
        new IsTrueQuizCategoryPresenter(
            userInput, settings.getQuestionQuantityForCategory(IS_TRUE));
    QuizPresenter countMistakes =
        new CountMistakesQuizCategoryPresenter(
            userInput, settings.getQuestionQuantityForCategory(COUNT_MISTAKES));

    addPresenter(willCompile, isTrue, countMistakes);

    if (shuffleQuestions) {
      presenters.forEach(QuizPresenter::shuffleQuestions);
    }
  }

  private void addPresenter(QuizPresenter... presenter) {
    presenters = new LinkedList<>();
    for (QuizPresenter p : presenter) {
      presenters.add(p);
      questionQuantity.put(p.getPresenterCategory(), p.getCategoryQuestionsQuantity());
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
    presenters.forEach(QuizPresenter::displayQuiz);
    printQuizSummary();
  }

  void reloadPresenters() {
    initializeQuizCategories();
  }

  int getQuestionsQuantityFor(QuestionCategory category) {
    return questionQuantity.get(category);
  }
}
