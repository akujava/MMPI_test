package questionary.models;

import java.util.List;

public class Question {
    private String value;
    private List<String> questions;
    private int currentIndex = 0;

    public Question(String value) {
        this.value = value;
    }


}
