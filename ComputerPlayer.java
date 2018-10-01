import java.util.ArrayList;

public class ComputerPlayer extends Player {

    private String intelligence;
    private ArrayList<Card> hand;
    private ArrayList<Card> booked;
    private int guesses[] = new int[13];

    public ComputerPlayer(){};
    public ComputerPlayer(String intel, Deck d){
        hand = new ArrayList<Card>();
        booked = new ArrayList<Card>();
        this.intelligence = intel;
        for(int i=0; i<13; ++i){ //initialize memory
            guesses[i] = 0;
        }
        for(int i=0; i<7; ++i){ //fill the computer's initial hand
            hand.add(d.getTopCard());
        }
    }

    @Override
    public ArrayList<Card> getHand() {
        return hand;
    }

    @Override
    public void deleteCard(int i) {
        hand.remove(i);
    }

    @Override
    public void printHand() {
        for (int i = 0; i < hand.size(); i++) {
            Card temp = hand.get(i);
            System.out.print(temp.toString() + ",");
        }
        System.out.println();
    }

    public void addToGuesses(Player p, int face){
        guesses[face-1] += 1;
    }

    public void printGuesses(){
        for (int i=0; i<guesses.length; ++i){
            System.out.print(guesses[i]+", ");
        }
        System.out.println();
    }


    public int numberOfFace(int face){
        int num = 0;
        for (int i=0; i<hand.size(); ++i){
            if(hand.get(i).getFaceIndex() == face){
                num++;
            }
        }
        return num;
    }

    /*
    Author: Will
    This will find which card the human has guessed the most
     */
    public int findMaxGuesses(){
        int max = 0;
        for (int i=0; i<guesses.length; ++i){
            if (guesses[i] >= max){
                max = i;
            }
        }
        return max;
    }

    @Override
    public void outOfCard(Deck d){
        if(d.outOfCards()){ //if the deck is out of cards
            if(hand.size() == 0){ //and the size of the player's hand is 0
                gameOver(); //end the game
            }
        }
        else{
            if(hand.size() == 0){
                System.out.println("Computer is out of cards.");
                hand.add(d.getTopCard());
            }
        }
    }

    /*
    Author: Will
    This allows the computer to make informed decisions
     */
    public int chooseCard(){
        int desiredCard = findMaxGuesses(); //Ideally, the computer will select the card that the player has guessed the most.
        if(intelligence == "smart") {
            if (!isInHand(desiredCard)){  //But if it isn't in its hand, then it can't make that selection. So it will select the card in its hand that it has the most of
                int mostFrequent = 0;
                int[] frequencyTable = new int[hand.size()]; //make a new array whose entries contain the number of each card the computer has in its hand
                for (int i=0; i<hand.size(); ++i){ //populate the table with the frequency of the cards
                    frequencyTable[hand.get(i).getFaceIndex()-1] += 1;
                }
                for (int j = 0; j < frequencyTable.length; ++j){ //now loop through the frequency table to find the one it has the most of
                    if (frequencyTable[j] >= mostFrequent){
                        mostFrequent = frequencyTable[j];
                    }
                }
                desiredCard = mostFrequent;
            }
        }else {
            while (!checkCard(desiredCard)) {
                desiredCard = (int) (Math.random() * 12);  //If the computer isn't smart, it will choose a card at random that is in its hand
            }
        }
        return desiredCard+1; //returns card value that it will request
    }

    @Override
    //Author: Will
    public void grabCard(Player p, int face, Deck d){
        Card temp = null;
        int numOfCard = 0;
        for(int i = 0; i < p.getHand().size(); i++) {
            if(p.getHand().get(i).getFaceIndex() == face) {
                temp = p.getHand().get(i);
                guesses[face-1] ++; //computer will now want more of this card
                this.hand.add(temp); //add it to the hand
                p.deleteCard(i); //card is taken from the player's hand, so delete it from their hand
                i--;
                numOfCard ++;
            }
        }
        if (numOfCard == 0) {
            System.out.println("Go Fish");
            temp = d.getTopCard();
            hand.add(temp);
            p.addGuess(temp.getFaceIndex());
        }else{
            p.setGuessed(face,numOfCard+numberOfFace(face));
        }
    };

    @Override
    public void checkNBook() {
        for (int i = 1; i < 14; i++) { //check all 13 kinds of face
            int owned = 0; //cards with same Face value
            for (int j = 0; j < hand.size(); j++) { //check the all cards in hand, and count the cards with the given face
                if (i == hand.get(j).getFaceIndex()) {
                    owned++;
                }
            }
            if (owned == 4) {// if given face have 4 of them, book it.
                guesses[i-1] = 0;
                for (int j = 0; j < hand.size(); j++) {//check the all cards in hand, and book them
                    if (i == hand.get(j).getFaceIndex()) {
                        booked.add(hand.get(j));
                        this.deleteCard(i);
                        j--; //after deleted the card the size will become smaller, so we need to decrease the j value
                    }
                }
            }
        }
    }

    @Override
    public void printBooked() {
        for (int i = 0; i < booked.size(); i++) {
            Card temp = booked.get(i);
            System.out.print(temp.toString() + ",");
        }
        System.out.println();
    }


    @Override
    public boolean isInHand(int face){
        boolean inHand = false;
        for(int i=0; i<hand.size(); ++i){
            if(hand.get(i).getFaceIndex() == face){
                inHand = true;
            }
        }
        return inHand;
    }
}


