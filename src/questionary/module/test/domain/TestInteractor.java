package questionary.module.test.domain;

import questionary.models.Answer;
import questionary.models.Sex;
import questionary.models.User;

import java.util.List;

public interface TestInteractor {

    void loadQuestions(Sex sex);

    String loadNextQuestion();

    void onQuestionAnswered(Answer answer);

    List<Answer> getAllAnswers();

    int getQuestionsCount();

    void saveTempAnswers(User user);
}
