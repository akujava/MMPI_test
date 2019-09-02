package questionary.module.main.view;

import questionary.module.main.presenter.MainPresenter;
import questionary.module.main.presenter.MainPresenterImpl;
import questionary.module.main.router.MainRouter;
import questionary.module.main.router.MainRouterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainViewImpl implements MainView {

    private MainPresenter presenter;
    private BufferedReader reader;
    private boolean isWorked = true;

    public void start() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        MainRouter router = new MainRouterImpl();
        presenter = new MainPresenterImpl(this, router);
        presenter.onStart();
    }

    @Override
    public void displayTitle() {
        System.out.println("МИННЕСОТСКИЙ МНОГОФАЗНЫЙ ЛИЧНОСТНЫЙ ТЕСТ (ММPI)");
    }

    @Override
    public void loadTempAnswers() {
        System.out.println("Считать с жесткого диска полученные ранее ответы?");
    }

    @Override
    public void inputUserName() {
        String userName = null;
        System.out.println("Введите имя/фамилию/никнейм:");
        try {
            userName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displaySexChoice() {
        System.out.println("Введите единицу (1), если ваш пол мужской.");
        System.out.println("Введите ноль (0), если ваш пол женский.");
    }

    @Override
    public void observeInput() {
        while (isWorked) {
            try {
                String input = reader.readLine();
                presenter.onInputEntered(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        isWorked = false;
    }
}
