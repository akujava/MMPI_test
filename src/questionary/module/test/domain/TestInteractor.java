package questionary.module.test.domain;

import questionary.models.Question;
import questionary.models.Sex;
import questionary.models.User;

public interface TestInteractor {

    int loadQuestions(Sex sex);

    Question getQuestionByIndex(int index);

    void saveTempAnswers(User user);
}
