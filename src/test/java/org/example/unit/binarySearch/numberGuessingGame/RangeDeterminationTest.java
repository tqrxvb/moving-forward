package org.example.unit.binarySearch.numberGuessingGame;

import org.example.binarySearch.numberGuessingGame.RangeDetermination;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
public class RangeDeterminationTest {

    @Test
    void shouldCreateObjectWithCorrectMinAndMax() {

        int expectedMin = 11;
        int expectedMax = 2;

        var range = new RangeDetermination(
                expectedMin,
                expectedMax);

        assertAll(
                () -> assertEquals(expectedMin, range.getMin(),
                        "Min value should match constructor argument"),
                () -> assertEquals(expectedMax, range.getMax(),
                        "Max value should match constructor argument")
        );
    }

    /*
    WHY LAMBDA?
    new RangeDetermination(...) will be run immediately,
    even before assertThrows will be call,
    so instead check the condition, java will throw
    java: no suitable method found for assertThrows
     */
    @Test
    void shouldThrowExceptionWhenMinIsGreaterThanMaxWhenCreatingObject(){

        int min = 2;
        int max = 1;

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new RangeDetermination(min, max),
                "IllegalArgumentException should be thrown"
        );

        assertAll(
                () -> assertNotNull(ex, "Exception should not be null"),
                () -> assertEquals(
                        RANGE_DETERMINATION_CONSTRUCTOR_EXCEPTION_MESSAGE,
                        ex.getMessage(),
                        "Message with correct content should be thrown"
                )
        );
    }

    @Test
    void shouldThrowExceptionWhenMinEqualsMaxWhenCreatingObject(){

        int min = 1;
        int max = 1;

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new RangeDetermination(min, max),
                "IllegalArgumentException should be thrown"
        );

        assertAll(
                () -> assertNotNull(ex, "Exception should not be null"),
                () -> assertEquals(
                        RANGE_DETERMINATION_CONSTRUCTOR_EXCEPTION_MESSAGE,
                        ex.getMessage(),
                        "Message with correct content should be thrown"
                )
        );
    }

    @Test
    void shouldUpdateMaxWithoutAffectingMinWhenShiftingUpperLimit(){

        int initialMin = 1;
        int initialMax = 2;
        int newMax = 3;

        var range = new RangeDetermination(
                        initialMin,
                        initialMax);

        range.shiftUpperLimit(newMax);

        assertAll(
                () -> assertEquals(
                        newMax, range.getMax(),
                        "Upper limit should be shifted correctly"),
                () -> assertEquals(
                        initialMin, range.getMin(),
                        "Lower limit should remain unchanged")
        );
    }

    @Test
    void shouldThrowExceptionWhenMinIsGreaterThanMaxWhenShiftingUpperLimit(){

        int initialMin = 2;
        int initialMax = 3;
        int newMax = 1;

        var range = new RangeDetermination(
                initialMin,
                initialMax);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> range.shiftUpperLimit(newMax),
                "IllegalArgumentException should be thrown"
        );

        assertAll(
                () -> assertNotNull(ex, "Exception should not be null"),
                () -> assertEquals(
                        SHIFT_UPPER_LIMIT_EXCEPTION_MESSAGE,
                        ex.getMessage(),
                        "Message with correct content should be thrown"
                )
        );
    }

    @Test
    void shouldThrowExceptionWhenMinEqualsMaxWhenShiftingUpperLimit(){

        int initialMin = 1;
        int initialMax = 2;
        int newMax = 1;

        var range = new RangeDetermination(
                initialMin,
                initialMax);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> range.shiftUpperLimit(newMax),
                "IllegalArgumentException should be thrown"
        );

        assertAll(
                () -> assertNotNull(ex, "Exception should not be null"),
                () -> assertEquals(
                        SHIFT_UPPER_LIMIT_EXCEPTION_MESSAGE,
                        ex.getMessage(),
                        "Message with correct content should be thrown"
                )
        );
    }

    @Test
    void shouldUpdateMinWithoutAffectingMaxWhenShiftingLowerLimit(){

        int initialMin = 1;
        int initialMax = 3;
        int newMin = 2;

        var range = new RangeDetermination(
                initialMin,
                initialMax);

        range.shiftLowerLimit(newMin);

        assertAll(
                () -> assertEquals(
                        newMin, range.getMin(),
                        "Lower limit should be shifted correctly"),
                () -> assertEquals(
                        initialMax, range.getMax(),
                        "Upper limit should remain unchanged")
        );
    }

    @Test
    void shouldThrowExceptionWhenMinIsGreaterThanMaxWhenShiftingLowerLimit(){

        int initialMin = 1;
        int initialMax = 2;
        int newMin = 3;

        var range = new RangeDetermination(
                initialMin,
                initialMax);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> range.shiftLowerLimit(newMin),
                "IllegalArgumentException should be thrown"
        );

        assertAll(
                () -> assertNotNull(ex, "Exception should not be null"),
                () -> assertEquals(
                        SHIFT_LOWER_LIMIT_EXCEPTION_MESSAGE,
                        ex.getMessage(),
                        "Message with correct content should be thrown"
                )
        );
    }

    @Test
    void shouldThrowExceptionWhenMinEqualsMaxWhenShiftingLowerLimit(){

        int initialMin = 1;
        int initialMax = 2;
        int newMin = 2;

        var range = new RangeDetermination(
                initialMin,
                initialMax);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> range.shiftLowerLimit(newMin),
                "IllegalArgumentException should be thrown"
        );

        assertAll(
                () -> assertNotNull(ex, "Exception should not be null"),
                () -> assertEquals(
                        SHIFT_LOWER_LIMIT_EXCEPTION_MESSAGE,
                        ex.getMessage(),
                        "Message with correct content should be thrown"
                )
        );
    }

    private static final String RANGE_DETERMINATION_CONSTRUCTOR_EXCEPTION_MESSAGE
            = "min cannot be greater or equal than max";
    private static final String SHIFT_UPPER_LIMIT_EXCEPTION_MESSAGE
            = "new max must be greater than current min";
    private static final String SHIFT_LOWER_LIMIT_EXCEPTION_MESSAGE
            = "new min must be smaller than current max";
}