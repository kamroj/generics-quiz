package rojek.patryk.kamil.quiz;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class QuestionsPack {
  final QuestionCategory category;
  private List<Question> pack;
  private int questionsQuantity;

  QuestionsPack(QuestionCategory category) {
    this.category = category;
    this.pack = new LinkedList<>();
  }

  void addQuestion(Question question) {
    pack.add(question);
    questionsQuantity++;
  }

  Question getQuestion() throws NoQuestionException {
    if (pack.isEmpty()) throw new NoQuestionException("No more questions!");
    return pack.remove(0);
  }

  void shuffle() {
    Collections.shuffle(pack);
  }

  int getQuestionsQuantity() {
    return questionsQuantity;
  }
}
