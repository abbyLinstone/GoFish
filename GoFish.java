// Warm-up Project
// CS 205
   
import java.util.ArrayList;

public class GoFish
{
   private ArrayList<Card> hand1 = new ArrayList<Card>();
   private ArrayList<Card> hand2 = new ArrayList<Card>();
   Hand hand = new Hand();
   Deck d = hand.getDeck();
   
   public void create2Hands()
   {
      hand1 = hand.newHand();
      hand2 = hand.newHand();
   }
   public void drawCard(ArrayList<Card> h)
   {
      hand.addCard(h);
   }
   /**
      The outOfCards determines if the deck and
      board are empty, thus out of cards.
      @return boolean If out of cards or not.
    */ 
    public boolean outOfCards() 
    {
        
        if(d.isEmpty())
        {
           return true;
        }else
        { 
           return false;
        }
    }

   public void play()
   {  
      create2Hands();
      int i;
//       for(i=1; i<39; i++)
//       {
//          drawCard(hand1);
//       }
      // Boolean to create turns
      boolean turn = true; 
      while(outOfCards() == false)
      {
         if(turn)
         {
         
            turn = false;
         }
         else
         {
         
            turn = true;
         }
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
