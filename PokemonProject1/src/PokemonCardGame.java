import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The PokemonCardGame class is responsible for creating and running a Pokemon TCG game between two players. It holds
 * all the core methods and game state variables.
 */
public class PokemonCardGame {

    private Player player1;
    private Player player2;
    private Scanner userInput = new Scanner(System.in);
    private boolean firstTurnCheck;
    private String whoGoesFirst;

    /**
     * The startGame method handles all the initialization tasks that are needed to start the game
     */
    public void startGame(){
        System.out.println("Starting game . . .");

        player1 = new Player();
        player2 = new Player();

        player1.createHand();
        player2.createHand();

        while(!player1.getDeck().checkForMulligan(player1.getHand())){
            mulligan(player1);
            addCardToOtherPlayer(player2);
        }

        while(!player2.getDeck().checkForMulligan(player2.getHand())){
            mulligan(player2);
            addCardToOtherPlayer(player1);
        }

        player1.pickPrizeDeck();
        player2.pickPrizeDeck();



        firstTurnCheck = true;
    }

    /***
     *
     * @return
     */
    public String coinFlip(){
        Random random = new Random();

        int coinFace = random.nextInt(0, 2);

        if(coinFace == 0){
            return "Heads";
        }else{
            return "Tails";
        }
    }

    /**
     *
     */
    public void mulligan(Player playerWithMulligan){

        ArrayList<Card> hand = playerWithMulligan.getHand();

        System.out.println("Mulligan Detected, showing player's hand");
        for(Card c : hand){
            System.out.println(c);
        }

        System.out.println("Returning cards to deck and picking a new hand . . .");

        playerWithMulligan.setHand(playerWithMulligan.getDeck().returnHandToDeck(hand));
    }

    /**
     *
     */
    public void player1Turn(){

    }

    /**
     *
     */
    public void player2Turn(){

    }

    /**
     *
     */
    public void runGame(){

    }

    /**
     *
     */
    public void addCardToOtherPlayer(Player playerToGetExtraCard){
        playerToGetExtraCard.getHand().add(playerToGetExtraCard.getDeck().pickTopCard());
    }
}
