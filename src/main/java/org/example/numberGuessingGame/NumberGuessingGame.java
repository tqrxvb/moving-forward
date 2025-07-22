package org.example.numberGuessingGame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessingGame {

    private static final Logger log = LoggerFactory.getLogger(NumberGuessingGame.class);
    private static final int LOW_END = 1;
    private static final int HIGH_END = 100;

    public void numberGuessingGame(){

        int expectedNumber = generateExpectedNumber();
        RangeDetermination range = new RangeDetermination(LOW_END, HIGH_END);

        log.info("We are looking for a number between {} and {}", LOW_END, HIGH_END);
        log.info("It is actually number {}", expectedNumber);

        int drawnNumber;
        int numberOfTrials = 1;

        do {

            drawnNumber = drawNumber(range);
            logTrial(numberOfTrials, drawnNumber);

            if (isCorrectGuess(drawnNumber, expectedNumber)){
                logSuccess(expectedNumber, numberOfTrials);
            } else if (drawnNumber > expectedNumber) {
                range.shiftUpperLimit(drawnNumber);
            } else {
                range.shiftLowerLimit(drawnNumber);
            }

            numberOfTrials++;
        } while (drawnNumber != expectedNumber);

    }

    private int generateExpectedNumber() {
        return ThreadLocalRandom.current().nextInt(LOW_END, HIGH_END + 1);
    }

    private int drawNumber(RangeDetermination range) {
        return ThreadLocalRandom.current().nextInt(range.getMin(), range.getMax());
    }

    private boolean isCorrectGuess(int guess, int expectedNumber) {
        return guess == expectedNumber;
    }

    private void logTrial(int attempt, int guess) {
        log.info("Trial {}: drawn number is {}", attempt, guess);
    }

    private void logSuccess(int expectedNumber, int attempts) {
        log.info("🎉 Congrats! The correct value {} was found in {} attempts!", expectedNumber, attempts);
    }
}
