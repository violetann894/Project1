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
     * The retreatActivePokemon method checks to see if the active pokemon can be retreated to the bench, moves
     * the active pokemon back to the bench, and then allows the player to pick a new pokemon from their bench
     * to take the old active pokemon's place.
     */
    public void retreatActivePokemon(){
        if(this.activePokemon.checkForRetreat() && !bench.isEmpty()){

            if(activePokemon.getEnergiesAttached().size() == activePokemon.getRetreatCost()){
                activePokemon.getEnergiesAttached().clear();

                System.out.println("Energies have been successfully removed, retreating active Pokemon . . . ");

                addCardToBench(activePokemon);

                activePokemon = null;

                System.out.println("Current Bench: " + this.bench);

                pickPokemonFromBench();

            }else{

                int retreatCost = 1;

                boolean broke = false;

                while(retreatCost <= activePokemon.getRetreatCost()){

                    System.out.println("Pick energy " + retreatCost + " to remove from your active pokemon.");

                    System.out.println(activePokemon.getEnergiesAttached());

                    String energyChoice = userInput.nextLine();

                    Card cardToRemove = null;

                    for(Card card : activePokemon.getEnergiesAttached()){
                        if(card.getNameOfCard().equalsIgnoreCase(energyChoice)){
                            cardToRemove = card;
                            broke = true;
                            break;
                        }
                    }

                    if(broke){
                        activePokemon.getEnergiesAttached().remove(cardToRemove);
                        addCardToDiscard(cardToRemove);
                        retreatCost++;
                    }else {
                        System.out.println("That is not a valid energy, please choose another energy card.");
                    }
                }

                System.out.println("Retreating active Pokemon . . . ");

                addCardToBench(activePokemon);

                activePokemon = null;

                System.out.println("Current Bench: " + this.bench);

                pickPokemonFromBench();
            }


        }else{
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
            for (Card card : this.getBench()) {

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
        this.setActivePokemon(pokemonToBeActive);
        this.removeCardFromBench(pokemonToBeActive);
    }

}
