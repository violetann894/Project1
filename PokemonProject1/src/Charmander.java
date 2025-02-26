import java.util.ArrayList;

/**
 * The Charmander class holds information about the pokemon Charmander for a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Charmander extends Pokemon{

    /**
     * Default constructor
     */
    public Charmander(){

        //Setting up the hp and the name of the pokemon
        setHp(50);
        setNameOfCard("Charmander");

        //Initializing the attacks ArrayList
        ArrayList<Attack> attacks = new ArrayList<>();

        //Setting up the scratch attack
        ArrayList<Energy> scratchAttackCost = new ArrayList<>();
        scratchAttackCost.add(new Energy());
        Attack claw = new Attack(scratchAttackCost, "Scratch", 10);

        //Setting up the ember attack
        ArrayList<Energy> emberCost = new ArrayList<>();
        emberCost.add(new Fire());
        emberCost.add(new Energy());
        Attack ember = new Attack(emberCost, "Ember", 30);

        //Adding the attacks to the ArrayList
        attacks.add(claw);
        attacks.add(ember);

        //Setting the attacks, weakness, type, and retreatCost of the pokemon
        setAttacks(attacks);
        setWeakness("Water");
        setType("Fire");
        setRetreatCost(1);

        //Setting the type of card and setting the Card variable, pokemon, to this object
        setTypeOfCard("Pokemon");
        setPokemon(this);
    }

}
