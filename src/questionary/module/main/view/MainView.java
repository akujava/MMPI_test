package questionary.module.main.view;

public interface MainView {

    void displayTitle();

    /**
     * ввод имени, для последующего использования при создании временного файла с ответами
     */
    void inputUserName();

    void printError();

    void printWaiting();

    void displayContinueChoice();

    void displaySexChoice();
}
