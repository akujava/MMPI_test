package questionary.module.main.view;

public interface MainView {

    void displayTitle();

    void loadTempAnswers(); //считать полученные ответы, если пользователь раньше уже прошел часть тестирования

    void inputUserName(); //ввод имени, для последующего использования при создании временного файла с ответами

    void displaySexChoice();

    void observeInput();

    void close();
}
