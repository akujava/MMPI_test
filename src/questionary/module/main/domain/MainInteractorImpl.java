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

    private String getPath(String name) {
        String path = SAVED_USER_ROOT + name + ".txt";
        return path;
    }

    @Override
    public Boolean checkUserExistance(String name) {
        String path = getPath(name);
        File savedTest = new File(path);
        return savedTest.isFile();
    }

    @Override
    public User loadTest(String name) {
        String path = getPath(name);
        List<String> savedTest = FileHelper.makeList(path);
        // Проверить, что список не пустой
        if (savedTest.isEmpty()) {
            System.out.println("Произошла ошибка: невозможно загрузить сохраненный тест.");
            System.out.println("Начните тест заново.");
            //start();
        }
        // Получить пол и ответы
        String userSex = savedTest.get(0);
        Sex sex = Sex.fromInput(userSex);

        List<String> answers = savedTest.subList(1, savedTest.size());
        List<Answer> userAnswers = new ArrayList<>(answers.size());
        for (int i = 0; i < answers.size(); i++) {
            String input = answers.get(i);
            Answer answer = Answer.fromInput(input);
            userAnswers.add(answer);
        }

        // Пользователя создавать в моменте return
        return new User(name, sex, userAnswers);
    }
}
