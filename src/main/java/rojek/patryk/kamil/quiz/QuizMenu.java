package rojek.patryk.kamil.quiz;

import static rojek.patryk.kamil.communication.MessageHandler.getMessageFromBundle;
import static rojek.patryk.kamil.communication.MessageHandler.logFormattedMessage;
import static rojek.patryk.kamil.communication.MessageHandler.logMessage;
import static rojek.patryk.kamil.communication.MessageHandler.logMessageFromBundle;

import java.util.HashMap;
import java.util.Map;
import rojek.patryk.kamil.communication.UserInput;

public class QuizMenu {
  private QuizSettings quizSettings;
  private QuizPresenterManager quizPresenterManager;
  private Map<Integer, String> mainMenuOptionsMap;
  private Map<Integer, QuestionCategory> questionsSettingsMap;
  private UserInput userInput;

  public QuizMenu(UserInput userInput) {
    this.userInput = userInput;
    this.quizSettings = new QuizSettings();
    this.quizPresenterManager = new QuizPresenterManager(userInput, quizSettings);
    initializeMainMenuMap();
    initializeQuestionSettingsMap();
  }

  public void initializeMenu() {
    displayMainOptions();
    int choice = userInput.getValidMapKeyIntegerInput(mainMenuOptionsMap);
    loadOption(choice);
  }

  private void displayMainOptions() {
    logMessage("");
    mainMenuOptionsMap.forEach(
        (key, value) -> {
          logFormattedMessage("%s: %s", key, value);
        });
  }

  private void loadOption(int choice) {
    switch (choice) {
      case 1:
        quizPresenterManager.startQuiz();
        break;
      case 2:
        displayQuestionSettings();
        break;
      case 3:
        displayProjectDescription();
        initializeMenu();
        break;
      default:
        break;
    }
  }

  private void displayQuestionSettings() {
    questionsSettingsMap.forEach(
        (key, value) -> {
          logFormattedMessage(
              "%s: %s (%d)",
              key,
              getMessageFromBundle(value.categoryName),
              quizPresenterManager.getQuestionsQuantityFor(value));
        });

    int choice = userInput.getValidMapKeyIntegerInput(questionsSettingsMap);
    QuestionCategory category = questionsSettingsMap.get(choice);
    changeQuestionsQuantityForCategory(category);
  }

  private void changeQuestionsQuantityForCategory(QuestionCategory category) {
    getMessageFromBundle("GIVE_QUESTION_QUANTITY");
    int choice = Integer.parseInt(userInput.getNumericInput());

    quizSettings.setQuestionQuantityForCategory(category, choice);
    logFormattedMessage(
        getMessageFromBundle("QUESTION_QUANTITY_CONFIRMATION"),
        getMessageFromBundle(category.categoryName));
    quizPresenterManager.reloadPresenters();
    initializeMenu();
  }

  private void initializeMainMenuMap() {
    this.mainMenuOptionsMap = new HashMap<>();
    mainMenuOptionsMap.put(1, getMessageFromBundle("START_QUIZ"));
    mainMenuOptionsMap.put(2, getMessageFromBundle("CHANGE_QUESTION_QUANTITY"));
    mainMenuOptionsMap.put(3, getMessageFromBundle("DISPLAY_PROJECT_DESCRIPTION"));
  }

  private void initializeQuestionSettingsMap() {
    this.questionsSettingsMap = new HashMap<>();
    int questionCounter = 1;

    for (QuestionCategory category : QuestionCategory.values()) {
      questionsSettingsMap.put(questionCounter++, category);
    }
  }

  private void displayProjectDescription() {
    logMessageFromBundle("PROJECT_DESCRIPTION");
  }
}
