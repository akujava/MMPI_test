package questionary;

import questionary.module.main.view.MainViewImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartClass {

    public static void main(String[] args) {
        MainViewImpl main = new MainViewImpl();
        main.start();
    }
}
