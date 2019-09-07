package questionary.module.test.presenter;

import questionary.models.Sex;
import questionary.module.test.domain.TestInteractor;
import questionary.module.test.router.TestRouter;
import questionary.module.test.view.TestView;

import java.util.List;

public class TestPresenterImpl implements TestPresenter {

    private TestView view;
    private TestRouter router;
    private TestInteractor interactor;

    public TestPresenterImpl(TestView view, TestRouter router, TestInteractor interactor) {
        this.view = view;
        this.router = router;
        this.interactor = interactor;
    }

    @Override
    public void onStart(Sex sex) {
        interactor.loadQuestions(sex);
        int questionsCount = interactor.getQuestionsCount();
        view.displayTestDescription(questionsCount);
        delay(500);
        view.displayConditions();
        delay(500);
        loadNextQuestion();
        view.observeInput();
    }

    @Override
    public void onInputEntered(String input) {
        switch (input) {
            case "0":
            case "1":
                boolean answer = input.equals("1");
                interactor.onQuestionAnswered(answer);
                loadNextQuestion();
                break;
            case "pause":
//                saveTempAnswers(???);//сохранение ответов в txt файл
                break;
            case "load":
//                load**(???);//загрузка ответов из txt файла
                break;
            case "exit":
                close();
                break;
            default:
                view.displayError();
                break;
        }
    }

    private void loadNextQuestion() {
        String question = interactor.loadNextQuestion();
        if (question == null) {
            close();
        } else {
            view.displayQuestion(question);
        }
    }

    //после команды "pause" сохраняем промежуточный рез-тат в txt файл
    private void saveTempAnswers(List<Boolean> answers) {
//        File tempAnswers = new File("C:\\javaEducationProj\\_temp\\" + MainViewImpl.userName + ".txt"); //создание файла, в имени которого будет храниться ФИО опрашиваемого
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempAnswers))) {
//            for (int i = 0; i < answers.size(); i++) {
//                writer.write(answers.get(i).toString()); //ok?
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    //загрузка промежуточного результата
    private void loadTempAnswers() {
        System.out.println("Введите имя файла из папки C:\\javaEducationProj\\_temp\\ (например \"valera.txt\")");
        String tempFileName = null; //надо считать имя файла
//        List<String> otvety = Scales.transformSourceToList("C:\\javaEducationProj\\_temp\\" + tempFileName);
    }

    private void close() {
        int questionsCount = interactor.getQuestionsCount();
        List<Boolean> answers = interactor.getAllAnswers();
        String answersString = answers == null ? "[]" : answers.toString();
        view.displayAnswers(questionsCount, answersString);
        view.close();
    }

    private void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
