package rojek.patryk.kamil.quiz;

import java.io.IOException;

class QuestionInitializer {
  private int questionLimit = Integer.MAX_VALUE;
  private QuestionFileReader questionFileReader;
  private QuestionCategory questionCategory;
  private QuestionsPack questionsPack;
  private String line;

  private QuestionInitializer(QuestionCategory questionCategory) {
    this.questionCategory = questionCategory;
    this.questionsPack = new QuestionsPack(questionCategory);
  }

  static QuestionInitializer initialize(QuestionCategory questionCategory) {
    return new QuestionInitializer(questionCategory);
  }

  QuestionInitializer withLimit(int questionLimit) {
    this.questionLimit = questionLimit;
    return this;
  }

  QuestionsPack getQuestionPack() {
    prepareQuestions();
    return questionsPack;
  }

  private void prepareQuestions() {
    this.questionFileReader = new QuestionFileReader(questionCategory.fileName);
    int questionCounter = 0;

    try {
      line = questionFileReader.readLine();
      Question question = null;

      while (line != null) {
        if (line.contains("Opis:")) { //todo zmienić na klucze
          if (++questionCounter > questionLimit) break;
          question = clearQuestion(question);
          setDescription(question);
        }

        if (question != null) {
          if (line.contains("Odpowiedź:")) { //todo zmienić na klucze
            setAnswer(question);
          }

          if (line.contains("Wytłumaczenie:")) { //todo zmienić na klucze
            setExplanation(question);
          }
        }
        line = questionFileReader.readLine();
      }
      clearQuestion(question);

    } catch (IOException e) {
      e.getMessage();
    }
  }

  private void setDescription(Question question) throws IOException {
    StringBuilder sb = new StringBuilder();
    line = questionFileReader.readLine();

    while (line != null && !line.contains("Odpowiedź:")) {
      if (line.isBlank()) {
        line = questionFileReader.readLine();
        continue;
      }
      sb.append(line).append("\n");
      line = questionFileReader.readLine();
    }

    question.setDescription(sb.toString());
  }

  private void setAnswer(Question question) throws IOException {
    line = questionFileReader.readLine();
    question.setAnswer(line);
  }

  private void setExplanation(Question question) throws IOException {
    StringBuilder sb = new StringBuilder("\n");
    line = questionFileReader.readLine();

    while (line != null && !line.contains("Zadanie:")) {
      if (line.isBlank()) {
        line = questionFileReader.readLine();
        continue;
      }
      sb.append(line).append("\n");
      line = questionFileReader.readLine();
    }
    question.setExplanation(sb.append("\n").toString());
  }

  private Question clearQuestion(Question question) {
    if (question != null) {
      questionsPack.addQuestion(question);
    }
    return new Question();
  }
}
