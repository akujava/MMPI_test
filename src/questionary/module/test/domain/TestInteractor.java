package questionary.module.test.domain;

import questionary.utils.Sex;

import java.util.List;

public interface TestInteractor {

    void loadQuestions(Sex sex);

    String loadNextQuestion();

    void onQuestionAnswered(boolean answer);

    List<Boolean> getAllAnswers();

    int getQuestionsCount();
}
