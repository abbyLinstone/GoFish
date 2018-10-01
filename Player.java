import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Xuanyou
 *
 */
public class Player {

    private ArrayList<Card> hand;
    private String name;
    private ArrayList<Card> booked;
    private boolean[] beenGuessed = new boolean[13];
    private int[] guesses = new int[13];

    /**
     * defualt player method, which probably will never used in this project.
     *
     * @author Xuanyou Liu
     */
    public Player() {
    }

    /**
     * Create a new player with name and deck that player use.
     *
     * @author Xuanyou Liu
     * @param n name of the player
     * @param d the deck that player use
     */
    public Player(String n, Deck d) {
        name = n;
        hand = new ArrayList<Card>();
        booked = new ArrayList<Card>();
        for (int i = 0; i < 7; i++) { // add 7 cards to the player at the start of the game
            hand.add(d.getTopCard());
        }
        for (int i=0; i<13; ++i){
            beenGuessed[i] = false;
        }
    }

    /**
     * getter of the name
     * @return the name in String.
     * @author Xuanyou Liu
     */
    public String getName() {
        return name;
    }

    /**
     * getter of the Hand
     * @return return the whole hand with an arraylist
     * @author Xuanyou Liu
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * setter of the name
     * @param n name of the player
     * @author Xuanyou Liu
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * setter of the Hand
     * @param cards a hand that have cards
     * @author Xuanyou Liu
     */
    public void setHand(ArrayList<Card> cards) {
        hand = cards;
    }

    public void setGuessed(int face, int numOfCard){
        guesses[face-1] = numOfCard;
    }

    /**
     * the method that will print each of the cards in your hand
     * @author Xuanyou Liu
     */
    public void printHand() {
        for (int i = 0; i < hand.size(); i++) {
            Card temp = hand.get(i);
            System.out.print(temp.toString() + ",");
        }
        System.out.println();
    }

    /**
     * You must have at least one card so that you can ask for
     * this card from another player,
     * @param num the specific index of the card that you want to check.
     * @return returu false if you don't have the card you ask for.
     * @author Xuanyou Liu
     */
    public boolean checkCard(int num) {
        int ownedCard = 0;
        for (int i = 0; i < hand.size(); i++) {
            Card tempCard = hand.get(i);
            if (tempCard.getFaceIndex() == num) {
                ownedCard += 1;
            }
        }
        if (ownedCard >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * remove the card by the given index
     * @param i index in the hand
     * @author Xuanyou Liu
     */
    public void deleteCard(int i) {
        hand.remove(i);
    }

    public void addGuess(int face){
        guesses[face-1] ++;
    }

    /**
     * grab a card from another player
     * @param p another player
     * @param face the face you ask for.
     * @return return false if another player don't have that card, if they have
     * grab it and return true.
     * @author Xuanyou Liu
     */
    public void grabCard(Player p, int face, Deck d) {
        Card temp = null;
        int numOfCard = 0;
        if (beenGuessed[face-1] == false){
            p.addGuess(face);
            beenGuessed[face-1] = true; //computer now knows that the player has guessed that card
        }
        for (int i = 0; i < p.getHand().size(); i++) { //check each card of another player
            if (p.getHand().get(i).getFaceIndex() == face) { // if they have the card
                temp = p.getHand().get(i);
                numOfCard++;
                this.hand.add(temp);
                p.deleteCard(i);
                i--;
            }
        }
        if(numOfCard == 0){
            System.out.println("Go Fish.");
            hand.add(d.getTopCard());
        }
    }

    public void printGuesses(){
        for (int i=0; i<beenGuessed.length; ++i){
            System.out.print(beenGuessed[i]+", ");
        }
        System.out.println();
    }

    /**
     * bubble sort used to organize the hand
     *
     * @author will
     */
    public void organizeHand() {
        for (int i = 0; i < hand.size() - 1; ++i) {
            for (int j = 0; j < hand.size() - i - 1; ++j) { //highest card will "bubble" to the end, so last i elements don't need to be checked
                if (hand.get(j).getFaceIndex() > hand.get(j + 1).getFaceIndex()) { //if the card is larger than the next one, swap them
                    Card temp = hand.get(j);
                    hand.set(j, hand.get(j + 1));
                    hand.set(j + 1, temp);
                }
            }
        }
    }

    public boolean isInHand(int face){
        boolean inHand = false;
        for(int i=0; i<hand.size(); ++i){
            if(hand.get(i).getFaceIndex() == face){
                inHand = true;
            }
        }
        return inHand;
    }

    /**
     * the method that will print each of the booked cards
     *
     * @author Xuanyou Liu
     */
    public void printBooked() {
        for (int i = 0; i < booked.size(); i++) {
            Card temp = booked.get(i);
            System.out.print(temp.toString() + ",");
        }
        System.out.println();
    }

    /**
     * check and book the card automatically every round. make sure to add them
     * after player's grab the card
     *
     * @author Xuanyou Liu
     */
    public void checkNBook() {
        for (int i = 1; i < 14; i++) { //check all 13 kinds of face
            int owned = 0; //cards with same Face value
            for (int j = 0; j < hand.size(); j++) { //check the all cards in hand, and count the cards with the given face
                if (i == hand.get(j).getFaceIndex()) {
                    owned++;
                }
            }
            if (owned == 4) {// if given face have 4 of them, book it.
                for (int j = 0; j < hand.size(); j++) {//check the all cards in hand, and book them
                    if (i == hand.get(j).getFaceIndex()) {
                        booked.add(hand.get(j));
                        this.deleteCard(j);
                        j--; //after deleted the card the size will become smaller, so we need to decrease the j value
                    }
                }
            }
        }
    }
}
