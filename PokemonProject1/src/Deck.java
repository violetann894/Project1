import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck class holds the cards used in the game and holds methods that relate to the deck.
 * @author Rachel Hussmann
 */
public class Deck extends Card{

    private ArrayList<Card> deckOfCards;

    /**
     * Default constructor
     */
    public Deck(){
        deckOfCards = new ArrayList<>();
    }

    /**
     * The generateDeck method generates a standard deck of cards with 20 pokemon, 15 trainer cards,
     * and 20 energy cards.
     */
    public void generateDeck(){

        for(int i = 0; i < 4; i++){
            //Adds 20 pokemon cards to the deck
            deckOfCards.add(new Charmander());
            deckOfCards.add(new Lapras());
            deckOfCards.add(new Pikachu());
            deckOfCards.add(new Eevee());
            deckOfCards.add(new Skarmory());
        }

        for(int i = 0; i < 3; i++){
            //Adds 15 energy cards
            deckOfCards.add(new Energy());
            deckOfCards.add(new Electric());
            deckOfCards.add(new Fire());
            deckOfCards.add(new Water());
            deckOfCards.add(new Steel());
        }

        for(int i = 0; i < 5; i++){
            //Adds 25 trainer cards to the deck
            deckOfCards.add(new ProfsLetter());
            deckOfCards.add(new ProfsResearch());
            deckOfCards.add(new Cynthia());
            deckOfCards.add(new PokeBall());
            deckOfCards.add(new XSpeed());
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
        while(!deckOfCards.isEmpty()){

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

    /**
     * The returnHandToDeck method returns a hand of cards back to the deck.
     * @param hand The hand of Cards that the player needs to return to the deck
     */
    public void returnHandToDeck(ArrayList<Card> hand){
        //Add the chosen cards back into the deck
        for(Card c : hand){
            this.getDeckOfCards().add(c);
        }

        //Shuffle the deck again
        this.shuffle();

        hand.clear();
    }

    /**
     * The findFirstPokemon method finds the first pokemon card in the deck.
     * @return The first Pokemon cards found in the deck.
     */
    public Pokemon findFirstPokemon(){

        //Search for the first pokemon card
        for(Card c : this.getDeckOfCards()){

            //Check if we found one
            if(c.getTypeOfCard().equals("Pokemon")){

                //If we found one, return that pokemon object
                return c.getPokemon();
            }
        }

        //If we didn't find one, return null
        return null;
    }

    /**
     * The findFirstEnergy method finds the first energy card in the deck.
     * @return The first Energy card found in the deck.
     */
    public Energy findFirstEnergy(){

        //Search for the first energy card
        for(Card c : this.getDeckOfCards()){

            //Check if we found one
            if(c.getTypeOfCard().equals("Energy")){

                //If we found one, return that energy object
                return c.getEnergy();
            }
        }

        //If we didn't find one, return null
        return null;
    }
}
