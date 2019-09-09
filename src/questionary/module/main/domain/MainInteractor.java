package questionary.module.main.domain;

import questionary.models.User;

public interface MainInteractor {

    Boolean checkUserExistence(String name);

    /**
     * считать полученные ответы, если пользователь раньше уже прошел часть тестирования
     */
    User loadUser(String name);

}
