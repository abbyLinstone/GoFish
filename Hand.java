// Warm-up Project
// CS 205
   
import java.util.ArrayList;

public class Hand
{
   private ArrayList<Card> hand;
   private Deck d = new Deck();
   
   public ArrayList<Card> newHand()
   {
      hand = new ArrayList<Card>();
      d.shuffle();
      d.toString();
      for(int i = 1; i < 8; i++)
      {
         hand.add(d.getTopCard());
      }
      return hand;
   }
   public ArrayList<Card> addCard(ArrayList<Card> h)
   {
      h.add(d.getTopCard());
      return h;
   }
   public String toString() 
   {
      String s = "";
      
      for(Card c: hand){
         s += c.toString() + "  "; 
      } 
      return s;  
   }
   public Deck getDeck()
   {
      return d;
   }

} 