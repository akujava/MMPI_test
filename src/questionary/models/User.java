package questionary.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private Sex sex;
    private List<Answer> answers;

    public User(String name, Sex sex, List<Answer> answers) {
        this.name = name;
        this.sex = sex;
        this.answers = answers;
    }

    public User(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.answers = new ArrayList<>();
    }

    public boolean isNewUser() {
        return this.getAnswers().isEmpty();
    }

    public int getNextAnswerIndex() {
        return this.getAnswers().size();
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}

//addAnswer
