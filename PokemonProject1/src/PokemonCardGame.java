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

        //
        ArrayList<Card> hand = playerWithMulligan.getHand();

        System.out.println("Mulligan Detected, showing player's hand");
        System.out.println();

        //
        for(Card card : hand){
            System.out.println(card);
        }

        System.out.println();
        System.out.println("Returning cards to deck and picking a new hand . . .");
        System.out.println();

        //
        playerWithMulligan.setHand(playerWithMulligan.getDeck().returnHandToDeck(hand));
    }

    /**
     * The player1Turn method handles the core functionalities of a player turn.
     */
    public void player1Turn(){

        //
        if(firstTurnCheck){

            //
            noActivePokemon(player1);

            //
            player1.addCardToHand();

            //
            int numberOfEnergiesUsed = 0;
            int numberOfSupporterCardsUsed = 0;
            boolean xSpeedUsed = false;
            boolean broke;
            boolean done = false;

            //
            while (true) {

                //
                displayPlayerStats(player1);

                System.out.println("Pick a card to continue with your turn (Or type done to move on to the next " +
                        "player's turn)");

                //
                broke = false;
                Card cardToBeUsed = null;

                //
                while (true) {

                    //
                    String cardToUse = userInput.nextLine();

                    //
                    if (cardToUse.equalsIgnoreCase("Done")) {
                        System.out.println("Moving on to next player's turn . . .");
                        done = true;
                        break;
                    }

                    //
                    for (Card card : player1.getHand()) {

                        //
                        if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {

                            //
                            int indexOfCard = player1.getHand().indexOf(card);

                            //
                            cardToBeUsed = player1.getHand().get(indexOfCard);

                            //
                            broke = true;
                            break;
                        }
                    }

                    //
                    if (broke) {
                        break;
                    }

                    System.out.println("You did not pick a valid option, please pick another card");
                    System.out.println();
                }

                //
                if (done) {
                    break;
                }

                //
                String typeOfCard = cardToBeUsed.checkTypeOfCard();

                //
                if (typeOfCard.equals("Trainer")) {

                    //
                    if (cardToBeUsed.getTrainer().getTypeOfTrainerCard().equals("Supporter") &&
                            numberOfSupporterCardsUsed < MAX_SUPPORTERS_USED) {

                        //
                        cardToBeUsed.getTrainer().useAbility(player1);

                        //
                        player1.removeCardFromHand(cardToBeUsed);
                        player1.addCardToDiscard(cardToBeUsed);

                        //
                        numberOfSupporterCardsUsed++;

                    } else if (!cardToBeUsed.getTrainer().getTypeOfTrainerCard().equals("Supporter")) {

                        //

                        //
                        if (cardToBeUsed.getTrainer().getNameOfCard().equals("X Speed")) {
                            xSpeedUsed = true;
                        }

                        //
                        cardToBeUsed.getTrainer().useAbility(player1);
                        player1.removeCardFromHand(cardToBeUsed);
                        player1.addCardToDiscard(cardToBeUsed);

                    } else {

                        System.out.println("You've already used a supporter card this turn, pick another card.");
                        System.out.println();

                    }
                } else if (typeOfCard.equals("Pokemon")) {

                    //
                    player1.addCardToBench(cardToBeUsed);
                    player1.removeCardFromHand(cardToBeUsed);

                    System.out.println("Added card to bench");
                    System.out.println();

                } else if (typeOfCard.equals("Energy")) {

                    //

                    //
                    if (numberOfEnergiesUsed < MAX_ENERGIES_PLACED) {
                        System.out.println("What pokemon do you want to add the energy to?");

                        System.out.println("Active pokemon: " + player1.getActivePokemon() + " Benched pokemon: " +
                                player1.getBench());

                        //
                        ArrayList<Card> allPokemon = new ArrayList<>();
                        allPokemon.addAll(player1.getBench());
                        allPokemon.add(player1.getActivePokemon());

                        //
                        broke = false;
                        Pokemon pokemonToBeUsed = null;

                        //
                        while (true) {

                            String cardToFind = userInput.nextLine();

                            //Added specialized case to check if more than one pokemon share the same name
                            //if they do, add additional prompt that asks the user which one they want to give it to

                            //
                            for (Card card : allPokemon) {

                                //
                                if (card.getNameOfCard().equalsIgnoreCase(cardToFind)) {

                                    //
                                    int indexOfCard = allPokemon.indexOf(card);

                                    //
                                    pokemonToBeUsed = (Pokemon) allPokemon.get(indexOfCard);
                                    player1.removeCardFromHand(card);

                                    //
                                    broke = true;
                                    break;
                                }
                            }

                            //
                            if (broke) {
                                break;
                            }
                            System.out.println("You did not pick a valid option, please pick another card");
                            System.out.println();
                        }

                        //
                        pokemonToBeUsed.attachEnergy((Energy) cardToBeUsed);
                        numberOfEnergiesUsed++;
                        player1.removeCardFromHand(cardToBeUsed);

                        System.out.println("Added " + cardToBeUsed.getNameOfCard() + " to " +
                                pokemonToBeUsed.getNameOfCard());

                        System.out.println();
                    } else {
                        System.out.println("You have already placed an energy this turn. Please choose another card.");
                    }
                }

                //
                firstTurnCheck = false;

            }
        }else{

            //
            if(player1.getActivePokemon() == null) {

                //
                noActivePokemon(player1);

            }

            //
            player1.addCardToHand();

            //
            runPlayerTurn(player1);

            //
            battlePhase(player1, player2);
        }
    }

    /**
     * The player2Turn method handles the care functionalities of a player turn.
     */
    public void player2Turn(){

        //
        if(player2.getActivePokemon() == null) {

            //
            noActivePokemon(player2);

        }

        //
        player2.addCardToHand();

        //
        runPlayerTurn(player2);

        //
        battlePhase(player2, player1);
    }

    /**
     * The runGame method runs the Pokemon TCG game.
     */
    public void runGame(){

        //
        while(!player1.getPrizeDeck().isEmpty() && !player2.getPrizeDeck().isEmpty()) {
            //
            player1Turn();

            //
            if (player2.getActivePokemon() == null) {

            } else if (player1.getPrizeDeck().isEmpty()) {
                break;
            } else if (player2.isKnockedOut()) {
                //
                player2.addCardToDiscard(player2.getActivePokemon());

                //
                player1.addPrizeCardToHand();

                //
                noActivePokemonFromBench(player2);
            }

            //
            player2Turn();


            if (player1.getActivePokemon() == null) {

            }else if(player2.getPrizeDeck().isEmpty()){
                break;
            }else if(player1.isKnockedOut()){

                //
                player1.addCardToDiscard(player1.getActivePokemon());

                //
                player2.addPrizeCardToHand();

                //
                noActivePokemonFromBench(player1);

            }


            //run checks after the turns to make sure that special cases are handled
        }

        if(player1.getPrizeDeck().isEmpty()){
            System.out.println("Player 2 won the game!");
            System.exit(0);
        }else if(player2.getPrizeDeck().isEmpty()){
            System.out.println("Player 1 won the game!");
            System.exit(0);
        }
    }

    /**
     * The addCardToOtherPlayer method handles when the other player should get another card due to a mulligan.
     * @param playerToGetExtraCard The player that should receive the extra card.
     */
    public void addCardToOtherPlayer(Player playerToGetExtraCard){

        //
        playerToGetExtraCard.getHand().add(playerToGetExtraCard.getDeck().pickTopCard());
    }

    /**
     * The displayPlayerStats method prints out the current statistics for a player.
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

        //
        boolean broke = false;
        Pokemon pokemonToBeActive = null;

        //
        while (true) {

            //
            String cardToUse = userInput.nextLine();

            //
            for (Card card : player.getHand()) {

                //
                if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {

                    //
                    if (card.getPokemon() != null) {

                        //
                        pokemonToBeActive = card.getPokemon();
                        broke = true;
                        break;
                    }
                }
            }

            //
            if (broke) {
                break;
            }
            System.out.println("You did not pick a valid option, please pick another card");
        }


        //
        System.out.println("Placed " + pokemonToBeActive.getNameOfCard() + " in the active spot");

        System.out.println();

        //
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

        System.out.println("Pick a pokemon from your bench to place in your active pokemon spot");

        //
        boolean broke = false;
        Pokemon pokemonToBeActive = null;

        //
        while (true) {

            //
            String cardToUse = userInput.nextLine();

            //
            for (Card card : player.getBench()) {

                //
                if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {

                    //
                    if (card.getPokemon() != null) {

                        //
                        pokemonToBeActive = card.getPokemon();
                        broke = true;
                        break;
                    }
                }
            }

            //
            if (broke) {
                break;
            }
            System.out.println("You did not pick a valid option, please pick another card");
        }

        //
        System.out.println("Placed " + pokemonToBeActive.getNameOfCard() + " in the active spot");

        System.out.println();

        //
        player.setActivePokemon(pokemonToBeActive);
        player.removeCardFromBench(pokemonToBeActive);
    }

    /**
     * The runPlayerTurn method allows the player to run through their turn. This includes putting pokemon on their
     * bench, attaching energies, and using trainer cards.
     * @param player The player whose turn it is.
     */
    public void runPlayerTurn(Player player) {

        //
        int numberOfEnergiesUsed = 0;
        int numberOfSupporterCardsUsed = 0;
        boolean xSpeedUsed = false;
        boolean broke;
        boolean done = false;

        //
        while (true) {

            //
            displayPlayerStats(player);

            System.out.println("Pick a card to continue with your turn (Or type done to move on to the battle phase)");

            //
            broke = false;
            Card cardToBeUsed = null;

            //
            while (true) {

                //
                String cardToUse = userInput.nextLine();

                //
                if (cardToUse.equalsIgnoreCase("Done")) {
                    System.out.println("Moving on to battle phase . . .");
                    done = true;
                    break;
                }

                //
                for (Card card : player.getHand()) {

                    //
                    if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {

                        //
                        int indexOfCard = player.getHand().indexOf(card);

                        //
                        cardToBeUsed = player.getHand().get(indexOfCard);

                        //
                        broke = true;
                        break;
                    }
                }

                //
                if (broke) {
                    break;
                }

                System.out.println("You did not pick a valid option, please pick another card");
                System.out.println();
            }

            //
            if (done) {
                break;
            }

            //
            String typeOfCard = cardToBeUsed.checkTypeOfCard();

            //
            if (typeOfCard.equals("Trainer")) {

                //
                if (cardToBeUsed.getTrainer().getTypeOfTrainerCard().equals("Supporter") &&
                        numberOfSupporterCardsUsed < MAX_SUPPORTERS_USED) {

                    //
                    cardToBeUsed.getTrainer().useAbility(player);

                    //
                    player.removeCardFromHand(cardToBeUsed);
                    player.addCardToDiscard(cardToBeUsed);

                    //
                    numberOfSupporterCardsUsed++;

                } else if (!cardToBeUsed.getTrainer().getTypeOfTrainerCard().equals("Supporter")) {

                    //

                    //
                    if (cardToBeUsed.getTrainer().getNameOfCard().equals("X Speed")) {
                        xSpeedUsed = true;
                    }

                    //
                    cardToBeUsed.getTrainer().useAbility(player);

                    player.removeCardFromHand(cardToBeUsed);
                    player.addCardToDiscard(cardToBeUsed);

                } else {

                    System.out.println("You've already used a supporter card this turn, pick another card.");
                    System.out.println();

                }
            } else if (typeOfCard.equals("Pokemon")) {

                //
                player.addCardToBench(cardToBeUsed);
                player.removeCardFromHand(cardToBeUsed);

                System.out.println("Added card to bench");
                System.out.println();

            } else if (typeOfCard.equals("Energy")) {

                //

                //
                if (numberOfEnergiesUsed < MAX_ENERGIES_PLACED) {
                    System.out.println("What pokemon do you want to add the energy to?");

                    System.out.println("Active pokemon: " + player.getActivePokemon() + " Benched pokemon: " +
                            player.getBench());

                    //
                    ArrayList<Card> allPokemon = new ArrayList<>();
                    allPokemon.addAll(player.getBench());
                    allPokemon.add(player.getActivePokemon());

                    //
                    broke = false;
                    Pokemon pokemonToBeUsed = null;

                    //
                    while (true) {

                        String cardToFind = userInput.nextLine();

                        //Added specialized case to check if more than one pokemon share the same name
                        //if they do, add additional prompt that asks the user which one they want to give it to

                        //
                        for (Card card : allPokemon) {

                            //
                            if (card.getNameOfCard().equalsIgnoreCase(cardToFind)) {

                                //
                                int indexOfCard = allPokemon.indexOf(card);

                                //
                                pokemonToBeUsed = (Pokemon) allPokemon.get(indexOfCard);
                                player.removeCardFromHand(card);

                                //
                                broke = true;
                                break;
                            }
                        }

                        //
                        if (broke) {
                            break;
                        }
                        System.out.println("You did not pick a valid option, please pick another card");
                        System.out.println();
                    }

                    //
                    pokemonToBeUsed.attachEnergy((Energy) cardToBeUsed);
                    numberOfEnergiesUsed++;

                    player.removeCardFromHand(cardToBeUsed);

                    System.out.println("Added " + cardToBeUsed.getNameOfCard() + " to " +
                            pokemonToBeUsed.getNameOfCard());

                    System.out.println();
                } else {
                    System.out.println("You have already placed an energy this turn. Please choose another card.");
                }
            }

        }

        //
        if (xSpeedUsed) {
            player.getActivePokemon().addOneRetreatCost();
        }
    }

    /**
     * The battlePhase method handles the battling stage of the game. It asks the user which attack they would like
     * to use and then checks if it is a valid choice (pokemon has enough energies and correct types).
     * @param attackingPlayer The player who is attacking.
     * @param defendingPlayer The player who is defending.
     */
    public void battlePhase(Player attackingPlayer, Player defendingPlayer){

        System.out.println("Now in the battle phase . . .");

        System.out.println();

        System.out.println("Your active pokemon is: " + attackingPlayer.getActivePokemon());

        System.out.println("Energies attached to active pokemon: " + attackingPlayer.getActivePokemon().getEnergiesAttached());

        System.out.println();

        System.out.println("Attacks for " + attackingPlayer.getActivePokemon() + " are " +
                attackingPlayer.getActivePokemon().getAttacks());

        System.out.println("What attack do you want to use? (if you cannot attack, type done)");

        boolean broke = false;

        //
        while (true) {

            String attackChoice = userInput.nextLine();

            if(attackChoice.equalsIgnoreCase("done")){
                break;
            }

            //
            for (Attack attack : attackingPlayer.getActivePokemon().getAttacks()) {

                //
                if (attack.getAttackName().equalsIgnoreCase(attackChoice)) {

                    //
                    if(attackingPlayer.getActivePokemon().checkIfAttackIsValid(attack,
                            attackingPlayer.getActivePokemon().getEnergiesAttached())){

                        //
                        attackingPlayer.getActivePokemon().battle(attackingPlayer.getActivePokemon(), attack,
                                defendingPlayer.getActivePokemon());

                        System.out.println("Player attack complete . . .");

                        //
                        broke = true;
                        break;
                    }
                }
            }

            //
            if (broke) {
                break;
            }
            System.out.println("You did not pick a valid option, please pick another attack");
            System.out.println();
        }

    }

}
