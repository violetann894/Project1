import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck class holds the cards used in the game and holds methods that relate to the deck.
 * @author Rachel Hussmann
 */
public class Deck extends Card{

    private ArrayList<Card> deckOfCards;

    /**
     * The generateDeck method generates a standard deck of cards with 20 pokemon, 10 trainer cards, and 30 energy cards
     */
    public void generateDeck(){

        for(int i = 0; i < 4; i++){

            //Adds 20 pokemon cards to the deck
            deckOfCards.add(new Charmander());
            deckOfCards.add(new Lapras());
            deckOfCards.add(new Pikachu());
            deckOfCards.add(new Eevee());
            deckOfCards.add(new Skarmory());

            //Adds 8 trainer cards to the deck
            deckOfCards.add(new ProfsLetter());
            deckOfCards.add(new ProfsResearch());
        }

        //Adds two more trainer cards to the deck
        deckOfCards.add(new Cynthia());
        deckOfCards.add(new PokeBall());

        //Adds 6 energies of each type to the deck
        for(int i = 0; i < 6; i++){
            deckOfCards.add(new Energy());
            deckOfCards.add(new Electric());
            deckOfCards.add(new Fire());
            deckOfCards.add(new Water());
            deckOfCards.add(new Steel());
        }
    }

    /**
     * The generateDeckMulligan method creates a deck of 60 cards with the specified number of pokemon and energies for
     * the MulliganMonteCarlo class and simulation.
     * @param numOfPokemon The number of pokemon to be added to the deck.
     * @param numOfEnergies The number of energies to be added to the deck.
     */
    public void generateDeckMulligan(int numOfPokemon, int numOfEnergies){

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
     * The generateDeckRareCandy method creates a new deck of 60 cards for use in the BrickMonteCarlo class and
     * simulation.
     * @param numOfPokemon The number of pokemon to be generated.
     * @param numOfEnergies The number of energies to be generated.
     * @param numOfTrainers The number of trainer cards to be generated.
     */
    public void generateDeckRareCandy(int numOfPokemon, int numOfEnergies, int numOfTrainers){
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

        //Add number of trainer cards to the deck
        for(int i = 0; i< numOfTrainers; i++){
            deck.add(new Card(new RareCandy()));
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

        //For the size of the deckOfCards
        while(deckOfCards.size() > 0){

            //Pick a random integer value
            int randomValue = random.nextInt(0, deckOfCards.size());

            //Add the randomly chosen card to the shuffled deck
            shuffled.add(deckOfCards.get(randomValue));

            //Remove the card from the original deck
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
        return deckOfCards.removeFirst();
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
