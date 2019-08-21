package rojek.patryk.kamil.quiz;

import java.util.ArrayDeque;
import java.util.Queue;

class QuestionsPack {
  final QuestionCategory category;
  private Queue<Question> pack;
  private int questionsQuantity;

  QuestionsPack(QuestionCategory category) {
    this.category = category;
    this.pack = new ArrayDeque<>();
  }

  void addQuestion(Question question) {
    pack.add(question);
    questionsQuantity++;
  }

  Question getQuestion() throws NoQuestionException {
    if (pack.isEmpty()) throw new NoQuestionException("No more questions!");
    return pack.poll();
  }

  int getQuestionsQuantity() {
    return questionsQuantity;
  }
}
