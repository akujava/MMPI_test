package questionary.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    public static List<String> makeList(String sourcePath) {
        List<String> newList = new ArrayList<>();

        try(BufferedReader txtReader = new BufferedReader(new FileReader(new File(sourcePath)))) {
            String line;
            while ((line = txtReader.readLine()) != null) {
                newList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newList;
    }

    /*public static List<String> makeList(String sourcePath, BufferedReader txtReader) {
        List<String> newList = new ArrayList<>();

        try(txtReader = new BufferedReader(new FileReader(new File(sourcePath)))) {
            String line;
            while ((line = txtReader.readLine()) != null) {
                newList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newList;
    }*/
}