package questionary.models;

import questionary.utils.Sex;

import java.util.List;

public class User {

    private String name;
    private Sex sex;
    private List<String> answers;

    public User(String name, Sex sex, List<String> answers) {
        this.name = name;
        this.sex = sex;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
