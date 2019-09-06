package questionary.module.main.domain;

public interface MainInteractor {

    Boolean checkUserExistance(String name);

    /**
     * считать полученные ответы, если пользователь раньше уже прошел часть тестирования
     */
    void loadSavedAnswers(String path);

}
