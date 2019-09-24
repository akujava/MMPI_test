package questionary.utils;

import questionary.models.Answer;
import questionary.models.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    // make lazy singleton
    private static FileHelper instance;

    private FileHelper() {
    }

    public static FileHelper getInstance() {
        if (instance == null) {
            instance = new FileHelper();
        }

        return instance;
    }

    public List<String> makeList(String sourcePath) {
        List<String> newList = new ArrayList<>();

        try (BufferedReader txtReader = new BufferedReader(new FileReader(new File(sourcePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = txtReader.readLine()) != null) {
                newList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newList;
    }

    public void makeTxtFile(User user) {
        String path = Constants.SAVED_USER_ROOT + user.getName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            String userSex = user.getSex().toString();
            writer.write(userSex);

            for (Answer answer : user.getAnswers()) {
                writer.write("\n");
                writer.write(answer.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); //??????????
        }
    }
}