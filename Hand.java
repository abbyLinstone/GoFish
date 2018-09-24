// Warm-up Project
// CS 205
   
import java.util.ArrayList;

public class Hand
{
   private ArrayList<Fish_Card> hand;
   private Fish_Deck d = new Fish_Deck();
   
   public ArrayList<Fish_Card> newHand()
   {
      hand = new ArrayList<Fish_Card>();
      d.shuffle();
      d.toString();
      for(int i = 1; i < 8; i++)
      {
         hand.add(d.draw());
      }
      return hand;
   }
   public ArrayList<Fish_Card> addCard(Fish_Deck d)
   {
      hand.add(d.draw());
      return hand;
   }
   public String toString() 
   {
      String s = "";
      
      for(Fish_Card c: hand){
         s += c.toString() + "  "; 
      } 
      return s;  
   }

} 
