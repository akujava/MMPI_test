package questionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scales {
    public static List<Integer> transformSourceToList(String sourcePath) { //надо ввести путь к файлу с номерами ответов для перевода их в кол-во баллов *** ПОЧЕМУ STATIC???***
        File txtFile = new File(sourcePath);
        List<Integer> newList = new ArrayList<>(100);

        try(BufferedReader txtReader = new BufferedReader(new FileReader(txtFile))) {
            String line;
            while ((line = txtReader.readLine()) != null) {
                newList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newList;
    }

    public void getPoints() {

    }
}
