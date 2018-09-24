// Warm-up Project
// CS 205
     
public class Card
{
   // Suit enumerated data type
   public enum Suit{CLUB, SPADE, DIAMOND, HEART};   
   // Face enumerated data type
   public enum Face{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
   
   private  Suit suit; // The card's suit   
   private  Face face; // The card's face value
   
   /**
      The Card constructor initializes the value of the suit and face parameters.
      @param Suit suit To hold suit value.
      @param String face To hold face value.
   */   
   public Card(Suit suit, Face face)
   {
      this.suit = suit;
      this.face = face;
   }
   // Getters
   public Suit getSuit()
   {
     return this.suit;  
   }
   public Face getFace()
   {
     return this.face;  
   }
   
   // Setters
   public void setSuit(Suit suit)
   {
     this.suit = suit;  
   }
   public void setFace(Face face)
   {
     this.face = face;
   }
   /**
      The toString method converts the object values of
      suit, and face to a text string.
      @return String The string value of cards.
   */  
   public String toString() 
   {
      return suit + ":"  + face;    
   }

}
