package rojek.patryk.kamil.quiz;

import java.io.IOException;

/**
 * Initializes questions that are written in concrete file provided by {@link
 * QuestionCategory#fileName}. Each of question category are presented by unique <tt>.txt</tt> file
 * located in the <i>src/main/resources</i> path.
 *
 * <p><br>
 * To add questions to category they must be written with the following structure: <br>
 * <i> $task$ no</br> <br>
 * $description$ <br>
 * Is Java better than C#? <br>
 * $answer$ <br>
 * y <br>
 * $explenation$ <br>
 * Java is better than C# because it simply is. It is beautiful and wonderful and meaningful
 * programming language, and ... Just stop. </br></i>
 *
 * {@hide It is not possible at the moment to create completely different question category as a *
 * separate file. It would require adding {@link QuestionCategory} enum and new {@link *
 * QuizPresenter} implementation.}
 *
 * @author Kamil Rojek
 */
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
        if (line.contains("$description$")) {
          if (++questionCounter > questionLimit) break;
          question = clearQuestion(question);
          setDescription(question);
        }

        if (question != null) {
          if (line.contains("$answer$")) {
            setAnswer(question);
          }

          if (line.contains("$explanation$")) {
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

    while (line != null && !line.contains("$answer$")) {
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

    while (line != null && !line.contains("$task$")) {
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
