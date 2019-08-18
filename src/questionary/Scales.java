package questionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scales {
    public List<Integer> getScalePoints(String ss) { //надо корректно ввести путь к файлу с номерами ответов для перевода их в кол-во баллов по определенной шкале
        String filePath = ss;
        File txtFile = new File(filePath);
        List<Integer> scalePoints = null;

        try(BufferedReader txtReader = new BufferedReader(new FileReader(txtFile))) {
            String line;
            scalePoints = new ArrayList<>(100); //макс кол-во совпадений - 78
            while ((line = txtReader.readLine()) != null) {
                scalePoints.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scalePoints;
    }

    public void getPoints() {

    }
}
