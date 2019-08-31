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
  private Map<Integer, String> quizSettingsMap;
  private Map<Integer, QuestionCategory> questionsSettingsMap;
  private UserInput userInput;

  public QuizMenu(UserInput userInput) {
    this.userInput = userInput;
    this.quizSettings = new QuizSettings();
    this.quizPresenterManager = new QuizPresenterManager(userInput, quizSettings);
    initializeMainMenuMap();
    initializeQuestionSettingsMap();
    initializeQuizSettingsMap();
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
        displayQuizSettings();
        break;
      case 3:
        displayProjectDescription();
        initializeMenu();
        break;
      default:
        break;
    }
  }

  private void displayQuizSettings() {
    logMessage("");
    quizSettingsMap.forEach(
        (key, value) -> {
          logFormattedMessage("%s: %s", key, value);
        });
    int choice = userInput.getValidMapKeyIntegerInput(quizSettingsMap);
    loadSettingOptions(choice);
  }

  private void loadSettingOptions(int choice) {
    switch (choice) {
      case 1:
        displayQuestionSettings();
        break;
      case 2:
        displayShuffleSetting();
        break;
      case 3:
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

  //todo changing quantity of questions should limit existing question pool rather than repeat the process of initializing question from files.
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

  private void displayShuffleSetting() {
    logMessageFromBundle("SHUFFLE_CONFIRMATION_QUESTION");
    setQuestionsShuffle();
  }

  private void setQuestionsShuffle() {
    String choice = userInput.getConfirmationInput();
    boolean shuffle = choice.equals("y");
    quizPresenterManager.shuffleQuestions(shuffle);
    logFormattedMessage("%s%b", getMessageFromBundle("SHUFFLE_CONFIRMATION_INFO"), shuffle);
    initializeMenu();
  }

  private void initializeMainMenuMap() {
    this.mainMenuOptionsMap = new HashMap<>();
    mainMenuOptionsMap.put(1, getMessageFromBundle("START_QUIZ"));
    mainMenuOptionsMap.put(2, getMessageFromBundle("DISPLAY_QUIZ_SETTINGS"));
    mainMenuOptionsMap.put(3, getMessageFromBundle("DISPLAY_PROJECT_DESCRIPTION"));
  }

  private void initializeQuizSettingsMap() {
    this.quizSettingsMap = new HashMap<>();
    quizSettingsMap.put(1, getMessageFromBundle("CHANGE_QUESTION_QUANTITY"));
    quizSettingsMap.put(2, getMessageFromBundle("CHANGE_QUESTION_SHUFFLE"));
    quizSettingsMap.put(3, getMessageFromBundle("BACK_TO_MAIN_MENU"));
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
