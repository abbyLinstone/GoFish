// Abby Linstone
// Warm-up Project
// CS 205

import java.util.ArrayList;

public class Deck
{
    // Create an ArrayList to store cards in a deck
    private ArrayList<Card> cards;

    /**
     The Deck constructor creates a deck of 52 cards
     */
    public Deck()
    {
        // Create a deck of 52 cards.
        cards = new ArrayList<Card>(52);
        for(Card.Suit suit : Card.Suit.values())
        {
            for(Card.Face face : Card.Face.values())
            {
                cards.add(new Card(suit,face));
            }
        }
    }

    /**
     Author: Abby
     The shuffle method shuffles deck ArrayList
     of values of cards.
     */
    public void shuffle()
    {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        while(!cards.isEmpty())
        {
            int location = (int)(Math.random()*cards.size());
            tempDeck.add(cards.get(location));
            cards.remove(location);
        }
        cards = tempDeck;
    }

    /**
     Author: Abby
     The outOfCards determines if the deck and
     board are empty, thus out of cards.
     @return boolean If out of cards or not.
     */
    public boolean outOfCards()
    {

        if(cards.isEmpty())
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     Author: Abby
     The getTopCard method returns the top card of
     the deck.
     @return Card cardCopy The top card.

     */
    public Card getTopCard()
    {
        Card top = cards.get(0);
        cards.remove(0);
        return top;
    }

    /**
     Author: Abby
     The toString method returns the text equivilant of
     the deck object ArrayList.
     @Param Deck cards The deck of cards.
     @return Card cardCopy The top card.

     */
    public String toString()
    {
        String s = "";

        for(Card c: cards){
            s += c.toString() + "  ";
        }
        return s;
    }

}