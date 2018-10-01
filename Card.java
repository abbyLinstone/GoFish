// Warm-up Project
// CS 210

public class Card {

    /**
     * Suit enumerated data type.
     */
    public enum Suit {
        SPADE, DIAMOND, HEART, CLUB
    };

    /**
     * Face enumerated data type.
     */
    public enum Face {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    };

    private Suit suit; // The card's suit
    private Face face; // The card's face value

    /*
     * The Card constructor initializes the value of the suit, face.
     *
     * @param int face to hold face value.
     * @param String suit to hold suit value.
     */
    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    /**
     * The getSuit method returns color.
     */
    public String getSuit() {
        String temp = "";
        switch (suit) {
            case SPADE:
                temp = "\u2660";
                break;
            case DIAMOND:
                temp = "\u2666";
                break;
            case HEART:
                temp = "\u2665";
                break;
            case CLUB:
                temp = "\u2663";
                break;
        }
        return temp;
    }

    ;

    /**
     The getFace method returns num.
     */
    public String getFace() {
        String temp = "";
        switch (face) {
            case ACE:
                temp = "A";
                break;
            case TWO:
                temp = "2";
                break;
            case THREE:
                temp = "3";
                break;
            case FOUR:
                temp = "4";
                break;
            case FIVE:
                temp = "5";
                break;
            case SIX:
                temp = "6";
                break;
            case SEVEN:
                temp = "7";
                break;
            case EIGHT:
                temp = "8";
                break;
            case NINE:
                temp = "9";
                break;
            case TEN:
                temp = "10";
                break;
            case JACK:
                temp = "J";
                break;
            case QUEEN:
                temp = "Q";
                break;
            case KING:
                temp = "K";
                break;
        }
        return temp;
    }

    /**
     *  getFaceIndex that will return a number show's the index of the face
     */
    public int getFaceIndex(){
        int temp = 0;
        switch (face) {
            case ACE:
                temp = 1;
                break;
            case TWO:
                temp = 2;
                break;
            case THREE:
                temp = 3;
                break;
            case FOUR:
                temp = 4;
                break;
            case FIVE:
                temp = 5;
                break;
            case SIX:
                temp = 6;
                break;
            case SEVEN:
                temp = 7;
                break;
            case EIGHT:
                temp = 8;
                break;
            case NINE:
                temp = 9;
                break;
            case TEN:
                temp = 10;
                break;
            case JACK:
                temp = 11;
                break;
            case QUEEN:
                temp = 12;
                break;
            case KING:
                temp = 13;
                break;
        }
        return temp;
    };


    /**
     * The toString method converts the object values of suit, and face to a
     * text string.
     *
     * @return String The string value of cards.
     */
    public String toString() {
        return this.getFace() + this.getSuit();
    }

}
