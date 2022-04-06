package com.cocolocomoco;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
////////// TEST CASES ///////////

        // Case: number already exists
        // Expected: 2.58
//        int n = 25;
//        List<Integer> instances = Arrays.asList(10, 25, 50, 100, 500);
//        List<Float> prices = Arrays.asList(2.46f, 2.58f, 2.0f, 2.25f, 3.0f);

        // Case: extrapolate larger
        // Expected: 6.13
//        int n = 2000;
//        List<Integer> instances = Arrays.asList(10, 25, 50, 100, 500);
//        List<Float> prices = Arrays.asList(27.32f, 23.13f, 21.25f, 18.00f, 15.50f);

        // Expected: 2.0
//        int n = 150;
//        List<Integer> instances = Arrays.asList(25, 50, 100);
//        List<Float> prices = Arrays.asList(5.0f, 4.0f, 3.0f);

        // Case: extrapolate smaller
        // Expected: 25
//        int n = 5;
//        List<Integer> instances = Arrays.asList(10, 20, 50, 100, 500);
//        List<Float> prices = Arrays.asList(20.0f, 10.0f, 21.25f, 18.00f, 15.50f);

        // Case: in-between
        // Expected: 3.5
//        int n = 75;
//        List<Integer> instances = Arrays.asList(25, 50, 100);
//        List<Float> prices = Arrays.asList(5.0f, 4.0f, 3.0f);

        // Case: only one number
        // Expected: 50.0
        int n = 25;
        List<Integer> instances = Arrays.asList(1);
        List<Float> prices = Arrays.asList(2.0f);


////////// RUN CODE ////////////

        String result = Result.interpolate(n, instances, prices);
        System.out.println(result);
    }
}

class Result {
    /*
    Complete the 'interpolate' function below

    The function is expected to return a STRING
    The function accepts the following parameters:
        1. INTEGER n
        2. INTEGER_ARRAY instances
        3. FLOAT_ARRAY price
     */
    public static String interpolate(int n, List<Integer> instances, List<Float> prices) {
        /*
        Algorithm:

        If only one, get price per and multiply
        Create hashmap for quick lookup based on iterating through two arrays
        If n exists in hashmap, return value
        Else,
            If value at i=0 is greater than n, extrapolate
            If value at i=size-1 is less than n, extrapolate
            Else, iterate through until you find index where the value at i-1 is less than n and value at i+1 is greater than n
                If values are 0 or neg, go to next one? i.e. if i-1 is 0, to go i-2 (EDGE CASE, worry about at end)
                Find slope and put on line. Return value
         */

        int totalCount = instances.size();

        // If only one instance, use that price
        if (totalCount == 1) {
            Float price = n * prices.get(0);
            return formatPrice(price);
        }

        // Create map for fast lookup
        HashMap<Integer, Float> mapInstanceToPrice = new HashMap<>();
        for (int i = 0; i < totalCount; i++) {
            Integer instance = instances.get(i);
            Float instancePrice = prices.get(i);

            mapInstanceToPrice.put(instance, instancePrice);
        }

        // Return exact price if exists
        if (mapInstanceToPrice.containsKey(n)) {
            return formatPrice(mapInstanceToPrice.get(n));
        }

        // n is smaller than any existing entry - extrapolate
        if (n < instances.get(0)) {
            Float price = linearInterpolateGivenPoints(prices.get(1), instances.get(1),
                    prices.get(0), instances.get(0), n);
            return formatPrice(price);
        }

        // n is larger than any existing entry - extrapolate
        if (n > instances.get(totalCount - 1)) {
            Float price = linearInterpolateGivenPoints(prices.get(totalCount - 1), instances.get(totalCount - 1),
                    prices.get(totalCount - 2), instances.get(totalCount - 2), n);
            return formatPrice(price);
        }

        // Must iterate through list to find neighbors which are larger and smaller
        // Start at i=1 and compare i-1 to i
        for (int i = 1; i < totalCount; i++) {
            // Found data point smaller than and larger than
            if (n > instances.get(i - 1) && n < instances.get(i)) {
                Float price = linearInterpolateGivenPoints(prices.get(i), instances.get(i),
                        prices.get(i - 1), instances.get(i - 1), n);
                return formatPrice(price);
            }
        }

        // Should never happen. In actual interview, use test cases to guide when this might happen and handle accordingly
        return "ERROR";
    }

    private static String formatPrice(Float price) {
        return String.format("%.2f", price);
    }

    private static Float linearInterpolateGivenPoints(Float y2, Integer x2, Float y1, Integer x1, Integer n) {
        Float m = (y2 - y1) / (x2 - x1);
        Float b = y2 - (m * x2);
        return m * n + b;
    }
}
