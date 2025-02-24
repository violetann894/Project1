/**
 * The Potion class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Potion extends Trainer{

    /**
     * Default Constructor
     */
    public Potion(){
        setNameOfCard("Potion");
        setTypeOfTrainerCard("Item");
        setTypeOfCard("Trainer");
        setDescriptionOfCard("Heal 30 damage from one of your pokemon");
        setTrainer(this);
    }

    public void healPokemon(Pokemon pokemonToBeHealed){
        int hp = pokemonToBeHealed.getHp();

        pokemonToBeHealed.setHp(hp);
    }

}
