package questionary.module.test.view;

import questionary.models.User;
import questionary.utils.ColorsForConsole;
import questionary.models.Sex;
import questionary.module.test.domain.TestInteractor;
import questionary.module.test.domain.TestInteractorImpl;
import questionary.module.test.presenter.TestPresenter;
import questionary.module.test.presenter.TestPresenterImpl;
import questionary.module.test.router.TestRouter;
import questionary.module.test.router.TestRouterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestViewImpl implements TestView {

    private BufferedReader reader;
    private TestPresenter presenter;
    private boolean isWorked = true;

    public void start(User user) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        TestInteractor interactor = new TestInteractorImpl();
        TestRouter router = new TestRouterImpl();
        presenter = new TestPresenterImpl(this, router, interactor);
        presenter.onStart(user);
    }

    @Override
    public void displayTestDescription(int questionsCount) {
        System.out.println("Данный тест состоит из " + questionsCount + " утверждений.");
    }

    @Override
    public void displayConditions() {
        System.out.println("если вы " + ColorsForConsole.ANSI_GREEN + "согласны " + ColorsForConsole.ANSI_RESET + "с утверждением, введите " + ColorsForConsole.ANSI_GREEN + "единицу (1)." + ColorsForConsole.ANSI_RESET);
        System.out.println("если вы " + ColorsForConsole.ANSI_RED + "не согласны " + ColorsForConsole.ANSI_RESET + "с утверждением, введите " + ColorsForConsole.ANSI_RED + "ноль (0)." + ColorsForConsole.ANSI_RESET);
        System.out.println("Введите \"exit\", если хотите выйти без сохранения.");
        System.out.println("Введите " + ColorsForConsole.ANSI_YELLOW_BACKGROUND + "\"pause\"" + ColorsForConsole.ANSI_RESET + ", если хотите сохранить промежуточный результат с возможностью продолжить тестирование позже (будет создан файл).");
        }

    @Override
    public void displayQuestion(String question) {
        System.out.println(question);
    }

    @Override
    public void displayError() {
        System.out.println(ColorsForConsole.ANSI_RED + "Ошибка ввода." + ColorsForConsole.ANSI_RESET + " Введите единицу или ноль.");
    }

    @Override
    public void displayAnswers(int questionsCount, String answers) {
        System.out.println("?: " + questionsCount + " , ответы: " + answers);
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
