package rojek.patryk.kamil.quiz;

public enum QuestionCategory {
  WILL_COMPILE("willcompile.txt", "WILLCOMPILE_CATEGORY_NAME"),
  IS_TRUE("istrue.txt", "ISTRUE_CATEGORY_NAME"),
  COUNT_MISTAKES("countmistakes.txt", "COUNTMISTAKES_CATEGORY_NAME");

  final String fileName;
  final String categoryName;

  QuestionCategory(String fileName, String categoryName) {
    this.fileName = fileName;
    this.categoryName= categoryName;
  }
}
