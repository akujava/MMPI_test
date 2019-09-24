package questionary.module.test.presenter;

import questionary.models.Answer;
import questionary.models.Question;
import questionary.models.User;
import questionary.module.test.domain.TestInteractor;
import questionary.module.test.router.TestRouter;
import questionary.module.test.view.TestView;

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
        int questionsCount = interactor.loadQuestions(user.getSex());
        view.displayTestDescription(questionsCount);
        delay(500);
        view.displayConditions();
        delay(500);
        loadNextQuestion();
    }

    @Override
    public void onAnswerEntered(String input) {
        switch (input) {
            case "0":
            case "1":
                Answer answer = Answer.fromInput(input);
                user.addAnswer(answer);
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
                loadNextQuestion();//**************************
                break;
        }
    }

    private void loadNextQuestion() {
        int nextQuestionIndex = user.getAnswersCount();
        Question nextQuestion = interactor.getQuestionByIndex(nextQuestionIndex);
        view.displayQuestion(nextQuestion.getValue());
    }

    private void close() {
//        List<Answer> answers = interactor.getAllAnswers();
//        String answersString = answers == null ? "[]" : answers.toString();
        //view.displayAnswers(questionsCount, answersString);
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
