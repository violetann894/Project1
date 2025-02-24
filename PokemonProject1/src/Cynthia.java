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
        setTypeOfCard("Trainer");
        setTypeOfTrainerCard("Supporter");
        setDescriptionOfCard("Shuffle your hand into your deck. Then, draw 6 cards");
        setTrainer(this);
    }
}
