import java.sql.SQLOutput;
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

        //Create the players
        player1 = new Player();
        player2 = new Player();

        //Create the player hands
        player1.createHand();
        player2.createHand();

        //Check for a mulligan
        while(!player1.getDeck().checkForMulligan(player1.getHand())){

            //If one is found, rectify the mulligan and give player 2 another card
            mulligan(player1);
            addCardToOtherPlayer(player2);
        }

        //Check for a mulligan
        while(!player2.getDeck().checkForMulligan(player2.getHand())){

            //If one is found, rectify the mulligan and give player 1 another card
            mulligan(player2);
            addCardToOtherPlayer(player1);
        }

        //Create the prize deck for each player
        player1.pickPrizeDeck();
        player2.pickPrizeDeck();

        //Do a coin flip to see who will go first
        String result = coinFlip();

        //if the result is heads, the players can stay the way they are
        //if the result is Tails, player 1 needs to be player 2 and player 2 needs to be player 1
        if(result.equals("Tails")){
            Player player3 = player1;
            Player player4 = player2;

            player1 = player4;
            player2 = player3;
        }

        //Check to see if it is the first turn of the game, since that will change how player 1 will be able to play.
        firstTurnCheck = true;
    }

    /***
     * The flipCoin method flips a coin and returns if it is heads or tails.
     * @return The result of the coin flip.
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
     * The mulligan method handles when a mulligan is found.
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
     * The player1Turn method handles the core functionalities of a player turn.
     */
    public void player1Turn(){

        int numberOfEnergiesUsed = 0;
        int numberOfSupporterCardsUsed = 0;
        boolean xSpeedUsed = false;

        if(firstTurnCheck){

            //if it is the first turn of the game, the player cannot attack the other player

            System.out.println("Number of prize cards: " + player1.getPrizeDeck().size());

            System.out.println("Current active pokemon: None");

            System.out.println("Current cards in hand: " + player1.getHand());

            System.out.println("Current cards in bench: " + player1.getBench());

            System.out.println("What card would you like to use? (Type the name of the card as you see it)");

            boolean validOption = false;

            while(validOption){
                String cardToUse = userInput.nextLine();
                for(Card c : )

            }

        }

    }

    /**
     * The player2Turn method handles the care functionalities of a player turn.
     */
    public void player2Turn(){

    }

    /**
     * The runGame method runs the Pokemon TCG game.
     */
    public void runGame(){
        while(!player1.getPrizeDeck().isEmpty() && !player2.getPrizeDeck().isEmpty()){
            player1Turn();
            player2Turn();

            //run checks after the turns to make sure that special


        }
    }

    /**
     * The addCardToOtherPlayer method handles when the other player should get another card due to a mulligan.
     * @param playerToGetExtraCard The player that should receive the extra card.
     */
    public void addCardToOtherPlayer(Player playerToGetExtraCard){
        playerToGetExtraCard.getHand().add(playerToGetExtraCard.getDeck().pickTopCard());
    }
}
