import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck class holds the cards used in the game and holds methods that relate to the deck.
 * @author Rachel Hussmann
 */
public class Deck extends Card{

    private ArrayList<Card> deckOfCards;

    /**
     * The generateDeck method creates a deck of 60 cards with the specified number of pokemon and energies in it
     * @param numOfPokemon The number of pokemon to be added to the deck.
     * @param numOfEnergies The number of energies to be added to the deck.
     */
    public void generateDeck(int numOfPokemon, int numOfEnergies){

        //Initialize the deck (An ArrayList of cards)
        ArrayList<Card> deck = new ArrayList<>();

        //Add the number of pokemon to the deck
        for(int i = 0; i < numOfPokemon; i++){
            deck.add(new Card(new Pokemon()));
        }

        //Add the number of energies to the deck
        for(int i = 0; i < numOfEnergies; i++){
            deck.add(new Card(new Energy()));
        }

        //The deck of cards created is now equal to the global variable deckOfCards
        deckOfCards = deck;
    }

    /**
     * The shuffle method shuffles the current deckOfCards
     */
    public void shuffle(){

        //Initialize and create the list and random object needed to shuffle
        ArrayList<Card> shuffled = new ArrayList<>();
        Random random = new Random();

        //
        for(int i = 0; i < deckOfCards.size(); i++){

            //
            int randomValue = random.nextInt(0, deckOfCards.size());

            //
            shuffled.add(deckOfCards.get(randomValue));

            //
            deckOfCards.remove(randomValue);
        }

        //The shuffled deck of cards is now equal to the global variable deckOfCards
        deckOfCards = shuffled;
    }

    /**
     * The pickTopCard method returns the card that is on the top of the deck.
     * @return The Card object from the top of the deck.
     */
    public Card pickTopCard(){
        return deckOfCards.remove(0);
    }

    /**
     * getDeckOfCards is the getter method for the deckOfCards variable.
     * @return The deckOfCards variable (An ArrayList of card objects).
     */
    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    /**
     * setDeckOfCards is the setter method for the deckOfCards variable.
     * @param deckOfCards The new deck.
     */
    public void setDeckOfCards(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
}
