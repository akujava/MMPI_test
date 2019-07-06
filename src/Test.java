import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public void startTest(Sex sex) throws InterruptedException {
        System.out.println("Данный тест состоит из 566 утверждений.");
        Thread.sleep(500);

        System.out.println("если вы " + ColorsForConsole.ANSI_GREEN + "согласны " + ColorsForConsole.ANSI_RESET + "с утверждением, введите " + ColorsForConsole.ANSI_GREEN + "единицу (1)." + ColorsForConsole.ANSI_RESET);
        System.out.println("если вы " + ColorsForConsole.ANSI_RED + "не согласны " + ColorsForConsole.ANSI_RESET + "с утверждением, введите " + ColorsForConsole.ANSI_RED + "ноль (0)." + ColorsForConsole.ANSI_RESET);
        Thread.sleep(500);

        File file = new File(sex.getPath());
        List<String> questions = new ArrayList<>(600);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fileLine;
            while ((fileLine = reader.readLine()) != null) {
                questions.add(fileLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Integer> answers = new ArrayList<>(600);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int i = 0, size = questions.size();
            while (i < size) {
                System.out.println(questions.get(i));
                String answer = reader.readLine();
                if (answer.equals("1") || answer.equals("0")) {
                    answers.add(Integer.parseInt(answer));
                    i++;
                } else {
                    System.out.println(ColorsForConsole.ANSI_RED + "Ошибка ввода." + ColorsForConsole.ANSI_RESET + " Введите единицу или ноль.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("?: " + questions.size() + " , ответы: " + answers);
    }
}
