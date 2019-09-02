package questionary.module.main.presenter;

public interface MainPresenter {

    void onStart();

    void onNameEntered(String name);

    void onContinueResponseEntered(String response);

    void onSexEntered(String sex);
}
