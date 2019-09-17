package questionary.module.test.presenter;

import questionary.models.User;

public interface TestPresenter {

    void onStart(User user);

    void onInputEntered(String input);
}
