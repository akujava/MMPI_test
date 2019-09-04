package questionary.module.main.domain;

import java.io.File;

import static questionary.Constants.SAVED_USER_ROOT;

public class MainInteractorImpl implements MainInteractor {

    @Override
    public Boolean checkUserExistance(String name) {
        String savedUserPath = SAVED_USER_ROOT + name + ".txt";
        File savedTest = new File(savedUserPath);

        return savedTest.isFile();
    }
}
