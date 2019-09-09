package questionary.module.main.domain;

import questionary.models.Answer;
import questionary.models.Sex;
import questionary.models.User;
import questionary.utils.FileHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static questionary.utils.Constants.SAVED_USER_ROOT;

public class MainInteractorImpl implements MainInteractor {

    private FileHelper fileHelper;

    public MainInteractorImpl(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }

    private String getPath(String name) {
        return SAVED_USER_ROOT + name + ".txt";
    }

    @Override
    public Boolean checkUserExistence(String name) {
        String path = getPath(name);
        File savedTest = new File(path);
        return savedTest.isFile();
    }

    @Override
    public User loadUser(String name) {
        String path = getPath(name);
        List<String> savedTest = fileHelper.makeList(path);
        // Проверить, что список не пустой
        if (savedTest.isEmpty()) {
            return null;
        }
        // Получить пол и ответы
        String userSex = savedTest.get(0);
        Sex sex = Sex.fromInput(userSex);
        if (sex == null) {
            return null;
        }

        List<String> answers = savedTest.subList(1, savedTest.size());
        List<Answer> userAnswers = new ArrayList<>(answers.size());
        for (String input : answers) {
            Answer answer = Answer.fromInput(input);
            if (answer == null) {
                return null;
            }
            userAnswers.add(answer);
        }

        // Пользователя создавать в моменте return
        return new User(name, sex, userAnswers);
    }
}
