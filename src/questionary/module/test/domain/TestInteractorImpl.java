package questionary.module.test.domain;

import questionary.models.Sex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestInteractorImpl implements TestInteractor {

    private List<String> questions;
    private List<Boolean> answers;
    private int currentIndex = 0;

    @Override
    public void loadQuestions(Sex sex) {
        File file = new File(sex.getPath());
        questions = new ArrayList<>(599);
        answers = new ArrayList<>(600);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fileLine;
            while ((fileLine = reader.readLine()) != null) {
                questions.add(fileLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String loadNextQuestion() {
        if (questions == null) throw new IllegalStateException("First you have to load questions");
        if (currentIndex >= questions.size()) return null;
        return questions.get(currentIndex);
    }

    @Override
    public void onQuestionAnswered(boolean answer) {
        if (answers == null) throw new IllegalStateException("First you have to load questions");
        answers.add(answer);
        currentIndex++;
    }

    @Override
    public List<Boolean> getAllAnswers() {
        return answers;
    }

    @Override
    public int getQuestionsCount() {
        if (questions == null) return 0;
        return questions.size();
    }
}
