/**
 * The ProfsResearch class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class ProfsResearch extends Trainer{

    /**
     * Default constructor
     */
    public ProfsResearch(){
        setNameOfCard("Professor's Research");
        setTypeOfCard("Trainer");
        setTypeOfTrainerCard("Supporter");
        setDescriptionOfCard("Discard your hand and draw 7 cards.");
        setTrainer(this);
    }

}
