/**
 * The XSpeed class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class XSpeed extends Trainer{

    /**
     * Default Constructor
     */
    public XSpeed(){
        setNameOfCard("X Speed");
        setTypeOfTrainerCard("Item");
        setTypeOfCard("Trainer");
        setDescriptionOfCard("During this turn, the retreat cost of your active pokemon is one less");
        setTrainer(this);
    }

}
