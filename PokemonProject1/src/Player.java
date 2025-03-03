import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Player class handles the state of the player.
 * @author Rachel Hussmann
 */
public class Player {

    private Deck deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizeDeck;
    private ArrayList<Card> bench;
    private Pokemon activePokemon;
    private ArrayList<Card> discardPile;
    private String playerName;
    private final Scanner userInput = new Scanner(System.in);
    private int numberOfSupporterCardsUsed;
    private int numberOfEnergiesUsed;
    private boolean xSpeedUsed;

    /**
     * Default constructor
     */
    public Player(){
        deck = new Deck();
        deck.generateDeck();
        deck.shuffle();
        hand = new ArrayList<>();
        prizeDeck = new ArrayList<>();
        bench = new ArrayList<>();
        discardPile = new ArrayList<>();
        numberOfSupporterCardsUsed = 0;
        numberOfEnergiesUsed = 0;
        xSpeedUsed = false;
    }

    /**
     * The createHand method creates a new hand of 7 cards for a player.
     */
    public void createHand(){
        for(int i = 0; i < 7; i++){
            hand.add(deck.pickTopCard());
        }
    }

    /**
     * The pickPrizeDeck method picks a prize deck of 6 cards for the player.
     */
    public void pickPrizeDeck(){
        for(int i = 0; i < 6; i++){
            prizeDeck.add(deck.pickTopCard());
        }
    }

    /**
     * Getter method for the variable deck
     * @return The current deck of cards
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Setter method for the deck variable
     * @param deck The new deck of cards
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Getter method for the hand variable
     * @return The current hand of cards
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Setter method for the hand variable
     * @param hand The new hand of cards
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * Getter method for the prizeDeck variable
     * @return The current prize deck
     */
    public ArrayList<Card> getPrizeDeck() {
        return prizeDeck;
    }

    /**
     * Setter method for the prizeDeck variable
     * @param prizeDeck The new prize deck
     */
    public void setPrizeDeck(ArrayList<Card> prizeDeck) {
        this.prizeDeck = prizeDeck;
    }

    /**
     * Getter method for the bench variable
     * @return The ArrayList of cards in the bench
     */
    public ArrayList<Card> getBench() {
        return bench;
    }

    /**
     * Setter method for the bench
     * @param bench The new ArrayList of cards in the bench
     */
    public void setBench(ArrayList<Card> bench) {
        this.bench = bench;
    }

    /**
     * Getter method for the activePokemon variable
     * @return The current active pokemon
     */
    public Pokemon getActivePokemon() {
        return (Pokemon) activePokemon;
    }

    /**
     * Setter method for the activePokemon variable
     * @param activePokemon The new active pokemon
     */
    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    /**
     * Getter method for the discardPile variable
     * @return The discard pile
     */
    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    /**
     * Setter method for the discardPile variable
     * @param discardPile The new discard pile
     */
    public void setDiscardPile(ArrayList<Card> discardPile) {
        this.discardPile = discardPile;
    }

    /**
     * The removeCardFromHand method removes the given card from the hand of the player.
     * @param cardToBeRemoved The card to be removed from the players hand.
     */
    public void removeCardFromHand(Card cardToBeRemoved){
        hand.remove(cardToBeRemoved);
    }

    /**
     * The removeCardFromBench method removes a card from the bench.
     * @param cardToBeRemoved The card to be removed from the bench.
     */
    public void removeCardFromBench(Card cardToBeRemoved){
        bench.remove(cardToBeRemoved);
    }

    /**
     * The addCardToDiscard adds the given card from the player's playing space and adds it to the discardPile.
     * @param cardToBeAdded The card to be added to the discard pile.
     */
    public void addCardToDiscard(Card cardToBeAdded){
        discardPile.add(cardToBeAdded);
    }

    /**
     * The addCardToHand method takes one card from the deck and adds it to the player hand.
     */
    public void addCardToHand(){
        hand.add(deck.pickTopCard());
    }

    /**
     * the addPrizeCardToHand method adds one card from the prize deck into the player's hand.
     */
    public void addPrizeCardToHand(){
        hand.add(prizeDeck.removeFirst());
    }

    /**
     * The addCardToBench method takes one card and adds it to the player's bench.
     * @param cardToAdd The pokemon card to add to the player's bench.
     */
    public void addCardToBench(Card cardToAdd){
        bench.add(cardToAdd);
    }

    /**
     * The isKnockedOut method checks to see if this player's active pokemon is knocked out.
     * @return true - if the pokemon has no HP left, false - if the pokemon still has some HP left
     */
    public boolean isKnockedOut(){
        return this.getActivePokemon().getHp() <= 0;
    }

    /**
     * Getter for the player name variable
     * @return The name of the player
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Setter for the player name variable
     * @param playerName The new name for the player
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * The displayPlayerStats method prints out the current statistics for a player, including, number of prize cards
     * left in their prize deck, the current active pokemon, the HP of their active pokemon, the cards they have in
     * their hand, the pokemon in their bench and the current number of cards they have left in their deck.
     */
    public void displayPlayerStats(){
        System.out.println("Number of prize cards: " + getPrizeDeck().size());
        System.out.println("Current active pokemon: " + getActivePokemon());
        System.out.println("Current HP of active Pokemon: " + getActivePokemon().getHp());
        System.out.println("Current cards in hand: " + getHand());
        System.out.println("Current cards in bench: " + getBench());
        System.out.println("Current number of cards in deck: " + getDeck().getDeckOfCards().size());
        System.out.println();
    }

    /**
     * The runPlayerTurn method allows the player to run through their turn. This includes putting pokemon on their
     * bench, attaching energies, and using trainer cards.
     * @param firstTurnCheck A boolean variable to see if it is the first turn of the game
     */
    public void runPlayerTurn(boolean firstTurnCheck) {

        numberOfSupporterCardsUsed = 0;
        numberOfEnergiesUsed = 0;
        xSpeedUsed = false;

        //Set up variables needed to track the status of the turn
        boolean broke;
        boolean done = false;

        //Loop until the player is done with their turn
        while (true) {

            //Display the stats of the player
            displayPlayerStats();

            //Inform the player of the instructions
            if(firstTurnCheck){
                System.out.println("Pick a card to continue with your turn (Or type done to move on the next " +
                        "player's turn)");
            }else {
                System.out.println("Pick a card to continue with your turn (Or type done to move on to the battle " +
                        "phase)");
            }

            System.out.println("You may also type retreat to retreat your active pokemon");

            //Set the broke flag to false and initialize the cardToBeUsed variable
            broke = false;
            Card cardToBeUsed = null;

            //Loop until the player has made a valid choice
            while (true) {

                //Accept user input
                String cardToUse = userInput.nextLine();

                //If the player types done and it is the first turn of the game
                if (cardToUse.equalsIgnoreCase("Done")&&firstTurnCheck) {

                    //Inform the player of the action
                    System.out.println("Moving on to next player's turn");

                    //Set the done flag to true and break out of the loop
                    done = true;
                    break;
                }else if(cardToUse.equalsIgnoreCase("Done")){

                    //else if the player typed done

                    //Inform the player of the action
                    System.out.println("Moving on to battle phase . . . ");

                    //Set the done flag to true and break out of the loop
                    done = true;
                    break;

                }else if(cardToUse.equalsIgnoreCase("Retreat")){

                    //Else if the player typed retreat

                    //Run the retreat method
                    retreatActivePokemon();

                    //Display the stats of the player
                    displayPlayerStats();

                    //Inform the player of the instructions
                    if(firstTurnCheck){
                        System.out.println("Pick a card to continue with your turn (Or type done to move on the next " +
                                "player's turn)");
                    }else {
                        System.out.println("Pick a card to continue with your turn (Or type done to move on to the " +
                                "battle phase)");
                    }

                }else {

                    //Else, let the player use a card from their hand

                    //Loop through the player's hand
                    for (Card card : getHand()) {

                        //Check to see if the card the player wants to use is in their hand
                        if (card.getNameOfCard().equalsIgnoreCase(cardToUse)) {

                            //If it is in their hand

                            //Find the index of the card
                            int indexOfCard = getHand().indexOf(card);

                            //Use the variable from earlier to hold that Card object
                            cardToBeUsed = getHand().get(indexOfCard);

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
            }

            //Check the done flag
            if (done) {

                //If the player typed done

                //Break out of the loop and skip to the next phase
                break;
            }

            //Now we need to check what type of card the player is trying to use

            //Use the card
            useCard(cardToBeUsed);

        }

        //Check to see if an XSpeed has been used
        if(xSpeedUsed){

            //If one has been used, now that it is the end of the player's turn, give the pokemon the retreat
            //cost back
            getActivePokemon().addOneRetreatCost();
        }
    }

    /**
     * The displayPlayerStatsNoActive displays the player's stats when they have no active Pokemon. This method is
     * used for specific cases, such as when the player first begins the game and has no Pokemon or when the player has
     * a Pokemon that gets knocked out due to battle.
     */
    public void displayPlayerStatsNoActive(){
        System.out.println("Number of prize cards: " + getPrizeDeck().size());
        System.out.println("Current active pokemon: None");
        System.out.println("Current cards in hand: " + getHand());
        System.out.println("Current cards in bench: " + getBench());
        System.out.println("Current number of cards in deck: " + getDeck().getDeckOfCards().size());
        System.out.println();
    }

    /**
     * The noActivePokemon method prints out the current stats for a player and handles when the player does not have an
     * active pokemon. This method is different from noActivePokemonFromBench because this method allows the player
     * to pick from their hand, typically reserved for beginning of game activities.
     */
    public void noActivePokemon(){

        //display the player's stats with no active pokemon
        displayPlayerStatsNoActive();

        //Inform the player of the instructions
        System.out.println("Pick a pokemon to place in your active pokemon spot");

        //Set the broke flag to false and initialize the variable that will hold the pokemon object
        boolean broke = false;
        Pokemon pokemonToBeActive = null;

        //Loop until the user makes a valid choice
        while (true) {

            //Accept user input
            String cardToUse = userInput.nextLine();

            //Loop through the player's hand
            for (Card card : getHand()) {

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
        setActivePokemon(pokemonToBeActive);
        removeCardFromHand(pokemonToBeActive);
    }

    /**
     * The noActivePokemonFromBench method displays the player's current stats and makes them choose a new pokemon from
     * their bench. This method does this after a player's activePokemon has been knocked out.
     */
    public void noActivePokemonFromBench(){

        //Show the player the current cards that they have
        displayPlayerStatsNoActive();

        //Last win condition, checks to see if the player has no active pokemon left to take its fallen one's place
        if(this.getBench().isEmpty()){

            //If the player has an empty bench, then the other player has knocked out all of this player's active
            //pokemon

            //Inform the players
            System.out.println(getPlayerName() + " has no active pokemon and no pokemon in their bench!");

            //Check to see which player lost
            if(getPlayerName().equalsIgnoreCase("Player 1")){

                //If player 1 lost, inform the players that player 2 won
                System.out.println("Player 2 is the winner!");

                //Exit out of the program because the game is over
                System.exit(0);
            }else if(getPlayerName().equalsIgnoreCase("Player 2")) {

                //Else, if player 2 lost, inform the players that player 1 won
                System.out.println("Player 1 is the winner!");

                //Exit out of the program because the game is over
                System.exit(0);
            }

        }

        //Otherwise, let the player pick a new pokemon from their bench
        pickPokemonFromBench();
    }

    /**
     * The battlePhase method handles the battling stage of the game. It asks the user which attack they would like
     * to use and then checks if it is a valid choice (pokemon has enough energies).
     * @param defendingPlayer The player who is defending.
     */
    public void battlePhase(Player defendingPlayer){

        //Inform the player of the battle phase, the state of their pokemon and the attacks that can be used
        System.out.println("Now in the battle phase . . .");
        System.out.println();
        System.out.println("Your active pokemon is: " + getActivePokemon());
        System.out.println("Energies attached to active pokemon: " +
                getActivePokemon().getEnergiesAttached().size());
        System.out.println();
        System.out.println("Attacks for " + getActivePokemon() + " are " +
                getActivePokemon().getAttacks());
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
            for (Attack attack : getActivePokemon().getAttacks()) {

                //Check to see if the player picked a valid attack
                if (attack.getAttackName().equalsIgnoreCase(attackChoice)) {

                    //If the player picked a valid attack

                    //Check to see if the pokemon has enough energy to perform the attack
                    if(this.getActivePokemon().checkIfAttackIsValid(attack)){

                        //If the pokemon does have enough energy

                        //Have the active pokemon attack the other player's active pokemon
                        this.getActivePokemon().battle(attack, defendingPlayer.getActivePokemon());

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



    /**
     * The retreatActivePokemon method checks to see if the active pokemon can be retreated to the bench, moves
     * the active pokemon back to the bench, and then allows the player to pick a new pokemon from their bench
     * to take the old active pokemon's place.
     */
    public void retreatActivePokemon(){

        //Check to see if the pokemon can be retreated and the bench is not empty
        if(this.activePokemon.checkForRetreat() && !bench.isEmpty()){

            //If both conditions are true

            //Check to see if the pokemon has an equal number of energies attached as the retreat cost
            if(activePokemon.getEnergiesAttached().size() == activePokemon.getRetreatCost()){

                //If that is true

                //Add the energies to the discardPile and clear the list of energies attached to the active pokemon
                discardPile.addAll(activePokemon.getEnergiesAttached());
                activePokemon.getEnergiesAttached().clear();

                //Inform the player
                System.out.println("Energies have been successfully removed, retreating active Pokemon . . . ");

                //Add the active pokemon to the bench, set the active pokemon to null and show the player their current
                //bench
                addCardToBench(activePokemon);
                activePokemon = null;
                System.out.println("Current Bench: " + bench);

                //Allow the player to pick a new active pokemon from their bench
                pickPokemonFromBench();

            }else{

                //Set the retreatCost variable to 1 and the broke variable to false
                int retreatCost = 1;
                boolean broke = false;

                //Run the loop until tha player removes enough energies from the active pokemon
                while(retreatCost <= activePokemon.getRetreatCost()){

                    //Inform the player of the instructions and of the energies attached to their active pokemon
                    System.out.println("Pick energy " + retreatCost + " to remove from your active pokemon.");
                    System.out.println(activePokemon.getEnergiesAttached());

                    //Accept user input
                    String energyChoice = userInput.nextLine();

                    //Set the cardToRemove variable to null
                    Card cardToRemove = null;

                    //Loop through the energies attached to the active pokemon
                    for(Card card : activePokemon.getEnergiesAttached()){

                        //Check to see if the card the player wants to remove is actually an option
                        if(card.getNameOfCard().equalsIgnoreCase(energyChoice)){

                            //If it is

                            //Set the cardToRemove variable to the energy card, the broke flag to true and break out of
                            //the loop
                            cardToRemove = card;
                            broke = true;
                            break;
                        }
                    }

                    //Check the broke flag
                    if(broke){

                        //If the broke flag is true

                        //Remove the card from the pokemon's attached energies, place it in the discardPile and
                        //increment the retreatCost variable
                        activePokemon.getEnergiesAttached().remove(cardToRemove);
                        addCardToDiscard(cardToRemove);
                        retreatCost++;
                    }else {

                        //Else, the player did not pick a valid option

                        //Inform the player
                        System.out.println("That is not a valid energy, please choose another energy card.");
                    }
                }

                //Inform the player of the action
                System.out.println("Retreating active Pokemon . . . ");

                //Add the active pokemon to the bench, set the active pokemon to null and show the player their current
                //bench
                addCardToBench(activePokemon);
                activePokemon = null;
                System.out.println("Current Bench: " + bench);

                //Allow the player to pick a new active pokemon from their bench
                pickPokemonFromBench();
            }


        }else{

            //Else, the player cannot retreat the pokemon because it either does not have enough energies or there are
            //no pokemon in their bench

            //Inform the player
            System.out.println("Your active pokemon cannot be retreated!");
            System.out.println("Please pick another option for your turn.");
            System.out.println();
        }
    }

    public void pickPokemonFromBench(){
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
            for (Card card : getBench()) {

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
            System.out.println("You did not pick a valid option, please pick another card from the bench");
        }

        //Inform the player of the action
        System.out.println("Placed " + pokemonToBeActive.getNameOfCard() + " in the active spot");
        System.out.println();

        //Set the player's active pokemon and remove the pokemon from their bench
        setActivePokemon(pokemonToBeActive);
        removeCardFromBench(pokemonToBeActive);
    }

    /**
     * The useCard method uses a card of the player's choice.
     * @param cardToUse The card the player wants to use
     */
    public void useCard(Card cardToUse){

        //Check to see what type of card the player played
        if (cardToUse.getTypeOfCard().equals("Trainer")) {

            //If the player used a trainer card

            //Check to see if the player is using a supporter card and if they have used a supporter card
            //already
            if (cardToUse.getTrainer().getTypeOfTrainerCard().equals("Supporter") &&
                    numberOfSupporterCardsUsed < 1) {

                //If the player is using a supporter card, and they have not used one before

                //Use the ability of the card
                cardToUse.getTrainer().useAbility(this);

                //Remove the card from the player's hand and add the card to the player's discard pile
                removeCardFromHand(cardToUse);
                addCardToDiscard(cardToUse);

                //Increment the numberOfSupporterCardsUsed flag
                numberOfSupporterCardsUsed++;

            } else if (!cardToUse.getTrainer().getTypeOfTrainerCard().equals("Supporter")) {

                //Else, if the card the player wants to use is a trainer card that is not also a supporter card

                //Check if it is an X Speed
                if (cardToUse.getTrainer().getNameOfCard().equals("X Speed")) {

                    //If it is

                    //Set the xSpeedUsed flag to true
                    xSpeedUsed = true;
                }

                //Use the card's ability, remove the card from the player's hand and add it their discard pile
                cardToUse.getTrainer().useAbility(this);
                removeCardFromHand(cardToUse);
                addCardToDiscard(cardToUse);

            } else {

                //Else, the player has chosen a supporter card and has already used one

                //Inform the player
                System.out.println("You've already used a supporter card this turn, pick another card.");
                System.out.println();

            }
        } else if (cardToUse.getTypeOfCard().equals("Pokemon")) {

            //Else, if the card the player wants to use is a Pokemon

            //Check if the player's bench is full
            if(this.getBench().size() > 5){

                //If it is full, inform the player
                System.out.println("You can't place anymore pokemon because your bench is full!");
            }else {

                //else if the player bench is not full

                //Add the card to the bench and remove it from the player's hand
                addCardToBench(cardToUse);
                removeCardFromHand(cardToUse);

                //Inform the player
                System.out.println("Added card to bench");
                System.out.println();
            }

        } else if (cardToUse.getTypeOfCard().equals("Energy")) {

            //Else, if the card the player wants to use is an energy

            //Check to make sure the player has not already used an energy during this turn
            if (numberOfEnergiesUsed < 1) {

                //If the player has not used an energy this turn

                //Use the energy
                cardToUse.getEnergy().useEnergy(this);

                //Increment the counter for energies used in a turn
                numberOfEnergiesUsed++;

            } else {

                //Else, the player has already placed on energy card this turn

                //Inform the player of this
                System.out.println("You have already placed an energy this turn. Please choose another card.");
            }
        }
    }
}
