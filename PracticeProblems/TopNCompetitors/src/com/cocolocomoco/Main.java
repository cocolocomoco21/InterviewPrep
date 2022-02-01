package com.cocolocomoco;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int numCompetitors = 6;
        int topNCompetitors = 2;
        List<String> competitors = Arrays.asList("newshop", "shopnow", "afashion", "fashionbeats", "mymarket", "tcellular");
        int numReviews = 6;
        List<String> reviews = Arrays.asList(
                "newshop is providing good services in the city; everyone should use newshop",
                "best services by newshop",
                "fashionbeats has great services in the city",
                "I am proud to have fashionbeats",
                "mymarket has awesome services",
                "Thanks Newshop for the quick delivery"
        );

        List<String> topCompetitors = topNumCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews);
        System.out.println("done");

    }


    public static List<String> topNumCompetitors(int numCompetitors,
                                          int topNCompetitors,
                                          List<String> competitors,
                                          int numReviews,
                                          List<String> reviews) {
        // Validation
        if (numReviews != reviews.size()) {
            throw new IllegalArgumentException("numReviews does not match amount of reviews");
        }

        if (topNCompetitors > numCompetitors) {
            throw new IllegalArgumentException("Amount of requested top competitors is greater than amount of total competitors");
        }

        // Build map of competitor to occurrence in reviews
        HashMap<String, List<Integer>> mapCompetitorToReviewOccurrence = buildCompetitorOccurrenceMap(competitors, reviews);




        List<String> result = mapCompetitorToReviewOccurrence.entrySet().stream().sorted(Comparator.comparingInt(value -> value.getValue().size())).limit(topNCompetitors).map(x -> x.getKey()).collect(Collectors.toList());
        return result;
    }

    private static HashMap<String, List<Integer>> buildCompetitorOccurrenceMap(List<String> competitors, List<String> reviews) {
        HashMap<String, List<Integer>> mapCompetitorToReviewOccurrence = new HashMap<>();

        // Pre-populate map to avoid more complicated inline ad hoc initialization and null checking
        for (String competitor : competitors) {
            mapCompetitorToReviewOccurrence.put(competitor, new ArrayList<>());
        }

        // Populate each competitor occurrence
        for (int i = 0; i < reviews.size(); i++) {
            String review = reviews.get(i);

            for (String competitor : competitors) {
                if (review.contains(competitor)) {
                    // Add index of string to signify occurrence in that string
                    mapCompetitorToReviewOccurrence.get(competitor).add(i);
                }
            }
        }

        return mapCompetitorToReviewOccurrence;
    }
}