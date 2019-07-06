package questionary.module.test.presenter;

import questionary.Sex;

public interface TestPresenter {

    void onStart(Sex sex);

    void onInputEntered(String input);
}
