package java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Card {
    //public static enum Face {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King};
    public enum Face {
//        Ace(1), King(2), Queen(3), Jack(4), Ten(5), Nine(6), Eight(7), Seven(8), Six(9), Five(10), Four(11), Three(12), Two(13);
        Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);
        final int rank;

        Face(int r) {
            rank = r;
        }

        int getRank() {
            return rank;
        }
    }

    //public static enum Suit {Clubs, Diamonds, Hearts, Spades };
    public enum Suit {
        Spades(1), Hearts(2), Diamonds(3), Clubs(4);
        final int order;

        Suit(int o) {
            order = o;
        }

        int getOrder() {
            return order;
        }
    }

    private final Face face; // face of card
    private final Suit suit; // suit of card

    // two-argument constructor
    public Card(Face cardFace, Suit cardSuit) {
        face = cardFace; // initialize face of card
        suit = cardSuit; // initialize suit of card
    }

    // return face of the card
    public Face getFace() {
        return face;
    }

    // return suit of java.Card
    public Suit getSuit() {
        return suit;
    }

    // return String representation of java.Card
    public String toString() {
        //return String.format( "%s.%s", suit.getOrder(), face.getRank() );
        return String.format("%s.%s", suit, face);
    }
}

// class java.DeckOfCards declaration
public class DeckOfCards {
    private final List<Card> list; // declare List that will store Cards

    // set up deck of Cards and shuffle
    public DeckOfCards() {
        Card[] deck = new Card[52];
        int count = 0; // number of cards

        // populate deck with java.Card objects
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Face face : Card.Face.values()) {
                deck[count] = new Card(face, suit);
                count++;
            }
        }

        list = Arrays.asList(deck); // get List
        Collections.shuffle( list );  // shuffle deck
    }

    // output deck
    public void printCards() {
        // display 52 cards in two columns
        for (Card card : list) {
            System.out.println(card);
//            System.out.printf("%-20s%s", list.get(i),
//                    ((i + 1) % 2 == 0) ? "\n" : "");
        }
    }

    public static void main(String[] args) {
        DeckOfCards cards = new DeckOfCards();
        cards.printCards();
        //cards.InsertionSort();
    }
}