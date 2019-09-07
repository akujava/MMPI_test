package questionary.module.test.presenter;

import questionary.models.Sex;

public interface TestPresenter {

    void onStart(Sex sex);

    void onInputEntered(String input);
}
