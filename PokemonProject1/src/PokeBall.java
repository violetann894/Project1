/**
 * The PokeBall class is a trainer card that can be used in a Pokemon TCG game.
 */
public class PokeBall extends Trainer{

    /**
     * Default constructor
     */
    public PokeBall(){
        setNameOfCard("Poke Ball");
        setTypeOfCard("Trainer");
        setTypeOfCard("Item");
        setDescriptionOfCard("Flip a coin. If heads, search you deck for a Pokemon, reveal it, and put it into your" +
                "hand. Then, shuffle your deck.");
        setTrainer(this);
    }

}
