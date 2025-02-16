import java.util.ArrayList;

public class PokemonCardGame {

    private ArrayList<Card> player1;

    private ArrayList<Card> player1Prize;

    private ArrayList<Card> player2;

    private ArrayList<Card> player2Prize;

    /**
     * Default constructor for the PokemonCardGame class. Player 1 and player 2's decks are created randomly.
     */
    public PokemonCardGame(){

        //Create the deck object for player 1
        Deck player1Deck = new Deck();

        //Generate Player 1's deck
        player1Deck.generateDeck(20, 30, 10);

        //Set player1 global variable equal to the new deck of cards just created
        this.player1 = player1Deck.getDeckOfCards();

        //Create the deck object for player 2
        Deck player2Deck = new Deck();

        //Generate Player 2's deck
        player2Deck.generateDeck(20,30,10);

        //Set player2 global variable equal to the new deck of cards just created
        this.player2 = player2Deck.getDeckOfCards();
    }

    /**
     * Constructor for the PokemonCardGame class. Player 2's deck is randomly created.
     * @param playerDeck A precrated deck of cards for player 1.
     */
    public PokemonCardGame(ArrayList<Card> playerDeck){
        player1 = playerDeck;

        //Generate player 2's deck and set it equal to the global variable player2
        Deck player2Deck = new Deck();
        player2Deck.generateDeck(20,30,10);
        this.player2 = player2Deck.getDeckOfCards();

    }

    /**
     * Constructor for the PokemonCardGame class.
     * @param player1Deck A precreated deck of cards for player 1.
     * @param player2Deck A precreated deck of cards for player 2.
     */
    public PokemonCardGame(ArrayList<Card> player1Deck, ArrayList<Card> player2Deck){
        player1 = player1Deck;
        player2 = player2Deck;
    }

    /**
     * Getter for the player1 deck.
     * @return The deck of the player in the form of an ArrayList of Cards.
     */
    public ArrayList<Card> getPlayer1() {
        return player1;
    }

    /**
     * Setter for the player1 deck.
     * @param player1 The new deck of Player1.
     */
    public void setPlayer1(ArrayList<Card> player1) {
        this.player1 = player1;
    }

    /**
     * Getter for the player2 deck.
     * @return The deck of the player in the form of an ArrayList of Cards.
     */
    public ArrayList<Card> getPlayer2() {
        return player2;
    }

    /**
     * Setter for the player2 deck.
     * @param player2 The new deck of Player2.
     */
    public void setPlayer2(ArrayList<Card> player2) {
        this.player2 = player2;
    }

    /**
     * The pickPlayer1Prize method is responsible for creating the prize card pile for player 1.
     */
    public void pickPlayer1Prize(){

        //Pick 6 cards from the top of the deck and place them in a new variable called player1Prize
        for(int i = 0; i < 6; i++) {
            player1Prize.add(player1.removeFirst());
        }
    }

    /**
     * The pickPlayer2Prize method is responsible for creating the prize card pile for player 2.
     */
    public void pickPlayer2Prize(){

        //Pick 6 cards from the top of the deck and place them in a new variable called player2Prize
        for(int i = 0; i < 6; i++){
            player2Prize.add(player2.removeFirst());
        }
    }

    /**
     * Getter method for the player 1 prize pile.
     * @return The prize pile for player 1.
     */
    public ArrayList<Card> getPlayer1Prize() {
        return player1Prize;
    }

    /**
     * Getter method for the player 2 prize pile.
     * @return The prize pile for player 2.
     */
    public ArrayList<Card> getPlayer2Prize() {
        return player2Prize;
    }
}
