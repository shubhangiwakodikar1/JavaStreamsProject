package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Implement the mean, median, mode and range methods of the Calculator class in Java 8 Functional
 * style with the minimum code necessary to pass the tests.
 */
class FunctionalTest {

    @Test
    void range() {
        assertEquals(14, calculator.range(3, 17, 15, 11, 9));
    }

    @Test
    void mean() {
        assertEquals(12.5, calculator.mean(13, 19, null, 14, 16, 5, 8), 0);
    }

    @Test
    void median() {
        assertEquals(6, calculator.median(7, 11, 6, 2, 5), 0);
        assertEquals(13.5, calculator.median(13, 18, 14, 16, 5, 8), 0);
    }

    @Test
    void mode() {
        assertArrayEquals(new int[]{3}, calculator.mode(5, 2, 3, 6, 4, 1, 3));
        assertArrayEquals(new int[]{3, 5}, calculator.mode(4, 5, 3, 1, 3, 2, 5, 6));
        assertArrayEquals(new int[]{5}, calculator.mode(4, 5, 5, 3, 1, 3, 2, 5, 6));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, calculator.mode(1, 3, 2, 4, 5));
    }

    private class Calculator {

        /**
         * range: the difference between min and max values
         */
        int range(int... input) {
            OptionalInt max = Arrays.stream(input).max();
            OptionalInt min = Arrays.stream(input).min();
            return (max.getAsInt() - min.getAsInt());
        }

        /**
         *  mean: the average of the numbers
         */
        double mean(Integer... input) {
            int sum = Arrays.stream(input).filter(Objects::nonNull).reduce((x, y) -> (x+y)).get();
            long count = Arrays.stream(input).filter(Objects::nonNull).count();
            double average = (float) sum/count;
            return average;
        }

        /**
         * median: the middle number in a sorted list
         * ...if there are two middle values, return the average of the two
         */
        double median(int... input) {
            int[] sortedArray = Arrays.stream(input).sorted().toArray();
            long count = sortedArray.length;
            double median;
            int midpointIndex;
            if ((count % 2) == 0) {
                midpointIndex = (int) count/2;
                median = (float) (sortedArray[midpointIndex - 1] + sortedArray[midpointIndex]) / 2;
            } else {
                midpointIndex = (int) ((count - 1) / 2);
                median = sortedArray[midpointIndex];
            }
            return median;
        }


        /**
         *  mode: the most frequently occurring number(s)
         */
        int[] mode(int... input) {
            int[] sortedArray = Arrays.stream(input).sorted().toArray();
            HashMap<Integer, Integer> intergerWithCounts = new HashMap<>();
            Arrays.stream(sortedArray).map(intElement -> segregateIntoMap(intElement, intergerWithCounts));
            OptionalInt maxCountOptional = intergerWithCounts.values().stream().mapToInt(object -> object.intValue()).max();
//            Stream.of(intergerWithCounts).filter((key, value) -> isMaxCount(value., maxCountOptional.getAsInt()));
            //WIP
//            int[] countsArray = Arrays.stream(intergerWithCounts.values().toArray()).mapToInt(object -> (int) object);
//            OptionalInttionalInt maxCount = Arrays.stream(intergerWithCounts.values().toArray()).map(element -> (Integer.valueOf( (int) element)));
            return null;
        }

        int segregateIntoMap(int intElement, HashMap<Integer, Integer> intergerWithCounts) {
            int count = intergerWithCounts.get(intElement);
            count++;
            intergerWithCounts.put(intElement, count);
            return intElement;
        }

        boolean isMaxCount(int value, int maxCount) {
            if (value == maxCount) {
                return true;
            }
            return false;
        }

    }

    private final Calculator calculator = new Calculator();
}