package questionary.module.test.domain;

import questionary.models.Answer;
import questionary.models.Question;
import questionary.models.Sex;
import questionary.models.User;

import java.util.List;

public interface TestInteractor {

    int loadQuestions(Sex sex);

    Question getQuestionByIndex(int index);

    void saveTempAnswers(User user);
}
