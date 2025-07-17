package org.example.numberGuessingGame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RangeDetermination {

    private static final Logger log = LoggerFactory.getLogger(RangeDetermination.class);
    private int min;
    private int max;

    public RangeDetermination(
            int max,
            int min
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
        this.max = newMax;
        log.info("The upper limit is now {}", this.max);
    }

    public void shiftLowerLimit(int newMin) {
        this.min = newMin;
        log.info("The lower limit is now {}", this.min);
    }
}
