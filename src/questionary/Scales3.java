package questionary;

import java.util.List;

public class Scales3 {
    public int getScalePoints(List<Boolean> answers, List<Integer> truePoints, List<Integer> falsePoints) {
        int totalPoints = 0;
        for (int i = 0; i < truePoints.size(); i++) {
            if (answers.get(truePoints.get(i) - 1) == true)
                totalPoints++;
        }

        for (int i = 0; i < falsePoints.size(); i++) {
            if (answers.get(falsePoints.get(i) - 1) == false)
                totalPoints++;
        }

        return totalPoints;
    }
}
