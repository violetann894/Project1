/**
 * The RareCandy class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class RareCandy extends Trainer{

    /**
     * Default constructor
     */
    public RareCandy(){
        setNameOfCard("Rare Candy");
        setTypeOfCard("Trainer");
        setTypeOfTrainerCard("Item");
        setDescriptionOfCard("Choose 1 of your basic pokemon in play. If you have a stage 2 card in your hand that" +
                "evolves from that pokemon, put that card onto the basic pokemon to evolve it, skipping the stage 1." +
                "You can't use this card during you first turn or on a basic pokemon that was put into play this turn.");
        setTrainer(this);
    }

}
