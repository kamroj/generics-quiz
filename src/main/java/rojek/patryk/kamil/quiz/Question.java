package rojek.patryk.kamil.quiz;

import java.util.Objects;

class Question {
  private String description;
  private String answer;
  private String explanation;

  String getDescription() {
    return description;
  }

  void setDescription(String description) {
    this.description = description;
  }

  String getAnswer() {
    return answer;
  }

  void setAnswer(String answer) {
    this.answer = answer;
  }

  String getExplanation() {
    return explanation;
  }

  void setExplanation(String explanation) {
    this.explanation = explanation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Question question = (Question) o;
    return Objects.equals(description, question.description)
        && Objects.equals(answer, question.answer)
        && Objects.equals(explanation, question.explanation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, answer, explanation);
  }
}
