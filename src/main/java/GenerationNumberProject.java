import java.util.ArrayList;
import java.util.List;

public class GenerationNumberProject {
    private static String generateNum(List<Integer> numbers) {
        int minSkipResult = 0;
        int maxResult = 0;
        int skipTemp = 0;
        int valueTemp = numbers.get(0);
        boolean haveSkip = false;
        for (Integer number : numbers) {
            if (maxResult < number) {
                maxResult = number;
            }
            skipTemp = Math.abs(valueTemp - number);
            if (skipTemp > 1) {
                haveSkip = true;
                if (minSkipResult == 0 || minSkipResult > skipTemp) {
                    minSkipResult = skipTemp;
                }
            }
            valueTemp = number;
        }
        if (numbers.size() == 1) {
            return String.format("%03d", 1);
        }

        if (haveSkip) {
            return String.format("%03d", minSkipResult);
        } else
            return String.format("%03d", maxResult + 1);
    }


}
