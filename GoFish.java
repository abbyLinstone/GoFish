// Warm-up Project
// CS 205
   
import java.util.ArrayList;

public class GoFish
{
   private ArrayList<Card> hand1 = new ArrayList<Card>();
   private ArrayList<Card> hand2 = new ArrayList<Card>();
   Hand hand = new Hand();
   
   public void create2Hands()
   {
      hand1 = hand.newHand();
      hand2 = hand.newHand();
   }
   public void drawCard(ArrayList<Card> h)
   {
      hand.addCard(h);
   }
   public void play()
   {  
      create2Hands();
      int i;
      for(i=1; i<39; i++)
      {
         drawCard(hand1);
      }
      // Boolean to create turns
      boolean turn = true; 
      if(turn)
      {
      
         turn = false;
      }
      else
      {
      
         turn = true;
      }
      System.out.println(hand1.toString()); 
      System.out.println(hand2.toString());
   }
   public static void main(String[] args)
   {
      GoFish game = new GoFish();
      game.play();
      
    
   }

} 
