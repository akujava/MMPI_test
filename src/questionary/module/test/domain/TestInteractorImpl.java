package questionary.module.test.domain;

import questionary.models.Answer;
import questionary.models.Sex;
import questionary.models.User;
import questionary.utils.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestInteractorImpl implements TestInteractor {

    @Override
    public void loadQuestions(User user) {
        File file = new File(user.getSex().getPath());
        questions = new ArrayList<>(600);
        answers = new ArrayList<>(600);
        if (!user.isNewUser()) {
            currentIndex = user.getNextAnswerIndex();
            answers = user.getAnswers();
        }

        // todo use FileHelper
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
    public String loadNextQuestion(int index) {
        if (questions == null) throw new IllegalStateException("Сначала загрузите вопросы");
        if (index >= questions.size()) return null;
        return questions.get(index);
    }

    @Override
    @Deprecated
    public void onQuestionAnswered(Answer answer) {
        if (answers == null) throw new IllegalStateException("Сначала загрузите вопросы");
        answers.add(answer);
        currentIndex++;
    }

    @Override
    @Deprecated
    public List<Answer> getAllAnswers() {
        return answers;
    }

    @Override
    public int getQuestionsCount() {
        if (questions == null) return 0;
        return questions.size();
    }

    @Override
    public void saveTempAnswers(User user) {
        try {
            String path = Constants.SAVED_USER_ROOT + user.getName() + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(path)); // todo try with resources, перенести в fileHelper

            String userSex = user.getSex() == Sex.MAN ? "man" : "woman";
            writer.write(userSex);

            for (Answer answer : answers) {
                writer.write("\n");
                writer.write(answer.toString());
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
