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
    private final Scanner userInput = new Scanner(System.in);
    private boolean firstTurnCheck;
    private final int MAX_ENERGIES_PLACED = 1;
    private final int MAX_SUPPORTERS_USED = 1;

    /**
     * The startGame method handles all the initialization tasks that are needed to start the game
     */
    public void startGame(){
        System.out.println("Starting game . . .");
        System.out.println();

        //Create the players
        player1 = new Player();
        player2 = new Player();

        //Create the player hands
        player1.createHand();
        player2.createHand();

        //Check for a mulligan
        while(!player1.getDeck().checkForMulligan(player1.getHand())){

            //If one is found, rectify the mulligan and give player 2 another card
            System.out.println("Player 1 has a mulligan");
            System.out.println();

            mulligan(player1);
            addCardToOtherPlayer(player2);
        }

        //Check for a mulligan
        while(!player2.getDeck().checkForMulligan(player2.getHand())){

            //If one is found, rectify the mulligan and give player 1 another card
            System.out.println("Player 2 has a mulligan");
            System.out.println();

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
        if(result.equals("Heads")){

            System.out.println("The coin shows heads. Player 1 will go first and player 2 will go second.");
            System.out.println();

        }else if(result.equals("Tails")){
            Player player3 = player1;
            Player player4 = player2;

            player1 = player4;
            player2 = player3;

            System.out.println("The coin shows tails. Player 2 will go first and Player 1 will go second.");
            System.out.println();
        }

        //Check to see if it is the first turn of the game, since that will change how player 1 will be able to play.
        firstTurnCheck = true;

        runGame();
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
        System.out.println();

        for(Card card : hand){
            System.out.println(card);
        }

        System.out.println();
        System.out.println("Returning cards to deck and picking a new hand . . .");
        System.out.println();

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

            System.out.println("Current number of cards in deck: " + player1.getDeck().getDeckOfCards().size());

            System.out.println();

            System.out.println("Pick a pokemon to place in your active pokemon spot");

            boolean broke = false;

            Pokemon pokemonToBeActive = null;

            while(true){

                String cardToUse = userInput.nextLine();
                for(Card card : player1.getHand()){
                    if(card.getNameOfCard().equalsIgnoreCase(cardToUse)){
                        if(card.getPokemon() != null){
                            pokemonToBeActive = card.getPokemon();
                            broke = true;
                            break;
                        }
                    }
                }

                if(broke){
                    break;
                }
                System.out.println("You did not pick a valid option, please pick another card");
            }

            System.out.println("Placed " + pokemonToBeActive.getNameOfCard() + " in the active spot");

            System.out.println();

            player1.setActivePokemon(pokemonToBeActive);
            player1.removeCardFromHand(pokemonToBeActive);

            player1.addCardToHand();

            displayPlayerStats(player1);

            boolean done = false;

            while(true) {
                System.out.println("Pick a card to continue with your turn (Or type done to move on to battle stage)");

                broke = false;

                Card cardToBeUsed = null;

                while (true) {

                    String cardToUse = userInput.nextLine();

                    if (cardToUse.equalsIgnoreCase("Done")) {
                        System.out.println("Moving on to the battle stage . . .");
                        done = true;
                        break;
                    }

                    for (Card card : player1.getHand()) {
                        if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {
                            int indexOfCard = player1.getHand().indexOf(card);

                            cardToBeUsed = player1.getHand().get(indexOfCard);

                            player1.removeCardFromHand(card);

                            broke = true;
                            break;
                        }
                    }

                    if (broke) {
                        break;
                    }
                    System.out.println("You did not pick a valid option, please pick another card");
                }

                if(done){
                    break;
                }

                String typeOfCard = cardToBeUsed.checkTypeOfCard();

                if(typeOfCard.equals("Trainer")){
                    //check if the card is a supporter and if player has not already used a supporter card

                    //if not run the ability
                }else if (typeOfCard.equals("Pokemon")){

                    //add it to the players bench

                }else if(typeOfCard.equals("Energy")){

                    //Ask the player which pokemon to attach it to
                    //increment the energy use variable
                    //create a check to see if the player is trying to use more than one energy in a turn

                }

            }

            //now into battle phase

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

            //run checks after the turns to make sure that special cases are handled


        }
    }

    /**
     * The addCardToOtherPlayer method handles when the other player should get another card due to a mulligan.
     * @param playerToGetExtraCard The player that should receive the extra card.
     */
    public void addCardToOtherPlayer(Player playerToGetExtraCard){
        playerToGetExtraCard.getHand().add(playerToGetExtraCard.getDeck().pickTopCard());
    }

    /**
     * The displayPlayerStats method prints out the current statistics for a player.
     * @param player The player that need their stats displayed.
     */
    public void displayPlayerStats(Player player){
        System.out.println("Number of prize cards: " + player.getPrizeDeck().size());

        System.out.println("Current active pokemon: " + player.getActivePokemon());

        System.out.println("Current cards in hand: " + player.getHand());

        System.out.println("Current cards in bench: " + player.getBench());

        System.out.println("Current number of cards in deck: " + player.getDeck().getDeckOfCards().size());

        System.out.println();
    }

}
