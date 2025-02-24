/**
 * The ProfsLetter class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class ProfsLetter extends Trainer{

    /**
     * Default constructor
     */
    public ProfsLetter(){
        setNameOfCard("Professor's Letter");
        setTypeOfTrainerCard("Supporter");
        setTypeOfCard("Trainer");
        setDescriptionOfCard("Search your deck for up to 2 basic energy cards, reveal them, and put them into your" +
                "hand. Shuffle your deck afterwards");
        setTrainer(this);
    }

}
