/**
 * The Cynthia class is a trainer card that can be used in a Pokemon TCG game.
 */
public class Cynthia extends Trainer{

    /**
     * Default constructor
     */
    public Cynthia(){
        setNameOfCard("Cynthia");
        setTypeOfTrainerCard("Supporter");
        setTypeOfCard("Trainer");
        setDescriptionOfCard("Shuffle you hand into your deck. Then, draw 6 cards");
        setTrainer(this);
    }

}
