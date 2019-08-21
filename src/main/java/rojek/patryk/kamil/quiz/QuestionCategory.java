package rojek.patryk.kamil.quiz;

public enum QuestionCategory {
  WILL_COMPILE("willcompile.txt"),
  IS_TRUE("istrue.txt"),
  COUNT_MISTAKES("countmistakes.txt");

  final String fileName;

  QuestionCategory(String fileName) {
    this.fileName = fileName;
  }
}
