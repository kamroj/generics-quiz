package rojek.patryk.kamil;

import java.util.Scanner;
import rojek.patryk.kamil.communication.UserInput;
import rojek.patryk.kamil.quiz.QuizMenu;

public class Main {
  public static void main(String[] args) {
    UserInput userInput = new UserInput(new Scanner(System.in));
    QuizMenu quizMenu = new QuizMenu(userInput);
    quizMenu.initializeMenu();
  }
}
