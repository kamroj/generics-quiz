package rojek.patryk.kamil.quiz;

import java.util.EnumMap;

class QuizSettings {
  private EnumMap<QuestionCategory, Integer> questionsQuantity;

  QuizSettings() {
    this.questionsQuantity = new EnumMap<>(QuestionCategory.class);
    initializeQuestionsByDefault();
  }

  void setQuestionQuantityForCategory(QuestionCategory category, int questionsNumber) {
    if (questionsNumber < 0) return; // todo throw exception
    questionsQuantity.put(category, questionsNumber);
  }

  int getQuestionQuantityForCategory(QuestionCategory category) {
    return questionsQuantity.get(category);
  }

  private void initializeQuestionsByDefault() {
    for (QuestionCategory category : QuestionCategory.values()) {
      questionsQuantity.put(category, Integer.MAX_VALUE);
    }
  }
}
