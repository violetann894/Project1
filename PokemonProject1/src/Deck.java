import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck class holds the cards used in the game and holds methods that relate to the deck.
 * @author Rachel Hussmann
 */
public class Deck extends Card{

    private ArrayList<Card> deckOfCards;

    public void generateDeck(int numOfPokemon, int numOfEnergies){
        ArrayList<Card> deck = new ArrayList<>();

        for(int i = 0; i < numOfPokemon; i++){
            deck.add(new Card(new Pokemon()));
        }

        for(int i = 0; i < numOfEnergies; i++){
            deck.add(new Card(new Energy()));
        }

        deckOfCards = deck;
    }

    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < deckOfCards.size(); i++){
            int randomValue = random.nextInt(0, deckOfCards.size());
            shuffled.add(deckOfCards.get(randomValue));
            deckOfCards.remove(randomValue);
        }

        deckOfCards = shuffled;
    }

    public Card pickTopCard(){
        return deckOfCards.remove(0);
    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
}
