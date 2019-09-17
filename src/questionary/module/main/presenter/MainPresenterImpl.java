package questionary.module.main.presenter;

import questionary.models.Sex;
import questionary.models.User;
import questionary.module.main.domain.MainInteractor;
import questionary.module.main.router.MainRouter;
import questionary.module.main.view.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private MainRouter router;
    private MainInteractor interactor;

    private String name;

    public MainPresenterImpl(MainView view, MainRouter router, MainInteractor interactor) {
        this.view = view;
        this.router = router;
        this.interactor = interactor;
    }

    @Override
    public void onStart() {
        view.displayTitle();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        view.displayUserNameInput();
    }

    @Override
    public void onNameEntered(String name) {
        if (name == null || name.isEmpty()) {
            view.printError();
            return;
        }
        this.name = name;
        view.printWaiting();
        Boolean isUserExist = interactor.checkUserExistence(name);

        if (isUserExist) {
            view.displayContinueChoice();
        } else {
            view.displaySexChoice();
        }
    }

    @Override
    public void onContinueResponseEntered(String response) {
        if (response == null || response.isEmpty()) {
            view.printError();
            return;
        }
        Boolean shouldContinue;
        switch (response) {
            case "1":
                shouldContinue = true;
                break;
            case "0":
                shouldContinue = false;
                break;
            default:
                shouldContinue = null;
                break;
        }
        if (shouldContinue == null) {
            view.displayContinueChoice();
            return;
        }

        if (!shouldContinue) {
            view.displaySexChoice();
            return;
        }

        User user = interactor.loadUser(name);
        if (user == null) {
            view.displayLoadingImpossibility();
            view.displayUserNameInput();
        } else {
            router.goToTest(user);
        }
    }

    @Override
    public void onSexEntered(String input) {
        if (input == null || input.isEmpty()) {
            view.printError();
            return;
        }
        Sex sex = Sex.fromInput(input);
        if (sex == null) {
            view.displaySexChoice();
            return;
        }

        router.goToTest(new User(name, sex));
    }
}
