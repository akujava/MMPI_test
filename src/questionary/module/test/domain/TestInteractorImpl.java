package questionary.module.test.domain;

import questionary.models.Answer;
import questionary.models.Question;
import questionary.models.Sex;
import questionary.models.User;
import questionary.utils.Constants;
import questionary.utils.FileHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestInteractorImpl implements TestInteractor {

    private final List<Question> questions = new ArrayList<>(600);
    private FileHelper fileHelper;

    public TestInteractorImpl(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }

    @Override
    public int loadQuestions(Sex sex) {
        List<String> stringQuestions = fileHelper.makeList(sex.getPath());
        questions.clear();
        for (String string : stringQuestions) {
            Question question = new Question(string);
            questions.add(question);
        }

        return questions.size();
    }

    @Override
    public Question getQuestionByIndex(int index) {
        if (index < 0 || index >= questions.size()) {
            return null;
        }
        return questions.get(index);
    }

    @Override
    public void saveTempAnswers(User user) {
//        try {
//            String path = Constants.SAVED_USER_ROOT + user.getName() + ".txt";
//            BufferedWriter writer = new BufferedWriter(new FileWriter(path)); // todo try with resources, перенести в fileHelper
//
//            String userSex = user.getSex() == Sex.MAN ? "man" : "woman"; // todo засунуть в Sex.toString()
//            writer.write(userSex);
//
//            for (Answer answer : answers) {
//                writer.write("\n");
//                writer.write(answer.toString());
//            }
//
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
