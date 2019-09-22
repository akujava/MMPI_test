package questionary.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
}