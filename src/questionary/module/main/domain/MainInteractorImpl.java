package questionary.module.main.domain;

import java.io.File;

public class MainInteractorImpl implements MainInteractor {

    @Override
    public Boolean checkUserExistance(String name) {
        String tempFilePath = "C:\\javaEducationProj\\_savedUser\\" + name + ".txt";
        File savedTest = new File(tempFilePath);

        if (savedTest.isFile())
        return true;
        else return false;
    }
}
