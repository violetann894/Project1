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

            //Assign players to the temp player variables
            Player tempPlayer1 = player1;
            Player tempPlayer2 = player2;

            //Put the player's in the correct order
            player1 = tempPlayer2;
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
     * The mulligan method handles when a mulligan is found.
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
            noActivePokemon(player1);

            //Add a card to the player's hand since they placed their active pokemon
            player1.addCardToHand();

            //Set up variables needed to track information about the turn
            int numberOfEnergiesUsed = 0;
            int numberOfSupporterCardsUsed = 0;
            boolean xSpeedUsed = false;
            boolean broke;
            boolean done = false;

            //This while loop is used to allow the user to use as many cards as they are allowed to
            //The loop is broken from within when certain checks have been made
            while (true) {

                //Display the player stats at the beginning of the prompt
                displayPlayerStats(player1);

                //Give the player a instruction statement
                System.out.println("Pick a card to continue with your turn (Or type done to move on to the next " +
                        "player's turn)");

                //Set boolean variable broke to false (one of the checks)
                broke = false;

                //The Card variable that will hold the card that the player wants to use
                Card cardToBeUsed = null;

                //Another loop, but the purpose of this one is constantly loop until the player give a valid response
                while (true) {

                    //Accept user input from the console
                    String cardToUse = userInput.nextLine();

                    //If the player typed done
                    if (cardToUse.equalsIgnoreCase("Done")) {

                        //Inform the player
                        System.out.println("Moving on to next player's turn . . .");

                        //Set one of the flags, done, equal to true
                        done = true;

                        //break out of the while loop
                        break;
                    }

                    //Loop through the player's hand
                    for (Card card : player1.getHand()) {

                        //Check to see if the card the player wants to use is in their hand
                        if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {

                            //If it is in their hand

                            //Find the index of the card
                            int indexOfCard = player1.getHand().indexOf(card);

                            //Use the variable from earlier to hold that Card object
                            cardToBeUsed = player1.getHand().get(indexOfCard);

                            //Set another flag (broke) equal to true
                            broke = true;

                            //Break out of the loop
                            break;
                        }
                    }

                    //Because the code above is in a double while loop, we have to break out again
                    if (broke) {

                        //If the broke flag is true

                        //Break again
                        break;
                    }

                    //If the player gets to this point, it means they have not picked a valid response to break
                    //them out of the loop

                    //Inform the player of this
                    System.out.println("You did not pick a valid option, please pick another card");
                    System.out.println();
                }

                //Check the done flag
                if (done) {

                    //If the player typed done

                    //Break out of the loop and skip to the next phase
                    break;
                }

                //Now we need to check what type of card the player is trying to use

                //Check to see what type the card is and hold in it the typeOfCard variable
                String typeOfCard = cardToBeUsed.checkTypeOfCard();

                //Check to see what type of card the player played
                if (typeOfCard.equals("Trainer")) {

                    //If the player used a trainer card

                    //Check to see if the player is using a supporter card and if they have used a supporter card
                    //already
                    if (cardToBeUsed.getTrainer().getTypeOfTrainerCard().equals("Supporter") &&
                            numberOfSupporterCardsUsed < MAX_SUPPORTERS_USED) {

                        //If the player is using a supporter card, and they have not used one before

                        //Use the ability of the card
                        cardToBeUsed.getTrainer().useAbility(player1);

                        //Remove the card from the player's hand and add the card to the player's discard pile
                        player1.removeCardFromHand(cardToBeUsed);
                        player1.addCardToDiscard(cardToBeUsed);

                        //Increment the numberOfSupporterCardsUsed flag
                        numberOfSupporterCardsUsed++;

                    } else if (!cardToBeUsed.getTrainer().getTypeOfTrainerCard().equals("Supporter")) {

                        //Else, if the card the player wants to use is a trainer card that is not also a supporter card

                        //Check if it is an X Speed
                        if (cardToBeUsed.getTrainer().getNameOfCard().equals("X Speed")) {

                            //If it is

                            //Set the xSpeedUsed flag to true
                            xSpeedUsed = true;
                        }

                        //Use the card's ability, remove the card from the player's hand and add it their discard pile
                        cardToBeUsed.getTrainer().useAbility(player1);
                        player1.removeCardFromHand(cardToBeUsed);
                        player1.addCardToDiscard(cardToBeUsed);

                    } else {

                        //Else, the player has chosen a supporter card and has already used one

                        //Inform the player
                        System.out.println("You've already used a supporter card this turn, pick another card.");
                        System.out.println();

                    }
                } else if (typeOfCard.equals("Pokemon")) {

                    //Else, if the card the player wants to use is a Pokemon

                    //Add the card to the player's bench and remove the card from the player's hand
                    player1.addCardToBench(cardToBeUsed);
                    player1.removeCardFromHand(cardToBeUsed);

                    //Inform the player
                    System.out.println("Added card to bench");
                    System.out.println();

                } else if (typeOfCard.equals("Energy")) {

                    //Else, if the card the player wants to use is an energy

                    //Check to make sure the player has not already used an energy during this turn
                    if (numberOfEnergiesUsed < MAX_ENERGIES_PLACED) {

                        //If they have not used an energy yet

                        //Ask the player which pokemon they want to give it to
                        System.out.println("What pokemon do you want to add the energy to?");

                        //Show the player their active pokemon and the pokemon in their bench
                        System.out.println("Active pokemon: " + player1.getActivePokemon() + " Benched pokemon: " +
                                player1.getBench());

                        //Create an ArrayList that holds all the pokemon in the player's active slot and in their bench
                        ArrayList<Card> allPokemon = new ArrayList<>();
                        allPokemon.add(player1.getActivePokemon());
                        allPokemon.addAll(player1.getBench());


                        //Set a flag and initialize variable to hold the card when found
                        broke = false;
                        Pokemon pokemonToBeUsed = null;

                        //Loop until the player gives a valid response
                        while (true) {

                            //Accept user input
                            String cardToFind = userInput.nextLine();

                            //Loop through all the pokemon the player has placed
                            for (Card card : allPokemon) {

                                //Check to see if the card the player wants to use is in the list
                                if (card.getNameOfCard().equalsIgnoreCase(cardToFind)) {

                                    //If the name is equal to the player's input

                                    //Grab the index of the card
                                    int indexOfCard = allPokemon.indexOf(card);

                                    //Assign the card to the temp variable created above
                                    pokemonToBeUsed = (Pokemon) allPokemon.get(indexOfCard);

                                    //Set the flag to true and break out of the loop
                                    broke = true;
                                    break;
                                }
                            }

                            //Since we are in a double loop, check the flag variable
                            if (broke) {

                                //If the flag is true

                                //Break out of the loop again
                                break;
                            }

                            //If the player reached this point, it means they did not pick a card available

                            //Inform the player
                            System.out.println("You did not pick a valid option, please pick another card");
                            System.out.println();
                        }

                        //Use the attachEnergy method to add the energy to the pokemon card chosen
                        pokemonToBeUsed.attachEnergy((Energy) cardToBeUsed);

                        //Increment the numberOfEnergiesUsed flag
                        numberOfEnergiesUsed++;

                        //Remove the energy card from the player's hand
                        player1.removeCardFromHand(cardToBeUsed);

                        //Inform the player of the action
                        System.out.println("Added " + cardToBeUsed.getNameOfCard() + " to " +
                                pokemonToBeUsed.getNameOfCard());
                        System.out.println();

                    } else {

                        //Else, the player has already placed on energy card this turn

                        //Inform the player of this
                        System.out.println("You have already placed an energy this turn. Please choose another card.");
                    }
                }

            }

            //Once we have reached this part of the code, the player has indicated that they have completed their
            //turn. Because we are in player1's first turn, we now go to player2's first turn

            //Check to see if an XSpeed has been used
            if(xSpeedUsed){

                //If one has been used, now that it is the end of the player's turn, give the pokemon the retreat
                //cost back
                player1.getActivePokemon().addOneRetreatCost();
            }

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
                noActivePokemon(player1);

            }

            //Since it is the beginning of the player's turn, give them a card
            player1.addCardToHand();

            //Run the standard player turn
            runPlayerTurn(player1);

            //After the player finishes their preparation phase, start the battling phase
            battlePhase(player1, player2);
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
            noActivePokemon(player2);

        }

        //Since it is the beginning of the player's turn, give them a card
        player2.addCardToHand();

        //Run the standard player turn
        runPlayerTurn(player2);

        //After the player finishes their preparation phase, start the battling phase
        battlePhase(player2, player1);
    }

    /**
     * The runGame method runs the Pokemon TCG game, by alternating the player turns and checking for win conditions.
     */
    public void runGame(){

        //Keep the game running until one of the player's has no more cards in their prize deck
        while(!player1.getPrizeDeck().isEmpty() && !player2.getPrizeDeck().isEmpty()) {

            //Run player1's turn
            player1Turn();

            //This if statment is done to prevent the game from throwing a NullPointerExpection because player2 has not
            //placed an active pokemon yet
            if (player2.getActivePokemon() == null) {

            } else if (player2.isKnockedOut()) {

                //else, if player2's active pokemon is knocked out

                //Add the pokemon to player2's discard pile
                player2.addCardToDiscard(player2.getActivePokemon());

                //Add one of player1's prize cards to their hand
                player1.addPrizeCardToHand();

                //Check to see if the player1's prize deck is empty
                if(player1.getPrizeDeck().isEmpty()){

                    //If it is, break, they won the game
                    break;
                }

                //Let player 2 pick a pokemon from their bench to move into their active slot
                noActivePokemonFromBench(player2);
            }

            //Run player2's turn
            player2Turn();

            //Check to see if player1's active pokemon is knocked out
            if(player1.isKnockedOut()){

                //If the pokemon is knocked out

                //Add the active pokemon to player1's discard pile
                player1.addCardToDiscard(player1.getActivePokemon());

                //Add a prize card to player2's hand
                player2.addPrizeCardToHand();

                //Check to see if player2's prize deck is empty
                if(player2.getPrizeDeck().isEmpty()){

                    //If it is, break, player 2 won the game
                    break;
                }

                //Let player 1 pick a pokemon from their bench to move into their active slot
                noActivePokemonFromBench(player1);

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

    /**
     * The displayPlayerStats method prints out the current statistics for a player, including, number of prize cards
     * left in their prize deck, the current active pokemon, the HP of their active pokemon, the cards they have in
     * their hand, the pokemon in their bench and the current number of cards they have left in their deck.
     * @param player The player that need their stats displayed.
     */
    public void displayPlayerStats(Player player){
        System.out.println("Number of prize cards: " + player.getPrizeDeck().size());
        System.out.println("Current active pokemon: " + player.getActivePokemon());
        System.out.println("Current HP of active Pokemon: " + player.getActivePokemon().getHp());
        System.out.println("Current cards in hand: " + player.getHand());
        System.out.println("Current cards in bench: " + player.getBench());
        System.out.println("Current number of cards in deck: " + player.getDeck().getDeckOfCards().size());
        System.out.println();
    }

    /**
     * The noActivePokemon method prints out the current stats for a player and handles when the player does not have an
     * active pokemon. This method is different from noActivePokemonFromBench because this method allows the player
     * to pick from their hand, typically reserved for beginning of game activities.
     * @param player The player who does not have an active pokemon.
     */
    public void noActivePokemon(Player player){
        System.out.println("Number of prize cards: " + player.getPrizeDeck().size());
        System.out.println("Current active pokemon: None");
        System.out.println("Current cards in hand: " + player.getHand());
        System.out.println("Current cards in bench: " + player.getBench());
        System.out.println("Current number of cards in deck: " + player.getDeck().getDeckOfCards().size());
        System.out.println();

        System.out.println("Pick a pokemon to place in your active pokemon spot");

        //Set the broke flag to false and initialize the variable that will hold the pokemon object
        boolean broke = false;
        Pokemon pokemonToBeActive = null;

        //Loop until the user makes a valid choice
        while (true) {

            //Accept user input
            String cardToUse = userInput.nextLine();

            //Loop through the player's hand
            for (Card card : player.getHand()) {

                //Check to see if the card the player wants to use in their hand
                if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {

                    //If the card is in their hand

                    //Check to make sure the player is picking a pokemon and not any other type of card
                    if (card.getPokemon() != null) {

                        //If the player picked a card that is a pokemon

                        //Assign the pokemon to the variable, set the broke flag to true and break out of the loop
                        pokemonToBeActive = card.getPokemon();
                        broke = true;
                        break;
                    }
                }
            }

            //Check the broke flag
            if (broke) {

                //If the flag was marked true, break out of the loop
                break;
            }

            //If the player got to this point, it means they did not pick a valid option

            //Inform the player
            System.out.println("You did not pick a valid option, please pick another card");
        }

        //Inform the player of the action
        System.out.println("Placed " + pokemonToBeActive.getNameOfCard() + " in the active spot");
        System.out.println();

        //Set the active pokemon to the one that was chosen and remove the pokemon from the player's hand
        player.setActivePokemon(pokemonToBeActive);
        player.removeCardFromHand(pokemonToBeActive);
    }

    /**
     * The noActivePokemonFromBench method displays the player's current stats and makes them choose a new pokemon from
     * their bench. This method does this after a player's activePokemon has been knocked out.
     * @param player The player whose activePokemon has been knocked out.
     */
    public void noActivePokemonFromBench(Player player){
        System.out.println("Number of prize cards: " + player.getPrizeDeck().size());
        System.out.println("Current active pokemon: None");
        System.out.println("Current cards in bench: " + player.getBench());
        System.out.println("Current number of cards in deck: " + player.getDeck().getDeckOfCards().size());
        System.out.println();

        //Last win condition, checks to see if the player has no active pokemon left to take its fallen one's place
        if(player.getBench().isEmpty()){

            //If the player has an empty bench, then the other player has knocked out all of this player's active
            //pokemon

            //Inform the players
            System.out.println(player.getPlayerName() + " has no active pokemon and no pokemon in their bench!");

            //Check to see which player lost
            if(player.getPlayerName().equalsIgnoreCase("Player 1")){

                //If player 1 lost, inform the players that player 2 won
                System.out.println("Player 2 is the winner!");

                //Exit out of the program because the game is over
                System.exit(0);
            }else if(player.getPlayerName().equalsIgnoreCase("Player 2")) {

                //Else, if player 2 lost, inform the players that player 1 won
                System.out.println("Player 1 is the winner!");

                //Exit out of the program because the game is over
                System.exit(0);
            }

        }

        //Inform the player of the action they need to take
        System.out.println("Pick a pokemon from your bench to place in your active pokemon spot");

        //Set the broke flag to false and initialize the variable to hold the pokemon object
        boolean broke = false;
        Pokemon pokemonToBeActive = null;

        //Loop through until the player makes a valid choice
        while (true) {

            //Accept user input
            String cardToUse = userInput.nextLine();

            //Loop through the player's bench
            for (Card card : player.getBench()) {

                //Check to see if the player picked a card in their bench
                if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {

                    //If they did, check to make sure they picked a pokemon card
                    if (card.getPokemon() != null) {

                        //If they did pick a pokemon card

                        //Set the card the player wants to use to the variable, set the broke flag to true and
                        //break out of the loop
                        pokemonToBeActive = card.getPokemon();
                        broke = true;
                        break;
                    }
                }
            }

            //Check the broke flag
            if (broke) {

                //If the loop above broke, break again
                break;
            }

            //If the player got to this point, they did not pick a valid option

            //Inform the player
            System.out.println("You did not pick a valid option, please pick another card");
        }

        //Inform the player of the action
        System.out.println("Placed " + pokemonToBeActive.getNameOfCard() + " in the active spot");
        System.out.println();

        //Set the player's active pokemon and remove the pokemon from their bench
        player.setActivePokemon(pokemonToBeActive);
        player.removeCardFromBench(pokemonToBeActive);
    }

    /**
     * The runPlayerTurn method allows the player to run through their turn. This includes putting pokemon on their
     * bench, attaching energies, and using trainer cards.
     * @param player The player whose turn it is.
     */
    public void runPlayerTurn(Player player) {

        //Set up variables needed to track the status of the turn
        int numberOfEnergiesUsed = 0;
        int numberOfSupporterCardsUsed = 0;
        boolean xSpeedUsed = false;
        boolean broke;
        boolean done = false;

        //Loop until the player is done with their turn
        while (true) {

            //Display the stats of the player
            displayPlayerStats(player);

            //Inform the player of the instructions
            System.out.println("Pick a card to continue with your turn (Or type done to move on to the battle phase)");

            //Set the broke flag to false and initialize the cardToBeUsed variable
            broke = false;
            Card cardToBeUsed = null;

            //Loop until the player has made a valid choice
            while (true) {

                //Accept user input
                String cardToUse = userInput.nextLine();

                //If the player types done
                if (cardToUse.equalsIgnoreCase("Done")) {

                    //Inform the player of the action
                    System.out.println("Moving on to battle phase . . .");

                    //Set the done flag to true and break out of the loop
                    done = true;
                    break;
                }

                //
                //Loop through the player's hand
                for (Card card : player1.getHand()) {

                    //Check to see if the card the player wants to use is in their hand
                    if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {

                        //If it is in their hand

                        //Find the index of the card
                        int indexOfCard = player1.getHand().indexOf(card);

                        //Use the variable from earlier to hold that Card object
                        cardToBeUsed = player1.getHand().get(indexOfCard);

                        //Set another flag (broke) equal to true
                        broke = true;

                        //Break out of the loop
                        break;
                    }
                }

                //Because the code above is in a double while loop, we have to break out again
                if (broke) {

                    //If the broke flag is true

                    //Break again
                    break;
                }

                //If the player gets to this point, it means they have not picked a valid response to break
                //them out of the loop

                //Inform the player of this
                System.out.println("You did not pick a valid option, please pick another card");
                System.out.println();
            }

            //Check the done flag
            if (done) {

                //If the player typed done

                //Break out of the loop and skip to the next phase
                break;
            }

            //Now we need to check what type of card the player is trying to use

            //Check to see what type the card is and hold in it the typeOfCard variable
            String typeOfCard = cardToBeUsed.checkTypeOfCard();

            //Check to see what type of card the player played
            if (typeOfCard.equals("Trainer")) {

                //If the player used a trainer card

                //Check to see if the player is using a supporter card and if they have used a supporter card
                //already
                if (cardToBeUsed.getTrainer().getTypeOfTrainerCard().equals("Supporter") &&
                        numberOfSupporterCardsUsed < MAX_SUPPORTERS_USED) {

                    //If the player is using a supporter card, and they have not used one before

                    //Use the ability of the card
                    cardToBeUsed.getTrainer().useAbility(player1);

                    //Remove the card from the player's hand and add the card to the player's discard pile
                    player1.removeCardFromHand(cardToBeUsed);
                    player1.addCardToDiscard(cardToBeUsed);

                    //Increment the numberOfSupporterCardsUsed flag
                    numberOfSupporterCardsUsed++;

                } else if (!cardToBeUsed.getTrainer().getTypeOfTrainerCard().equals("Supporter")) {

                    //Else, if the card the player wants to use is a trainer card that is not also a supporter card

                    //Check if it is an X Speed
                    if (cardToBeUsed.getTrainer().getNameOfCard().equals("X Speed")) {

                        //If it is

                        //Set the xSpeedUsed flag to true
                        xSpeedUsed = true;
                    }

                    //Use the card's ability, remove the card from the player's hand and add it their discard pile
                    cardToBeUsed.getTrainer().useAbility(player1);
                    player1.removeCardFromHand(cardToBeUsed);
                    player1.addCardToDiscard(cardToBeUsed);

                } else {

                    //Else, the player has chosen a supporter card and has already used one

                    //Inform the player
                    System.out.println("You've already used a supporter card this turn, pick another card.");
                    System.out.println();

                }
            } else if (typeOfCard.equals("Pokemon")) {

                //Else, if the card the player wants to use is a Pokemon

                //Add the card to the player's bench and remove the card from the player's hand
                player1.addCardToBench(cardToBeUsed);
                player1.removeCardFromHand(cardToBeUsed);

                //Inform the player
                System.out.println("Added card to bench");
                System.out.println();

            } else if (typeOfCard.equals("Energy")) {

                //Else, if the card the player wants to use is an energy

                //Check to make sure the player has not already used an energy during this turn
                if (numberOfEnergiesUsed < MAX_ENERGIES_PLACED) {

                    //If they have not used an energy yet

                    //Ask the player which pokemon they want to give it to
                    System.out.println("What pokemon do you want to add the energy to?");

                    //Show the player their active pokemon and the pokemon in their bench
                    System.out.println("Active pokemon: " + player1.getActivePokemon() + " Benched pokemon: " +
                            player1.getBench());

                    //Create an ArrayList that holds all the pokemon in the player's active slot and in their bench
                    ArrayList<Card> allPokemon = new ArrayList<>();
                    allPokemon.add(player1.getActivePokemon());
                    allPokemon.addAll(player1.getBench());


                    //Set a flag and initialize variable to hold the card when found
                    broke = false;
                    Pokemon pokemonToBeUsed = null;

                    //Loop until the player gives a valid response
                    while (true) {

                        //Accept user input
                        String cardToFind = userInput.nextLine();

                        //Loop through all the pokemon the player has placed
                        for (Card card : allPokemon) {

                            //Check to see if the card the player wants to use is in the list
                            if (card.getNameOfCard().equalsIgnoreCase(cardToFind)) {

                                //If the name is equal to the player's input

                                //Grab the index of the card
                                int indexOfCard = allPokemon.indexOf(card);

                                //Assign the card to the temp variable created above
                                pokemonToBeUsed = (Pokemon) allPokemon.get(indexOfCard);

                                //Set the flag to true and break out of the loop
                                broke = true;
                                break;
                            }
                        }

                        //Since we are in a double loop, check the flag variable
                        if (broke) {

                            //If the flag is true

                            //Break out of the loop again
                            break;
                        }

                        //If the player reached this point, it means they did not pick a card available

                        //Inform the player
                        System.out.println("You did not pick a valid option, please pick another card");
                        System.out.println();
                    }

                    //Use the attachEnergy method to add the energy to the pokemon card chosen
                    pokemonToBeUsed.attachEnergy((Energy) cardToBeUsed);

                    //Increment the numberOfEnergiesUsed flag
                    numberOfEnergiesUsed++;

                    //Remove the energy card from the player's hand
                    player1.removeCardFromHand(cardToBeUsed);

                    //Inform the player of the action
                    System.out.println("Added " + cardToBeUsed.getNameOfCard() + " to " +
                            pokemonToBeUsed.getNameOfCard());
                    System.out.println();

                } else {

                    //Else, the player has already placed on energy card this turn

                    //Inform the player of this
                    System.out.println("You have already placed an energy this turn. Please choose another card.");
                }
            }

        }

        //Once we have reached this part of the code, the player has indicated that they have completed their
        //turn. Because we are in player1's first turn, we now go to player2's first turn

        //Check to see if an XSpeed has been used
        if(xSpeedUsed){

            //If one has been used, now that it is the end of the player's turn, give the pokemon the retreat
            //cost back
            player1.getActivePokemon().addOneRetreatCost();
        }
    }

    /**
     * The battlePhase method handles the battling stage of the game. It asks the user which attack they would like
     * to use and then checks if it is a valid choice (pokemon has enough energies and correct types).
     * @param attackingPlayer The player who is attacking.
     * @param defendingPlayer The player who is defending.
     */
    public void battlePhase(Player attackingPlayer, Player defendingPlayer){

        //Inform the player of the battle phase, the state of their pokemon and the attacks that can be used
        System.out.println("Now in the battle phase . . .");
        System.out.println();
        System.out.println("Your active pokemon is: " + attackingPlayer.getActivePokemon());
        System.out.println("Energies attached to active pokemon: " +
                attackingPlayer.getActivePokemon().getEnergiesAttached().size());
        System.out.println();
        System.out.println("Attacks for " + attackingPlayer.getActivePokemon() + " are " +
                attackingPlayer.getActivePokemon().getAttacks());
        System.out.println("What attack do you want to use? (if you cannot attack, type done)");

        //Set the broke flag to false
        boolean broke = false;

        //Loop until the player makes a valid choice
        while (true) {

            //Accept user input
            String attackChoice = userInput.nextLine();

            //Check to see if the player typed done
            if(attackChoice.equalsIgnoreCase("done")){

                //If they did, break out of the loop
                break;
            }

            //Loop through the attacks that the active pokemon has
            for (Attack attack : attackingPlayer.getActivePokemon().getAttacks()) {

                //Check to see if the player picked a valid attack
                if (attack.getAttackName().equalsIgnoreCase(attackChoice)) {

                    //If the player picked a valid attack

                    //Check to see if the pokemon has enough energy to perform the attack
                    if(attackingPlayer.getActivePokemon().checkIfAttackIsValid(attack)){

                        //If the pokemon does have enough energy

                        //Have the active pokemon attack the other player's active pokemon
                        attackingPlayer.getActivePokemon().battle(attack, defendingPlayer.getActivePokemon());

                        //Inform the player of the action
                        System.out.println("Player attack complete . . .");
                        System.out.println();

                        //Set the broke flag to true and break out of the loop
                        broke = true;
                        break;
                    }
                }
            }

            //Check the broke flag
            if (broke) {

                //If the above loop was broken out of, break again
                break;
            }

            //If the player made it to this point, it means that they did not make a valid choice

            //Inform the player
            System.out.println("You did not pick a valid option, please pick another attack");
            System.out.println();
        }
    }

}
