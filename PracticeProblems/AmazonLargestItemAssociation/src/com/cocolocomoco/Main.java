package com.cocolocomoco;

import java.util.*;

public class Main {

    public static void main(String []argh)
    {
        List<PairString> itemAssociation = new ArrayList<>();
        itemAssociation.add(new PairString("item1","item2"));
        itemAssociation.add(new PairString("item3","item4"));
        itemAssociation.add(new PairString("item4","item5"));
        itemAssociation.add(new PairString("item3","item6"));

//        itemAssociation.add(new PairString("item4","item5"));
//        itemAssociation.add(new PairString("item5","item7"));
//        itemAssociation.add(new PairString("item1","item2"));
//        itemAssociation.add(new PairString("item1","item3"));


        List<String> result = largestItemAssociation(itemAssociation);
        System.out.println(result.toString());

    }
    private static List<String> largestItemAssociation(List<PairString> itemAssociation)
    {
        // leveraging TreeMap and TreeSet
        Map<String, Set<String>> sets = new TreeMap<>();

        for (PairString pair : itemAssociation) {
            sets.computeIfAbsent(pair.first, k -> new TreeSet<>()).add(pair.first);
            sets.computeIfAbsent(pair.second, k -> new TreeSet<>()).add(pair.second);

            sets.get(pair.first).add(pair.second);
            sets.get(pair.second).add(pair.first);
        }

        int max = 0;
        Set<String> maxSet = null;
        for (Map.Entry<String, Set<String>> entry : sets.entrySet()) {
            if (entry.getValue().size() > max) {
                maxSet = entry.getValue();
                max = maxSet.size();
            }
        }

        List<String> result = new ArrayList<>(maxSet.size());
        result.addAll(maxSet);
        return result;
    }
}

class PairString
{
    String first;
    String second;

    PairString(String first, String second)
    {
        this.first = first;
        this.second = second;
    }
}
