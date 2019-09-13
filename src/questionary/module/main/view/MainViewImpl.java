package questionary.module.main.view;

import questionary.module.main.domain.MainInteractor;
import questionary.module.main.domain.MainInteractorImpl;
import questionary.module.main.presenter.MainPresenter;
import questionary.module.main.presenter.MainPresenterImpl;
import questionary.module.main.router.MainRouter;
import questionary.module.main.router.MainRouterImpl;
import questionary.utils.FileHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainViewImpl implements MainView {

    private MainPresenter presenter;
    private BufferedReader reader;

    public void start() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        MainRouter router = new MainRouterImpl();
        MainInteractor interactor = new MainInteractorImpl(FileHelper.getInstance());
        presenter = new MainPresenterImpl(this, router, interactor);
        presenter.onStart();
    }

    @Override
    public void displayTitle() {
        System.out.println("МИННЕСОТСКИЙ МНОГОФАЗНЫЙ ЛИЧНОСТНЫЙ ТЕСТ (ММPI)");
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void displayUserNameInput() {
        System.out.println("Введите имя/фамилию/никнейм:");
        String userName = readLine();
        presenter.onNameEntered(userName);
    }

    @Override
    public void printError() {
        System.out.println("Непредвиденная ошибка");
    }

    @Override
    public void printWaiting() {
        System.out.println("Подождите...");
    }

    @Override
    public void displayContinueChoice() {
        System.out.println("Введите единицу (1) для загрузки теста или ноль (0), чтобы начать тест заново");
        String response = readLine();
        presenter.onContinueResponseEntered(response);
    }

    @Override
    public void displayLoadingImpossibility() {
        System.out.println("Произошла ошибка: невозможно загрузить сохраненный тест.");
        System.out.println("Начните тест заново.");
    }

    @Override
    public void displaySexChoice() {
        System.out.println("Введите единицу (1), если ваш пол мужской.");
        System.out.println("Введите ноль (0), если ваш пол женский.");
        String sex = readLine();
        presenter.onSexEntered(sex);
    }
}
