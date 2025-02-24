import java.util.ArrayList;

/**
 * The Player class handles the state of the player.
 * @author Rachel Hussmann
 */
public class Player {

    private Deck deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizeDeck;
    private ArrayList<Card> bench;
    private Card activePokemon;
    private ArrayList<Card> discardPile;

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
     * The createHand method creates a new hand for a player.
     */
    public void createHand(){
        for(int i = 0; i < 7; i++){
            hand.add(deck.pickTopCard());
        }
    }

    /**
     * The pickPrizeDeck method picks a prize deck for the player.
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

}
