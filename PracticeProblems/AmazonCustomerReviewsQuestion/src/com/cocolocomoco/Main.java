package com.cocolocomoco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Have as local vars for testing rather than command arg parsing
//        List<String> inputRepository = new ArrayList<>(List.of("mobile", "mouse", "moneypot", "monitor", "mousepad"));
//        String customerQuery = "mouse";
        List<String> inputRepository = new ArrayList<>(List.of("bicycle", "bike", "bitcoin", "bitmap", "bitmoji"));
        String customerQuery = "bitmap";

        List<List<String>> suggestions = Result.searchSuggestions(inputRepository, customerQuery);
        suggestions.forEach(indexedStr -> {
            indexedStr.forEach(item -> System.out.print(item + " "));
            System.out.println();
        });
    }
}

class Result {
    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        List<List<String>> allSuggestions = new ArrayList<>(new ArrayList<>());

        // Build trie for letter lookup
        TrieNode root = TrieNode.buildTrie(repository);

        // Iterate over all potential strings. Search trie using substring from index 0 -> i, starting with offset at
        // index 1 since minimum string length is 2
        for (int i = 1; i < customerQuery.length(); i++) {
            String queryString = customerQuery.substring(0, i + 1);

            // Already sorted, so just grab the top three
            List<String> possibilities = root.findPossibleStrings(queryString);
            allSuggestions.add(possibilities.stream().limit(3).collect(Collectors.toList()));
        }

        return allSuggestions;
    }
}

class TrieNode {
    // Letter at this node
    Character letter;

    // Child nodes, representing possible longer words using the existing prefix to this point
    List<TrieNode> nodes;

    // List of all words that are possible at the trie up to this point
    List<String> words;


    public TrieNode(Character c) {
        this.letter = c;
        this.nodes = new ArrayList<>();
        this.words = new ArrayList<>();
    }

    Character getLetter() {
        return this.letter;
    }

    List<String> getWords() {
        return this.words;
    }

    TrieNode getChild(Character c) {
        return this.nodes.stream().filter(node -> node.getLetter().equals(c)).findFirst().get();
    }

    void addChildNode(TrieNode newNode) {
        this.nodes.add(newNode);
    }

    boolean containsChild(Character c) {
        return this.nodes.stream().anyMatch(node -> node.getLetter() == c);
    }

    @Override
    public String toString() {
        return this.letter == null ? "root" : letter.toString();
    }

    /**
     * Build trie. Iterate over all chars in all strings to build trie, having nodes point to list of potential
     * next leters
     * @param input input list of strings
     * @return pointer to root TrieNode
     */
    public static TrieNode buildTrie(List<String> input) {
        TrieNode root = new TrieNode(null);
        TrieNode currentNode = root;

        // Sort strings alphabetically up front so retrieval can be made more efficient
        input.sort(Comparator.naturalOrder());

        // Iterate over all strings
        for (String str: input) {

            // Iterate over each char of the string.
            char[] chars = str.toLowerCase().toCharArray();
            for (char c: chars) {
                // Add letter if it isn't added
                if (!currentNode.containsChild(c)) {
                    TrieNode newNode = new TrieNode(c);
                    currentNode.addChildNode(newNode);
                    currentNode = newNode;
                } else {
                    // If letter exists, just update currentNode to already-made letter
                    currentNode = currentNode.getChild(c);
                }

                currentNode.getWords().add(str);
            }

            // Restart iteration from root for next string
            currentNode = root;
        }

        return root;
    }

    public List<String> findPossibleStrings(String queryString) {
        char[] chars = queryString.toLowerCase().toCharArray();

        TrieNode currentNode = this;

        for (char c : chars) {
            if (currentNode.containsChild(c)) {
                currentNode = currentNode.getChild(c);
            } else {
                return new ArrayList<>();
            }
        }

        // At this point, currentNode will be the last matched char in the string. Return the list of words at the node,
        // as they we will be the possible words through this point of the trie.
        return currentNode.getWords();
    }
}