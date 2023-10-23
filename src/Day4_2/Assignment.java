package Day4_2;

import java.util.ArrayList;
import java.util.Objects;

public class Assignment {
    private final int firstNumber, lastNumber;
    private ArrayList<Integer> interval;

    public Assignment(int firstNumber, int lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
        this.interval = new ArrayList<>();
        for (int number = firstNumber; number <= lastNumber; number++) {
            this.interval.add(number);
        }
    }

    public boolean isOverlapping(Assignment other) {
        boolean isOverlapping = false;
        for (Integer thisInteger: this.interval) {
            for (Integer otherInteger: other.interval) {
                if (Objects.equals(thisInteger, otherInteger))
                    isOverlapping = true;
            }
        }
        return isOverlapping;
    }
}
