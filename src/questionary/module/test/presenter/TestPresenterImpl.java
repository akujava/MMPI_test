package questionary.module.test.presenter;

import questionary.models.Answer;
import questionary.models.User;
import questionary.module.test.domain.TestInteractor;
import questionary.module.test.router.TestRouter;
import questionary.module.test.view.TestView;

import java.util.List;

public class TestPresenterImpl implements TestPresenter {

    private TestView view;
    private TestRouter router;
    private TestInteractor interactor;
    private User user;

    public TestPresenterImpl(TestView view, TestRouter router, TestInteractor interactor) {
        this.view = view;
        this.router = router;
        this.interactor = interactor;
    }

    @Override
    public void onStart(User user) {
        this.user = user;
        interactor.loadQuestions(user);
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
                interactor.onQuestionAnswered(Answer.fromInput(input));
                loadNextQuestion();
                break;
            case "pause":
                interactor.saveTempAnswers(user);
                view.close();
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
        List<Answer> answers = interactor.getAllAnswers();
        String answersString = answers == null ? "[]" : answers.toString();
        view.displayAnswers(questionsCount, answersString);
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
