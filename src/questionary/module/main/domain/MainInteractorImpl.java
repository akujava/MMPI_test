package questionary.module.main.domain;

import questionary.Scales;
import questionary.models.User;
import questionary.utils.FileHelper;
import questionary.utils.Sex;

import javax.swing.text.StringContent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static questionary.utils.Constants.SAVED_USER_ROOT;

public class MainInteractorImpl implements MainInteractor {
    private User user;

    public String getPath(String name) {
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
        List<String> list = FileHelper.makeList(path);

        user.setName(name);

        String userSex = list.get(0);

        user.getSex();

        list.remove(0);
        user.setAnswers();

        return user;
    }

    @Override
    public void saveTest(User user) {

    }
}
