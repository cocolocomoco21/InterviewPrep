package com.cocolocomoco;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for (Suit suit :Suit.values()) {

        }
    }

    enum Suit {
        Spade,
        Club,
        Heart,
        Diamond
    }

//    enum Face {
//        "Ace",
//         "2",
//         "3",
//         "4",
//         "5",
//         "6",
//         "7",
//         "8",
//         "9",
//         "10",
//        "Jack",
//        "Queen",
//        "King"
//    }


    Random random  = new Random();


    random.nextInt(52);


    public Random getRandom() {
        return random;
    }


}



// void reshuffle()
// Card deal()
// void addToDeck()