package rojek.patryk.kamil.quiz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class QuizManager {
  private List<QuizPresenter> presenters = new LinkedList<>();

  void addPresenter(QuizPresenter... presenter) {
    presenters.addAll(Arrays.asList(presenter));
  }

  void startQuiz() {
    presenters.forEach(QuizPresenter::displayQuiz);
  }

  void printQuizSummary() {
    QuizHistory.getInstance().printHistory();
    QuizAnswerChecker answerChecker = new QuizAnswerChecker();
    answerChecker.printAnswersResult();
  }
}
