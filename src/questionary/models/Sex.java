package questionary.models;

public enum  Sex {
    MAN("C:\\javaEducationProj\\MMPI-383_муж.txt"),
    WOMAN("C:\\javaEducationProj\\MMPI-383_жен.txt");

    private String path;

    Sex(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static Sex fromInput(String input) {
        switch (input) {
            case "1": return Sex.MAN;
            case "0": return Sex.WOMAN;
            default: return null;
        }
    }
}
