package rojek.patryk.kamil.quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class LogReaderHandler {
  private static final String TEST_CASE_PATH = "src/test/resources/game_test_cases/";
  private static final String QUIZ_LOGS_PATH = "src/test/resources/";

  static String readUserInputTestCaseSteps(String testCaseName) throws TestCaseFileException {
    try (Scanner scanner = new Scanner(new File(TEST_CASE_PATH + testCaseName))) {
      while (scanner.hasNext()) {
        if (scanner.nextLine().contains("Steps:")) {
          return scanner.nextLine();
        }
      }
      throw new TestCaseFileException("No test case steps detected!");
    } catch (FileNotFoundException e) {
      throw new TestCaseFileException(e.getMessage());
    }
  }

  static String readExpectedConsoleLogs(String testCaseName) throws TestCaseFileException {
    StringBuilder sb = new StringBuilder();
    try (Scanner scanner = new Scanner(new File(TEST_CASE_PATH + testCaseName))) {
      while (scanner.hasNext()) {
        if (scanner.nextLine().contains("Logs:")) {
          while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
          }
        }
      }
      if (sb.toString().isBlank()) throw new TestCaseFileException("File is blank!");
      return removeWhiteSpaces(sb.toString());
    } catch (FileNotFoundException e) {
      throw new TestCaseFileException(e.getMessage());
    }
  }

  static String readConsoleQuizLogs(String quizLogFileName) throws TestCaseFileException {
    try {
      String logs = Files.readString(Paths.get(QUIZ_LOGS_PATH + quizLogFileName));
      return removeWhiteSpaces(logs);
    } catch (IOException e) {
      throw new TestCaseFileException("Error while reading logs file!");
    }
  }

  static void clearTestLogFile() {
    try (BufferedWriter bw =  Files.newBufferedWriter(Paths.get(QUIZ_LOGS_PATH))){
      bw.write("");
    } catch (IOException e) {
      System.err.println("Problem with clearing test log file!");
    }
  }

  private static String removeWhiteSpaces(String s) {
    return s.replaceAll("\\s", "");
  }

  static class TestCaseFileException extends Exception {
    TestCaseFileException(String message) {
      super(message);
    }
  }
}

