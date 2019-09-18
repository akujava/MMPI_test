package questionary.module.test.domain;

import questionary.models.Answer;
import questionary.models.Sex;
import questionary.models.User;
import questionary.utils.Constants;
import questionary.utils.FileHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestInteractorImpl implements TestInteractor {

    private List<String> questions;
    private List<Answer> answers;
    private int currentIndex = 0;

    @Override
    public void loadQuestions(User user) {
        File file = new File(user.getSex().getPath());
        questions = new ArrayList<>(600);
        answers = new ArrayList<>(600);
        if (!user.isNewUser()) {
            currentIndex = user.getLastAnswerIndex() + 1;
            answers = user.getAnswers();
        }

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
        if (questions == null) throw new IllegalStateException("Сначала загрузите вопросы");
        if (currentIndex >= questions.size()) return null;
        return questions.get(currentIndex);
    }

    @Override
    public void onQuestionAnswered(Answer answer) {
        if (answers == null) throw new IllegalStateException("Сначала загрузите вопросы");
        answers.add(answer);
        currentIndex++;
    }

    @Override
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(path)); //нужно ли вынести writer в private переменные?
            String userSex;
            switch (user.getSex()) {
                case MAN:
                    userSex = "1";
                    break;
                case WOMAN:
                    userSex = "0";
                    break;
                default:
                    userSex = null;
                    break;
            }

            if (userSex == null)
                return;

            writer.write(userSex);

            for (Answer answer : answers) {
                String stringAnswer;
                if (answer.isValue()) {
                    stringAnswer = "1";
                } else {
                    stringAnswer = "0";
                }
                writer.write("\n");
                writer.write(stringAnswer);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
