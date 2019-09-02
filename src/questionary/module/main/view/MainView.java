package questionary.module.main.view;

public interface MainView {

    void displayTitle();

    /**
     * считать полученные ответы, если пользователь раньше уже прошел часть тестирования
     */
    void loadTempAnswers();

    /**
     * ввод имени, для последующего использования при создании временного файла с ответами
     */
    void inputUserName();

    void displaySexChoice();

    void observeInput();

    void close();
}
