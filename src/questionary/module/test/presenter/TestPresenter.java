package questionary.module.test.presenter;

import questionary.utils.Sex;

public interface TestPresenter {

    void onStart(Sex sex);

    void onInputEntered(String input);
}
