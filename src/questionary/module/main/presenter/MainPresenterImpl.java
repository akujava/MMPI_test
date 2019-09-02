package questionary.module.main.presenter;

import questionary.Sex;
import questionary.module.main.router.MainRouter;
import questionary.module.main.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private MainRouter router;
    private String name;

    public MainPresenterImpl(MainView view, MainRouter router) {
        this.view = view;
        this.router = router;
    }

    @Override
    public void onStart() {
        view.displayTitle();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        view.inputUserName(); //я добавил
    }

    @Override
    public void onInputEntered(String input) {
        switch (input) {
            case "1": router.goToTest(Sex.MAN); break;
            case "0": router.goToTest(Sex.WOMAN); break;
            case "break": view.close(); break;
            default: view.displaySexChoice(); break;
        }
    }

    @Override
    public void onNameEntered(String name) {
        this.name = name;
        view.displaySexChoice();
        view.observeInput();
    }
}
