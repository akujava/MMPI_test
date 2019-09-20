package questionary.models;

import java.util.List;

public class Answer {
    private boolean value;
    private List<Answer> answers;

    public Answer(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public static Answer fromInput(String input) {
        switch (input) {
            case "1": return new Answer(true);
            case "0": return new Answer(false);
            default: return null;
        }
    }

    @Override
    public String toString() {
        if (value) {
            return "1";
        } else {
            return "0";
        }
    }
}
