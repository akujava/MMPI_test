package questionary.module.test.presenter;

import questionary.Sex;
import questionary.module.test.domain.TestInteractor;
import questionary.module.test.router.TestRouter;
import questionary.module.test.view.TestView;

import java.util.List;

public class TestPresenterImpl implements TestPresenter {

    private TestView view;
    private TestRouter router;
    private TestInteractor interactor;

    public TestPresenterImpl(TestView view, TestRouter router, TestInteractor interactor) {
        this.view = view;
        this.router = router;
        this.interactor = interactor;
    }

    @Override
    public void onStart(Sex sex) {
        interactor.loadQuestions(sex);
        int questionsCount = interactor.getQuestionsCount();
        view.displayTestDescription(questionsCount);
        delay(500);
        view.displayConditions();
        delay(500);
        loadNextQuestion();
        view.observeInput();
    }

    @Override
    public void onInputEntered(String input) {
        switch (input) {
            case "0":
            case "1":
                boolean answer = input.equals("1");
                interactor.onQuestionAnswered(answer);
                loadNextQuestion();
                break;
            case "exit":
                close();
                break;
            default:
                view.displayError();
                break;
        }
    }

    private void loadNextQuestion() {
        String question = interactor.loadNextQuestion();
        if (question == null) {
            close();
        } else {
            view.displayQuestion(question);
        }
    }

    private void close() {
        int questionsCount = interactor.getQuestionsCount();
        List<Boolean> answers = interactor.getAllAnswers();
        view.displayAnswers(questionsCount, answers.toString());
        view.close();
    }

    private void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
