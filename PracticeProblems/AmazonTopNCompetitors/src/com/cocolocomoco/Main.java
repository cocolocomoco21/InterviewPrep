/**
 * Note: this approach is not the most optimal way to solve this problem. I opted for a Java8 stream approach, but for
 * time complexity this is not the best, as there are redundant iterations and string lookups. The more optimal way is to:
 * - create a HashSet of competitors
 * - iterate over each word of each review, lookup if each word is in the HashSet of competitors
 * - it word is a competitor, count occurrence in count HashMap and mark competitor as seen (separate HashSet)
 * - after operating over all reviews, return sorted sublist. this can be done via priority queue or heap to maintain
 *   count, and then removing the top n, or from filtering/sorting a list and limiting the return.
 */

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
        System.out.println(topCompetitors.toString());
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

        // Previous code, kept for reference
        // Build map of competitor to occurrence in reviews
        //HashMap<String, List<Integer>> mapCompetitorToReviewOccurrence = buildCompetitorOccurrenceMap(competitors, reviews);
        //Set<Map.Entry<String, List<Integer>>> result = mapCompetitorToReviewOccurrence.entrySet().stream().sorted(Comparator.comparingInt(value -> value.getValue().size())).limit(topNCompetitors).collect(Collectors.toSet());

        List<Competitor> competitorsOccurrenceList = buildCompetitorOccurrenceList(competitors, reviews);
        competitorsOccurrenceList
                .sort((o1, o2) -> o1.reviewsAppearedIn.size() == o2.reviewsAppearedIn.size()
                        ? o1.name.compareTo(o2.name)
                        : o2.reviewsAppearedIn.size() - o1.reviewsAppearedIn.size());


        return competitorsOccurrenceList.stream()
                .map(c -> c.name)
                .limit(topNCompetitors)
                .collect(Collectors.toList());
    }

    // Previous code, kept for reference
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

    private static List<Competitor> buildCompetitorOccurrenceList(List<String> competitors, List<String> reviews) {
        List<Competitor> competitorOccurrenceList = new ArrayList<>();

        // Populate each competitor occurrence
        for (String competitor : competitors) {
            // Create new Competitor
            Competitor currentCompetitor = new Competitor(competitor);
            for (int i = 0; i < reviews.size(); i++) {
                String review = reviews.get(i).toLowerCase();

                if (review.contains(competitor)) {
                    // Add index of review string to signify occurrence in that string
                    currentCompetitor.addReviewOccurrence(i);
                }
            }

            competitorOccurrenceList.add(currentCompetitor);
        }

        return competitorOccurrenceList;
    }
}

class Competitor {
    // TODO in an actual interview, don't access these via the raw field. Make them private and use getters
    String name;
    Set<Integer> reviewsAppearedIn;

    Competitor(String name) {
        this.name = name;
        this.reviewsAppearedIn = new HashSet<>();
    }

    public boolean addReviewOccurrence(int i) {
        return this.reviewsAppearedIn.add(i);
    }
}