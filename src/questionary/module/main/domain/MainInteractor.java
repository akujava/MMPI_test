package questionary.module.main.domain;

import questionary.models.User;

public interface MainInteractor {

    Boolean checkUserExistence(String name);

    User loadUser(String name);

}
