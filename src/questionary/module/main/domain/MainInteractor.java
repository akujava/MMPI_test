package questionary.module.main.domain;

import questionary.models.User;

public interface MainInteractor {

    Boolean checkUserExistance(String name);

    /**
     * считать полученные ответы, если пользователь раньше уже прошел часть тестирования
     */
    User loadTest(String path);

    }
