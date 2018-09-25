// Warm-up Project
// CS 210
     
public class Card
{
   /**
      Suit enumerated data type.
   */
   public enum Suit { SPADE, DIAMOND, HEART, CLUB };
   

   /**
      Face enumerated data type.
   */   
   public enum Face { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING };
   
   private  Suit suit; // The card's suit   
   private  Face face; // The card's face value
   
   /**
      The Card constructor initializes the value of the suit, face.
      @param int face to hold face value.
      @param String suit to hold suit value.
   */   
   public Card(Suit suit, Face face)
   {
      this.suit = suit;
      this.face = face;
   }
   /**
      The getSuit method returns color.
   */ 
   public Suit getSuit()
   {
      return suit;
   }

   /**
      The getFace method returns num.
   */ 
   public Face getFace()
   {
      return face;
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