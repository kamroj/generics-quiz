package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.communication.MessageHandler.getMessageFromBundle;
import static rojek.patryk.kamil.communication.MessageHandler.logFormattedMessage;
import static rojek.patryk.kamil.communication.MessageHandler.logMessageFromBundle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

final class QuizHistory {
  private static final QuizHistory instance = new QuizHistory();
  private Map<Question, String> questionsAndAnswers = new LinkedHashMap<>();

  private QuizHistory() {}

  static QuizHistory getInstance() {
    return instance;
  }

  void updateHistory(Question question, String answer) {
    questionsAndAnswers.put(question, answer);
  }

  Map<Question, String> getQuestionsAndAnswers() {
    return questionsAndAnswers;
  }

  void printHistory() {
    AtomicInteger questionCounter = new AtomicInteger(1);
    questionsAndAnswers.forEach(
        (key, value) -> {
          logMessageFromBundle("DRAW_SEPARATOR_HASH");
          logFormattedMessage("%s %d: \n%s", getMessageFromBundle("TASK_DESCRIPTION"), questionCounter.get(), key.getDescription());
          logFormattedMessage("%s: %s", getMessageFromBundle("TASK_ANSWER"), value);
          logFormattedMessage("%s: %s", getMessageFromBundle("CORRECT_ANSWER"), key.getAnswer());
          logFormattedMessage("%s: %s", getMessageFromBundle("TASK_EXPLANATION"), key.getExplanation());
          logMessageFromBundle("DRAW_SEPARATOR_HASH");
          questionCounter.getAndIncrement();
        });
  }
}
