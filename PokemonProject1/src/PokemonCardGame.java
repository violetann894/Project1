import java.util.Random;

/**
 * The PokemonCardGame class is responsible for creating and running a Pokemon TCG game between two players. It holds
 * all the core methods and game state variables.
 */
public class PokemonCardGame {

    private Player player1;
    private Player player2;
    private boolean firstTurnCheck;


    /**
     * The startGame method handles all the initialization tasks that are needed to start the game
     */
    public void startGame(){
        System.out.println("Starting game . . .");
        System.out.println();

        //Create the players
        player1 = new Player();
        player2 = new Player();

        //Set the player names
        player1.setPlayerName("Player 1");
        player2.setPlayerName("Player 2");

        //Create the player hands
        player1.createHand();
        player2.createHand();

        //Check for a mulligan
        while(!player1.getDeck().checkForMulligan(player1.getHand())){

            //If one is found, rectify the mulligan and give player 2 another card
            System.out.println("Player 1 has a mulligan");
            System.out.println();

            //Run the mulligan method and add another card to the other player's hand
            mulligan(player1);
            addCardToOtherPlayer(player2);
        }

        //Check for a mulligan
        while(!player2.getDeck().checkForMulligan(player2.getHand())){

            //If one is found, rectify the mulligan and give player 1 another card
            System.out.println("Player 2 has a mulligan");
            System.out.println();

            //Run the mulligan method and add another card to the other player's hand
            mulligan(player2);
            addCardToOtherPlayer(player1);
        }

        //Create the prize deck for each player
        player1.pickPrizeDeck();
        player2.pickPrizeDeck();

        //Do a coin flip to see who will go first
        String result = coinFlip();

        if(result.equals("Heads")){

            //if the result is heads, the players can stay the way they are

            System.out.println("The coin shows heads. Player 1 will go first and player 2 will go second.");
            System.out.println();

        }else if(result.equals("Tails")){

            //if the result is Tails, player 1 needs to be player 2 and player 2 needs to be player 1

            //Assign player1 to the temp player variable
            Player tempPlayer1 = player1;

            //Put the player's in the correct order
            player1 = player2;
            player2 = tempPlayer1;

            //Inform the player
            System.out.println("The coin shows tails. Player 2 will go first and Player 1 will go second.");
            System.out.println();
        }

        //Check to see if it is the first turn of the game, since that will change how player 1 will be able to play.
        firstTurnCheck = true;

        //Run the game
        runGame();
    }

    /***
     * The flipCoin method flips a coin and returns if it is heads or tails.
     * @return The result of the coin flip.
     */
    public String coinFlip(){

        //Create a random object
        Random random = new Random();

        //Generate an int from 0 to 1
        int coinFace = random.nextInt(0, 2);

        //Check the number
        if(coinFace == 0){

            //If the number is zero

            //Return heads
            return "Heads";
        }else{

            //If the number is anything but zero

            //Return tails
            return "Tails";
        }
    }

    /**
     * The mulligan method takes the hand of the player with a mulligan, returns it to their deck, and picks them a
     * new hand.
     * @param playerWithMulligan The Player that has the mulligan
     */
    public void mulligan(Player playerWithMulligan){

        //Inform the player of the mulligan
        System.out.println("Mulligan Detected, showing player's hand");
        System.out.println();

        //Print out the player's hand
        for(Card card : playerWithMulligan.getHand()){
            System.out.println(card);
        }

        //Inform the player about the next step
        System.out.println();
        System.out.println("Returning cards to deck and picking a new hand . . .");
        System.out.println();

        //Return the player's hand to their deck
        playerWithMulligan.getDeck().returnHandToDeck(playerWithMulligan.getHand());

        //Create a new hand for the player with the mulligan
        playerWithMulligan.createHand();
    }

    /**
     * The player1Turn method handles the core functionalities of player1's turn.
     */
    public void player1Turn(){

        //Check to see if it is the first turn of the game
        if(firstTurnCheck){

            //If it is, that means that player 1 cannot battle the other player

            //Use the noActivePokemon method to get the player to set their active pokemon
            player1.noActivePokemon();

            //Add a card to the player's hand since they placed their active pokemon
            player1.addCardToHand();

            player1.runPlayerTurn(firstTurnCheck);

            //Once we have reached this part of the code, the player has indicated that they have completed their
            //turn. Because we are in player1's first turn, we now go to player2's first turn

            //Set the firstTurnCheck to false
            firstTurnCheck = false;

        }else{

            //Checks one of the win conditions, if the player's deck is empty by the beginning of their turn
            if(player1.getDeck().getDeckOfCards().isEmpty()){

                //If the player's deck is empty

                //Inform the players
                System.out.println(player1.getPlayerName() + " has no more cards in their deck at the start of " +
                        "their turn!");
                System.out.println("Player 2 is the winner!");

                //Exit out of the program because the game is over
                System.exit(0);
            }

            //Check to see if the player has an active pokemon in their active slot
            if(player1.getActivePokemon() == null) {

                //If there isn't a pokemon their, allow the player to add one from their hand
                player1.noActivePokemon();

            }

            //Since it is the beginning of the player's turn, give them a card
            player1.addCardToHand();

            //Run the standard player turn
            player1.runPlayerTurn(firstTurnCheck);

            //After the player finishes their preparation phase, start the battling phase
            player1.battlePhase(player2);
        }
    }

    /**
     * The player2Turn method handles the care functionalities of player2's turn.
     */
    public void player2Turn(){

        //Checks one of the win conditions, if the player's deck is empty by the beginning of their turn
        if(player2.getDeck().getDeckOfCards().isEmpty()){

            //If the player's deck is empty

            //Inform the players
            System.out.println(player2.getPlayerName() + " has no more cards in their deck at the start of " +
                    "their turn!");
            System.out.println("Player 1 is the winner!");

            //Exit out of the program because the game is over
            System.exit(0);
        }

        //Check to see if the player has an active pokemon in their active slot
        if(player2.getActivePokemon() == null) {

            //If there isn't a pokemon there, allow the player to add one from their hand
            player2.noActivePokemon();

        }

        //Since it is the beginning of the player's turn, give them a card
        player2.addCardToHand();

        //Run the standard player turn
        player2.runPlayerTurn(firstTurnCheck);

        //After the player finishes their preparation phase, start the battling phase
        player2.battlePhase(player1);
    }

    /**
     * The runGame method runs the Pokemon TCG game, by alternating the player turns and checking for win conditions.
     */
    public void runGame(){

        //Keep the game running until one of the player's has no more cards in their prize deck
        while(!player1.getPrizeDeck().isEmpty() && !player2.getPrizeDeck().isEmpty()) {

            //Run player1's turn
            player1Turn();

            if (player2.getActivePokemon() != null && player2.isKnockedOut()) {

                //if player2's active pokemon is knocked out

                //Add the active pokemon and its energies to player2's discard pile
                for(Card card : player2.getActivePokemon().getEnergiesAttached()){
                    player2.addCardToDiscard(card);
                }
                player2.getActivePokemon().getEnergiesAttached().clear();
                player2.addCardToDiscard(player2.getActivePokemon());

                //Add one of player1's prize cards to their hand
                player1.addPrizeCardToHand();

                //Check to see if the player1's prize deck is empty
                if(player1.getPrizeDeck().isEmpty()){

                    //If it is, break, they won the game
                    break;
                }

                //Let player 2 pick a pokemon from their bench to move into their active slot
                player2.noActivePokemonFromBench();
            }

            //Run player2's turn
            player2Turn();

            //Check to see if player1's active pokemon is knocked out
            if(player1.isKnockedOut()){

                //If the pokemon is knocked out

                //Add the active pokemon and its energies to player1's discard pile
                for(Card card : player1.getActivePokemon().getEnergiesAttached()){
                    player1.addCardToDiscard(card);
                }
                player1.getActivePokemon().getEnergiesAttached().clear();
                player1.addCardToDiscard(player1.getActivePokemon());

                //Add a prize card to player2's hand
                player2.addPrizeCardToHand();

                //Check to see if player2's prize deck is empty
                if(player2.getPrizeDeck().isEmpty()){

                    //If it is, break, player 2 won the game
                    break;
                }

                //Let player 1 pick a pokemon from their bench to move into their active slot
                player1.noActivePokemonFromBench();

            }

        }

        //Another win condition check, checks to see if the player's prizeDeck is empty
        if(player1.getPrizeDeck().isEmpty()){

            //If player1's prize deck is empty, they won the game

            //Inform the players
            System.out.println("Player 1 won the game!");

            //Exit out of the program because the game is over
            System.exit(0);

        }else if(player2.getPrizeDeck().isEmpty()){

            //Else, if player2's prize deck is empty, they won the game

            //Inform the players
            System.out.println("Player 2 won the game!");

            //Exit out of the program because the game is over
            System.exit(0);
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
