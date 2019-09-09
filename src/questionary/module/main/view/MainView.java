package questionary.module.main.view;

public interface MainView {

    void displayTitle();

    /**
     * ввод имени, для последующего использования при создании временного файла с ответами
     */
    void displayUserNameInput();

    void printError();

    void printWaiting();

    void displayContinueChoice();

    void displayLoadingImpossibility();

    void displaySexChoice();
}
