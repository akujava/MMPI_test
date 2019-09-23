package questionary.module.test.domain;

import questionary.models.Question;
import questionary.models.Sex;
import questionary.models.User;
import questionary.utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class TestInteractorImpl implements TestInteractor {

    private final List<Question> questions = new ArrayList<>(600);
    private FileHelper fileHelper;

    public TestInteractorImpl(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }

    @Override
    public int loadQuestions(Sex sex) {
        List<String> stringQuestions = fileHelper.makeList(sex.getPath());
        questions.clear();
        for (String string : stringQuestions) {
            Question question = new Question(string);
            questions.add(question);
        }

        return questions.size();
    }

    @Override
    public Question getQuestionByIndex(int index) {
        if (index < 0 || index >= questions.size()) {
            return null;
        }
        return questions.get(index);
    }

    @Override
    public void saveTempAnswers(User user) {
        fileHelper.makeTxtFile(user);
    }
}
