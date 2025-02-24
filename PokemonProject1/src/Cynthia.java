import java.util.ArrayList;

/**
 * The Cynthia class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Cynthia extends Trainer{

    /**
     * Default constructor
     */
    public Cynthia(){
        setNameOfCard("Cynthia");
        setTypeOfTrainerCard("Supporter");
        setTypeOfCard("Trainer");
        setDescriptionOfCard("Shuffle your hand into your deck. Then, draw 6 cards");
        setTrainer(this);
    }

    public void shuffleAndDraw(Player playerWithCard){

        ArrayList<Card> hand = playerWithCard.getHand();
        Deck playerDeck = playerWithCard.getDeck();

        playerDeck.returnHandToDeck(hand);
        hand.clear();

        for(int i = 0; i < 6; i++) {
            hand.add(playerDeck.pickTopCard());
        }

        playerWithCard.setHand(hand);
    }

}
