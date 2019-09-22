package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.communication.MessageHandler.getMessageFromBundle;
import static rojek.patryk.kamil.communication.MessageHandler.logFormattedMessage;

import java.util.Map;

class QuizAnswerChecker {
  private QuizHistory quizHistory = QuizHistory.getInstance();
  private int questionsQuantity;

  void printAnswersResult() {
    int allQuestionsQuantity = countQuizQuestions();
    int correctAnswers = countCorrectAnswers();
    logFormattedMessage(getMessageFromBundle("QUIZ_SUMMARY"), correctAnswers, allQuestionsQuantity);
  }

  private int countQuizQuestions() {
    return quizHistory.getQuestionsAndAnswers().size();
  }

  private int countCorrectAnswers() {
    Map<Question, String> questionsAndAnswers = quizHistory.getQuestionsAndAnswers();
    int correctAnswers = 0;

    for (Question question : questionsAndAnswers.keySet()) {
      String answer = questionsAndAnswers.get(question);
      if (answer.equals(question.getAnswer())) ++correctAnswers;
    }

    return correctAnswers;
  }
}
