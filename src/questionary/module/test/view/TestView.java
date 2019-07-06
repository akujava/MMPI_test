package questionary.module.test.view;

public interface TestView {

    void displayTestDescription(int questionsCount);

    void displayConditions();

    void displayQuestion(String question);

    void displayAnswers(int questionsCount, String answers);

    void displayError();

    void observeInput();

    void close();
}
