package org.example.binarySearch.numberGuessingGame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RangeDetermination {

    private static final Logger log = LoggerFactory.getLogger(RangeDetermination.class);
    private int min;
    private int max;

    public RangeDetermination(
            int min,
            int max
    ) {
        if (min >= max) {
            throw new IllegalArgumentException
                    ("min cannot be greater or equal than max");
        }
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void shiftUpperLimit(int newMax) {
        if (newMax <= min) {
            throw new IllegalArgumentException(
                    "new max must be greater than current min");
        }
        this.max = newMax;
        log.info("The upper limit is now {}", this.max);
    }

    public void shiftLowerLimit(int newMin) {
        if (newMin >= max) {
            throw new IllegalArgumentException(
                    "new min must be smaller than current max");
        }
        this.min = newMin;
        log.info("The lower limit is now {}", this.min);
    }

}
