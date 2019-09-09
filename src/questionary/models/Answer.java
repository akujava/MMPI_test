package questionary.models;

public class Answer {
    private boolean value;

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
}
