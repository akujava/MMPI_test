import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartClass {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        try {
            System.out.println("МИННЕСОТСКИЙ МНОГОФАЗНЫЙ ЛИЧНОСТНЫЙ ТЕСТ (ММPI)");

            Thread.sleep(500);

            System.out.println("Введите единицу (1), если ваш пол мужской.");
            System.out.println("Введите ноль (0), если ваш пол женский.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s;

            boolean isWorked = true;
            Test test = new Test();
            while (isWorked) {
                s = reader.readLine();
                switch (s) {
                    case "1": test.startTest(Sex.MAN); break;
                    case "0": test.startTest(Sex.WOMAN); break;
                    case "break": isWorked = false; break;
                    default: start();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
