package com.cocolocomoco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> rainfallPerDay = Arrays.asList(1,1,1,1,1,1,1,1,1,1);
        int k = 3;

        List<Integer> validDays = predictRainfall(rainfallPerDay, k);
        System.out.println(validDays.toString());

    }

    // Think question might be asking "for all left of k, they must be <= k, and all right must be >= k"?
    // I interpreted it as "each left item must be <= the one on its left until k, and then all right must be >= their right
    public static List<Integer> predictRainfall(List<Integer> rainfallPerDay, int k) {
        List<Integer> validDays = new ArrayList<>();

        // Create start and end indices. These will be the range of acceptable days to check - run through these and
        // perform verification
        int startIndex = k;
        int endIndex = rainfallPerDay.size() - k - 1;

        for (int currentIndex = startIndex; currentIndex <= endIndex; currentIndex++) {
            boolean isInvalidDay = false;
            int localMinIndex = currentIndex - k;
            int localMaxIndex = currentIndex + k;

            for (int localItr = localMinIndex; localItr < currentIndex; localItr++) {
                if (!(rainfallPerDay.get(localItr) >= rainfallPerDay.get(localItr + 1))) {
                    isInvalidDay = true;
                    break;
                }
            }

            if (isInvalidDay) {
                continue;
            }

            for (int localItr = localMaxIndex; localItr > currentIndex; localItr--) {
                if (!(rainfallPerDay.get(localItr - 1) <= rainfallPerDay.get(localItr))) {
                    isInvalidDay = true;
                    break;
                }
            }

            if (isInvalidDay) {
                continue;
            }

            // Add since day = currentIndex + 1 (days are one-indexed, not zero-indexed)
            validDays.add(currentIndex + 1);
        }

        return validDays;
    }

}
