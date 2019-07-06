package questionary;

public enum  Sex {
    MAN("C:\\javaEducationProj\\MMPI-383_муж2.txt"),
    WOMAN("C:\\javaEducationProj\\MMPI-383_жен2.txt");

    private String path;

    Sex(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
